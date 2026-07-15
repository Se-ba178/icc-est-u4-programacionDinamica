## Practica de Programacion Dinamica ejercicio Fibonacci
fecha : 15/7/2026
Nombre : Christian Sebastian Villa Morales
```java
    public static void main(String[] args) throws Exception {
        // runFibonnaci();
        // runFibonnaciRecursivoPD();
        // runFibonacciTres();
        runFibonacciIterativoPractica();

    }

    private static void runFibonacciIterativoPractica() {
        long startTime = System.nanoTime();
        int num = 48;
        long i = getFibonacciIterativo(num);
        long endTime = System.nanoTime();
        long executionTime = endTime - startTime;

        double milliseconds = (executionTime / 1_000_000.0);

        System.out.println("Finbonaci de " + num + " es " + i + "  en: " + milliseconds + " milliseconds");

    }

    public static long getFibonacciIterativo(int n) {
        if (n <= 1) {
            return n;
        }

        long anteriorAnterior = 0; 
        long anterior = 1; 
        long actual = 0;

        for (int i = 2; i <= n; i++) {
            actual = anterior + anteriorAnterior;
            anteriorAnterior = anterior;
            anterior = actual;
        }

        return actual;

    }

    private static void runFibonacciTres() {
        long startTime = System.nanoTime();
        int num = 48;
        long i = getFibonacciTres(num);
        long endTime = System.nanoTime();
        long executionTime = endTime - startTime;

        double milliseconds = (executionTime / 1_000_000.0);

        System.out.println("Finbonaci de " + num + " es " + i + "  en: " + milliseconds + " milliseconds");

    }

    public static long getFibonacciTres(int n) {
        if (n <= 1) {
            return n;
        }
        long[] dp = new long[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];

    }

    private static void runFibonnaciRecursivoPD() {
        long startTime = System.nanoTime();
        int num = 48;
        long[] memo = new long[num + 1];
        long i = getFibonacciPD(num, memo);
        long endTime = System.nanoTime();
        long executionTime = endTime - startTime;

        double milliseconds = (executionTime / 1_000_000.0);

        System.out.println("Finbonaci de " + num + " es " + i + "  en: " + milliseconds + " milliseconds");

    }

    public static long getFibonacciPD(int n, long[] memo) { // Complejidad Temporal = O(n)
        if (n <= 1) {
            return n;
        }
        if (memo[n] != 0) {
            return memo[n];
        }
        memo[n] = getFibonacciPD(n - 1, memo) + getFibonacciPD(n - 2, memo);
        return memo[n];

    }

    private static void runFibonnaci() {
        long startTime = System.nanoTime();
        int num = 48;
        long i = getFibonacci(num);
        long endTime = System.nanoTime();
        long executionTime = endTime - startTime;

        double milliseconds = (executionTime / 1_000_000.0);

        System.out.println("Finbonaci de " + num + " es " + i + "  en: " + milliseconds + " milliseconds");

    }

    private static long getFibonacci(int i) {
        if (i <= 1) {
            return i;
        }
        return getFibonacci(i - 1) + getFibonacci(i - 2);
    }
```
En esta practica creamos algunos metodos que nos van a permitir poder realizar la suma de fibonacci pero aplicando programacion dinamica osea dividiendolo en problemas mas pequeños para de ahi solo quedarnos con el calculo ademas de practicar de como bajar la complejidad de un codigo de O(n) a O(1) lo cual va a servir para el examen despues y para otrps ejericios de la practica del dia de mañana 

## Practica 
fecha : 15/7/2026
