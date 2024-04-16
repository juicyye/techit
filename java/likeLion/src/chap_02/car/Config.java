package chap_02.car;

public class Config {
    private Car car(){
        return new K3Car();
    }
    public Driver driver(){
        return new Driver(car());
    }


}
