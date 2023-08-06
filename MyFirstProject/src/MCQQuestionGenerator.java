import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class MCQQuestionGenerator {

  public static void main(String[] args) {
    
    // Define the list of questions
    ArrayList<Question> questions = new ArrayList<Question>();
    questions.add(new Question("What is the capital of France?", new String[]{"London", "Paris", "Berlin", "Madrid"}, "Paris"));
    questions.add(new Question("What is the largest organ in the human body?", new String[]{"Heart", "Liver", "Lungs", "Skin"}, "Skin"));
    questions.add(new Question("What is the tallest mammal?", new String[]{"Elephant", "Giraffe", "Horse", "Lion"}, "Giraffe"));
    questions.add(new Question("What is the currency of Japan?", new String[]{"Yen", "Dollar", "Euro", "Pound"}, "Yen"));
    questions.add(new Question("Who is the current President of the United States?", new String[]{"Joe Biden", "Donald Trump", "Barack Obama", "George W. Bush"}, "Joe Biden"));
    questions.add(new Question("What is the largest planet in the solar system?", new String[]{"Mars", "Venus", "Jupiter", "Saturn"}, "Jupiter"));
    questions.add(new Question("What is the chemical symbol for gold?", new String[]{"Au", "Ag", "Cu", "Fe"}, "Au"));
    questions.add(new Question("What is the smallest continent?", new String[]{"Europe", "North America", "Australia", "Asia"}, "Australia"));
    questions.add(new Question("What is the highest mountain in the world?", new String[]{"Mount Everest", "K2", "Makalu", "Annapurna"}, "Mount Everest"));
    
    questions.add(new Question("What is the capital of india", new String[]{"Punjab", "Haryana", "Delhi", "Mumbai"}, "DelhiD"));
    
    // Shuffle the questions
    Collections.shuffle(questions);
    
    
    int score = 0;
    
    // Display each question and ask for the user's answer
    Scanner scanner = new Scanner(System.in);
    for (int i = 0; i < 10; i++) {
      System.out.println((i + 1) + ". " + questions.get(i).getQuestion());
      String[] options = questions.get(i).getOptions();
      for (int j = 0; j < options.length; j++) {
        System.out.println((char) ('A' + j) + ". " + options[j]);
      }
      System.out.print("Your answer: ");
      String answer = scanner.nextLine();
      if (answer.equals(questions.get(i).getAnswer())) {
        score++;
      }
    }
    
    // Display the user's score
    System.out.println("Your score: " + score + "/10");
    
  }

}

class Question {

  private String question;
  private String[] options;
  private String answer;

  public Question(String question, String[] options, String answer) {
    this.question = question;
    this.options = options;
    this.answer = answer;
  }

  public String getQuestion() {
    return question;
  }

  public String[] getOptions() {
    return options;
  }

  public String getAnswer() {
    return answer;
  }

}