package com.company;

import java.security.cert.TrustAnchor;
import java.time.temporal.TemporalUnit;

public class MultipleBounds {
    class Car{
        void move(){
            System.out.println("Car is moving");
        }
    }

    class ManualCar extends Car{
        @Override
        void move(){
            System.out.println("Car is moving manually");
        }
    }

    class AutoCar extends Car{
        @Override
        void move() {
            System.out.println("Car is moving Automatically");
        }
    }

    interface CarMove{
        void moveViaInterface();
    }
    class FourWheelDrive extends Car implements CarMove{

        @Override
        public void move() {
            super.move();
        }

        @Override
        public void moveViaInterface() {
            System.out.println("Car is moving via Interface");
        }
    }

    class Truck extends Car implements CarMove{

        @Override
        public void moveViaInterface() {
            System.out.println("Truck is moving");
        }
    }

    class TransmitCar<U extends Car & CarMove>{
        void moveMyCar(U car){
           if(car instanceof Car){
               car.move();;
           }
           else if (car instanceof CarMove){
               car.moveViaInterface();
           }
        }
    }

    public static void main(String argv[]){
        MultipleBounds multipleBounds=new MultipleBounds();
        multipleBounds.start();
    }

    private void start() {
        Truck truck=new Truck();
        Car manualCar=new ManualCar();
        Car autoCar=new AutoCar();
        TransmitCar<Truck> moveTransmitCar=new TransmitCar<Truck>();
        moveTransmitCar.moveMyCar(truck);
    }

}
