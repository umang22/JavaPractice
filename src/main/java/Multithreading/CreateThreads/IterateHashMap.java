package Multithreading.CreateThreads;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class IterateHashMap implements Callable {


    public static void main(String[] args) {
        Map<Instant, UUID> map = new HashMap<>();

        ExecutorService executorService = Executors.newFixedThreadPool(2);

    }

    @Override
    public Object call() throws Exception {
        return null;
    }


}
