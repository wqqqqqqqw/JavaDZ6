
package javadz.DZ6;

/**
* Интерфейс счетчика геттеров в классе
*/
public interface IGetterCounter {
    /**
     * Возвращает количество геттеров в переданном классе
     * @param clazz класс, в котором необходимо посчитать геттеры
     * @return возвращает количество найденных геттеров 
     */
   int calcGetterCount(Class<?> clazz);
   String someAnotherMeth(Integer digit);
}
