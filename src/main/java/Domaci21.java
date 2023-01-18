/*
Automatizovati navodjenje na sajtu https://automationexercise.com.
Otici na pocetnu stranu, kliknuti na "Signup / Login",
unesite u polja za "New User Signup!" pomocu faker-a - ime i email.
Kliknuti dugme Signup.
Pored neophodnih polja na Signup ekranu uneti i date of birth, cekirati Title i
 "Receive special offers from our partners!". Country staviti na "Canada".
Docekace vas ekran Account created, kliknuti "Continue". Vratice vas na pocetnu stranicu.
Za kraj kliknuti Delete Account, opet kliknuti Continue.

Waitere po potrebi dodavati.
*/


import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.Instant;

public class Domaci21 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\colic\\OneDrive\\Radna površina\\QA\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Faker faker = new Faker();
        driver.get("https://automationexercise.com");
        driver.manage().window().maximize();

        WebElement singup = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a"));
        singup.click();

        WebElement username = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[2]"));
        username.sendKeys(faker.name().name());

        WebElement email = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[3]"));
        email.sendKeys(faker.internet().emailAddress());

        WebElement singUp = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/button"));
        singUp.click();

        WebElement password = driver.findElement(By.xpath("//*[@id=\"password\"]"));
        password.sendKeys(faker.internet().password());

        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("window.scrollBy(0,550);","");

        WebElement date = driver.findElement(By.xpath("//*[@id=\"days\"]"));
        Select day = new Select(date);
        day.selectByVisibleText("2");

        WebElement date2 = driver.findElement(By.xpath("//*[@id=\"months\"]"));
        Select month = new Select(date2);
        month.selectByVisibleText("July");

        WebElement date3 = driver.findElement(By.xpath("//*[@id=\"years\"]"));
        Select year = new Select(date3);
        year.selectByValue("1998");

        WebElement newsLetter = driver.findElement(By.id("newsletter"));
        newsLetter.click();

        WebElement option = driver.findElement(By.xpath("//*[@id=\"optin\"]"));
        option.click();

        WebElement firstName = driver.findElement(By.xpath("//*[@id=\"first_name\"]"));
        firstName.sendKeys(faker.name().firstName());

        WebElement lastName = driver.findElement(By.xpath("//*[@id=\"last_name\"]"));
        lastName.sendKeys(faker.name().lastName());

        WebElement address = driver.findElement(By.xpath("//*[@id=\"address1\"]"));
        address.sendKeys(faker.address().streetAddress());

        JavascriptExecutor javascriptExecutor1 = (JavascriptExecutor) driver;
        javascriptExecutor1.executeScript("window.scrollBy(0,550);","");

        WebElement country = driver.findElement(By.xpath("//*[@id=\"country\"]"));
        Select canada = new Select(country);
        canada.selectByVisibleText("Canada");

        WebElement state = driver.findElement(By.xpath("//*[@id=\"state\"]"));
        state.sendKeys(faker.address().state());

        WebElement city = driver.findElement(By.xpath("//*[@id=\"city\"]"));
        city.sendKeys(faker.address().city());

        WebElement zipCode = driver.findElement(By.xpath("//*[@id=\"zipcode\"]"));
        zipCode.sendKeys(faker.address().zipCode());

        WebElement mobile = driver.findElement(By.id("mobile_number"));
        mobile.sendKeys(faker.phoneNumber().cellPhone());

        WebElement createAccount = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div[1]/form/button"));
        createAccount.click();

        WebElement continueBtn = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div/a"));
        continueBtn.click();

        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //manuelno ugasim reklamu, klikom na prazan prostor pored

        webDriverWait.until(ExpectedConditions.urlToBe("https://automationexercise.com/"));
        WebElement deleteAccount = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[5]/a"));
        deleteAccount.click();

        WebElement conitnueBtn2 = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div/a"));
        conitnueBtn2.click();


    }
}
