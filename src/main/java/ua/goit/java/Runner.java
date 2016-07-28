package ua.goit.java;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ua.goit.gojavaonline.*;

import java.util.Scanner;

/**
 * Created by tamila on 7/25/16.
 */
public class Runner {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        Calculator calculator = applicationContext.getBean("calculator", Calculator.class);
        calculator.registerOperator("+", new CustomAddOperator());
        calculator.registerOperator("-", new SubOperator());
        calculator.registerOperator("*", new MultiplyOperator());
        calculator.registerOperator("/", new DivisionOperator());
        MathExpressionParser mathExpressionParser = applicationContext.getBean("mathExpressionParser", MathExpressionParser.class);

        while(true){
            Scanner scanner = new Scanner(System.in);
            System.out.print("Please, input your expression: ");
            String expression = scanner.nextLine();
            if(expression.equals("q")){
                return;
            }
            System.out.println(expression + " = " + mathExpressionParser.calculateExpression(expression));
        }
    }
}
