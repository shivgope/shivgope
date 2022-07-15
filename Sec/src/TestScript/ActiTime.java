package TestScript;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import Genericlib.BaseClass;

public class ActiTime extends BaseClass {
@Test(groups= {"smoke"})	
public void users()
{
driver.findElement(By.id("container_reports")).click();
}
	
	

}
