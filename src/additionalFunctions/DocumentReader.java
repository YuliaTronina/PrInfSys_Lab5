package additionalFunctions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DocumentReader {
    public static ArrayList<String> fileLineReader(String filename) { // на вход подаем строку с путем к файлу
        BufferedReader reader; // создаем ридер для чтения из файла
        ArrayList<String> readLines = new ArrayList<>(); // создаем массив строк
        try {
            reader = new BufferedReader(new FileReader(filename)); // указываем из какого файла читать
            String line = reader.readLine(); // читаем строку
            while (line != null) { // если не конец файла
                readLines.add(line); //записываем прочитанное в массив строк
                line = reader.readLine(); // переходим на следующую строку
            }
            reader.close(); // закрываем ридер
        } catch (IOException e) {
            throw new RuntimeException(e); // выбрасываем ошибку в случае чего
        }
        return readLines; // возвращаем массив строк
    }
}
