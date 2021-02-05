package barracksWars.core;

import barracksWars.interfaces.*;

import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class CommandInterpreterImp implements CommandInterpreter {
    private Repository repository;
    private UnitFactory unitFactory;
    
    public CommandInterpreterImp(Repository repository, UnitFactory unitFactory){
        this.repository = repository;
        this.unitFactory = unitFactory;
    }
    
    @Override
    public Executable interpretCommand(String[] data, String commandName) {
        Executable executable = null;
        commandName = commandName.replaceFirst(String.valueOf(commandName.charAt(0)), String.valueOf(commandName.toUpperCase().charAt(0)));
        try {
            Class<?> clazz = Class.forName("barracksWars.core.commands." + commandName);
            Constructor<?> constructor = clazz.getDeclaredConstructor();
            constructor.setAccessible(true);
            executable = (Executable)constructor.newInstance();
            setFields(executable, data);
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }

        return executable;
    }

    private void setFields(Executable executable, String[] data) throws IllegalAccessException {
        Field[] fields = executable.getClass().getDeclaredFields();
        Field[] declaredFields = this.getClass().getDeclaredFields();
        for (Field field : fields) {
            Inject annotation = field.getAnnotation(Inject.class);
            if(annotation != null){
                field.setAccessible(true);
                if(field.getType() == String[].class){
                    field.set(executable, data);
                }else{
                    for (Field declaredField : declaredFields) {
                        if(declaredField.getType() == field.getType()){
                            field.set(executable, declaredField.get(this));
                        }
                    }
                }
            }
        }
    }
}
