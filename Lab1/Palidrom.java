public class Palindrom {
    // Класс, позволяющий определить палиндром
    public static void main(String[] args){
        // Метод, обрабатывающий аргументы командной строки и проверяет, являются ли они палиндромами
        for (int i = 0; i < args.length; i++){
            String s = args[i];
            if (isPalindrom(s)){
                System.out.println(s + " is a palindrom");
            }
            else{
                System.out.println(s + " is not a palindrom");
            }
        }
    }
    public static String reverseString(String s) {
        // Возвращает перевернутую строку
        return new StringBuilder(s).reverse().toString();
    }
    public static boolean isPalindrom(String s) {
        // Проверяет на палиндром
        return s.equals(reverseString(s));
    }
}