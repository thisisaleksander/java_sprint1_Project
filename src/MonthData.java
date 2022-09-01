public class MonthData {
    private int[] stepsPerDay;

    public  void setStepsByDay(int day, int steps) {
        stepsPerDay[day] = steps;
    }
    public int[] getStepsPerDay() {
        return stepsPerDay;
    }

    public void setStepsPerDay(int[] stepsPerDay) {
        this.stepsPerDay = stepsPerDay;
    }

    public MonthData(int[] stepsPerDay) {
        this.stepsPerDay = stepsPerDay;
    }

    public MonthData(int daysInMonth) {
        this.stepsPerDay = new int[daysInMonth];
    }
    public MonthData() {
        stepsPerDay = new int[30];
    }

    public int getStepsByDay(int day) {
        return stepsPerDay[day];
    }
}
