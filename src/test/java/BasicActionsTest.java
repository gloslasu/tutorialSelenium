import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class BasicActionsTest {


    @Test
    public void performAction(){

        WebDriverManager.chromedriver().setup(); // korzystamy z web driver managera aby pod spodem pobrał się webdriver i automatycznie żeby się ustawiła do niego ścieżka.
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium");
        driver.manage().window().maximize();

        // klikanie
        WebElement basicPageLing = driver.findElement(By.linkText("Podstawowa strona testowa")); // klikamy w pierwszy link na stronie
        basicPageLing.getText(); // #189 6' pobieramy tekst znajdujący się między znacznikiem otwierającym a zamykającym.
        basicPageLing.click();

        // czyszczenie inputa, wpisywanie tekstu,
        WebElement firstNameInput = driver.findElement(By.id("fname"));
        firstNameInput.click();
        firstNameInput.sendKeys("Sławek");

        // czyszczenie inputa, wpisywanie tekstu, naciskanie klawiszy
        WebElement userNameInput = driver.findElement(By.name("username"));
        userNameInput.clear();
        userNameInput.sendKeys("admin");
        //userNameInput.sendKeys(Keys.ENTER);

        // znajdowanie checkboxa za pomocą CSS
        WebElement checkBox = driver.findElement(By.cssSelector("[type='checkbox']")); // <input type="checkbox">
        checkBox.click();

        // zaznaczamy radiobutton po css selektore value
        WebElement radioButtonMale = driver.findElement(By.cssSelector("[value='male']")); // <input type="radio" name="gender" value="male">
        radioButtonMale.click();

        // #188 znajdowanie opcji w liście rozwijanej select
        WebElement selectCar = driver.findElement(By.cssSelector("select")); // <select>
        Select cars = new Select(selectCar); // klasa Select dostarcza nam specjalne metody, które umożliwią nam wybranie konkretnej opcji z listy wyboru.
        cars.selectByIndex(2); // wybieramy opcję numer 2 (2+1 bo od zera) w liście wyboru select
        cars.selectByVisibleText("Saab"); // wybieramy po widocznym na steonie tekście
        cars.selectByValue("volvo"); // wybieramy po wartości atrybutu value

        // #189 Pobranie wszystkich dostępnych opcji z Selecta
        List<WebElement> options = cars.getOptions(); // pobieramy obiekty do listy web elementów

        // wypisujemy na ekranie wszystkie opcje w selekcie
        for (WebElement option : options) { // dla opcji która jest web elementem znajdującej się w liście options wykonujemy jakąś akcję
            System.out.println(option.getText()); // metodą getText wybieramy text z obiektu (elementu znajdującego się w liście)

        }


    }


}
