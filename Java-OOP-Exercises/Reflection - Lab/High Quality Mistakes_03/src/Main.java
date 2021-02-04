import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Class<Reflection> reflectionClass = Reflection.class;
        List<String> fieldList = new ArrayList<>();
        List<String> getterList = new ArrayList<>();
        List<String> setterList = new ArrayList<>();
        Field[] fields = reflectionClass.getDeclaredFields();
        Method[] methods = reflectionClass.getDeclaredMethods();

        for (Field field : fields) {
            if(!Modifier.isPrivate(field.getModifiers())){
                fieldList.add(field.getName() + " must be private!");
            }
        }
        Collections.sort(fieldList);
        for (String field : fieldList) {
            System.out.println(field);
        }

        for (Method method : methods) {
            if(method.getName().startsWith("get")){
                if(!Modifier.isPublic(method.getModifiers())){
                    getterList.add(method.getName() + " have to be public!");
                }
            }else if(method.getName().startsWith("set")){
                if(!Modifier.isPrivate(method.getModifiers())){
                    getterList.add(method.getName() + " have to be private!");
                }
            }
        }
        Collections.sort(getterList);
        Collections.sort(setterList);

        for (String getter : getterList) {
            System.out.println(getter);
        }

        for (String setter : setterList) {
            System.out.println(setter);
        }
    }
}
