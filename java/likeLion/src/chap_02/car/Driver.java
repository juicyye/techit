package chap_02.car;

public class Driver {
    private Car car;

    public Driver(Car car) {
        this.car = car;
    }

    public void drive(){
        System.out.println("자동차를 운전합니다.");
        car.startEngine();
        car.pressAccelerator();
        car.offEngine();
    }
}
