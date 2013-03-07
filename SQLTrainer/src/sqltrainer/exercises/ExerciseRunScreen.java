/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sqltrainer.exercises;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author karlinsv
 */
public class ExerciseRunScreen extends javax.swing.JFrame {

    ExerciseDatabaseConnection conn = null;
    List<TopicItem> topics = null;
    TopicItem currentTopic = null;
    ExerciseItem currentExercise = null;
    boolean fullTextAnswer = true;
    
    /**
     * Creates new form ExerciseRunScreen
     */
    public ExerciseRunScreen(ExerciseDatabaseConnection conn, List<TopicItem> topics) {
        this.conn = conn;
        this.topics = topics;
        initComponents();
        updateQuestion();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        answerPanel = new javax.swing.JPanel();
        textAnswerPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        fullTextAnswerText = new javax.swing.JTextArea();
        multipleChoiseAnswerPanel = new javax.swing.JPanel();
        multpileChoiceAnswerChoice1 = new javax.swing.JRadioButton();
        multipleChoiceAnswerChoice2 = new javax.swing.JRadioButton();
        multipleChoiceAnswerChoice3 = new javax.swing.JRadioButton();
        questionPanel = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        questionText = new javax.swing.JTextArea();
        exerciseNextButton = new javax.swing.JButton();
        exercisePrevButton = new javax.swing.JButton();
        checkPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        checkText = new javax.swing.JTextArea();
        checkAnswer = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Aufgabe beantworten");

        answerPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Antwort"));
        answerPanel.setLayout(new java.awt.CardLayout());

        fullTextAnswerText.setColumns(20);
        fullTextAnswerText.setRows(5);
        jScrollPane2.setViewportView(fullTextAnswerText);

        javax.swing.GroupLayout textAnswerPanelLayout = new javax.swing.GroupLayout(textAnswerPanel);
        textAnswerPanel.setLayout(textAnswerPanelLayout);
        textAnswerPanelLayout.setHorizontalGroup(
            textAnswerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 804, Short.MAX_VALUE)
        );
        textAnswerPanelLayout.setVerticalGroup(
            textAnswerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
        );

        answerPanel.add(textAnswerPanel, "card2");

        javax.swing.GroupLayout multipleChoiseAnswerPanelLayout = new javax.swing.GroupLayout(multipleChoiseAnswerPanel);
        multipleChoiseAnswerPanel.setLayout(multipleChoiseAnswerPanelLayout);
        multipleChoiseAnswerPanelLayout.setHorizontalGroup(
            multipleChoiseAnswerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(multipleChoiseAnswerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(multipleChoiseAnswerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(multpileChoiceAnswerChoice1)
                    .addComponent(multipleChoiceAnswerChoice2)
                    .addComponent(multipleChoiceAnswerChoice3))
                .addContainerGap(777, Short.MAX_VALUE))
        );
        multipleChoiseAnswerPanelLayout.setVerticalGroup(
            multipleChoiseAnswerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(multipleChoiseAnswerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(multpileChoiceAnswerChoice1)
                .addGap(18, 18, 18)
                .addComponent(multipleChoiceAnswerChoice2)
                .addGap(18, 18, 18)
                .addComponent(multipleChoiceAnswerChoice3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        answerPanel.add(multipleChoiseAnswerPanel, "card3");

        questionPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Frage"));

        questionText.setColumns(20);
        questionText.setEditable(false);
        questionText.setRows(5);
        questionText.setBorder(null);
        questionText.setEnabled(false);
        jScrollPane3.setViewportView(questionText);

        javax.swing.GroupLayout questionPanelLayout = new javax.swing.GroupLayout(questionPanel);
        questionPanel.setLayout(questionPanelLayout);
        questionPanelLayout.setHorizontalGroup(
            questionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3)
        );
        questionPanelLayout.setVerticalGroup(
            questionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
        );

        exerciseNextButton.setText("Weiter");
        exerciseNextButton.setEnabled(false);

        exercisePrevButton.setText("Zurück");
        exercisePrevButton.setEnabled(false);

        checkPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Result"));

        checkText.setColumns(20);
        checkText.setEditable(false);
        checkText.setRows(5);
        checkText.setEnabled(false);
        jScrollPane1.setViewportView(checkText);

        javax.swing.GroupLayout checkPanelLayout = new javax.swing.GroupLayout(checkPanel);
        checkPanel.setLayout(checkPanelLayout);
        checkPanelLayout.setHorizontalGroup(
            checkPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        checkPanelLayout.setVerticalGroup(
            checkPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
        );

        checkAnswer.setText("Antwort prüfen");
        checkAnswer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkAnswerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(questionPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(answerPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(exercisePrevButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(checkAnswer)
                        .addGap(284, 284, 284)
                        .addComponent(exerciseNextButton))
                    .addComponent(checkPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(questionPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(checkPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(answerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(exerciseNextButton)
                    .addComponent(exercisePrevButton)
                    .addComponent(checkAnswer))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void checkAnswerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkAnswerActionPerformed
        if(fullTextAnswer) {
            checkFullTextAnswer();
        } else {
            checkMultipleChoiceAnswer();
        }
    }//GEN-LAST:event_checkAnswerActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel answerPanel;
    private javax.swing.JButton checkAnswer;
    private javax.swing.JPanel checkPanel;
    private javax.swing.JTextArea checkText;
    private javax.swing.JButton exerciseNextButton;
    private javax.swing.JButton exercisePrevButton;
    private javax.swing.JTextArea fullTextAnswerText;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JRadioButton multipleChoiceAnswerChoice2;
    private javax.swing.JRadioButton multipleChoiceAnswerChoice3;
    private javax.swing.JPanel multipleChoiseAnswerPanel;
    private javax.swing.JRadioButton multpileChoiceAnswerChoice1;
    private javax.swing.JPanel questionPanel;
    private javax.swing.JTextArea questionText;
    private javax.swing.JPanel textAnswerPanel;
    // End of variables declaration//GEN-END:variables

    private void updateQuestion() {
        if(currentTopic != null) {
            currentTopic = topics.get(0);
        }
        try {
            if(currentExercise != null) {
                    ResultSet result = conn.query("SELECT * FROM exExercises WHERE topicid="+currentTopic.getId()+" LIMIT 1");
                    currentExercise = new ExerciseItem(result.getInt("id"), result.getString("title"), result.getString("question"), result.getString("answer"), currentTopic);

            } else {
                ResultSet result = conn.query("SELECT * FROM exExercises WHERE topicid="+currentTopic.getId()+" AND ID>"+currentExercise.getId()+" LIMIT 1");
                currentExercise = new ExerciseItem(result.getInt("id"), result.getString("title"), result.getString("question"), result.getString("answer"), currentTopic);
            }
        } catch (SQLException ex) {
            System.out.println("Fehler bei der Abfrage.");
        }
    }

    private void checkFullTextAnswer() {
        if(currentExercise.getAnswer().equals(this.fullTextAnswerText.getText())) {
            this.checkText.setText("Antwort ist korrekt:\n\r"+currentExercise.getAnswer());
        } else {
            this.checkText.setText("Antwort ist falsch:\n\r"+currentExercise.getAnswer());
        }
    }

    private void checkMultipleChoiceAnswer() {
        String answer = currentExercise.getAnswer();
        String[] answers = answer.split("§");
        int correct = Integer.getInteger(answers[3]);
        if(correct == (this.multpileChoiceAnswerChoice1.isSelected() ? 1 : this.multipleChoiceAnswerChoice2.isSelected() ? 2 : 3)) {
            this.checkText.setText("Antwort ist korrekt:\n\r"+answers[correct-1]);
        } else {
            this.checkText.setText("Antwort ist falsch:\n\r"+answers[correct-1]);
        }
    }
}
