package operations;

import java.util.ArrayList;
import java.util.List;

public class Operations {
    ArrayList<String> simbol = new ArrayList<>();
    ArrayList<Integer> nums = new ArrayList<>();
    private double result;

    public Operations(String operation){
        try {
            setResult(operation);
        } catch (IllegalArgumentException | ArithmeticException e){
            throw new IllegalArgumentException(e.getMessage());
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

            if (operator.equals("*") || operator.equals("/")){
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
            String operator = expression.get(i);
            double nextNum = parseNumber(expression.get(i + 1));

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

    public void setResult(String result) {
        System.out.println(result);
        this.result = calculate(result);

    }

    public String getResult() {
        return String.valueOf(result);
    }
}
