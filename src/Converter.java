public class Converter {
    public double convertToKM(int sumOfSteps) {
        double totalDistance = 0.0;
        totalDistance = sumOfSteps * 0.75 / 1000;
        return totalDistance;
    }

    public double convertToCalories(int sumOfSteps) {
        double totalCalories = 0.0;
        totalCalories = sumOfSteps * 50 / 1000;
        return totalCalories;
    }
}
