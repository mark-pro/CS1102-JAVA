package questions;

import javax.swing.JOptionPane;

public abstract class AbstractQuestion {

    protected static float _numCorrect;
    protected static float _numQuestions;

    protected String _correctAnswer;
    protected String _question;

    public AbstractQuestion(
        String question, 
        String correctAnswer
        
    ) {
        _question = question;
        _correctAnswer = correctAnswer;
        _numQuestions++;
    }

    protected abstract String ask();

    public void check() {
        var r = ask();
        var isCorrect = 
            _correctAnswer.toUpperCase()
                .equals(r.toUpperCase());

        if(isCorrect) _numCorrect++;
        
        var message = isCorrect 
            ? "Correct! You rock!"
            : String.format("Incorrect! The correct answer was %s", _correctAnswer);

        JOptionPane.showMessageDialog(null, message);
    }

    public static int calculateScore() {
        return Math.round((_numCorrect / _numQuestions) * 100);
    }

    public static String getLetterScore() {
        var score = calculateScore();
        return score >= 95 ? "A"
            : score >= 80 ? "B"
            : score >= 70 ? "C"
            : score >= 60 ? "D"
            : "F";
    }

    public static void displayScore() {
        var message = String.format(
            "You score is %s (%d%%)",
            getLetterScore(),
            calculateScore()
        );
        
        JOptionPane.showMessageDialog(null, message);
    }
}