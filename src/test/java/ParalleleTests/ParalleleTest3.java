package ParalleleTests;

import org.testng.annotations.Test;

public class ParalleleTest3 {
    @Test
    public void ToTest3() {
        System.out.println("To Test 3 PARALLEL TEST- " + Thread.currentThread().getId());
    }
}
