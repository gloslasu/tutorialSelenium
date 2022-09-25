import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.testeroprogramowania.BaseTest;

import java.time.Duration;
import java.util.List;
import java.util.function.Function;

public class TwoTest extends BaseTest { // pl.testeroprogramowania.SecondTest

WebDriver driver;

@Test
    public void firstTest() //
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/wait2.html");
        driver.findElement(By.id("clickOnMe")).click();
        waitForElementToExist(By.cssSelector("p"));

        String paragrafText = driver.findElement(By.cssSelector("p")).getText();
        Assert.assertEquals(paragrafText, "Dopiero się pojawiłem!"); // int
        driver.quit();
    }

    @Test
    public void secondTest() // #225 @BeforeTest i @BeforeMethod
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/wait2.html");
        driver.findElement(By.id("clickOnMe")).click();
        waitForElementToExist(By.cssSelector("p"));

        String paragrafText = driver.findElement(By.cssSelector("p")).getText();
        Assert.assertEquals(paragrafText, "Dopiero się pojawiłem!");
        driver.quit();

    }

public void waitForElementToExist(By locator) // metoda przyjmuje lokator
    {
        //tworzymy fluent Waita z konfiguracją:
        FluentWait<WebDriver> wait = new FluentWait<>(driver); //#220
        wait.ignoring(NoSuchElementException.class);
        wait.withTimeout(Duration.ofSeconds(10));
        wait.pollingEvery(Duration.ofSeconds(1));

        //definiujemy nasz własny warunek #222
        wait.until(new Function<WebDriver, Boolean>() { // new Function<WebDriver - to jest rodzaj parametru jaki przekazujemy do metody apply() A drugi parametr to jest typ zwracanej wartości, my bedziemy chcieli zwracać true albo false.
            @Override
            public Boolean apply(WebDriver webDriver) {
                //wewnątrz apply() dostarczamy nasz własny warunek.
                //najpierw znajdujemy element
                List<WebElement> elements = driver.findElements(locator); // locator mamy przekazany w naszej metodzie.
                //sprawdzamy czy ilość elementów na liscie jest wieksza od 0
                if (elements.size()>0) {
                    System.out.println("element jest na stronie");
                    return true;
                } else {
                    System.out.println("elementu nie ma na stronie");
                    return false;
                }
            }
        });

    }

}
