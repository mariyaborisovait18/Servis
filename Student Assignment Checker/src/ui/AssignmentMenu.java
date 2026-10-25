
package ui;

import java.util.Scanner;
import factory.AssignmentCreator;
import factory.TestAssignmentCreator;
import factory.ProgrammingAssignmentCreator;
import factory.EssayAssignmentCreator;
import strategy.GradingContext;
import strategy.TestGradingStrategy;
import model.TestAssignment;
import model.ProgrammingAssignment;
import strategy.CodeGradingStrategy;
import model.EssayAssignment;
import strategy.EssayGradingStrategy;
import decorator.GradeResult;
import decorator.BasicGradeResult;
import decorator.LateSubmissionDecorator;
import decorator.PlagiarismCheckDecorator;
import decorator.FeedbackDecorator;

public class AssignmentMenu {
  
  private final Scanner scanner = new Scanner(System.in);
  
  public void start() {
    
    while (true) {
      System.out.println("\n=== СИСТЕМА ПРОВЕРКИ РАБОТ ===");
      System.out.println("1. Тест");
      System.out.println("2. Программирование");
      System.out.println("3. Эссе");
      System.out.println("0. Выход");
      System.out.print("Ваш выбор: ");
      
      String choice = scanner.nextLine();
      
      
      switch (choice) {
        case "1":
          checkTest();
          break;
          
        case "2":
          checkProgramming();
          break;
          
        case "3":
          checkEssay();
          break;
        
        case "0":
          System.out.println("Завершение программы...");
          return;
        
        default:
          System.out.println("Неверный выбор. Попробуйте снова.");
      }
    }
  }
  
  private void createAssignment(AssignmentCreator creator) {
    System.out.println("\n=== СОЗДАНИЕ ЗАДАНИЯ ===");
    creator.showAssignment();
  }
  
  
  private void checkTest() {
    
    System.out.println("\n=== ПРОВЕРКА ТЕСТА ===");
    
    // Создаём задание через Factory Method
    AssignmentCreator creator = new TestAssignmentCreator();
    
    TestAssignment test =
      (TestAssignment) creator.createAssignment();
    
    System.out.println("Название: " + test.getTitle());
    System.out.println("Количество вопросов: " + test.getQuestionCount());
    
    // Получаем результат студента
    System.out.print("Введите количество правильных ответов: ");
    
    int correctAnswers;
    
    try {
      correctAnswers = Integer.parseInt(scanner.nextLine());
    } catch (NumberFormatException e) {
      System.out.println("Ошибка: необходимо ввести целое число.");
      return;
    }
    
    // Выбираем стратегию оценивания
    GradingContext context =
      new GradingContext(new TestGradingStrategy());
    
    try {
      double grade = context.calculateGrade(
        correctAnswers,
        test.getQuestionCount()
      );
      
      System.out.println("Оценка студента: "
        + grade + " из " + test.getMaxScore());
      applyDecorators(
        grade,
        "Тест по Java проверен автоматически"
      );
      
    } catch (IllegalArgumentException e) {
      System.out.println("Ошибка: " + e.getMessage());
    }
  }
  
  
  private void checkProgramming() {
    
    System.out.println("\n=== ПРОВЕРКА ПРОГРАММНОГО ЗАДАНИЯ ===");
    
    // Создаём задание через Factory Method
    AssignmentCreator creator =
      new ProgrammingAssignmentCreator();
    
    ProgrammingAssignment assignment =
      (ProgrammingAssignment) creator.createAssignment();
    
    System.out.println("Название: " + assignment.getTitle());
    System.out.println("Язык программирования: "
      + assignment.getProgrammingLanguage());
    
    // Для демонстрации используем 10 тест-кейсов
    int totalTests = 10;
    
    System.out.println("Всего тест-кейсов: " + totalTests);
    System.out.print("Введите количество пройденных тест-кейсов: ");
    
    int passedTests;
    
    try {
      passedTests = Integer.parseInt(scanner.nextLine());
    } catch (NumberFormatException e) {
      System.out.println("Ошибка: необходимо ввести целое число.");
      return;
    }
    
    // Выбираем стратегию проверки программного кода
    GradingContext context =
      new GradingContext(new CodeGradingStrategy());
    
    try {
      double grade = context.calculateGrade(
        passedTests,
        totalTests
      );
      
      System.out.println("Оценка студента: "
        + grade + " из " + assignment.getMaxScore());
      applyDecorators(
        grade,
        "Программное задание проверено по тест-кейсам"
      );
      
    } catch (IllegalArgumentException e) {
      System.out.println("Ошибка: " + e.getMessage());
    }
  }
  
  
  private void checkEssay() {
    
    System.out.println("\n=== ПРОВЕРКА ЭССЕ ===");
    
    // Создаём задание через Factory Method
    AssignmentCreator creator = new EssayAssignmentCreator();
    
    EssayAssignment essay =
      (EssayAssignment) creator.createAssignment();
    
    System.out.println("Название: " + essay.getTitle());
    System.out.println("Минимальное количество слов: "
      + essay.getMinWordCount());
    
    System.out.println("\nВведите оценки по критериям (от 0 до 100):");
    
    int content;
    int structure;
    int grammar;
    
    try {
      System.out.print("Содержание: ");
      content = Integer.parseInt(scanner.nextLine());
      
      System.out.print("Структура: ");
      structure = Integer.parseInt(scanner.nextLine());
      
      System.out.print("Грамотность: ");
      grammar = Integer.parseInt(scanner.nextLine());
      
    } catch (NumberFormatException e) {
      System.out.println("Ошибка: необходимо вводить целые числа.");
      return;
    }
    
    // Выбираем стратегию оценивания эссе
    GradingContext context =
      new GradingContext(new EssayGradingStrategy());
    
    try {
      double grade = context.calculateEssayGrade(
        content,
        structure,
        grammar
      );
      
      System.out.println("\nИтоговая оценка за эссе: "
        + grade + " из " + essay.getMaxScore());
      applyDecorators(
        grade,
        "Эссе проверено преподавателем"
      );
      
    } catch (IllegalArgumentException e) {
      System.out.println("Ошибка: " + e.getMessage());
    }
  }
  
  private void applyDecorators(double grade, String description) {
    
    // Создаём базовый результат
    GradeResult result = new BasicGradeResult(
      grade,
      description
    );
    
    System.out.println("\n=== ДОПОЛНИТЕЛЬНАЯ ОБРАБОТКА ===");
    
    // Штраф за просрочку
    System.out.print("Применить штраф за просрочку? (да/нет): ");
    String lateAnswer = scanner.nextLine();
    
    if (lateAnswer.equalsIgnoreCase("да")) {
      try {
        System.out.print("Введите размер штрафа: ");
        double penalty = Double.parseDouble(scanner.nextLine());
        
        result = new LateSubmissionDecorator(result, penalty);
        
      } catch (NumberFormatException e) {
        System.out.println("Ошибка: некорректный размер штрафа.");
      } catch (IllegalArgumentException e) {
        System.out.println("Ошибка: " + e.getMessage());
      }
    }
    
    // Отметка о проверке на плагиат
    System.out.print(
      "Добавить отметку о проверке на плагиат? (да/нет): "
    );
    
    String plagiarismAnswer = scanner.nextLine();
    
    if (plagiarismAnswer.equalsIgnoreCase("да")) {
      result = new PlagiarismCheckDecorator(result);
    }
    
    // Комментарий преподавателя
    System.out.print(
      "Добавить комментарий преподавателя? (да/нет): "
    );
    
    String feedbackAnswer = scanner.nextLine();
    
    if (feedbackAnswer.equalsIgnoreCase("да")) {
      System.out.print("Введите комментарий: ");
      String feedback = scanner.nextLine();
      
      try {
        result = new FeedbackDecorator(result, feedback);
      } catch (IllegalArgumentException e) {
        System.out.println("Ошибка: " + e.getMessage());
      }
    }
    
    // Вывод итогового результата
    System.out.println("\n=== ИТОГОВЫЙ РЕЗУЛЬТАТ ===");
    System.out.println("Оценка: " + result.getScore());
    System.out.println(result.getDescription());
  }
  
}
