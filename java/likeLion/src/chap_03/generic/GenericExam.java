package chap_03.generic;

public class GenericExam<T,U> {
    private T name;
    private U book;

    public GenericExam(T name, U book) {
        this.name = name;
        this.book = book;
    }

    public T getName() {
        return name;
    }

    public U getBook() {
        return book;
    }
}
