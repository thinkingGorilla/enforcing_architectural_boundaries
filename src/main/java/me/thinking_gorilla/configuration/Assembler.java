package me.thinking_gorilla.configuration;

import org.reflections.Reflections;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static org.reflections.scanners.Scanners.TypesAnnotated;

public class Assembler {
    private static final Map<Class<?>, Object> registered = new HashMap<>();

    public static void init() {
        Reflections reflection = new Reflections("me.thinking_gorilla");
        Set<Class<?>> annotated = reflection.get(TypesAnnotated.with(Inject.class).asClass());

        for (Class<?> each : annotated) {
            registered.put(each.getInterfaces()[0], instantiate(each));
            System.out.println("Found annotated class: " + each.getName());
        }
    }

    private static Object instantiate(Class<?> each) {
        Object instance = null;
        try {
            Constructor<?> constructor = each.getDeclaredConstructor();
            constructor.setAccessible(true);
            instance = constructor.newInstance();
        } catch (NoSuchMethodException | InvocationTargetException | InstantiationException |
                 IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        return instance;
    }

    public static <T> T inject(Class<T> clazz) {
        return clazz.cast(registered.get(clazz));
    }
}
