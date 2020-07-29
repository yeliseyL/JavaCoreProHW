package HW5;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Car implements Runnable {
    private static int CARS_COUNT;
    static {
        CARS_COUNT = 0;
    }
    private Race race;
    private int speed;
    private String name;
    private CountDownLatch cdl1;
    private CountDownLatch cdl2;
    private Semaphore smp;
    public String getName() {
        return name;
    }
    public int getSpeed() {
        return speed;
    }
    public Car(Race race, int speed, CountDownLatch cdl1, CountDownLatch cdl2, Semaphore smp) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
        this.cdl1 = cdl1;
        this.cdl2 = cdl2;
        this.smp = smp;
    }
    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int)(Math.random() * 800));
            System.out.println(this.name + " готов");
            cdl1.countDown();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            cdl1.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }
        try {
            smp.acquire();
            if (smp.availablePermits() == CARS_COUNT - 1) {
                System.out.println(this.name + " WIN");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        cdl2.countDown();
    }
}
