import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class WaitTest {

WebDriver driver;

@Test
    public void webDriverWaitTest()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //#218 implicit Wait dla wszystkich elementów na stonir
        driver.get("https://testeroprogramowania.github.io/selenium/wait2.html");

        driver.findElement(By.id("clickOnMe")).click();

        WebDriverWait wait = new WebDriverWait(driver, 10); // przekazujemy do konstruktora drivera oraz timeout w sekundach
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p"))); // #219 czekamy aż będzie widoczny dla uzytkownika lokator p

        driver.findElement(By.cssSelector("p"));


//        FluentWait<WebDriver> wait = new FluentWait<>(driver);
//        wait.ignoring(NoSuchElementException.class); // tutaj były dwie NoSuchElementException do wyboru
//        wait.withTimeout(Duration.ofSeconds(10));

    }

    @Test
    public void fluentDriverWaitTest()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //#218 implicit Wait dla wszystkich elementów na stonir
        driver.get("https://testeroprogramowania.github.io/selenium/wait2.html");

        driver.findElement(By.id("clickOnMe")).click();

        FluentWait<WebDriver> wait = new FluentWait<>(driver); //#220
        wait.ignoring(NoSuchElementException.class); // ignorujemy przez 10 s nosuchelementexception #220
        wait.withTimeout(Duration.ofSeconds(10)); // przekazujemy do waita ile ma czekać  #220
        wait.pollingEvery(Duration.ofSeconds(1)); // możemy też zdefiniowac co jaki czas chcemy sprawdzac warunek (aż do osiągniecie timera) #220
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p"))); // #219 czekamy aż będzie widoczny dla uzytkownika lokator p

        driver.findElement(By.cssSelector("p"));

    }


    @Test
    public void expectedConditions()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //#218 implicit Wait dla wszystkich elementów na stonir
        driver.get("https://testeroprogramowania.github.io/selenium/wait2.html");

        driver.findElement(By.id("clickOnMe")).click();

        FluentWait<WebDriver> wait = new FluentWait<>(driver); //#220
        wait.ignoring(NoSuchElementException.class); // ignorujemy przez 10 s nosuchelementexception #220
        wait.withTimeout(Duration.ofSeconds(10)); // przekazujemy do waita ile ma czekać  #220
        wait.pollingEvery(Duration.ofSeconds(1)); // możemy też zdefiniowac co jaki czas chcemy sprawdzac warunek (aż do osiągniecie timera) #220
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p"))); // #219 czekamy aż będzie widoczny dla uzytkownika lokator p // przekazujemy lokator a nie webelement
        // #222 komentujemy bu sprawdzić metodę waitForElementToExist() // wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("p")))); // #221 w tej metodzie visibilityOf przekazujemy web Element który jest driverem i z góry zakładamy, że ten element jest widoczny. dlatego nam zfailuje.

        driver.findElement(By.cssSelector("p"));
        waitForElementToExist(By.cssSelector("p"));

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

@Test // #223
    public void waitForElementToExistLambda(By locator) // metoda przyjmuje lokator
    {
        //tworzymy fluent Waita z konfiguracją:
        FluentWait<WebDriver> wait = new FluentWait<>(driver); //#220
        wait.ignoring(NoSuchElementException.class);
        wait.withTimeout(Duration.ofSeconds(10));
        wait.pollingEvery(Duration.ofSeconds(1));

        //definiujemy nasz własny warunek #222
        wait.until((driver) -> // korzystamy z wyrażenia LAMBDA, przekazujemy drivera jako parametr a nastepnie z tego drivera korzystamy.
        {
                List<WebElement> elements = driver.findElements(locator); // locator mamy przekazany w naszej metodzie.
                //sprawdzamy czy ilość elementów na liscie jest wieksza od 0
                if (elements.size()>0) {
                    System.out.println("element jest na stronie");
                    return true;
                } else {
                    System.out.println("elementu nie ma na stronie");
                    return false;
                }
        });

    }


}
