package Multithreading.CreateThreads;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

import static java.lang.Thread.sleep;

public class ThreadTask implements Callable<Result> {

    @Override
    public Result call() throws Exception {
        Result result = new Result();
        for (int i = 0; i < 20; i++) {
            sleep(2000);
//            result.i = i;
            Thread thread = new Thread();
            result.map.put(i, i);
            System.out.println(result.map);
        }

        return result;
    }
}

class Result {
    public int i;
    Map<Integer, Integer> map = new HashMap<>();

}
