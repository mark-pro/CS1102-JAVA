import factories.MultipleChoiceQuestionBuilder;
import factories.TrueFalseQuestionBuilder;
import questions.AbstractQuestion;

public class App {
    public static void main(String[] args) throws Exception {
        var questions = new AbstractQuestion[] {
            new MultipleChoiceQuestionBuilder()
                .setQuestion("What is the surface temperature of the sun?")
                .setCorrectAnswer("A")
                .addChoices("5772 K", "6600 K", "4400 K", "4886 K")
                .build() ,

            new MultipleChoiceQuestionBuilder()
                .setQuestion("What were the first animals in space?")
                .setCorrectAnswer("C")
                .addChoices("Dogs", "Cats", "Fruit flies", "Monkies")
                .build(),

            new MultipleChoiceQuestionBuilder()
                .setQuestion("When was the declaration of independence signed?")
                .setCorrectAnswer("B")
                .addChoices(
                    "November 22nd 1963", "July 4th 1776", 
                    "July 4th 1970", "November 5th 1605"
                ).build(),
            new TrueFalseQuestionBuilder()
                .setQuestion("Is the sky blue?")
                .setCorrectAnswer("true")
                .build(),
            new TrueFalseQuestionBuilder()
                .setQuestion("Was Arnold Schwarzenegger governor of Texas?")
                .setCorrectAnswer("false")
                .build()
        };

        for (var question : questions) question.check();

        AbstractQuestion.displayScore();
    }

    
}
