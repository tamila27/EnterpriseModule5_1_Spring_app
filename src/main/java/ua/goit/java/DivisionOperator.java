package ua.goit.java;

import ua.goit.gojavaonline.BinaryOperator;
import ua.goit.gojavaonline.OperandTypeAnalyser;
import ua.goit.gojavaonline.Operator;

/**
 * Created by tamila on 7/27/16.
 */
public class DivisionOperator extends Operator implements BinaryOperator {
    @Override
    public String calculate(String a, String b) {
        if(OperandTypeAnalyser.getOperandClass(a) == Double.class ||
                OperandTypeAnalyser.getOperandClass(b) == Double.class){
            return calculateDouble(OperandTypeAnalyser.parseOperand(a).doubleValue(), OperandTypeAnalyser.parseOperand(b).doubleValue());
        }
        return calculateLong(OperandTypeAnalyser.parseOperand(a).longValue(), OperandTypeAnalyser.parseOperand(b).longValue());
    }

    public String calculateDouble(Double a, Double b){
        return String.valueOf(a / b);
    }

    public String calculateLong(Long a, Long b){
        return String.valueOf(a / b);
    }
}
