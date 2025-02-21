En este reposotorio se encuentra un intérprete de infix, el cual primero recibe un string con las operaciones y luego
parsea dichas operaciones a "lenguaje" postfix para evaluarlas y retornar su resultado.

También se utiliza el patrón de Class Factory para utilizar distintas implementaciones del intérprete postfix y el patrón de Singleton
para utilizar solo una instancia de la calculadora de postfix.