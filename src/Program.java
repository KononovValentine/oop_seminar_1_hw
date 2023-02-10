//Доработайте программу в свободном стиле.
//Можно сравнить 2 автомобиля между собой
//Или пусть авто заедет за фруктами :-)
//Добавьте несколько произвольных методов и свойств
//<br>
//ДОП: Сделать гонки:
//- задаём растояние
//- едут до финиша.
//Сказать кто победит.

import java.util.LinkedList;
import java.util.Random;

public class Program {
    public static void main(String[] args) {
        String[] models = {"Ford", "Lada", "Volkswagen", "Seat", "Toyota", "Mitsubishi", "Iran Khodro"};
        String[] colors = {"Black", "White", "Red", "Blue", "Green", "Yellow", "Silver"};
        double[] engines = {1.0, 1.2, 1.4, 1.5, 1.6, 1.8, 2.0, 2.2, 2.4};
        Random random = new Random();
        LinkedList<Car> listCars = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            Car car = new Car(
                    models[random.nextInt(0, models.length)],
                    random.nextInt(1990, 2022),
                    random.nextInt(900000, 3000000),
                    colors[random.nextInt(0, colors.length)],
                    engines[random.nextInt(0, engines.length)],
                    random.nextInt(80, 220),
                    random.nextInt(1250, 2000)
            );
            listCars.add(car);
        }

        System.out.println("Список участников: ");
        for (Car listCar : listCars) {
            System.out.println(listCar.toString());
        }

        DragRace dragRace = new DragRace(listCars);
        dragRace.setRace();
        dragRace.startRace(420);
    }
}
