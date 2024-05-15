import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GoogleSearchTest {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        // Set the path to the chromedriver executable
        System.setProperty("webdriver.chrome.driver", "C:\\Automation\\Selenium\\src\\test\\resources\\chromedriver-win64\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
//        ChromeDriver driver = new ChromeDriver(options);
        
        driver = new ChromeDriver(options);
    }

    @Test
    public void testGoogleSearch() {
        driver.get("https://www.google.com");

        // Find the search box
        WebElement searchBox = driver.findElement(By.name("q"));

        // Enter a search term
        searchBox.sendKeys("Selenium WebDriver");

        // Submit the search
        searchBox.submit();

        // Verify the title of the page
        Assert.assertTrue(driver.getTitle().contains("Selenium WebDriver"));
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
