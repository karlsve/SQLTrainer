/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sqltrainer.exercises;

/**
 *
 * @author karlinsv
 */
public class TopicItem {
    private int id=-1;
    private String title = "";
    private String description = "";
    
    public TopicItem(int id, String title, String description) {
        this.id=id;
        this.title=title;
        this.description=description;
    }

    public String getDescription() {
        return description;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
    
    @Override
    public String toString() {
        return this.title;
    }
}
