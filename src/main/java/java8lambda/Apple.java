package java8lambda;

/**
 * Created by sunyuqing on 2019/11/7.
 */
public class Apple {
    private String color;
    private int weight;
    private int price;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Apple(String color, int weight, int price) {
        this.color = color;
        this.weight = weight;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "color='" + color + '\'' +
                ", weight=" + weight +
                ", price=" + price +
                '}';
    }
}
