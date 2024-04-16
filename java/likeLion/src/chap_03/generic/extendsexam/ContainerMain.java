package chap_03.generic.extendsexam;

public class ContainerMain {
    public static void main(String[] args) {
        Container<String> container = new ContainerBox<>();
        container.setValue("하이");
        String value = container.getValue();
        System.out.println("value = " + value);

        Container<Integer> integerContainer = new ContainerBox<>();
        integerContainer.setValue(10);
        Integer value1 = integerContainer.getValue();
        System.out.println("value1 = " + value1);
    }
}
