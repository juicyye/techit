package chap_03.generic.balpyo;

public class GenericClass<T, U> {
    private T name;
    private U age;

    public GenericClass(T name, U age) {
        this.name = name;
        this.age = age;
    }

    public T getName() {
        return name;
    }

    public U getAge() {
        return age;
    }
}
