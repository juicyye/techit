package chap_03.generic.extendsexam;

public interface Container<T> {
    T getValue();
    void setValue(T value);
}
