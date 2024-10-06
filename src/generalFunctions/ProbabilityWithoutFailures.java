package generalFunctions;

import java.util.ArrayList;

public class ProbabilityWithoutFailures { //Оценка вероятности безотказной работы P
    public static double probabilityCalculations(ArrayList<String> lines) {
        int numberOfExperiments = Integer.parseInt(lines.get(1)); // Количество экспериментов N
        int numberOfFailures = Integer.parseInt(lines.get(0)); // Количество отказов Q
        return 1 - (double) numberOfFailures / (double) numberOfExperiments; // Возврат вероятности безотказной работы
    }
}
