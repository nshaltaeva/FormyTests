package SuperHero.HomePage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class ApplyingIterationMethods {

    public WebDriver driver;
    public String URL = "https://glitchitsystem.com/superhero/index.html";

    public void LoginWithCredential() throws InterruptedException {
        WebElement email = driver.findElement(By.id("loginEmail"));
        email.sendKeys("justtesting@gmail.com");
        WebElement password = driver.findElement(By.id("loginPassword"));
        password.sendKeys("123456");
        driver.findElement(By.xpath("//*[@id=\"form-login\"]/button")).click();
        Thread.sleep(3000);
    }

    public List<String> SuperHeroNames(){
        List<String> names = new ArrayList<>();
        names.add("Wolverine");
        names.add("Iron Man");
        names.add("Deadpool");
        names.add("Thor");
        names.add("Spider-Man");
      //  names.add("Elsa");
         return names;
    }

    @BeforeMethod
    public void SetUp2() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(URL);
    }

    @Test(description = "Verify Names SuperHero Roster", priority = 0)
    public void VerifyNamesSuperHeroRoster() throws InterruptedException {
        LoginWithCredential();

        List<WebElement> listWebElements = driver.findElements(By.xpath("//*[@id='hero-list']//li"));
        for(int i=0; i<listWebElements.size();i++){
            System.out.println(listWebElements.get(i).getText());
            Assert.assertEquals(listWebElements.get(i).getText(),SuperHeroNames().get(i));
        }
    }

    @Test(description = "Verify the home page links", priority = 1)
    public void NavigationDesiredLink() throws InterruptedException {
        LoginWithCredential();

    }

    @AfterMethod
    public void teardown2(){
        driver.quit();
    }

}
