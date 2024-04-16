package chap_03.generic;

public class GenericMethod {
    static <T> void printArrayElements(T[] array){
        for (T t : array) {
            System.out.println("t = " + t);
        }
    }

    public static <T> T getGenericElement(T[] array, int index) {
        //<T>는 제네릭임을 알려주는 선언에 불과하다
        if (index >= 0 && index < array.length) {
            return array[index];
        } else {
            return null;
        }
    }
    static <t, u> void print(t generic, u hi){
        System.out.println(generic);
        System.out.println("hi = " + hi);
    }
    static <t> void max(t x, t y, t z){
        System.out.println("x = " + x);
        System.out.println("z = " + z);
    }



    public static void main(String[] args) {
//        Integer[] iarray = {1, 2, 3, 4, 5, 6, 7, 8};
//
//        printArrayElements(iarray); // 기본형은 제네릭으로 받을 수 없음

        int a= 3;
        max(a, 3, new Book(1L,"하이"));
        print("하이", new Book(1L,"하이"));

    }
}
