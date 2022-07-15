package Genericlib;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseClass 
{
	
	public  WebDriver driver;
	public Datautility du=new Datautility();
@BeforeClass(alwaysRun=true)
public void launchBrowser()
{
	System.setProperty("webdriver.chrome.driver","D:\\selenium\\webbrowser\\chromedriver.exe");
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	
}@BeforeMethod(alwaysRun=true)
public void login() throws IOException
{
	driver.get(du.getDataFromProperties("url"));
	driver.findElement(By.id("username")).sendKeys(du.getDataFromProperties("username"));
	driver.findElement(By.name("pwd")).sendKeys(du.getDataFromProperties("password"));
	driver.findElement(By.id("loginButton")).click();	
}
@AfterMethod(alwaysRun=true)
public void logout() throws InterruptedException
{
	Thread.sleep(2000);
driver.findElement(By.id("logoutLink")).click();	
}
@AfterClass(alwaysRun=true)
public void closeBrowser()
{
driver.close();
}
}

