package additionalFunctions;

import java.util.ArrayList;

public class SplitLines {
    public static String subStrings (ArrayList<String> lines, int index) { // передаем в метод массив строк и индекс элемента, который будем редактировать
        String str = lines.get(index); // записываем третий элемент массива в строку
        str = str.substring(0, str.length() - 1); // создаем подстроку, отрезаем последний символ
        str = str.substring(1); // создаем подстроку, отрезаем первый символ
        return str; // возвращаем итоговую строку без первого и последнего символа
    }
    public static double [] splitLines (String lines) { // передаем строку, полученную из предыдущего метода
        String [] words = lines.split(";"); // создаем массив строк и помещаем в него строки с разделителем
        double [] result = new double[words.length]; // создаем массив вещественных чисел
        for (int i = 0; i < words.length; i++) {
            result[i] = Double.parseDouble(words[i]); // помещаем в массив предварительно приведенные к вещественным числам строки
        }
        return result; // возвращаем этот массив
    }
}
