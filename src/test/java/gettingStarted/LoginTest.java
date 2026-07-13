package gettingStarted;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class LoginTest {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        // navigate to url
        driver.navigate().to("http://eaapp.somee.com");


        // maximize the window
      //  driver.manage().window().fullscreen();
        // get current handler
        //System.out.println(driver.getCurrentUrl());
        // get the window handler
        //System.out.println(driver.getWindowHandle());
        // minimize the window
       // driver.manage().window().minimize();

        login(driver);
        createEmployee(driver);
        logout(driver);
            // opening dashboard
      //  driver.findElement(By.linkText("\uD83D\uDCCA Dashboard")).click();
    }

    public static void login(WebDriver driver){
        // using webelement login
        //  By lnkLogin = By.cssSelector("a.nav-link.text-white[href='/Account/Login']");
        By lnkLogin = By.linkText("Login");
        driver.findElement(lnkLogin).click();
        driver.findElement(By.id("UserName")).sendKeys("admin");
        driver.findElement(By.id("Password")).sendKeys("password");
        driver.findElement(By.cssSelector(".btn")).click();
    }

    public static void createEmployee(WebDriver driver){

        driver.findElement(By.linkText("\uD83D\uDC65 Employees")).click();
        driver.findElement(By.linkText("+ New Employee")).click();
        driver.findElement(By.id("Name")).sendKeys("Coder Test");
        driver.findElement(By.id("Age")).sendKeys("25");
        driver.findElement(By.id("Salary")).sendKeys("25000");
        driver.findElement(By.id("DurationWorked")).sendKeys("24");

        Select select = new Select(driver.findElement(By.id("Grade")));
        select.selectByVisibleText("Middle");

        driver.findElement(By.id("Email")).sendKeys("codertest@email.com");

        WebElement button = driver.findElement(
                By.xpath("//button[@type='submit' and contains(@class,'btn-submit')]")
        );

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", button);
    }

    public static void logout(WebDriver driver){
        driver.findElement(By.cssSelector("btn.btn-link.text-white")).click();
    }

}
