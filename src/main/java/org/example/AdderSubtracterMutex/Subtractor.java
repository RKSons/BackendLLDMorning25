package org.example.AdderSubtracterMutex;

import java.util.concurrent.Callable;
import java.util.concurrent.locks.Lock;

public class Subtractor implements Callable<Void> {
    Value v;
    Lock lock;
    Lock lock2;

    public Subtractor(Value v, Lock lock, Lock lock2){
        this.v = v;
        this.lock = lock;
        this.lock2 = lock2;
    }

    @Override
    public Void call() throws Exception {
        for(int i=1;i<=1000;i++){
            lock.lock();
            lock2.lock();
            System.out.println("Subtracting :" + i);
            v.x -= i;
            lock2.unlock();
            lock.unlock();
        }
        return null;
    }
}
