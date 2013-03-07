/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sqltrainer.exercises;

import javax.swing.JFrame;

/**
 *
 * @author karlinsv
 */
public interface ExerciseNewTopicListener {
    public void onCancel(JFrame sender);
    public void onSubmit(JFrame sender, String title, String description);
}
