package org.prog.poly.homework;

public class Android implements IPhone {

    @Override
    public void call() {
        System.out.println("Android phone call");
    }

    @Override
    public void unlock() {
        System.out.println("Android phone unlock");
    }
}
