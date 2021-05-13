package factories;

import java.util.ArrayList;
import java.util.List;
import questions.MultipleChoiceQuestion;

public class MultipleChoiceQuestionBuilder implements IQuestionBuilder<MultipleChoiceQuestion> {

    private String _correctAnswer;
    private List<String> _choices;
    private String _question;

    public MultipleChoiceQuestionBuilder() {
        _choices = new ArrayList<>();
    }

    @Override
    public MultipleChoiceQuestionBuilder setCorrectAnswer(String correctAnswer) {
        _correctAnswer = correctAnswer;
        return this;
    }
    
    @Override
    public MultipleChoiceQuestionBuilder setQuestion(String question) {
        _question = question;
        return this;
    }

    public MultipleChoiceQuestionBuilder addChoice(String choice) {
        _choices.add(choice);
        return this;
    }

    public MultipleChoiceQuestionBuilder addChoices(String... choices) {
        for (var choice : choices) 
            addChoice(choice);
        
        return this;
    }

    public MultipleChoiceQuestion build() {
        var choiceArray = new String[_choices.size()];
        _choices.toArray(choiceArray);
        return new MultipleChoiceQuestion(
            _correctAnswer, 
            _question, 
            choiceArray
        );
    }
}
