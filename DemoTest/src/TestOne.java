import static org.junit.Assert.*;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class TestOne {

	private WebDriver wd;
	private CreateUser createUser;
	private LogInPage logInPage;

	@Before
	public void driver() {
		wd = new ChromeDriver();
		createUser = PageFactory.initElements(wd, CreateUser.class);
		logInPage = PageFactory.initElements(wd, LogInPage.class);
	}

	@Test
	public void test() {

		wd.manage().window().maximize();
		wd.navigate().to("http://thedemosite.co.uk/");

		createUser.DoCreate("lewtest", "lewtest");
		logInPage.DoLogIn("lewtest", "lewtest");

		CheckLog();
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
