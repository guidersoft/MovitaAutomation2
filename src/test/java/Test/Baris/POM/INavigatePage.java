package Test.Baris.POM;

import Test.Baris.Locators.BaseLocator;

import java.lang.reflect.InvocationTargetException;

public interface INavigatePage extends BaseLocator {

    default   <T> T navigateTo(Class<T> clazz)  {
        try {
            return clazz.getDeclaredConstructor().newInstance();
        } catch (InvocationTargetException | NoSuchMethodException | InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
