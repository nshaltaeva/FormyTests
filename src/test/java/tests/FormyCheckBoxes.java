package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FormyCheckBoxes {


  //  3 categories: variables, locators, methods
  //  variables
    public WebDriver driver;
   // locators

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


}
