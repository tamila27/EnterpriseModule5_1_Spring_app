package ua.goit.java;

import ua.goit.gojavaonline.OperandTypeAnalyser;

import java.time.LocalDate;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

/**
 * Created by tamila on 7/27/16.
 */
public class CustomOperandTypeAnalizer extends OperandTypeAnalyser{
    private static final Pattern DATE_PATTERN = Pattern.compile("\\d+:\\d+:\\d+");

    public static Class getOperandClass(String operand) {
        return DATE_PATTERN.matcher(operand).matches()? LocalDate.class:(OperandTypeAnalyser.getOperandClass(operand));
    }

    private static LocalDate parseData(String operand){
        StringTokenizer stringTokenizer = new StringTokenizer(operand, ":", true);
        int year = Integer.parseInt(stringTokenizer.nextToken());
        stringTokenizer.nextToken();
        int month = Integer.parseInt(stringTokenizer.nextToken());
        stringTokenizer.nextToken();
        int day = Integer.parseInt(stringTokenizer.nextToken());
        return LocalDate.of(year, month, day);
    }

    public static Object parse(String operand) {
        return getOperandClass(operand) == LocalDate.class?parseData(operand):OperandTypeAnalyser.parseOperand(operand);
    }
}
