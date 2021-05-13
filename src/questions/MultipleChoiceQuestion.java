package questions;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;

public class MultipleChoiceQuestion extends AbstractQuestion {
    
    private String[] _choices;

    public MultipleChoiceQuestion(
        String correctAnswer,
        String question,
        String... choices
    ) {
        super(question, correctAnswer);
        _choices = choices;
    }

    @Override
    protected String ask() {
        while(true) {
            var result = JOptionPane.showInputDialog(toString()).toUpperCase();
            var choiceMap = getChoiceAnswerPairs();
            if(!choiceMap.containsKey(result)) {
                var message = String.format("%s is not valid\n", result);
                    for (var entry : choiceMap.entrySet()) 
                        message += String.format(" %s ", entry.getKey());
                
                JOptionPane.showMessageDialog(null, message);
                continue;
            }
            else return result;
        }
    }

    @Override
    public String toString() {
        var s = _question + "\n";
        
        for (var entry : getChoiceAnswerPairs().entrySet()) {
            s += String.format("%s. %s\n", entry.getKey(), entry.getValue());
        }

        return s;
    }

    private Map<String, String> getChoiceAnswerPairs() {
        Map<String, String> map = new HashMap<String, String>();
        for(var i = 0; i < _choices.length; i ++) {
            map.put(
                Character.toString((char) (97 + i)).toUpperCase(),
                _choices[i]
            );
        }

        return map;
    }

}
