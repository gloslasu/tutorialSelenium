import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SecondTest {


    @Test
    public void findSeleniumTutorial() {
//Sprawdzanie czy mamy zainstalowaną odpowiednią wersję chrome driver managera i jesli nie to odpowiednia wersja zostanie zainstalowana:
        WebDriverManager.chromedriver().setup();
// tworzymy nowe okno przeglądfarki poprzez stworzenie niowego obiektu klasy ChromeDriver.
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
// nastepnie odwołujemy się do naszego drivera i otwieramy stronę http://seleniumdemo.com/
        driver.get("http://seleniumdemo.com/");
// szukamy i klikamy na zakładkę shop
        driver.findElement(By.xpath("//span[text()='Shop']")).click();
// szukamy na stronie produktu o nazwie Java Selenium WebDriver
        WebElement seleniumProduct = driver.findElement(By.xpath("//h2[text()='Java Selenium WebDriver']"));
// dodajemy asercje sprawdzającą czy na stronie na pewno wyswietla się szukany produkt
        Assert.assertTrue(seleniumProduct.isDisplayed());
        seleniumProduct.click();


    }


}
