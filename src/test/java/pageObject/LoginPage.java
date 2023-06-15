package pageObject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class LoginPage {
    public WebDriver driver;

    public void launchBrowser(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://admin-demo.nopcommerce.com/login");
    }
    public void clickLogin(String email, String password){
        driver.findElement(By.id("Email")).clear();
        driver.findElement(By.id("Email")).sendKeys(email);
        driver.findElement(By.id("Password")).clear();
        driver.findElement(By.id("Password")).sendKeys(password);
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    public void validateProductPage(){
        try {
            boolean status = driver.findElement(By.xpath("//img[@class='brand-image-xl logo-xl']")).isDisplayed();
            Assert.assertEquals(true, status);
            System.out.println("Logged in successfully");
        }
        catch (AssertionError e){
            System.out.println(e);
            driver.quit();
        }

    }

    public void clickLogout() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[@href='/logout']")).click();
    }

    public void validateLoginPage(){
        String text = driver.findElement(By.xpath("//h1[contains(text(),'Admin area demo')]")).getText();
        Assert.assertEquals(text, "Admin area demo");
    }

    public void quitBrowser(){
        driver.quit();
    }
}
