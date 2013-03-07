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
public interface NewExerciseListener {
    public void onSubmitTextAnswer(JFrame sender, int topic, String title, String question, String answer);
    public void onSubmitMultipleChoiceAnswer(JFrame sender, int topic, String title, String question, String[] possibilities, int answer);
    public void onCancel(JFrame sender);
}
