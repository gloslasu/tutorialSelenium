import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class WebDriverManagerTest {

    @Test
    public void openBrowswer() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT); // akceptujemy jak wyskoczy jakiś alert

        WebDriver driver = new ChromeDriver(options);
        JavascriptExecutor executor = (JavascriptExecutor) driver;

        // teraz bez ustawiania properties i bez wskazywania gdzie jest zlokalizowany powinno nam zadziałać:
        //WebDriver driver = new ChromeDriver(); // dzieki linii powyżej nawet jak nie będziemy mieć na kompie geckoDrivera to nam się odpali Firefox
        options.setHeadless(false); // nie zobaczymy przeglądarki a test wykona się w tle - coś nie dziala u mnie
        driver.manage().window().maximize();
        executor.executeScript("alert('alert wyskakujący')");
        driver.get("hhtps://google.pl");
        driver.quit();

    }

}
