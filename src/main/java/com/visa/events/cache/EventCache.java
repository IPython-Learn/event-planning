package com.visa.events.cache;

import com.visa.events.model.Estimation;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Simple InMemory Cache
 *
 * @author ThirupathiReddy Vajjala
 */
public class EventCache {


    private static final Map<String, Estimation> CACHE = new HashMap();
    private static EventCache INSTANCE;
    static Lock lock = new ReentrantLock();

    /**
     * simple demonstration of lock API for synchronization
     *
     * @return singleton Instance
     */
    public static EventCache getInstance() {

        if (INSTANCE == null) {
            lock.lock();

            if (INSTANCE == null) {
                INSTANCE = new EventCache();
            }

            lock.unlock();
        }

        return INSTANCE;
    }

    /**
     * isEstimationAvailable
     *
     * @param referenceId referenceId
     * @return true if estimation available in cache
     */
    public boolean isEstimationAvailable(String referenceId) {

        return CACHE.containsKey(referenceId);
    }

    /**
     * Returns {@link Estimation} baed on referenceId
     *
     * @param referenceId referenceId
     * @return estimation {@link Estimation}
     */
    public Estimation get(String referenceId) {

        return CACHE.get(referenceId);

    }


    /**
     * adding calculated estimation details to cache
     *
     * @param referenceId referenceId
     * @param estimation  {@link Estimation}
     * @return estimation {@link Estimation}
     */
    public Estimation put(String referenceId, Estimation estimation) {

        lock.lock();
        estimation = CACHE.put(referenceId, estimation);
        lock.unlock();

        return estimation;
    }
}
