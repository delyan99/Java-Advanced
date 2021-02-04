import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Tracker {

    @Author(name = "George")
    public static void main(String[] args) {
        Tracker.printMethodsByAuthor(Tracker.class);
    }

    @Author(name = "Peter")
    public static void printMethodsByAuthor(Class<?> cl) {
        Map<String, List<String>> map = new HashMap<>();
        Method[] methods = cl.getDeclaredMethods();
        for (Method method : methods) {
            Author annotation = method.getAnnotation(Author.class);
            if (annotation != null) {
                map.putIfAbsent(annotation.name(), new ArrayList<>());
                map.get(annotation.name()).add(method.getName() + "()");
            }
        }
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + String.join(" ", entry.getValue()));
        }
    }
}
