package blackBoxInteger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        Class<BlackBoxInt> blackBoxIntClass = BlackBoxInt.class;
        Constructor<BlackBoxInt> declaredConstructor = blackBoxIntClass.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);
        BlackBoxInt blackBoxInt = declaredConstructor.newInstance();
        Method[] methods = blackBoxIntClass.getDeclaredMethods();
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        while (!"END".equals(input)){
            String[] tokens = input.split("_");
            String command = tokens[0];
            int param = Integer.parseInt(tokens[1]);
            switch (command){
                case "add":
                    for (Method method : methods) {
                        if(method.getName().equals("add")){
                            printValue(blackBoxIntClass, blackBoxInt, param, method);
                        }
                    }
                    break;
                case "subtract":
                    for (Method method : methods) {
                        if(method.getName().equals("subtract")){
                            printValue(blackBoxIntClass, blackBoxInt, param, method);
                        }
                    }
                    break;
                case "divide":
                    for (Method method : methods) {
                        if(method.getName().equals("divide")){
                            printValue(blackBoxIntClass, blackBoxInt, param, method);
                        }
                    }
                    break;
                case "multiply":
                    for (Method method : methods) {
                        if(method.getName().equals("multiply")){
                            printValue(blackBoxIntClass, blackBoxInt, param, method);
                        }
                    }
                    break;
                case "rightShift":
                    for (Method method : methods) {
                        if(method.getName().equals("rightShift")){
                            printValue(blackBoxIntClass, blackBoxInt, param, method);
                        }
                    }
                    break;
                case "leftShift":
                    for (Method method : methods) {
                        if(method.getName().equals("leftShift")){
                            printValue(blackBoxIntClass, blackBoxInt, param, method);
                        }
                    }
                    break;
            }
            input = scanner.nextLine();
        }
    }

    private static void printValue(Class<BlackBoxInt> blackBoxIntClass, BlackBoxInt blackBoxInt, int param, Method method) throws IllegalAccessException, InvocationTargetException, NoSuchFieldException {
        method.setAccessible(true);
        method.invoke(blackBoxInt, param);
        Field field = blackBoxIntClass.getDeclaredField("innerValue");
        field.setAccessible(true);
        Integer innerValue = (Integer) field.get(blackBoxInt);
        System.out.println(innerValue);
    }
}
