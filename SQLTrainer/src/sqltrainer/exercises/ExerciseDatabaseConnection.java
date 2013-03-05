/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sqltrainer.exercises;

import java.io.DataInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

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
            driverLoaded=true;
        } catch (ClassNotFoundException ex) {
            driverLoaded = false;
            System.out.println("Could not load driver.");
        }
    }
    
    private void connect() {
        if(driverLoaded && conn == null) {
            try {
                conn = DriverManager.getConnection("jdbc:derby:SQLTrainer;create=true","trainer","trainer");
            } catch (SQLException ex) {
                System.out.println("Could not connect to database.");
            }
        }
    }
    
    private void disconnect() {
        if(conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
                System.out.println("Could not disconnect from database.");
            }
        }
    }

    private void initDatabase() {
        try {
            connect();
            DataInputStream stream = (DataInputStream)getClass().getResourceAsStream("/resources/Productions.png");
            String sql = stream.readUTF();
            Statement statement = conn.createStatement();
            statement.executeQuery(sql);
            disconnect();
        } catch (IOException ex) {
            System.out.println("Could not read.");
        } catch (SQLException ex) {
            System.out.println("Could not create statement.");
        }
    }
}
