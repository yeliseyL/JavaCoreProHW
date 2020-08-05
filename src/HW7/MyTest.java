package HW7;

public class MyTest {
    @BeforeSuite
    public static void beforeMethod() {
        System.out.println("Starting tests!");
    }

    @Test(priority = 8)
    public static void test1() {
        System.out.println("test1...");
    }

    @Test(priority = 3)
    public static void test2() {
        System.out.println("test2...");
    }

    @Test(priority = 10)
    public static void test3() {
        System.out.println("test3...");
    }

    @AfterSuite
    public static void afterMethod() {
        System.out.println("Tests finished!");
    }

}
