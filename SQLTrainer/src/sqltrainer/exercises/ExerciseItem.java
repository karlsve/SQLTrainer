/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sqltrainer.exercises;

/**
 *
 * @author karlinsv
 */
public class ExerciseItem {
    private int id = -1;
    private String title = "";
    private String question = "";
    private String answer = "";
    private TopicItem topic = null;
    
    public ExerciseItem(int id, String title, String question, String answer, TopicItem topic) {
        this.id=id;
        this.title=title;
        this.question=question;
        this.answer=answer;
        this.topic=topic;
    }

    public String getAnswer() {
        return answer;
    }

    public int getId() {
        return id;
    }

    public String getQuestion() {
        return question;
    }

    public String getTitle() {
        return title;
    }

    public TopicItem getTopic() {
        return topic;
    }
    
}
