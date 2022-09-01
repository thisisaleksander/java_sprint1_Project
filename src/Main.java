import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Приветствуем, это наш первый проект - Счетчик калорий!");
        printMenu();
        int userInput = scanner.nextInt();
        StepTracker stepTracker = new StepTracker();

        while (userInput != 0) {
            // обработка разных случаев
            if (userInput == 1) {
                System.out.println("За какой месяц вы хотите ввести количество шагов? Введите номер месяца (0 - январь, 11 - декабрь)");
                int mountsNumber = scanner.nextInt();
                System.out.println("За какой день вы хотите ввести количество шагов? Введите номер месяца (от 1 до 30)");
                int dayNumber = scanner.nextInt();
                System.out.println("Введите колчество шагов:");
                int stepsNumber = scanner.nextInt();

                stepTracker.addStepsByDay(mountsNumber, dayNumber, stepsNumber);
                System.out.println("Измененя сохранены: день " + dayNumber + " - " + stepTracker.getStepsByDay(mountsNumber, dayNumber));
            }
            else if (userInput == 2) {
                System.out.println("За какой месяц вы хотите узнать статистику? Введите номер месяца (0 - январь, 11 - декабрь)");
                int mountNumber = scanner.nextInt();

                    for (int j = 0; j < 30; j++) {
                        int stepsByDay = stepTracker.getStepsByDay(mountNumber, j);
                        System.out.print((j + 1) + " день: " + stepsByDay + ", ");
                    }
                System.out.println("");
                System.out.println("Общее количество шагов за месяц: " + stepTracker.getStepsSumByMonth(mountNumber));
                System.out.println("Максимальное пройденное количество шагов в месяце: " + stepTracker.getStepsMaxByMonth(mountNumber));
                System.out.println("Среднее количество шагов: " + stepTracker.getStepsAverageByMonth(mountNumber));
                System.out.println("Пройденная дистанция (в км): " + stepTracker.getTotalDistanceByMonth(mountNumber));
                System.out.println("Количество сожжённых килокалорий: " + stepTracker.getCaloriesByMonth(mountNumber));
                System.out.println("Лучшая серия: " + stepTracker.getBestSession(mountNumber));

            }
            else if (userInput == 3) {
                System.out.println("Введите новое значение для цели шагов в день:");
                int stepsTargetNew = scanner.nextInt();
                while (stepsTargetNew < 0) {
                    System.out.println("Введите неотрицательное значение");
                    stepsTargetNew = scanner.nextInt();
                }
                    stepTracker.setNewStepsTarget(stepsTargetNew);
                    System.out.println("Новое значение для цели шагов сохранено: " + stepTracker.stepsTarget);
                }
            else {
                System.out.println("Команда не найдена, пожалуйста введите другую");
            }
            printMenu(); // печатаем меню ещё раз перед завершением предыдущего действия
            userInput = scanner.nextInt(); // повторное считывание данных от пользователя
        }
        System.out.println("Программа завершена");
    }

    private static void printMenu() {
        System.out.println("Что вы хотите сделать?");
        System.out.println("1 - Ввести количество шагов за определённый день");
        System.out.println("2 - Напечатать статистику за определённый месяц");
        System.out.println("3 - Изменить цель по количеству шагов в день");
        System.out.println("0 - Выйти из приложения");
    }
}