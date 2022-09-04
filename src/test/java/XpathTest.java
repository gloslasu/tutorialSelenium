import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class XpathTest {

    @Test
    public void findElement(){
        WebDriverManager.chromedriver().setup(); // korzystamy z web driver managera aby pod spodem pobrał się webdriver i automatycznie żeby się ustawiła do niego ścieżka.
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");
        driver.manage().window().maximize();
// id
        By buttonID = By.xpath("//button[@id='clickOnMe']"); // Obiekt klasy By definiuje nam technikę lokalizowania elementu.
        WebElement clickOnMeButton = driver.findElement(buttonID);
        //clickOnMeButton.click();
// name
        driver.findElement(By.xpath("//input[@name='fname']"));

// class
        By paraHidden = By.xpath("//p[@class='topSecret']");
        driver.findElement(paraHidden);

// tag input
        By inputLocator = By.tagName("input");
        WebElement input = driver.findElement(inputLocator);
        input.sendKeys("Został znaleziony pierwszy input");
        List<WebElement> inputs = driver.findElements(inputLocator); // zostaną zwrócone wszystkie inputy, które są na stronie
        System.out.println(inputs.size());

// link href a
        By linkText = By.xpath("//a[text()='Visit W3Schools.com!']");
        WebElement w3SchoolLink = driver.findElement(linkText);

// znajdowanie elemetu znając tylko częśc tekstu linku.
        By partialLink = By.xpath("//a[contains(text(),'Visit')]");
        WebElement w3SchoolPartial = driver.findElement(partialLink);

////////// Xpath //////////////////
        By fullPath = By.xpath("/html/body/div/ul"); // szukamy konkretnej ściezki
        By shortPath = By.xpath("//ul"); // szukamy wszytkich tagów ul wewnątrz struktury
        By allXPath = By.xpath("//*");
        By nElement = By.xpath("(//input)[2]");
        By lastElement = By.xpath("(//input)[last()]");
        By elementWithAttribute = By.xpath("//*[@name]");

        By attrEquals = By.xpath("//button[@id='clickOnMe']");
        By attrNotEquals = By.xpath("//button[@id!='clickOnMe']");
        By attrNotEquals1 = By.xpath("//*[@id!='clickOnMe'] ");
        // możemy szukać wszystkich elementów * dla których [] wartość atrybutu name zawiwiera ame
        By attrContains = By.xpath("//*[contains(@name, 'ame')]");
        // mamy metodę start-with nastepnie  atrybut a następnie frazę od której rozpoczyna się atrybut name.
        By startWith = By.xpath("//*[starts-with(@name, 'user')]");
        //By endsWith = By.xpath("//*[ends-with(@name,'user')]"); nie działa, może w xPath 2.0 będzie dzxiałało, teraz trzeba kombinowac z Substring
        By endsWithSubstring = By.xpath("//*[substring(@name,string-length(@name)-string-length('name')+1)='name']");

        //#178
        By child = By.xpath("//div/child::ul");
        By parent = By.xpath("//div/../.."); // wybiera bezpośredniego rodzica
        By desc = By.xpath("//div/descendant::ul"); //zstępni
        By asc = By.xpath("//div/ancestor::*"); // stępni
        By fall = By.xpath("//img/following::*");
        By fallSib = By.xpath("//img/following-sibling::*");
        By prec = By.xpath("//img/preceding::*"); // wszystkie przed
        By precSib = By.xpath("//img/preceding-sibling::*"); // wszystkie przed na tym samym poziomie

        //#179
        By divsAndLinks = By.xpath("//a | //div//a"); // znajdzie nam divy i linki na stronie
        By andOperator = By.xpath("//input[@name=’fname’ and @id=’fname’]");
        By andOperator1 = By.xpath("//*[@name='fname' and @id='fname']");
        By orOperator = By.xpath("//input[@name='fname' or @id='fnahme']");

        driver.findElement(fullPath);
        driver.findElement(shortPath);
        driver.findElement(allXPath);
        driver.findElement(nElement);
        driver.findElement(lastElement);
        driver.findElement(elementWithAttribute);

        driver.findElement(attrEquals);
        driver.findElement(attrNotEquals);
        driver.findElement(attrNotEquals1);
        driver.findElement(attrContains);
        driver.findElement(startWith);
        driver.findElement(endsWithSubstring);

        //#178
        driver.findElement(child);
        driver.findElement(parent);
        driver.findElement(desc);
        driver.findElement(asc);
        driver.findElement(fall);
        driver.findElement(fallSib);
        driver.findElement(prec);
        driver.findElement(precSib);

        //#179
        driver.findElement(divsAndLinks);
        driver.findElement(andOperator1);
        driver.findElement(orOperator);

    }



}
