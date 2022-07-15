package TestScript;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Test1 {

	public static void main(String[] args) throws IOException 
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\gopes\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	
		driver.get("https://www.naukri.com/");
		WebElement wb=driver.findElement(By.xpath("//div[text()='Jobs']"));
		Actions act=new Actions(driver);
		act.moveToElement(wb).perform();
		driver.findElement(By.xpath("//a[text()='IT jobs']")).click();
		String parent=driver.getWindowHandle();
		Set<String> allid=driver.getWindowHandles();
		for(String i:allid)
		{
		if(!parent.equals(i))
		{
		driver.switchTo().window(i);
		}
		}
	driver.findElement(By.xpath("//a[text()='Mainframe Developer']")).click();
	Set<String> allid1=driver.getWindowHandles();
	for(String j:allid1)
	{
		if(!parent.equals(j))
		{
			driver.switchTo().window(j);
		}
	}
	WebElement wb1=driver.findElement(By.className("logo"));
	File src=wb.getScreenshotAs(OutputType.FILE);
	File trg=new File("./Screenshot/screenn.png");
	FileUtils.copyFile(src, trg);
		
		
	}

}
