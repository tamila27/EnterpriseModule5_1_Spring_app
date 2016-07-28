package ua.goit.java;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ua.goit.gojavaonline.Calculator;
import ua.goit.gojavaonline.MathExpressionParser;

/**
 * Created by tamila on 7/27/16.
 */
@Configuration
public class AppConfig {

    @Bean
    public Calculator calculator(){
        return new Calculator();
    }
    @Bean
    public MathExpressionParser mathExpressionParser(Calculator calculator){
        MathExpressionParser mathExpressionParser = new MathExpressionParser();
        mathExpressionParser.setCalculator(calculator);
        return mathExpressionParser;
    }
}
