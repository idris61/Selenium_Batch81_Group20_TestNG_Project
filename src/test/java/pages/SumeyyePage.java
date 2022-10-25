package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;
import utilities.Driver;

import java.util.List;

public class SumeyyePage {


    public SumeyyePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public Actions actions = new Actions(Driver.getDriver());
    public JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
    public SoftAssert softAssert = new SoftAssert();

    @FindBy(xpath = "//input[@id='regular_price']")
    public WebElement productAddNewPrice;

    @FindBy(xpath = "//*[text()='Sign In']")
    public WebElement signIn;

    @FindBy(xpath = "//*[text()='Register']")
    public WebElement register;

    @FindBy(xpath = "//*[text()='Become a Vendor']")
    public WebElement becomeAVendor;

    @FindBy(css = "#user_email")
    public WebElement email;

    @FindBy(xpath = "//*[@name='wcfm_email_verified_input']")
    public WebElement verficationCode;

    @FindBy(xpath = "//*[@name='loginfmt']")
    public WebElement outlookmail;

    @FindBy(xpath = "//*[@type='submit']")
    public WebElement ileri;

    @FindBy(xpath = "//*[@type='password']")
    public WebElement password;

    @FindBy(xpath = "//*[@type='submit']")
    public WebElement oturumAc;
    @FindBy(id = "idBtn_Back")
    public WebElement hayir;
    @FindBy(xpath = "//*[text()='Gereksiz E-posta']")
    public WebElement gereksiz;
    @FindBy(xpath = "(//div[@class='customScrollBar jEpCF']//div/div)[2]")
    public WebElement ilkMesaj;
    @FindBy(xpath = "//*[@style='margin:0 0 16px']/b")
    public WebElement sayi;
    @FindBy(css = "#passoword")
    public WebElement alloverpassword;
    @FindBy(xpath = "//*[id='confirm_pwd']")
    public WebElement confirmPassword;
    @FindBy(id = "wcfm_membership_register_button")
    public WebElement registerButton;
    @FindBy(xpath = "//*[text()='Not right now']")
    public WebElement simdiDegil;
    @FindBy(xpath = "//*[text()='Sign Out']")
    public WebElement signOut;
    @FindBy(xpath = "(//a[text()='Account details'])[1]")
    public WebElement acoutdetails;
    @FindBy(xpath = "//*[@id='account_first_name']")
    public WebElement ilkname;
    @FindBy(xpath = "//*[@id='account_last_name']")
    public WebElement lastname;
    @FindBy(xpath = "//*[@id='account_email']")
    public WebElement emaildegistir;
    @FindBy(xpath = "//*[text()='Save changes']")
    public WebElement savechanges;
    @FindBy(xpath = "//input[@id='username']")
    public WebElement signInEmail;
    @FindBy(xpath = "//a[text()='My Account']")
    public WebElement myAccount;
    //My Account
    @FindBy(xpath = "(//p[@class='text-uppercase text-center mb-0'])[1]")
    public WebElement orders;
    @FindBy(xpath = "(//p[@class='text-uppercase text-center mb-0'])[2]")
    public WebElement downloads;
    @FindBy(xpath = "(//p[@class='text-uppercase text-center mb-0'])[3]")
    public WebElement adresses;

    @FindBy(xpath = "(//p[@class='text-uppercase text-center mb-0'])[4]")
    public WebElement accountDetails;

    @FindBy(xpath = "(//p[@class='text-uppercase text-center mb-0'])[5]")
    public WebElement wishList;

    @FindBy(xpath = "(//p[@class='text-uppercase text-center mb-0'])[6]")
    public WebElement logout;

    @FindBy(xpath = "//h2")
    public WebElement myAccountText;

    //Dashboord
    @FindBy(xpath = "//*[text()='Store Manager']")
    public WebElement storeManagerButton;

    @FindBy(xpath = "(//*[text()='Orders'])[1]")
    public WebElement ordersButton;

    @FindBy(xpath = "(//*[text()='Downloads'])[1]")
    public WebElement downloadsButton;

    @FindBy(xpath = "(//*[text()='Addresses'])[1]")
    public WebElement addressesButton;

    @FindBy(xpath = "(//*[text()='Account details'])[1]")
    public WebElement accountDetailsButton;

    @FindBy(xpath = "(//*[text()='Wishlist'])[2]")
    public WebElement wishListButton;

    @FindBy(xpath = "(//*[text()='Support Tickets'])[1]")
    public WebElement supportTicketsButton;

    @FindBy(xpath = "//*[text()='Followings']")
    public WebElement followingsButton;

    @FindBy(xpath = "(//*[text()='Logout'])[1]")
    public WebElement logOutButton;

    @FindBy(xpath = "//*[text()='Go Shop']")
    public WebElement goShop;

    @FindBy(xpath = "//*[text()='Shop']")
    public WebElement shopText;

    /*
    @FindBy (xpath = "//div[@class='product-archive']//li[1]")
    public WebElement georgeOrwell;

    @FindBy (xpath = "//div[@class='product-archive']//li[3]")
    public WebElement AyaMatematik;
    @FindBy (xpath = "//div[@class='product-archive']//li[4]")
    public WebElement iPadAir;
    @FindBy (xpath = "//div[@class='product-archive']//li[5]")
    public WebElement noteCom;

     */

    @FindBy(xpath = "//a[@class='btn-product-icon product_type_simple add_to_cart_button ajax_add_to_cart']")
    public List<WebElement> shopList;

    @FindBy(xpath = "//a[@class='btn-product-icon product_type_simple add_to_cart_button ajax_add_to_cart']")
    public WebElement sepeteEkle;


    @FindBy(xpath = "//*[@class='btn-product-icon product_type_simple add_to_cart_button ajax_add_to_cart added']")
    public List<WebElement> sepetEkleWebElement;

    @FindBy(xpath = "//div[@class='product-archive']//li[2]")
    public WebElement acısızTarhana;

    @FindBy(xpath = "//button[@class='quantity-plus w-icon-plus']")
    public WebElement plusButton;

    @FindBy(xpath = "//*[@class='single_add_to_cart_button button alt']")
    public WebElement addToCart;


    // Store Manager
    @FindBy(xpath = "(//span[@class='text'])[4]")
    public WebElement products;

    @FindAll({
            @FindBy(xpath = "//thead//tr/th[5]"),
            //public WebElement statusText;

            @FindBy(xpath = "//thead//tr/th[6]"),
            //public WebElement stockText;

            @FindBy(xpath = "//thead//tr/th[7]"),
            //public WebElement priceText;

            @FindBy(xpath = "//thead//tr/th[11]")
            //public WebElement dateText;
    })
    public List<WebElement> productHeaders;

    @FindBy(xpath = "(//*[text()='Add New'])[1]")
    public WebElement addNewButton;

    @FindBy(xpath = "(//input[@type='checkbox'])")
    public WebElement virtualCheckBox;
    @FindBy(xpath = "(//input[@type='checkbox'])[2]")
    public WebElement downloadableCheckBox;

    @FindBy(xpath = "//*[@id='pro_title']")
    public WebElement productTitleBox;

    @FindBy(xpath = "//*[@id='featured_img_display']")
    public WebElement addPhoto;

    @FindBy(xpath = "//*[@id='__wp-uploader-id-1']")
    public WebElement selectFiles;

    @FindBy(xpath = "//*[@class='media-frame-content']")
    public WebElement selectFilesHepsi;

    @FindBy(xpath = "//*[@id='menu-item-browse']")
    public WebElement mediaLibrary;

    @FindBy(xpath = "(//*[@class='thumbnail'])[1]")
    public WebElement mediaLibraryFirstPhoto;

    @FindBy(xpath = "//*[text()='Select']")
    public WebElement onSelect;

    @FindBy(xpath = "//*[@id='gallery_img_gimage_0_display']")
    public WebElement kucukPhoto;

    @FindBy(xpath = "(//*[text()='Add to Gallery'])[3]")
    public WebElement addToGallery;

    @FindBy(xpath = "(//*[@class='wcfm_title wcfm_full_ele'])[2]")
    public WebElement productBrancBox;

    @FindAll({
            @FindBy(xpath = "//input[@value='454']"),
            //Besin takviyeleri
            @FindBy(xpath = "//input[@value='225']"),
            //Best Seller
            @FindBy(xpath = "//input[@value='230']"),
            //Elektronics
            @FindBy(xpath = "//input[@value='448']"),
            //Ev & yasam
            @FindBy(xpath = "//input[@value='455']"),
            //Indirimli ürünler
            @FindBy(xpath = "//input[@value='232']"),
            //Books & Music & Film
            @FindBy(xpath = "//input[@value='456']"),
            //Kozmetik
            @FindBy(xpath = "//input[@value='235']"),
            //kisisel
            @FindBy(xpath = "//input[@value='344']"),
            //Moda
            @FindBy(xpath = "//input[@value='399']"),
            //Clothing
            @FindBy(xpath = "//input[@value='233']"),
            //Toys & Games
            @FindBy(xpath = "//input[@value='466']"),
            //Taki Aksesuar
            @FindBy(xpath = "//input[@value='226']"),
            //New Arrivals


    })
    public List<WebElement> categoriesList;
    @FindAll({
            @FindBy(xpath = "//input[@value='35']"),

            @FindBy(xpath = "//input[@value='41']"),

            @FindBy(xpath = "//input[@value='46']"),

            @FindBy(xpath = "//input[@value='47']"),

            @FindBy(xpath = "//input[@value='50']"),

            @FindBy(xpath = "//input[@value='52']"),

            @FindBy(xpath = "//input[@value='55']")


    })
    public List<WebElement> productBrandsElements;

    @FindBy(xpath = "//*[@id='product_cats_checklist']/li/input")
    public List<WebElement> categorieslist;


    @FindBy(xpath = " //*[@id='product_brand']/li/input")
    public List<WebElement> productBrandlist;

    @FindBy(xpath = "//input[@id='sku']")
    public WebElement sku;

    @FindBy(xpath = "//input[@id='manage_stock']")
    public WebElement manageStock;

    @FindBy(xpath = "//input[@id='stock_qty']")
    public WebElement stockQty;

    @FindBy(xpath = "//input[@id='wcfm_products_simple_draft_button']")
    public WebElement draft;


    @FindAll({
            @FindBy(xpath = "//input[@id='sku']"),


            @FindBy(xpath = "//input[@id='manage_stock']"),


            @FindBy(xpath = "//input[@id='stock_qty']")


    })
    public List<WebElement> sMs;

    @FindBy(xpath = "//*[@class='wcfm-checkbox wcfm_ele simple variable non-job_package non-resume_package non-auction non-redq_rental non-appointment non-accommodation-booking']")
    public WebElement soldIndividually;

    @FindBy(xpath = "//select[@id='stock_status']")
    public WebElement backorder;

    @FindBy(xpath = "//*[@class='icon-box-title text-normal']")
    public WebElement orderText;

    @FindBy(xpath = "//thead//tr//th")
    public List<WebElement> orderHeaderList;


    @FindBy(xpath = "//*[text()='No downloads available yet.']")
    public WebElement noDownloadText;

    @FindBy(xpath = "//*[text()='Billing address']")
    public WebElement billingAddressText;

    @FindBy(xpath = "//*[text()='Shipping address']")
    public WebElement shippingAddressText;

    @FindBy(xpath = "//*[text()='Account Details']")
    public WebElement accountDetailsText;

    @FindBy(xpath = "//*[text()='Account details changed successfully.']")
    public WebElement succesfully;


    @FindBy(xpath = "(//*[@class='text'])[7]")
    public WebElement customersButton;


    @FindAll({
            @FindBy(xpath = "//thead//tr//th[1]"),
            @FindBy(xpath = "//thead//tr//th[2]"),
            @FindBy(xpath = "//thead//tr//th[3]"),
            @FindBy(xpath = "//thead//tr//th[4]"),
            @FindBy(xpath = "//thead//tr//th[6]")
    })
    public List<WebElement> customerTableHeads;

    @FindAll({
            @FindBy(xpath = "//*[text()='PDF']"),


            @FindBy(xpath = "//*[text()='Excel']"),


            @FindBy(xpath = "//*[text()='CSV']")

    })
    public List<WebElement> pdfExcelCSV;


    @FindBy(xpath = "(//*[text()='Add New'])[1]")
    public WebElement customersAddNew;


    @FindBy(xpath = "//*[@id='user_name']")
    public WebElement customerUserName;

    @FindBy(xpath = "//*[@id='user_email']")
    public WebElement customerUserEmail;

    @FindBy(xpath = "//*[@id='first_name']")
    public WebElement customerFirstName;

    @FindBy(xpath = "//*[@id='last_name']")
    public WebElement customerLastName;

    // Customer Billing location

    @FindAll({
            @FindBy(xpath = "//*[@id='bfirst_name']"),

            @FindBy(xpath = " //*[@id='blast_name']"),

            @FindBy(xpath = "//*[@id='bcompany_name']"),

            @FindBy(xpath = "//*[@id='bphone']"),

            @FindBy(xpath = "//*[@id='baddr_1']"),

            @FindBy(xpath = "//*[@id='baddr_2']"),

            @FindBy(xpath = "//*[@id='bcity']"),

            @FindBy(xpath = "//*[@id='bstate']"),

            @FindBy(xpath = "//*[@id='bzip']")

    })
    public List<WebElement> customerBillingList;


    @FindBy(xpath = "//*[@id='bcountry']")
    public WebElement customerBillingCountry;


    @FindBy(xpath = "//*[@id='same_as_billing']")
    public WebElement customerSameasBillingButton;

    @FindAll({
            @FindBy(xpath = "//*[@id='sfirst_name']"),

            @FindBy(xpath = " //*[@id='slast_name']"),

            @FindBy(xpath = "//*[@id='scompany_name']"),

            @FindBy(xpath = "//*[@id='saddr_1']"),

            @FindBy(xpath = "//*[@id='saddr_2']"),

            @FindBy(xpath = "//*[@id='scity']"),

            @FindBy(xpath = "//*[@id='sstate']"),

            @FindBy(xpath = "//*[@id='szip']")

    })
    public List<WebElement> customerShippingList;

    @FindBy(xpath = "//*[@id='scountry']")
    public WebElement customerShippingCountry;


    @FindBy(xpath = "//*[@id='wcfm_customer_submit_button']")
    public WebElement customerSubmitButton;

    @FindBy(xpath = "(//*[@class='text'])[8]")
    public WebElement refundButton;

    @FindBy(xpath = "//thead//tr//th[2]")
    public WebElement refundRequestId;

    @FindBy(xpath = "//thead//tr//th[3]")
    public WebElement refundOrderId;


    @FindAll({
            @FindBy(xpath = "//thead//tr//th[5]"),

            @FindBy(xpath = "//thead//tr//th[6]")

    })
    public List<WebElement> refundTypeReason;


    @FindBy(xpath = "(//*[@class='text'])[11]")
    public WebElement followersButton;

    @FindAll({
            @FindBy(xpath = "//thead//tr/th[1]"),

            @FindBy(xpath = "//thead//tr/th[2]")

    })
    public List<WebElement> followersNameEmail;

    @FindBy(xpath = "//thead//tr/th[3]")
    public WebElement followersActions;


}

