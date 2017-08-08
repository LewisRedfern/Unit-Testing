import static org.junit.Assert.*;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestOne {

	private WebDriver wd;

	@Before
	public void driver() {
		wd = new ChromeDriver();
	}

	@Test
	public void test() {
		
		wd.manage().window().maximize();
		wd.navigate().to("http://thedemosite.co.uk/");
		
		CreateUser();
		EnterUser();
		CheckLog();
	}
	
	public void CreateUser() {
		
		WebElement createUser = wd.findElement(By.xpath("//a[@href=\"addauser.php\"]"));
		createUser.click();
		WebElement newUser = wd.findElement(By.xpath("//input[@name=\"username\"]"));
		newUser.sendKeys("lewtest");
		WebElement newPass = wd.findElement(By.xpath("//input[@name=\"password\"]"));
		newPass.click();
		newPass.sendKeys("lewtest");
		WebElement save = wd.findElement(By.xpath("//input[@name=\"FormsButton2\"]"));
		save.click();
	}
	
	public void EnterUser() {
		
		WebElement login = wd.findElement(By.xpath("//a[@href=\"login.php\"]"));
		login.click();
		WebElement user = wd.findElement(By.xpath("//input[@name=\"username\"]"));
		user.click();
		user.sendKeys("lewtest");
		WebElement password = wd.findElement(By.xpath("//input[@name=\"password\"]"));
		password.click();
		password.sendKeys("lewtest");
		WebElement button = wd.findElement(By.xpath("//input[@name=\"FormsButton2\"]"));
		button.click();
	}
	
	public void CheckLog() {
		
		WebElement text = wd.findElement(By.xpath("//blockquote/blockquote/font/center/b"));
		assertEquals("not succesful", "**Successful Login**", text.getText());
	}
	
	@After
	public void after() {
		wd.quit();
	}
}
