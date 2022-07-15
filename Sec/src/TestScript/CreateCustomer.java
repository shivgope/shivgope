  package TestScript;

import java.io.IOException;
import java.time.Duration;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import Genericlib.BaseClass;
import Genericlib.Datautility;

public class CreateCustomer extends BaseClass {
@Test(groups= {"system"})
public void crateCustomer() throws EncryptedDocumentException, IOException
{
		Datautility du=new Datautility();
		Random r=new Random();
		int num=r.nextInt(10000);
		driver.findElement(By.id("container_tasks")).click();
		driver.findElement(By.cssSelector(".title.ellipsis")).click();
		driver.findElement(By.className("createNewCustomer")).click();
		driver.findElement(By.className("newNameField")).sendKeys(num+du.getDataFromExcelSheet("sheet1",0,0));
		driver.findElement(By.xpath("//div[text()='Create Customer']")).click();
	}

}
