package chap_03.generic;

public class GenericExamMain {
    public static void main(String[] args) {
        GenericExam<String, Book> exam = new GenericExam("하이", new Book(1L, "하이"));
        Book book = exam.getBook();
        String name = exam.getName();

        System.out.println("name = " + name);
        System.out.println("id = " + book);

    }
}
