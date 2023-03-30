import java.util.Scanner;

class StepTracker {
    /* Реализация логики по сохранению
    и изменению количества шагов + вывод статистики */
    Scanner scanner;
    MonthData[] monthToData = new MonthData[12];
    int goalByStepsPerDay = 10000;
    Converter converter = new Converter();

    StepTracker(Scanner scan) {
        scanner = scan;

        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    void addNewNumberStepsPerDay() {
        // Ввод и проверка № месяца, дня и кол-ва шагов
        System.out.println("Введите номер месяца");
        int month = scanner.nextInt();
        if (month < 1 || month > 12) {
            System.out.println("Такого месяца нет");
            return;
        }
        System.out.println("Введите день от 1 до 30 (включительно)");
        int day = scanner.nextInt();
        if (day < 1 || day > 30) {
            System.out.println("Такого дня нет");
            return;
        }
        System.out.println("Введите количество шагов");
        int step = scanner.nextInt();
        if (step < 0) {
            System.out.println("Количество шагов не может быть меньше нуля");
            return;
        }
        // Получение соответствующего объекта MonthData из массива
        MonthData monthData = monthToData[month - 1];
        // Сохранение полученных данных
        monthData.days[day - 1] = step;

    }

    void changeStepGoal() {
        // Пользовательский ввод цели по кол-ву шагов
        System.out.println("Введите цель по количеству шагов в день");
        int newGoalByStepsPerDay = scanner.nextInt();
        if (newGoalByStepsPerDay <= 0) {
            System.out.println("Цель по количеству шагов не может быть меньше или равно нулю");
            return;
        }
        goalByStepsPerDay = newGoalByStepsPerDay;
    }

    void printStatistic(){
        System.out.println("Введите число месяца");
        int month = scanner.nextInt();
        if (month < 1 || month > 12) {
            System.out.println("Такого месяца нет");
            return;
        }
        int sumSteps = monthToData[month - 1].sumStepsFromMonth();
        System.out.println("Количество пройденных шагов по дням");
        monthToData[month - 1].printDaysAndStepsFromMonth();
        System.out.println("Общее количество шагов за месяц - " + sumSteps);
        System.out.println("Максимальное пройденное количество шагов в месяце - "
                + monthToData[month - 1].maxSteps());
        System.out.println("Среднее количество шагов - "
                + (sumSteps / monthToData[month - 1].days.length));
        System.out.println("Пройденная дистанция (в км) - "
                + converter.convertToKm(sumSteps));
        System.out.println("Количество сожжённых килокалорий - "
                + converter.convertStepsToKilocalories(sumSteps));
        System.out.println("Лучшая серия - "
                + monthToData[month - 1].bestSeries(goalByStepsPerDay));
        System.out.println();
    }
}
