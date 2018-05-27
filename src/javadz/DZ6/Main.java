package javadz.DZ6;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        SomeClass mc = new SomeClass("abc", new ArrayList<String>(), 2.5);

        IGetterCounter proxyGC = (IGetterCounter) Proxy.newProxyInstance(SomeClass.class.getClassLoader(),
                new Class[]{IGetterCounter.class},
                new InvocationHandler() {

            String analizedClassName;
            Map<String, Integer> classesGettersCountMaper = new HashMap<>();

            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("\nProxying..");
                if (method.getName().equals("calcGetterCount")) {
                    System.out.println("Invoking calcGetterCount method");
                    analizedClassName = ((Class) args[0]).getSimpleName();

                    if (classesGettersCountMaper.containsKey(analizedClassName)) {
                        System.out.println("Returning from memory");
                        return classesGettersCountMaper.get(analizedClassName);
                    } else {
                        System.out.println("Calculating");
                        int count = new GetterCounterImpl().calcGetterCount((Class) args[0]);
                        classesGettersCountMaper.put(analizedClassName, count);
                        return count;
                    }
                } else {
                    System.out.println("Invoking another method");
                    return null;
                }
            }
        });

        proxyGC.calcGetterCount(mc.getClass()); //Proxying..
                                                //Invoking calcGetterCount method
                                                //Calculating
                                                //Getters in SomeClass: 2

        proxyGC.someAnotherMeth(123);  //Proxying..
                                       //Invoking another method

        proxyGC.calcGetterCount(mc.getClass()); //Proxying..
                                                //Invoking calcGetterCount method
                                                //Returning from memory
    }
}
