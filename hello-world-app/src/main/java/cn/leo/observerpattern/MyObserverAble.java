package cn.leo.observerpattern;

import java.util.Observable;
import java.util.Observer;

public class MyObserverAble extends Observable{

    Observer observer1;
    Observer observer2;
    Observer observer3;
    
    public MyObserverAble(){
        observer1=new Observer1();
        observer2=new Observer2();
        observer3=new Observer2();
        addObserver(observer3);
        addObserver(observer2);
        addObserver(observer1);
    }
    
    public static void main(String[] args) {
        MyObserverAble observerAble=new MyObserverAble();
        observerAble.setChanged();

        try {
            observerAble.notifyObservers();
        } catch (Exception e) {
            System.out.println("in notify exception");
            e.printStackTrace();
        }
    }
}
