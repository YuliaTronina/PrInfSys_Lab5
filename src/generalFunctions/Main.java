package generalFunctions;

import additionalFunctions.DocumentReader;
import additionalFunctions.SplitLines;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) { //Главный метод, точка входа в программу
        ArrayList<String> list  = DocumentReader.fileLineReader("lab5/src/file1"); // читаем данные из файла и сохраняем в массив
        double [] averageRecoveryTime = SplitLines.splitLines(SplitLines.subStrings(list,2)); // массив с пороговыми значениями для параметра Тв, взятый из прочитанного файла
        double [] estDurTransIO = SplitLines.splitLines(SplitLines.subStrings(list,4)); // массив с пороговыми значениями для параметра Тп, взятый из прочитанного файла
        double probability = ProbabilityWithoutFailures.probabilityCalculations(list); // рассчет P
        double averageRecTimeEstimate = AverageRecTime.averageRecoveryTimeEstimate(list,AverageRecTime.recoveryTime(averageRecoveryTime)); // рассчет Qв
        double estDurTransformIO = EstDurTransformIO.estimateDurationIO(EstDurTransformIO.actualConversionDuration(list,estDurTransIO)); // рассчет Qп
        System.out.println("Вероятность безотказной работы (P): "+probability);
        System.out.println("Оценка по среднему времени восстановления (Qв): "+averageRecTimeEstimate);
        System.out.println("Оценка по продолжительности преобразования входного набора данных в выходной (Qп): "+estDurTransformIO);
        System.out.println("Итоговая оценка вероятности безотказной работы : "+probability);
        System.out.println("Итоговая оценка по среднему времени восстановления и продолжительности преобразования : "+ MetricsCalculations.finalGradeCalculation(averageRecTimeEstimate,estDurTransformIO));
        System.out.println("Абсолютный показатель критериев : "+ MetricsCalculations.absoluteIndicatorsCalculation(probability, MetricsCalculations.finalGradeCalculation(averageRecTimeEstimate,estDurTransformIO)));
        System.out.println("Относительный показатель критериев : "+ MetricsCalculations.relativeIndicatorsCalculation(MetricsCalculations.absoluteIndicatorsCalculation(probability, MetricsCalculations.finalGradeCalculation(averageRecTimeEstimate,estDurTransformIO)),Double.parseDouble(list.get(6))));
        System.out.println("Фактор надежности : "+ MetricsCalculations.relativeIndicatorsCalculation(MetricsCalculations.absoluteIndicatorsCalculation(probability, MetricsCalculations.finalGradeCalculation(averageRecTimeEstimate,estDurTransformIO)),Double.parseDouble(list.get(6))));
    }
}
