package ParalleleTests;

import org.testng.annotations.Test;

public class ParalleleTest2 {
    @Test
    public void TestA() {
        System.out.println("Test A PARALLEL CLASS- " + Thread.currentThread().getId());
    }

    @Test
    public void TestB() {
        System.out.println("Test B PARALLEL CLASS- " + Thread.currentThread().getId());
    }
}
