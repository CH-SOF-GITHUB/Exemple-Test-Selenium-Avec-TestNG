package ParalleleTests;

import org.testng.annotations.Parameters;

public class ParalleleInstanceTest {
    private String browser;

    @Parameters("browser")
    public ParalleleInstanceTest(String browser) {
        this.browser = browser;
    }

    public void TestBrowser() {
        System.out.println("Execution avec " + browser + " - Thread ID: " + Thread.currentThread().getId());
    }
}
