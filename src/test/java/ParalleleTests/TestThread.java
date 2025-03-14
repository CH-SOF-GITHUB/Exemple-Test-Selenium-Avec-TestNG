package ParalleleTests;

import org.testng.annotations.Test;

public class TestThread {

    @Test(invocationCount = 6, threadPoolSize = 3)
    public void Run() {
        System.out.println("Run at Thread: " + Thread.currentThread().getId());
    }
}
