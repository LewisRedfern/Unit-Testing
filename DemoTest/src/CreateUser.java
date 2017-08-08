import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

public class CreateUser {

	
	@FindBy(xpath = "//a[@href=\"addauser.php\"]")
	private WebElement createUser;
	
	@FindBy(xpath = "//input[@name=\"username\"]")
	private WebElement newUser;
	
	@FindBy(xpath = "//input[@name=\"password\"]")
	private WebElement newPass;
	
	@FindBy(xpath = "//input[@name=\"FormsButton2\"]")
	private WebElement saveBut;
	
	public void ClickCreate () {
		createUser.click();
	}
	
	public void InputUser (String user) {
		newUser.sendKeys(user);
	}
	
	public void InputPass (String pass) {
		newPass.sendKeys(pass);
	}
	
	public void ClickSave () {
		saveBut.click();
	}
	
	public void DoCreate (String u, String p){
		ClickCreate();
		InputUser(u);
		InputPass(p);
		ClickSave();
	}
}

