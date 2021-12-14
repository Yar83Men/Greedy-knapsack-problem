package Algorithm_and_Structure;

import java.util.Arrays;

public class BackPack_with_foods {
    // Объекты делимые на части
    public static void main(String[] args) {
        final Item item1 = new Item(4, 20);
        final Item item2 = new Item(3, 18);
        final Item item3 = new Item(2, 14);
        final Item[] items = {item1, item2, item3};
        //Вместимость рюкзака
        //final int backPackWeight = 7;
        //System.out.println(Arrays.toString(items));
        System.out.println(max(items, 7));
    }
    private static int max(Item[] arr, int maxBackPackWeight){
        Arrays.sort(arr, (a, b) -> (int) (b.valuePerUnitOfWeight() - a.valuePerUnitOfWeight()));
        int sum = 0;
        int temp = 0;

        for (int i = 0; i < arr.length; i++) {
            Item current = arr[i];
            if (maxBackPackWeight - current.getWeight() >= 0) {
                maxBackPackWeight -= current.getWeight();
                sum += current.getValue();
            } else {
                //temp количество товара arr[i] не вошедшего в рюкзак
                temp = current.getValue() - maxBackPackWeight;
                // + количество что влезло * вес одной части товара
                sum += (current.getValue() - temp) * current.valuePerUnitOfWeight();
                break;
            }
        }
        return sum;
    }
}

class Item {
    private final int weight;
    private final int value;

    public Item(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }

    public int getWeight() {
        return weight;
    }

    public int getValue() {
        return value;
    }

    public double valuePerUnitOfWeight() {
        return (double) value / weight;
    }

    @Override
    public String toString() {
        return "{" +
                "weight=" + weight +
                ", value=" + value +
                '}';
    }
}
