/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sqltrainer.exercises;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author karlinsv
 */
public class ExerciseDatabaseConnection {
        
    private Connection conn = null;
    private boolean driverLoaded = false;
    
    public ExerciseDatabaseConnection() {
        init();
        initDatabase();
    }

    private void init() {
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            driverLoaded = true;
        } catch (ClassNotFoundException ex) {
            driverLoaded = false;
            ex.printStackTrace();
        }
    }
    
    public void connect() {
        if(driverLoaded && conn == null) {
            try {
                conn = DriverManager.getConnection("jdbc:derby:SQLTrainer;create=true","trainer","trainer");
            } catch (SQLException ex) {
                System.out.println("Could not connect to database.");
            }
        }
    }
    
    public void disconnect() {
        if(conn != null) {
            try {
                conn.close();
                conn = null;
            } catch (SQLException ex) {
                System.out.println("Could not disconnect from database.");
            }
        }
    }

    private void initDatabase() {
        try {
            connect();
            List<String> queries = getQueriesFromResource("/resources/ExerciseTable.sql");
            executeMultipleQueries(queries);
            disconnect();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public List<String> getTables() {
        try {
            DatabaseMetaData meta = conn.getMetaData();
            ResultSet result = meta.getTables(null, null, null, new String[]{"TABLE"});
            List<String> names = new ArrayList<String>();
            while(result.next()) {
                names.add(result.getString("TABLE_NAME"));
            }
            return names;
        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ResultSet query(String sql) {
        ResultSet result = null;
        try {
            Statement statement = conn.createStatement();
            result = statement.executeQuery(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }
    
    public List<String> getQueriesFromFile(String file) {
        List<String> queries = new ArrayList<String>();
        return queries;
    }

    public List<String> getQueriesFromResource(String resource) {
        List<String> queries = new ArrayList<String>();
        try {
            BufferedInputStream stream = (BufferedInputStream)getClass().getResourceAsStream(resource);
            byte[] buffer = new byte[1024];
            int read = 0;
            String content = "";
            while((read=stream.read(buffer)) > -1) {
                content += new String(buffer, 0, read);
            }
            content = content.replaceAll("\n|\r", "");
            content = content.replaceAll("  ", "");
            for(String query : content.split(";")) {
                if(queryExecutable(query)) {
                    queries.add(query);
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return queries;
    }
    
    public String getQueryFromResource(String resource, int i) {
        List<String> queries = getQueriesFromResource(resource);
        return queries.get(i);
    }

    public List<ResultSet> executeMultipleQueries(List<String> queries) {
        List<ResultSet> result = new ArrayList<ResultSet>();
        for(String query : queries) {
            if(query.length() > 0) {
                result.add(query(query));
            }
        }
        return result;
    }
    
    public boolean queryExecutable(String query) {
        List<String> tables = getTables();
        for(String table : tables) {
            if(query.toLowerCase().contains("create table "+table.toLowerCase())) {
                return false;
            }
        }
        return true;
    }

    public List<String> filterMultipleQueries(List<String> queries) {
        List<String> toDelete = new ArrayList<String>();
        for(String query : queries) {
            if(queryExecutable(query)) {
                toDelete.add(query);
            }
        }
        queries.removeAll(toDelete);
        return queries;
    }
}
