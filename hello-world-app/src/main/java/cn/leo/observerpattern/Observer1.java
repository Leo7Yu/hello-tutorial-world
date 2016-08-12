package cn.leo.observerpattern;

import java.util.Observable;
import java.util.Observer;

public class Observer1 implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("in observer1 update");
        
    }

}
