package JUnit;
import code.Internetshop;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

public class junitshop {

    private static Internetshop shopJusk ;
    private static WebDriver driver;

    @BeforeAll
    public static void setUp() {
        shopJusk = new Internetshop(driver);
    }
    @Test
    public void googlePageTest() {
    shopJusk.loadPage();
    shopJusk.passcookies();
    shopJusk.findpriceandparseit();
    }
}
