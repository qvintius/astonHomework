package homework1;

public class Homework1 {
    public static void main(String[] args) {
        turnString("I love Java");
        getDistinctNumbers(new int[]{1, 2, 2, 3, 4, 5, 5, 6, 7, 8, 8, 9});
        System.out.println(findSecondMaxElement(new int[]{10, 48, 23, 11, 44, 13, 66, 1, 6, 47}));
        System.out.println(lengthOfLastWord("    fly me    to the moon    "));
        System.out.println(isPalindrome("aba"));
    }

    // Перевернуть строку и вывести на консоль
    //  String string = "I love Java";
    public static void turnString(String string) {
        System.out.println("\nСлово задом напрёд: ");
        for (int i = string.length()-1; i >= 0; i--) {
            System.out.print(string.charAt(i));//массив задом наперёд
        }
        System.out.println();
    }

    // int[] ints = {1, 2, 2, 3, 4, 5, 5, 6, 7, 8, 8, 9};
    // Удалить дубликаты из массива и вывести в консоль
    public static void getDistinctNumbers(int[] ints) {
        int[] newInts = ints.clone();//клон исходного массива
        System.out.println("\nДубликаты массива: ");
        for (int i = 0; i < ints.length; i++) {
            for (int j = i + 1; j < newInts.length; j++) {
                if (ints[i] == ints[j]) {//сравнение элементов первого с последующими после него во втором
                    System.out.printf("%s ", ints[i]);//вывод дубликатов
                }
            }
        }
        System.out.println("\nМассив без дубликатов: ");
        for (int i = 0; i < newInts.length; i++) {
            boolean isDublicate = false;
            for (int j = i + 1; j < newInts.length; j++)//сравнение элемента из первого массива с последующими после него во втором
                if (newInts[i] == newInts[j])
                    isDublicate = true;//если такой же присутствует, то его не выводить

            if (!isDublicate)
                System.out.printf("%s ", newInts[i]);
        }
        System.out.println();
    }

    // Дан массив, заполненный уникальными значениями типа int.
    // int[] arr = {10, 15, 23, 11, 44, 13, 66, 1, 6, 47};
    // Необходимо найти элемент, который меньше максимума, но больше всех остальных.
    public static Integer findSecondMaxElement(int[] arr) {
        System.out.println("\nЭлемент, который меньше максимума, но больше всех остальных в массиве: ");
        int max = arr[0];
        int secondMax = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {//если текущий элемент больше мксимума, то сделать тот который был максимумом вторым за макимумом, а сам максимум обновить
                secondMax = max;
                max = arr[i];
            } else if (arr[i] > secondMax) //иначе если просто элемент больше текущего искомого значения, то обновить его
                secondMax = arr[i];

        }
        return secondMax;
    }

    // Найти длину последнего слова в строке. В строке только буквы и пробелы.
    // "Hello world" - 5
    // "    fly me    to the moon    " - 4
    public static Integer lengthOfLastWord(String string) {
        System.out.println("\nДлина последнего слова в строке: ");
        int length = 0;
        String[] arr = string.split(" ");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != "") {
                length = arr[i].length();
            }
        }
        return length;
    }

    // Определить, что строка является палиндромом
    // Сложность по памяти O(1), не создавать новые String, StringBuilder
    // Примеры:
    // abc - false
    // 112233 - false
    // aba - true
    // 112211 - true
    public static boolean isPalindrome(String string) {
        System.out.printf("\nСлово %s является палиндромом: ", string);
        boolean isPalindrome = true;
        for (int i = 0; i < string.length(); i++)
            if (string.charAt(i) != string.charAt(string.length() - 1 - i)) //сравнение с двух концов массива
                return false;//если найдено несовпадение, то не палендром

        return isPalindrome;
    }
}