import java.util.Stack;

public class Calculadora {
    private static Calculadora instance;

    private Calculadora() {}
    /**
     * Obtiene la instancia de la calculadora, es el método Singleton.
    * @return
     */
    public static Calculadora getInstance() {
        if (instance == null) {
            instance = new Calculadora();
        }
        return instance;
    }
    /**
    * 
    * @param postfix
    * @return
    * @throws ArithmeticException
     * @throws IllegalArgumentException
     */
    public int evaluate(String postfix) throws ArithmeticException, IllegalArgumentException {
        Stack<Integer> stack = new Stack<>();
        
        for (String token : postfix.split(" ")) {
            if (token.matches("\\d+")) { // 
                stack.push(Integer.valueOf(token));
            } else {
                if (stack.size() < 2) throw new IllegalArgumentException("Expresión inválida");

                int b = stack.pop();
                int a = stack.pop();

                switch (token) {
                    case "+" -> stack.push(a + b);
                    case "-" -> stack.push(a - b);
                    case "*" -> stack.push(a * b);
                    case "/" -> {
                        if (b == 0) {
                            throw new ArithmeticException("División por cero");
                        }
                        stack.push(a / b);
                    }
                    default -> throw new IllegalArgumentException("Operador desconocido: " + token);
                }
            }
        }

        return stack.pop();
    }
}

