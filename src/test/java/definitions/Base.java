package definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Base {
    public static WebDriver driver;
    public static WebDriverWait wait;

    public Base(WebDriver driver) {
        this.driver = driver;
    }

    @Before
    public static void setUp() {

        System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver , 10);
    }

    public void ingresarWeb() {
        driver.get("https://parabank.parasoft.com/parabank/index.htm");
    }

    public String devolverTexto(By locator){
        return driver.findElement(locator).getText();
    }
    public void enterText(By locator, String text){
        driver.findElement(locator).sendKeys(text);
    }
    public void pulsarEnter(By locator){
        driver.findElement(locator).sendKeys(Keys.ENTER);
    }
    @After
    public static void tearDown() {
        driver.manage().deleteAllCookies();
        driver.close();
    }


}


