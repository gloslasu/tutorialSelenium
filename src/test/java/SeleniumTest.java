import com.google.common.annotations.VisibleForTesting;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;


public class SeleniumTest {

    public static void main(String[] args) {
        WebDriver webDriver = new FirefoxDriver(); // korzystamy z interfejsu WebDriver

    }

    @Test
    public void sampleTest() {
        System.out.println("hello");
    }


}
