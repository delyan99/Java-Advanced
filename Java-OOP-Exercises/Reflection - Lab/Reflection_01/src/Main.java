import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<Reflection> reflectionClass = Reflection.class;
        System.out.println(reflectionClass);
        Class<? super Reflection> superclass = reflectionClass.getSuperclass();
        System.out.println(superclass);
        Class<?>[] interfaces = reflectionClass.getInterfaces();
        for (Class<?> anInterface : interfaces) {
            System.out.println(anInterface);
        }
        Reflection reflection = reflectionClass.getDeclaredConstructor().newInstance();
        System.out.println(reflection);
    }
}
