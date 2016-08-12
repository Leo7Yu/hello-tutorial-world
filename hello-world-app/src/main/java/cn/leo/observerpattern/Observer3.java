package cn.leo.observerpattern;

import java.util.Observable;
import java.util.Observer;

public class Observer3 implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("in observer2 update");
        throw new RuntimeException("observer3 runtimeException...");
    }

}
