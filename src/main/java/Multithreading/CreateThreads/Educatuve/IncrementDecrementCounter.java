package Multithreading.CreateThreads.Educatuve;

/*It increments a counter and decrements it an equal number of times.
 The final value of the counter should be zero, however,
 if you run the program enough times, you'll sometimes get the correct zero value,
  and at others, you'll get a non-zero value.
   We sleep the threads to give them a chance to run in a non-deterministic order.*/

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class IncrementDecrementCounter {

    //statement to sleep thread randomly
    static Random random = new Random(System.currentTimeMillis());

    public static void main(String[] args) throws InterruptedException {
        //create object of unsafe counter
        ThreadUnsafeCounter badCounter = new ThreadUnsafeCounter();
//        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> map = Collections.synchronizedMap(new HashMap<>());
        //create a thread to increment badCounter 200 times
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    badCounter.increment();
                    map.put(i, i);
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("map in t1 :" + map);
                    IncrementDecrementCounter.sleepRandomlyForLessThan10Sec();
                }
            }
        });

        //setup a thread to decrement the badCounter 200 times
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    badCounter.decrement();
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    map.remove(i);
                    System.out.println("map in t2 :" + map);
                    IncrementDecrementCounter.sleepRandomlyForLessThan10Sec();
                }
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        badCounter.printFinalCount();
        System.out.println("Final Map -> " + map.entrySet());


    }

    private static void sleepRandomlyForLessThan10Sec() {
        try {
            Thread.sleep(random.nextInt(10));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

class ThreadUnsafeCounter {
    int count = 0;

    public void increment() {
        count++;
    }

    public void decrement() {
        count--;
    }

    void printFinalCount() {
        System.out.println("Counter is : " + count);
    }
}
