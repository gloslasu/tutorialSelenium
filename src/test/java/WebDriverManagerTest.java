import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class WebDriverManagerTest {

    @Test
    public void openBrowswer() {
        WebDriverManager.firefoxdriver().setup();
        // teraz bez ustawiania properties i bez wskazywania gdzie jest zlokalizowany powinno nam zadziałać:
        WebDriver driver = new FirefoxDriver(); // dzieki linii powyżej nawet jak nie będziemy mieć na kompie geckoDrivera to nam się odpali Firefox


    }

}
