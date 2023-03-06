package code;

import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
public class Internetshop  {
    private final static String URL = "https://jysk.ua/zberigannya/peredpokiy/vishalki-pidlogovi/drabynka-bindslev-bambuk";
    private static final String TELEGRAM_BOT_TOKEN = "6070234115:AAGvwjAvTqYocvLOk3EVflk5_U--6d0pfCM";
    private static final String TELEGRAM_CHAT_ID = "6070234115";
    private final By catalogButton = By.xpath("//*[@id='site-nav-collapse']/div/div/nav/ul/li[6]");
    WebDriver driver = new ChromeDriver();
    public Internetshop(WebDriver driver) {
        super();
    }
    public void loadPage() {
        driver.manage().window().setSize(new Dimension(1500, 900));
        driver.get("about:blank");
        driver.get(URL);
    }
    public void passcookies() {
        driver.findElement(By.className("coi-banner__accept")).click();
    }
    public void Hovermenuandclick(){
        WebElement menu = driver.findElement(catalogButton); // Находим элемент меню
        Actions builder = new Actions(driver); // Создаем объект класса Actions
        builder.moveToElement(menu).build().perform(); // Наводим курсор на меню
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10) ); // Ожидаем появление выпадающего меню
        WebElement category = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#site-nav-collapse > div > div > nav > ul > li:nth-child(6) > nav > div > div > div:nth-child(1) > ul > li:nth-child(7) > a")));
        category.click(); // Кликаем на категорию
    }
    public void Opensubcategory() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        JavascriptExecutor ts = (JavascriptExecutor) driver;
        ts.executeScript("window.scrollBy(0, 3000);");
        //WebElement element = driver.findElement(By.xpath("//*[@class='left-nav-sub']/li[3]"));
        //Actions actions = new Actions(driver);
        //((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        //new WebDriverWait(driver, Duration.ofSeconds(50)).until(ExpectedConditions.visibilityOf(element));
        //actions.moveToElement(element).click().build().perform();
        new WebDriverWait(driver, Duration.ofSeconds(50));
        WebElement element2 = driver.findElement(By.xpath("//*[@class='left-nav-sub']/li[3]"));
        element2.click();
    }
    public void Opensecondsubcategory() {
        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            WebElement popup = driver.findElement(By.className("frel_valign"));
            WebElement closeButton = popup.findElement(By.xpath("//*[@class='frel_valign']/div/div/div"));
            closeButton.click();
            JavascriptExecutor ts = (JavascriptExecutor) driver;
            ts.executeScript("window.scrollBy(0, 6000);");
            driver.findElement(By.xpath("//*[@id='product-list-content']/div[5]/div[2]/div[1]/div/div/div[2]/div[1]/a")).click();


        } catch (NoSuchElementException e) {
            JavascriptExecutor ts = (JavascriptExecutor) driver;
            ts.executeScript("window.scrollBy(0, 6000);");
            driver.findElement(By.xpath("//*[@id='product-list-content']/div[5]/div[2]/div[1]/div/div/div[2]/div[1]/a")).click();
        }
    }
    public void findpriceandparseit(){

            WebElement element = driver.findElement(By.xpath("//*[@class='ssr-product-price__value']"));
            String elementText = element.getText();
            String[] splitText = elementText.split(" ");
            int elementIntValue = Integer.parseInt(splitText[0]);
            String messageText;
            if (elementIntValue < 700) {
                messageText = "Цена" + " " + elementIntValue + " " + "грн" + " " + " - " + " " + "Можно покупать!";
            } else {
                messageText = "Цена" + " " + elementIntValue + " " + "грн" + " " + " - " + " " + "Продолжаем следить за ценой!";
            }
        // Создаем экземпляр бота
        MyBot myBot = new MyBot();
        // Отправляем сообщение
        myBot.sendMessage(messageText);



    }}




