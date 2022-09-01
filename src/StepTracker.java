import java.util.Arrays;
import java.util.zip.ZipFile;

public class StepTracker {
    MonthData[] monthToData;
    Converter converter = new Converter();
    int stepsTarget = 10000;

    public StepTracker() {
        monthToData = new MonthData[12];
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    public void setNewStepsTarget(int newStepsTarget) {
        stepsTarget = newStepsTarget;
    }
    public int getBestSession(int month) {
        int[] sessions = new int[30];
        sessions[0] = 1;
        int[] bestSessions = new int[30];
        int realBestSession = 1;
        MonthData monthToData = this.monthToData[month];

        for (int i = 1; i < 29; i++) {
            if (monthToData.getStepsByDay(i) > monthToData.getStepsByDay(i - 1)) {
                sessions[i] = 1;
            }
            else {
                sessions[i] = 0;
            }
        }

        for (int i = 1; i < 30; i++) {
            if (sessions[i] == 1) {
                realBestSession = realBestSession + sessions[i];
            }
            else {
                bestSessions[i] = realBestSession;
                realBestSession = 1;
            }
        }

        realBestSession = 0;
        for (int i = 0; i < 30; i++) {
            if (bestSessions[i] > realBestSession) {
                realBestSession = bestSessions[i];
            }
        }

        return realBestSession;
    }
    public double getTotalDistanceByMonth(int month) {
        double distance = converter.convertToKM(getStepsSumByMonth(month));
        return  distance;
    }

    public double getCaloriesByMonth(int month) {
        double calories = converter.convertToCalories(getStepsSumByMonth(month));
        return  calories;
    }
    public int getStepsByDay(int month, int day){
        return monthToData[month].getStepsByDay(day);
    }

    public MonthData[] getMonthToData() {
        return monthToData;
    }

    public void setMonthToData(MonthData[] monthToData) {
        this.monthToData = monthToData;

    }

    public void addStepsByDay(int month, int day, int steps) {
        monthToData[month].setStepsByDay(day, steps);
    }

    public  int getStepsSumByMonth(int month) {
        int sum = 0;
        MonthData monthToData = this.monthToData[month];
        int[] stepsPerDay = monthToData.getStepsPerDay();
        for (int i = 0; i < stepsPerDay.length; i++) {
            sum += stepsPerDay[i];
        }
        return sum;
    }

    public int getStepsMaxByMonth(int month) {
        int max = 0;
        MonthData monthToData = this.monthToData[month];
        int[] stepsPerDay = monthToData.getStepsPerDay();
        for (int i = 0; i < stepsPerDay.length; i++) {
            if (stepsPerDay[i] > max) {
                max = stepsPerDay[i];
            }
        }
        return max;
    }

    public int getStepsAverageByMonth(int month) {
        return getStepsSumByMonth(month) / 30;
    }
}