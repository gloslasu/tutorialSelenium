import com.google.common.annotations.VisibleForTesting;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class SeleniumTest {


    @Test
    public void openGooglePage()
    {
        WebDriver driver = getDriver("firefox");
        driver.manage().window().maximize();
        driver.get("https://www.google.com");
// znalezienie przycisku
        WebElement agreeButton = driver.findElement(By.xpath("//div[text()='Zaakceptuj wszystko']"));
// klikniecie przycisku
        agreeButton.click();
// znajdz pole wyszukiwania
        WebElement searchField = driver.findElement(By.name("q"));
// wprowadz wartosc Selenium do pola
        searchField.sendKeys("Selenium");
// zasymuluj nacisniecie przycisku Enter
        searchField.sendKeys(Keys.ENTER);
// znalezc rezultat
        WebElement result = driver.findElement(By.xpath("//a[contains(@href,'selenium.dev')]//h3"));

        Assert.assertTrue(result.isDisplayed());



//        WebDriver driver = getDrviver("chrome");
//        driver.manage().window().maximize();
//        //Dimension d = new Dimension(300,300);
//        //driver.manage().window().setSize(d);
//        driver.get("HTTPS://google.com");
//       JavascriptExecutor executor = (JavascriptExecutor) driver; // driver jest typu WebDriver ale implementuje też JavascriptExecutor (zapis kastowania (JavascriptExecutor) driver)
//// teraz nasz executor może wykonywać kod JS:
//        executor.executeScript("window.open('https://google.pl', 'blank', 'heigh=300, width=300')"); //executor otwiera nam nowe okno. blank to nazwa naszego okna
//        //driver.quit();
//        driver.close();

//  String path = "C:\\Program Files\\chromedriver_win32\\chromedriver.exe";
//  System.setProperty("webdriver.chrome.driver", path);
//  ChromeDriver chromeDriver = new ChromeDriver(); // otwiera chroma. Możemy też otworzyć chroma tak:
//  WebDriver jest interfejsem a ChromeDriver jest konkretną implementacją tego interfejsu
//  WebDriver driver = getDrviver("chrome"); // otwiera przeglądarkę z naszej metody
// driver.get("https://www.google.com"); // get przyjmuje parametr czyli adres który chcmy otworzyć  // zaimplemrntowaliśmy tę linię w metodzie getDriver()
    }

    public WebDriver getDriver(String browser)
    {
        switch (browser) // w zalezności od wartości browswer będziemy chciec wykonać rózne akcje
        {
            case "chrome":
                //System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver_win32\\chromedriver.exe");
                return new ChromeDriver(); // ponieważ mamy tutaj return to w kolejnej linii nie jest nam potrzebny break;
            case "firefox":
                //System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\geckodriver-v0.31.0-win64\\geckodriver.exe");
                return new FirefoxDriver();
            default:
                throw new InvalidArgumentException("Invalid browswer name");
        }

    }

}