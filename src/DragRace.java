import java.util.LinkedList;
import java.util.Random;

public record DragRace(LinkedList<Car> cars) {

    // Автомобили подготавливаются к гонке
    public void setRace() {
        System.out.println();
        for (Car car : cars) {
            car.startEngine();
        }
    }

    // Автомобиль завершает гонку
    private void stopRace(Car car, int time) {
        System.out.println();
        System.out.println("Автомобиль " + car.getModel() + " завершил заезд!");
        System.out.println("Автомобиль " + car.getModel() + " заезжает в боксы.");
        System.out.println("Время заезда: " + time + " миллисекунд.");
        car.stopEngine();
    }

    // Начинает соревнование и подсчитывает время заездов
    public void startRace(int distance) {
        String[] result = new String[cars.size()];
        Random random = new Random();
        String firstPlace = "";
        String secondPlace = "";
        String thirdPlace = "";
        int minTime = 90000;
        int minTimeIndex = 0;
        int secondMinTime = 90000;
        int secondMinTimeIndex = 0;
        int thirdMinTime = 90000;
        int thirdMinTimeIndex = 0;
        for (int i = 0; i < cars.size(); i++) {
            StringBuilder stringBuilder = new StringBuilder();
            int raceWay = distance;
            int speed = 0;
            int milliseconds = 0;
            while (raceWay > 0) {
                speed = speed + cars.get(i).getBoost();
                milliseconds = milliseconds + random.nextInt(850, 1000);
                raceWay = raceWay - speed;
            }
            stopRace(cars.get(i), milliseconds);
            stringBuilder.append(cars.get(i).toString())
                    .append(", Max speed: ")
                    .append(speed)
                    .append(", Milliseconds to finish: ")
                    .append(milliseconds);
            result[i] = stringBuilder.toString();
        }
        System.out.println();
        System.out.println("Результаты заездов: ");


        for (int i = 0; i < result.length; i++) {
            int time = Integer.parseInt(result[i].split("Milliseconds to finish: ")[1]);
            if (i == 0) {
                minTime = time;
                secondMinTime = time;
                thirdMinTime = time;
            }
            if (time < minTime) {
                minTime = time;
                minTimeIndex = i;
            }
            if (time < secondMinTime && time > minTime) {
                secondMinTime = time;
                secondMinTimeIndex = i;

            }
            if (time < thirdMinTime && time > secondMinTime) {
                thirdMinTime = time;
                thirdMinTimeIndex = i;
            }
            firstPlace = result[minTimeIndex];
            secondPlace = result[secondMinTimeIndex];
            thirdPlace = result[thirdMinTimeIndex];

            System.out.println(result[i]);
        }
        System.out.println();
        System.out.println("Победители соревнования: ");
        System.out.println("1 место: " + firstPlace);
        System.out.println("2 место: " + secondPlace);
        System.out.println("3 место: " + thirdPlace);
    }
}
