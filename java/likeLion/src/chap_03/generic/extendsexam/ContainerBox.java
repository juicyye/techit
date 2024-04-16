package chap_03.generic.extendsexam;

public class ContainerBox<T> implements Container<T>{
    private T value;
    @Override
    public void setValue(T value) {
        this.value = value;
    }

    @Override
    public T getValue() {
        return value;
    }
}
