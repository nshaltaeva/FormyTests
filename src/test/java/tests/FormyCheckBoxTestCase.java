package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class FormyCheckBoxTestCase extends FormyCheckBoxes {

    //Test cases
    //junit @Test

    @Test
    public void NavigatetoCheckboxLink () throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
       driver.get("http://formy-project.herokuapp.com");
       NavigateToDesiredLink("Checkbox");

       driver.close();
    }

    @Test
    public void VerifyCheckBoxTest() throws InterruptedException {
        GoToFormyWebPage();
        NavigateToDesiredLink("Checkbox");
        VerifyCheckBoxTestNames();

        driver.close();
    }
}
