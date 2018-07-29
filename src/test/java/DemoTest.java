import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DemoTest {

    protected WebDriver driver;

    @BeforeClass
    public static void init() {
        ChromeDriverManager.getInstance().setup();
    }

    @Test
    public void testGoogleSearch() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get("http://www.google.com/xhtml");
        Thread.sleep(5000);
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("ChromeDriver");
        searchBox.submit();
        Thread.sleep(5000);  // Let the user actually see something!

        Assert.assertEquals(2 + 2, 5);

    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

}
