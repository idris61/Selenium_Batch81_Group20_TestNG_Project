package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class BeyzaPage {
    public BeyzaPage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "(//*[text()='Sign In'])[1]")
    public WebElement signIn;

    @FindBy(xpath = "(//input[@id='username'])[1]")
    public WebElement username;

    @FindBy(xpath = "//*[text()='Sign Out']")
    public WebElement signOut;

    @FindBy(xpath = "(//*[text()='My Account'])[4]")
    public WebElement myAccount;

    @FindBy(xpath = "//*[@class='myaccount-content']")
    public WebElement myAccountList;

    @FindBy(xpath = "//*[text()='Sign Out']")
    public WebElement myAccountSignOutLink;

    @FindBy(xpath = "//*[text()='Store Manager']")
    public WebElement storManager;

    @FindBy(xpath = "(//span[@class='text'])[4]")
    public WebElement products;

    @FindBy(xpath = "(//span[@class='text'])[18]")
    public WebElement addNew;

    @FindBy(xpath = "(//*[text()='Toptan Ürün Gösterme Ayarları'])[1]")
    public WebElement toptanUrunlerGostermeAyarlari;

    @FindBy(xpath = "//select[@id='piecetype']")
    public WebElement pieceDdm;

    @FindBy(xpath = "//input[@id='unitpercart']")
    public WebElement unitPerPiece;

    @FindBy(xpath = "//input[@class='wcfm-text wcfm_ele simple variable external grouped booking field_61d33a93da83d']")
    public WebElement minOrderQuantity;

    @FindBy(xpath = "(//span[@class='text'])[14]")
    public WebElement reports;

    @FindBy(xpath = "//*[@id=\"poststuff\"]/div/div[1]/ul/li[1]/a")
    public WebElement year;

    @FindBy(xpath = "//*[@id=\"poststuff\"]/div/div[1]/ul/li[2]/a")
    public WebElement lastMonth;


    @FindBy(xpath = "//*[@id=\"poststuff\"]/div/div[1]/ul/li[3]/a")
    public WebElement thisMonth;

    @FindBy(xpath = "//*[@id=\"poststuff\"]/div/div[1]/ul/li[4]/a")
    public WebElement last7Days;

    @FindBy(xpath = "//*[@name='wcfm-date-range']")
    public WebElement chooseDateRange;

    @FindBy(xpath = "/html/body/div[8]/div[2]/table[1]/tbody/tr[4]/td[3]/div")
    public WebElement octoberButton;

    @FindBy(xpath = "/html/body/div[8]/div[2]/table[2]/tbody/tr[2]/td[2]/div")
    public WebElement decemberButton;

    @FindBy(xpath = "//*[@id='chart-placeholder-canvas']")
    public WebElement grafik;
}
