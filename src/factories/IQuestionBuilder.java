package factories;
import questions.AbstractQuestion;

public interface IQuestionBuilder<T extends AbstractQuestion> {
    IQuestionBuilder<T> setQuestion(String question);
    IQuestionBuilder<T> setCorrectAnswer(String correctAnswer);
    T build();
}