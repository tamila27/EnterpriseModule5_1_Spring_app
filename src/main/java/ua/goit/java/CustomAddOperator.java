package ua.goit.java;

import ua.goit.gojavaonline.AddOperator;

import java.time.LocalDate;

/**
 * Created by tamila on 7/27/16.
 */
public class CustomAddOperator extends AddOperator {
    @Override
    public String calculate(String a, String b) {
        if(CustomOperandTypeAnalizer.getOperandClass(a) == LocalDate.class) {
            return calculateDates((LocalDate) CustomOperandTypeAnalizer.parse(a), (Long) CustomOperandTypeAnalizer.parse(b));
        }
        return super.calculate(a, b);
    }

    private String calculateDates(LocalDate a, Long b){
        LocalDate localDate = a.plusDays(b);
        return localDate.getYear()+ ":" + localDate.getMonthValue() + ":" + localDate.getDayOfMonth();
    }
}
