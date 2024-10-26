package testBase;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	public Logger logger;	
    public WebDriver driver;
    public Properties proobj;
	
    @BeforeClass
    @Parameters({"os","browser"})
	public void setUP(String os,String br) throws IOException
	{
    	
    	FileReader file=new FileReader(System.getProperty("user.dir")+"//src//test//resources//config.properties");
    	proobj=new Properties();
    	proobj.load(file);
    	logger=LogManager.getLogger(this.getClass());
    	switch(br.toLowerCase())
    	{
    	case "chrome":driver=new ChromeDriver();break;
    	case "edge":driver=new EdgeDriver();break;
    	case "firefox":driver=new FirefoxDriver();break;
    	default:System.out.println("enter wrong browser details");return;
    	}
    	
    	driver.manage().deleteAllCookies();
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    	
    	driver.get(proobj.getProperty("appurl"));
    	driver.manage().window().maximize();
		
	}
	
    @AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	public String randomeString()
    {
    	String generatedstring=RandomStringUtils.randomAlphabetic(5);
    	return generatedstring;
    }
	public String randomeNumber()
    {
    	String generatednumber=RandomStringUtils.randomNumeric(10);
    	return generatednumber;
    }
	public String randomAlphaNumeric()
	{
		String generatedstring=RandomStringUtils.randomAlphabetic(3);
		String generatednumber=RandomStringUtils.randomNumeric(3);
		return (generatedstring+"@"+generatednumber);
	}
}
