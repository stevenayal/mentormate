package common;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import utilities.WaitUtilities;

public class TestObject {
    protected WebDriver driver;
    protected WaitUtilities wait;

    @BeforeSuite
    public void setUpTestSuite() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setUpTest() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        wait = new WaitUtilities(driver);
    }

    @AfterMethod
    public void tearDownTest() {
        driver.quit();
    }
}
