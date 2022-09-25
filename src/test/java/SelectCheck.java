// #190 Praca domowa (klasa SelectCheck)  i  #191 rozwiązanie pracy domowej
//  Polega na napisaniu metody która jako parametr będzie przyjmowała stringa (sprawdzany tekst) otaz obiekt Web Element (z którego wyciągniemy tekst do porównania) i
//  będzie zwracała wartość true albo false. Metoda ma sprawdzać czy jakaś wartość znajduje się w naszym selekcie.
//  Jeżeli mamy jakąś opcję w naszym selekcie, jeżeli opcja jaką podamy jako parametr naszej metody jest w
//  selekcie to musimy zwrócić true a jeżeli jej nie ma to zwracamy false.

// Czyli tworzymy metodę, która sprawdzi czy jakiś tekst jest jedną z opcji naszego selekta.

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectCheck {

    public boolean checkOption(String optionText, WebElement element) // optionText to tekst który podamy w parametrze. element to będzie tekst pobrany z elementu // WebElement element - czyli to jest element na stronie, który jest selectem
    {
        Select select = new Select(element); // do konstruktora klasy Select przekazujemy Web Element // WebElement selectCar = driver.findElement(By.cssSelector("select")); // <select>
        List<WebElement> options = select.getOptions(); // musimy pobrać wszystkie opcje z selecta do listy
        for(WebElement option : options)
        {
            if (option.getText().equals(optionText))
            {
                return true;
            }
        }
        return false;
    }








}
