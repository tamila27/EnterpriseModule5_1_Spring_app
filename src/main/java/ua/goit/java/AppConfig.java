package ua.goit.java;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import ua.goit.gojavaonline.Calculator;
import ua.goit.gojavaonline.MathExpressionParser;

/**
 * Created by tamila on 7/27/16.
 */
@Configuration
@EnableAspectJAutoProxy
public class AppConfig {

    @Bean
    public LogAspect logAspect() {
        return new LogAspect();
    }

    @Bean
    public Calculator calculator() {
        return new Calculator();
    }

    @Bean
    public MathExpressionParser mathExpressionParser(Calculator calculator) {
        MathExpressionParser mathExpressionParser = new MathExpressionParser();
        mathExpressionParser.setCalculator(calculator);
        return mathExpressionParser;
    }
}
