package chap_03.generic;

import java.util.Arrays;
import java.util.List;

public class WildcardExam {
    static void printList(List<?> list){
        for (Object object : list) {
            System.out.println("object = " + object);
        }
    }
    static<T> void printList2(List<T> list, T element){
        list.add(element);
        for (T object : list) {
            System.out.println("object = " + object);
        }
    }
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3);
        printList(list);
    }
}
