package chap_02.car;

public class CarMain {
    public static void main(String[] args) {
        Config config = new Config();
        Driver driver1 = config.driver();

        driver1.drive();
    }
}
