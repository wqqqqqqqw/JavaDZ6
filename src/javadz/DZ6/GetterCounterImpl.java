package javadz.DZ6;

import java.lang.reflect.Method;

public class GetterCounterImpl implements IGetterCounter {

    @Override
    public int calcGetterCount(Class<?> clazz) {
        int result = 0;
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            if (method.getAnnotationsByType(Skip.class).length == 0) {
                if (method.getName().startsWith("get")
                        && method.getReturnType() != null
                        && method.getParameterCount() == 0) {
                    ++result;
                }
            }
        }
        System.out.println("Getters in " + clazz.getSimpleName() + ": "
                                         + result);
        return result;
    }
    
    @Override
    public String someAnotherMeth(Integer digit) {
        return digit.toString();
    }

}
