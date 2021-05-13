package questions;

import java.util.Arrays;
import java.util.List;

import javax.swing.JOptionPane;

public class TrueFalseQuestion extends AbstractQuestion {

    private List<String> _validAnswers;

    public TrueFalseQuestion(
        String question,
        String correctAnswer
    ) {
        super(question, correctAnswer);
        _validAnswers = Arrays.asList(
            "yes", "true", "no", "false"
        );
    }
 
    @Override
    protected String ask() {
        
        for(;;) {
            var r = JOptionPane.showInputDialog(
                "TRUE or FALSE: " + _question
            ).toUpperCase();
            if(isValidAnswer(r)) {
                return r.contains("Y") || r.contains("T")
                    ? "TRUE" : "FALSE";
            }
            else 
                JOptionPane.showMessageDialog(
                    null, 
                    "Must enter yes or no (n/y) or true or false (t/f)"
                );
        }
        
    }
    
    private boolean isValidAnswer(String answer) {
        return _validAnswers.stream()
        .map(value -> value.toUpperCase()).anyMatch(value -> 
            value.equals(answer) || (value.charAt(0) + "").equals(answer)
        );
    }

    @Override
    public String toString() {
        return _question;
    }
}
