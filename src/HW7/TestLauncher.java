package HW7;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.TreeMap;

public class TestLauncher {
    public static void start(Class cls) {
        Method[] methods = cls.getDeclaredMethods();
        boolean beforeLaunched = false;
        boolean afterLaunched = false;
        try {
            for (Method m : methods) {
                if(m.isAnnotationPresent(BeforeSuite.class)) {
                    if (!beforeLaunched) {
                        m.invoke(null);
                        beforeLaunched = true;
                    } else {
                        throw new RuntimeException();
                    }
                }
            }

            TreeMap<Integer, Method> metMap = new TreeMap<>();
            for (Method m : methods) {
                if(m.isAnnotationPresent(Test.class)){
                    metMap.put(m.getAnnotation(Test.class).priority(), m);
                }
            }

            for (Integer priority : metMap.descendingKeySet()) {
                metMap.get(priority).invoke(null);
            }

            for (Method m : methods) {
                if(m.isAnnotationPresent(AfterSuite.class)) {
                    if (!afterLaunched) {
                        m.invoke(null);
                        afterLaunched = true;
                    } else {
                        throw new RuntimeException();
                    }
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
