import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CssSelectorsTest {

    @Test
public void findElements() {

    WebDriverManager.chromedriver().setup(); // korzystamy z web driver managera aby pod spodem pobrał się webdriver i automatycznie żeby się ustawiła do niego ścieżka.
    WebDriver driver = new ChromeDriver();
    driver.get("https://testeroprogramowania.github.io/selenium/basics.html");
    driver.manage().window().maximize();
// szukanie po css id #
    By cssId = By.cssSelector("#clickOnMe"); // Obiekt klasy By definiuje nam technikę lokalizowania elementu.
    driver.findElement(cssId);

// szukanie po css class .
    By cssClass = By.cssSelector(".topSecret");
    driver.findElement(cssClass);
// po css class name
    By cssNameClass = By.cssSelector("[class = topSecret]");
    driver.findElement(cssNameClass);

// tag mane
    By cssTag = By.cssSelector("input");
    driver.findElement(cssTag).sendKeys("pierwszy element");

// atrybut name w css
    By cssName = By.cssSelector("[name = 'fname']");
    driver.findElement(cssName);

// all
    By all = By.cssSelector("*");
    driver.findElement(all);

// by ul inside Div by cssSelector
    By ulInsideDiv = By.cssSelector("div ul");

// by tr inside table - szukamy tr w table ale nie patrzymy tylko na bezpośrednie dziecko table tylko na wszystkie tr zagnieżdżone w table
    By trInsideTable = By.cssSelector("table tr");

// first child
    By firstChildUlInDiv = By.cssSelector("div ul");
    By firstChildTrInTbody = By.cssSelector("tbody tr");
    driver.findElement(firstChildUlInDiv);
    driver.findElement(firstChildTrInTbody);

// wszystkie tagi na tym samym poziomie po jakimś tagu
    By firstFormAfterLabel = By.cssSelector("label + form");
    By allFormAfterLabel = By.cssSelector("label ~ form");
    driver.findElement(firstFormAfterLabel);
    driver.findElement(allFormAfterLabel);

//
    By attrTag = By.cssSelector("input[name=fname]");
    By attrContains = By.cssSelector("[name*='fn']");
    By attrStarts = By.cssSelector("[name^='gen']");
    By attrEnds = By.cssSelector("[name$='der']");

    driver.findElement(attrTag);
    driver.findElement(attrContains);
    driver.findElement(attrStarts);
    driver.findElement(attrEnds);

// kolejne dzieci
    By firstChild = By.cssSelector("li:first-child");
    By lastChild = By.cssSelector("li:last-child");
    By nthChild = By.cssSelector("li:nth-child(3)");
    driver.findElement(firstChild);
    driver.findElement(lastChild);
    driver.findElement(nthChild);

}

}
