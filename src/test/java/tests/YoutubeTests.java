package tests;

import Utilities.BrowserWait;
import Utilities.ConfigurationReader;
import Utilities.Driver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;

import java.util.List;


public class YoutubeTests {




    @Test //(description = "Verify url = https://www.youtube.com/")
    public void test1(){
        String expectedBrowser= "chrome";
        //we write keys in "key" as a string
        //as return, you will get value
        //key=value
        //property name = value
        //we don't change property names, we change values
        //the idea is change in the one place, and affect entire framework
        //lets say every class will read browser type from properties file
        //and to perform cross-browsing testing, we can easily change value of browser property
        String actualBrowser = ConfigurationReader.getProperty("browser");
        Assert.assertEquals(actualBrowser, expectedBrowser);
        //read value of url property
        System.out.println("URL: "+ConfigurationReader.getProperty("url"));

    }

    @Test //put on searchbox "java tutorial" and click on search button
    public void test2(){
        String url = ConfigurationReader.getProperty("url");
        //Driver.get() --> will return webdriver object
        //and then we can call webdriver methods like get(), findElement()....
//        WebDriver driver = Driver.get();
        Driver.get().get(url);
        WebElement searchbox = Driver.get().findElement(By.id("search"));
        searchbox.sendKeys("Java Tutorial for Beginners [2019]");
        Driver.get().findElement(By.xpath("//*[@id=\"search-icon-legacy\"]/yt-icon")).click();
        BrowserWait.wait(2);
        Driver.get().findElement(By.xpath("//a[contains(text(),'Java Tutorial for Beginners [2019]')]")).click();
/*
        List<WebElement> allLinks = Driver.get().findElements(By.xpath("//*[@id='video-title']"));

        allLinks.get(0).click();

 */
    }


}
