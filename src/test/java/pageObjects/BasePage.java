package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
      WebDriver driver;
      public BasePage(WebDriver driver)
      {
    	  this.driver=driver;
    	  PageFactory.initElements(driver, this);
      }
      //contain only constructer it is extend to all pageObject class.it is parent of all pageObject Class because constructer
      //is similar to all pageObject class so instead of making constructor every pageObject 
}
