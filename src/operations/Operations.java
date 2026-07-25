package operations;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.SimpleTimeZone;

public class Operations {
    ArrayList<String> simbol = new ArrayList<>();
    ArrayList<Integer> nums = new ArrayList<>();
    public Operations(String operation){
        try {
            double result = calculate(operation);
            System.out.println(result);
        } catch (IllegalArgumentException | ArithmeticException e){
            System.out.println("Error: " + e.getMessage());
        }

    }

    private double calculate(String operation) {
        String[] tokens = operation.split("\\s+");

        /*Revisa que haya numeros y que la operacion se pueda realizar
        Los numeros impares son signos y numeros pares son numeros
         */
        if (tokens.length % 2 == 0){
            throw new IllegalArgumentException("La operacion no es valida");
        }
        List<String> expression = new ArrayList<>();

        //primer numero
        expression.add(tokens[0]);

        //Operaciones de multiplicación y división
        for (int i=1; i < tokens.length; i+=2){
            String operator = tokens[i];
            double nextNum = parseNumber(tokens[i+1]);
            System.out.println(operator);
            if (operation.equals("*") || operation.equals("/")){
                double previousNumber = parseNumber(expression.removeLast());

                double partialResult;

                if (operator.equals("*")) {
                    partialResult = previousNumber * nextNum;
                } else {
                    if (nextNum == 0) {
                        throw new ArithmeticException("No se puede dividir entre cero");
                    }

                    partialResult = previousNumber / nextNum;
                }

                expression.add(String.valueOf(partialResult));
            } else if (operator.equals("+") || operator.equals("-")){
                expression.add(operator);
                expression.add(String.valueOf(nextNum));
            } else {
                throw new IllegalArgumentException(
                        "Operador no válido: " + operator
                );
            }

        }

        double result = Double.parseDouble(expression.getFirst());

        //Sumas y restas
        for (int i=1; i < expression.size(); i+=2){
            String operator = expression.get(1);
            double nextNum = parseNumber(expression.get(i)+1);

            if (operator.equals("+")) result += nextNum;
            else result -= nextNum;
        }

        return result;
    }

    private double parseNumber(String value){
        try {
            return Double.parseDouble(value);
        }catch (NumberFormatException e) {
            throw new IllegalArgumentException("Error " + e.getMessage());
        }

    }
    public static void main(String[] args) {
        new Operations("123 - 200 * 3");

    }
}
