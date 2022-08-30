import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class SelectorsTest {

    @Test
    public void findElement(){
        WebDriverManager.chromedriver().setup(); // korzystamy z web driver managera aby pod spodem pobrał się webdriver i automatycznie żeby się ustawiła do niego ścieżka.
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");
        driver.manage().window().maximize();
// id
        By buttonID = By.id("clickOnMe"); // Obiekt klasy By definiuje nam technikę lokalizowania elementu.
        WebElement clickOnMeButton = driver.findElement(buttonID);
        //clickOnMeButton.click();
// name
        driver.findElement(By.name("fname"));

// class
        By paraHidden = By.className("topSecret");
        driver.findElement(paraHidden);

// tag input
        By inputLocator = By.tagName("input");
        WebElement input = driver.findElement(inputLocator);
        input.sendKeys("Został znaleziony pierwszy input");
        List<WebElement> inputs = driver.findElements(inputLocator); // zostaną zwrócone wszystkie inputy, które są na stronie
        System.out.println(inputs.size());

// link href a
        By linkText = By.linkText("Visit W3Schools.com!");
        WebElement w3SchoolLink = driver.findElement(linkText);

// znajdowanie elemetu znając tylko częśc tekstu linku.
        By partialLink = By.partialLinkText("Visit");
        WebElement w3SchoolPartial = driver.findElement(partialLink);


    }



}
