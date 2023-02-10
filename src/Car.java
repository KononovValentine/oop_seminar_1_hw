import java.util.Arrays;

public class Car {
    private final String model;
    private final int year;
    private final int price;
    private final String color;
    private final double engine;
    private final int horsePower;
    private final int weight;
    private boolean isFrontLeftWindowOpen = false;
    private boolean isFrontRightWindowOpen = false;
    private boolean isRearLeftWindowOpen = false;
    private boolean isRearRightWindowOpen = false;
    private boolean isPowerOn = false;

    Car(String model, int year, int price, String color, double engine, int horsePower, int weight) {
        this.model = model;
        this.year = year;
        this.price = price;
        this.color = color;
        this.engine = engine;
        this.horsePower = horsePower;
        this.weight = weight;
    }

    // Выводит информацию по автомобилю
    public void getInfo() {
        String stringBuilder = "Model: " +
                model +
                ", Power: " +
                engine +
                ", Year: " + year;
        System.out.println(stringBuilder);
    }

    public String getModel() {
        return model;
    }

    // Запускает двигатель
    public void startEngine() {
        if (isPowerOn) {
            System.out.println("Двигатель уже запущен!");
        } else {
            isPowerOn = true;
            System.out.println(model + " Двигатель запущен.");
        }
    }

    // Останавливает двигатель
    public void stopEngine() {
        if (isPowerOn) {
            isPowerOn = false;
            System.out.println(model + " Двигатель остановлен.");
        } else {
            System.out.println("Двигатель не запущен!");
        }
    }

    // Устанавливает пункт назначения автомобиля
    public void setWay(String way) {
        if (isPowerOn) {
            System.out.println("Автомобиль " + model + " двигается в пункт: " + way);
        } else {
            System.out.println("Двигатель не запущен! Невозможно ехать.");
        }
    }

    // Устанавливает несколько пунктов назначения
    public void setWay(String[] way) {
        if (isPowerOn) {
            System.out.println("Автомобиль " + model + " двигается в пункты: " + Arrays.toString(way));
        } else {
            System.out.println("Двигатель не запущен! Невозможно ехать.");
        }
    }

    // изменяет положение окон
    public void changeWindowState(String window) {
        switch (window.toLowerCase()) {
            case "front left" -> {
                isFrontLeftWindowOpen = !isFrontLeftWindowOpen;
            }
            case "front right" -> {
                isFrontRightWindowOpen = !isFrontRightWindowOpen;
            }
            case "rear left" -> {
                isRearLeftWindowOpen = !isRearLeftWindowOpen;
            }
            case "rear right" -> {
                isRearRightWindowOpen = !isRearLeftWindowOpen;
            }
        }
    }

    public String getWindowStatus(String window) {
        String result = "";
        switch (window.toLowerCase()) {
            case "front left" -> {
                if (isFrontLeftWindowOpen) {
                    result = "Окно открыто";
                } else {
                    result = "Окно закрыто";
                }
            }
            case "front right" -> {
                if (isFrontRightWindowOpen) {
                    result = "Окно открыто";
                } else {
                    result = "Окно закрыто";
                }
            }
            case "rear left" -> {
                if (isRearLeftWindowOpen) {
                    result = "Окно открыто";
                } else {
                    result = "Окно закрыто";
                }
            }
            case "rear right" -> {
                if (isRearRightWindowOpen) {
                    result = "Окно открыто";
                } else {
                    result = "Окно закрыто";
                }
            }
        }
        return result;
    }

    // Возвращает полную информацию по автомобилю
    @Override
    public String toString() {
        return "Model: " +
                model +
                ", Year: " +
                year +
                ", Price: " +
                price +
                ", Color: " +
                color +
                ", Engine: " +
                engine +
                ", Horse Power: " +
                horsePower +
                ", Weight: " +
                weight;
    }

    // Сравнивает два автомобиля по основным техническим параметрам
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Car car)) {
            return false;
        }
        return model.equals(car.model)
                && engine == car.engine
                && horsePower == car.horsePower
                && weight == car.weight;
    }

    // Вычисляет коэффециент ускорения
    public int getBoost() {
        return weight / horsePower;
    }
}