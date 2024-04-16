package chap_03.generic.extendsexam;

public class StringBox<T, U> extends Box<T> {
    private U color;

    public StringBox(T value, U color) {
        super(value);
        this.color = color;
    }

    public U getColor() {
        return color;
    }

    public void setColor(U color) {
        this.color = color;
    }
}
