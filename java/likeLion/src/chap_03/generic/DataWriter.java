package chap_03.generic;

import java.util.ArrayList;
import java.util.List;

public class DataWriter {
    static void addNumber(List<? super Integer> list) {
        for (int i = 0; i < 5; i++) {
            list.add(i);
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> integers = new ArrayList<>();
        addNumber(integers);


    }
}
