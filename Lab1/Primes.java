public class Primes {
    //Класс Primes, позволяющий определить простоту числа и получить список
    public static void main(String[] args) {
        //Метод вывода простых чисел от 2 до 100
        for (int i = 2; i <= 100; i++)
            if (isPrime(i))
                System.out.println(i);
    }

    public static boolean isPrime(int n) {
        // Метод, возвращающий простое число}
        boolean is_Prime = true;
        for (int i = 2; i < Math.sqrt(n); i++)
            if (n % i == 0) is_Prime = false;
        return is_Prime;
    }
}


