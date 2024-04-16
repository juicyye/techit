package chap_03.generic;

public class PairMain {
    static class print <T,S> {
        private T name;
        private S value;

    }


    public static void main(String[] args) {
        GenericPair<String, Integer> pair = new GenericPair<>("hello", 4);
        String first = pair.getFirst();
        Integer second = pair.getSecond();

        GenericPair<Book, String> pair2 = new GenericPair<>(new Book(1L, "모두의 자바"), "제네릭");
        Book first1 = pair2.getFirst();
        String second1 = pair2.getSecond();

    }
}
