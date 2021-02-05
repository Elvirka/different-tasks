package com.github.elvirka.tasks.entityLockerTask;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

public class EntityLocker<T> {
    private final Map<T, ReentrantLock> lockers = new HashMap<>();

    void getLock(T id){
        ReentrantLock locker = lockers.get(id);
        synchronized (this) {
            if (locker == null) {
                locker = new ReentrantLock();
                lockers.put(id, locker);
            }
        }
        locker.lock();
    }

    void releaseLock(T id){
        ReentrantLock locker = lockers.get(id);
        if (locker == null) {
            throw new IllegalStateException("Lock is missing");
        }
        locker.unlock();
    }

}
