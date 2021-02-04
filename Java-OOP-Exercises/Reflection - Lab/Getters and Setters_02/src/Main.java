import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<Reflection> reflectionClass = Reflection.class;
        Method[] declaredMethods = reflectionClass.getDeclaredMethods();
        List<String> getters = new ArrayList<>();
        List<String> setters = new ArrayList<>();

        for (Method declaredMethod : declaredMethods) {
            if(declaredMethod.getName().contains("get")) {
                getters.add(declaredMethod.getName() + " will return class " + declaredMethod.getReturnType().getName());
            }
        }
        Collections.sort(getters);

        for (String getter : getters) {
            System.out.println(getter);
        }
        for (Method declaredMethod : declaredMethods) {
            if(declaredMethod.getName().contains("set")) {
                Class<?>[] parameterTypes = declaredMethod.getParameterTypes();
                StringBuilder parType = new StringBuilder();
                for (Class<?> parameterType : parameterTypes) {
                    parType.append(parameterType.getName()).append(" ");
                }
                setters.add(declaredMethod.getName() + " and will set field of class " + parType.toString());
            }
        }
        Collections.sort(setters);

        for (String setter : setters) {
            System.out.println(setter);
        }
    }
}
