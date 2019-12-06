package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class FormyCheckBoxes {


  //  3 categories: variables, locators, methods
  //  variables
    public WebDriver driver;
   // locators

    public void GoToFormyWebPage(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://formy-project.herokuapp.com");
    }
      //  methods
    public void NavigateToDesiredLink(String checkbox) throws InterruptedException {
       List<WebElement> linksToNavigate = driver.findElements(By.xpath("/html/body/div/div/li[3]/a"));
        for (WebElement link: linksToNavigate) {
          if(link.getText().equalsIgnoreCase("Checkbox")) {
              link.click();
              Thread.sleep(3000);
              break;
          } else {
              System.out.println("It did not find the link to click");
          }
        }
    }
  //  Inheritance
    public void VerifyCheckBoxTestNames() throws InterruptedException {
       List<WebElement>  checkboxes = driver.findElements(By.xpath("/html/body/div/div/div/div"));

       for(int i=0; i<checkboxes.size();i++){
           String result = checkboxes.get(i).getText();
           Thread.sleep(3000);
           System.out.println("Result " +" "+ (i+1) +" " + result);
       }
    }

    public void ClickCheckBoxes() throws InterruptedException {
        List<WebElement> Clickable = driver.findElements(By.xpath("/html/body/div/div/div/div/input"));
        for(int i=0; i<Clickable.size();i++){

            Clickable.get(i).click();
            Thread.sleep(2000);

        }

    }

    public void ClickDesireCheckBox(String CheckBox) throws InterruptedException {
        List<WebElement> DesireBox = driver.findElements(By.xpath("/html/body/div/div/div/div"));
        List<WebElement> InputCheckBoxes = driver.findElements(By.xpath("/html/body/div/div/div/div/input"));
        for(int i=0; i<DesireBox.size();i++){
            Thread.sleep(3000);
            if(DesireBox.get(i).getText().equalsIgnoreCase(CheckBox)){
                InputCheckBoxes.get(i).click();
            }
        }
     }










}
