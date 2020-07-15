package HW1;

import HW1.Fruits.Fruit;

import java.util.ArrayList;

public class Box<T extends Fruit> {
    private ArrayList<T> fruits = new ArrayList<>();

    public void add(T fruit) {
        fruits.add(fruit);
    }

    public float getWeight() {
        if (fruits.size() == 0) {
            return 0;
        }
        return  fruits.get(0).getWeight() * fruits.size();
    }

    public boolean compare(Box<?> box) {
        if (getWeight() == box.getWeight()) {
            return true;
        }
        return false;
    }

    public void relocate(Box<T> box) {
        for (int i = 0; i < fruits.size(); i++) {
            box.add(fruits.get(i));
        }
        fruits.clear();
    }

}
