package HW1;

import HW1.Fruits.Apple;
import HW1.Fruits.Fruit;
import HW1.Fruits.Orange;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String[] arrStr = {"one", "two", "three", "four", "five"};
        Integer[] arrInt = {1, 2, 3, 4, 5};

        System.out.println(Arrays.toString(swapElements(arrStr, 0, 4)));
        System.out.println(Arrays.toString(swapElements(arrInt, 1, 3)));

        ArrayList<String> arrayStrList = convertToArrayList(arrStr);
        ArrayList<Integer> arrayIntList = convertToArrayList(arrInt);
        arrayStrList.add("six");
        arrayIntList.add(6);
        System.out.println(Arrays.toString(arrayStrList.toArray()));
        System.out.println(Arrays.toString(arrayIntList.toArray()));

        //////////////

        Box<Orange> orangeBox1 = new Box<>();
        Box<Orange> orangeBox2 = new Box<>();
        Box<Apple> appleBox = new Box<>();

        for (int i = 0; i < 10; i++) {
            orangeBox1.add(new Orange());
        }

        for (int i = 0; i < 5; i++) {
            appleBox.add(new Apple());
        }

        System.out.printf("Orange box1 weight: %.1f %n", orangeBox1.getWeight());
        System.out.printf("Orange box2 weight: %.1f %n", orangeBox2.getWeight());
        System.out.printf("Apple box's weight: %.1f %n", appleBox.getWeight());
        System.out.println(orangeBox1.compare(appleBox));

        orangeBox1.relocate(orangeBox2);

        System.out.printf("Orange box1 weight: %.1f %n", orangeBox1.getWeight());
        System.out.printf("Orange box2 weight: %.1f %n", orangeBox2.getWeight());
    }

    public static <T> T[] swapElements(T[] arr, int i, int j) {
        T[] newArr = arr.clone();
        T temp = newArr[i];
        newArr[i] = newArr[j];
        newArr[j] = temp;
        return newArr;
    }

    public static <E> ArrayList<E> convertToArrayList(E[] arr) {
        return new ArrayList<E>(Arrays.asList(arr));
    }
}
