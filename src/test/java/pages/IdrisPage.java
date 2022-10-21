package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class IdrisPage {

    public IdrisPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath="(//*[text()='Sign In'])[1]")
    public WebElement signIn;

    @FindBy(xpath="(//input[@id='username'])[1]")
    public WebElement username;

    @FindBy(xpath="//*[text()='Sign Out']")
    public WebElement signOut;


}
