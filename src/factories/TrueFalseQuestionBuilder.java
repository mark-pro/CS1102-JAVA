package factories;

import questions.TrueFalseQuestion;

public class TrueFalseQuestionBuilder implements IQuestionBuilder<TrueFalseQuestion> {

    private String _question;
    private String _correctAnswer;

    @Override
    public IQuestionBuilder<TrueFalseQuestion> setQuestion(String question) {
        _question = question;
        return this;
    }

    @Override
    public IQuestionBuilder<TrueFalseQuestion> setCorrectAnswer(String correctAnswer) {
        _correctAnswer = correctAnswer;
        return this;
    }

    @Override
    public TrueFalseQuestion build() {
        return new TrueFalseQuestion(_question, _correctAnswer);
    }
}
