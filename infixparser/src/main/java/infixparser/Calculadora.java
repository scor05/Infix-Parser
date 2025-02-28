package infixparser;

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
    @SuppressWarnings("rawtypes")
    public int evaluate(String postfix, IStack stackImplementation) throws ArithmeticException, IllegalArgumentException {
        @SuppressWarnings("unchecked")
        IStack<Integer> stack = stackImplementation;

        for (String token : postfix.split("\\s+")) {
            if (token.matches("\\d+")) {
                stack.push(Integer.valueOf(token));
            } else {
                if (postfix.split("\\s+").length < 3) throw new IllegalArgumentException("Operandos insuficientes");

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

        int resultado = stack.pop();
        
        if (stack.peek() != null) {
            throw new IllegalArgumentException("Expresión inválida");
        }

        return resultado;
    }
}

