package ParalleleTests;

import org.testng.annotations.Test;

public class ParalleleTest1 {
    @Test
    public void Test1() {
        System.out.println("Test 1 PARALLEL METHOD- " + Thread.currentThread().getId());
    }

    @Test
    public void Test2() {
        System.out.println("Test 2 PARALLEL METHOD- " + Thread.currentThread().getId());
    }

    @Test
    public void Test3() {
        System.out.println("Test 3 PARALLEL METHOD- " + Thread.currentThread().getId());
    }
}
