package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import java.time.Duration;
import static org.testng.AssertJUnit.assertTrue;




// Open Browser
@Test (priority = 1)
public class TestCases {
    static ChromeDriver driver;
    public void test1() {
        if (driver == null) {
            driver = new ChromeDriver();
        }

        //WebDriverManager.chromedriver().setup();
        //ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://magento.softwaretestingboard.com/");
        //driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }


//Create an Account
@Test(priority = 2)
public static void test2() {

        driver.findElement(By.linkText("Create an Account")).click();
        driver.findElement(By.id("firstname")).sendKeys("Omar");
        driver.findElement(By.id("lastname")).sendKeys("Mahrous");
// Must be change mail every single time when you run
        driver.findElement(By.id("email_address")).sendKeys("omarmahrossss@gg.com");
        driver.findElement(By.id("password")).sendKeys("Omar12345");
        driver.findElement(By.id("password-confirmation")).sendKeys("Omar12345");
        driver.findElement(By.className("submit")).click();
//The Account has been Created
    }



// Navigate to Host Sellers in Home page
@Test(priority = 3)
public void test3() {

        driver.navigate().to("https://magento.softwaretestingboard.com/");
        String actualResult = driver.findElement(By.xpath("(//h2[normalize-space()='Hot Sellers'])[1]")).getText();
        String expecteTitle = "Hot Sellers";
        assertTrue(actualResult.contains(expecteTitle));
    }


//Add 2 Products to Compare list
@Test(priority = 4)
    public void test4(){
        driver.findElement(By.className("product-item-info")).click();
        driver.findElement(By.xpath("(//span[normalize-space()='Add to Compare'])[1]")).click();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.navigate().to("https://magento.softwaretestingboard.com/");
        driver.findElement(By.xpath("(//div[@class='product-item-info'])[2]")).click();
        driver.findElement(By.xpath("(//span[contains(text(),'Add to Compare')])[1]")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.findElement(By.xpath("(//a[@title='Compare Products'])[1]")).click();



        // For Close Browser
        driver.quit();

    }


}
