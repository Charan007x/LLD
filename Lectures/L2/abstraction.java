interface Car{
    void startEngine();
    void shiftGear(int gear);
    void accelerate();
    void brake();
    void stopEngine();
}

class sportsCar implements  Car{ //concrete class needs to have implementation of all the abstract methods of the interface
    String brand;
    String model;
    boolean isEngineOn=false;
    int currSpeed=0;
    int currGear=0;
    public sportsCar(String brand,String model){
        this.brand=brand;
        this.model=model;
    }

    @Override // @Override marks this as an implementation of a method
    // required by the Car interface, and asks Java to check that it matches the signature.
    public void startEngine(){
        isEngineOn=true;
        System.out.println("Engine on");
    }
    
    @Override
    public void shiftGear(int gear){
        if(!isEngineOn){
            System.out.println("Engine is off");
            return;
        }
        this.currGear=gear;
        System.out.println("The current gear is : "+currGear);
    }

    @Override
    public void accelerate(){
        if(!isEngineOn){
            System.out.println("Engine is off");
            return;
        }
        currSpeed+=20;
        System.out.println("Current Speed : "+currSpeed);
    }    

    @Override
    public void brake(){
        currSpeed-=20;
        if(currSpeed<20){
            currSpeed=0;
        }
        System.out.println("The current speed is : "+currSpeed);
    }

    @Override
    public void stopEngine(){
        isEngineOn=false;
        currSpeed =0;
        currGear=0;
        System.out.println("Engine turned off");
    }
}

public class abstraction{
    public static void main(String []args){
        Car myCar=new sportsCar("Ford","Mustang");
        myCar.startEngine();
        myCar.shiftGear(2);
        myCar.accelerate();
        myCar.brake();
        myCar.stopEngine();
    }
}


// Car is the interface and the variable’s reference type.
// myCar is a reference variable.
// new sportsCar("Ford", "Mustang") creates a sportsCar object.


// If some method depends on the car, eg Garage(Car myCar), now if we observe since made our code
// based on a contract and not tightly coupled, we ca change sportsCar to electricCar and it will function
// the same. This passing of car object to garage is called Dependency Injection. 