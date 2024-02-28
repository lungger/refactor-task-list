package Commands;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class CommandFactory {
    public static Command createCommand(String commandName, String params) {
        try {
            String className = "Commands." + capitalize(commandName);
            Class<?> commandClass = Class.forName(className);

            Constructor<?> constructor = commandClass.getConstructor(String.class);
            return (Command) constructor.newInstance(params);
        }
        catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            return null;
        }
    }

    private static String capitalize(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
}
