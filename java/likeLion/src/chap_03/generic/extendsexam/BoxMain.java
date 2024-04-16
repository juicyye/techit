package chap_03.generic.extendsexam;

public class BoxMain {
    public static void main(String[] args) {
        StringBox<String, Integer> box = new StringBox<>("하이하이", 123);
        String value = box.getValue();
        Integer color = box.getColor();


    }
}
