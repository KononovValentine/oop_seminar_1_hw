public class Fruit {
    private final String name;
    private final String color;
    private final int weight;
    private final int price;

    Fruit(String name, String color, int weight, int price) {
        this.name = name;
        this.color = color;
        this.weight = weight;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public int getWeight() {
        return weight;
    }

    public int getPrice() {
        return price;
    }
}