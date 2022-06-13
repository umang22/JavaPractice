package Multithreading.Createlist;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class ConcurrentErrorTest {
    static final long runtime = 5000;
    static final AtomicInteger errCount = new AtomicInteger();
    static final int count = 10;

    public static void main(String[] args) throws InterruptedException {
        List<Thread> list = new LinkedList<>();
        final Map<String, Integer> map = getMap();

        for (int i = 0; i < count; i++) {
            Thread t = getThread(map);
            list.add(t);
            t.start();
        }

        for (int i = 0; i < count; i++) {
            list.get(i).join(runtime + 1000);
        }

        for (String s : map.keySet()) {
            System.out.println(s + " " + map.get(s));
        }
        System.out.println("Length:" + map.size());
        System.out.println("Errors recorded: " + errCount.get());
    }

    private static Map<String, Integer> getMap() {
        Map<String, Integer> map = new HashMap<>();
        return map;
    }

    private static Map<String, Integer> getConcMap() {
        Map<String, Integer> map = new ConcurrentHashMap<>();
        return map;
    }

    private static Thread getThread(final Map<String, Integer> map) {
        return new Thread(new Runnable() {
            @Override
            public void run() {
                long start = System.currentTimeMillis();
                long now = start;
                while (now - start < runtime) {
                    try {
                        for (int i = 0; i < 1000; i++)
                            map.put("i=" + i, i);
                        now = System.currentTimeMillis();
                    } catch (Exception e) {
                        System.out.println("P - Error occured: " + e.toString());
                        errCount.incrementAndGet();
                    }
                }
            }
        });
    }
}