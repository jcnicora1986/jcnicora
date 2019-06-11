import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ejLogin {

    @Test
    public void login(){

        System.setProperty("webdriver.chrome.driver","Driver/chromedriver.exe");
        WebDriver driver =new ChromeDriver();
        driver.get("https://verstandqa.com/login-employee-v2/");
        WebElement userLogin=driver.findElement(By.id("user"));
        userLogin.sendKeys("admin");
        WebElement passLogin=driver.findElement(By.id("pass"));
        passLogin.sendKeys("admin123");
        WebElement clickLogIn=driver.findElement(By.id("loginButton"));
        clickLogIn.click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement buttonAdd = driver.findElement(By.id("addButton"));
        Assert.assertTrue(buttonAdd.isDisplayed());
        driver.quit();
        /*driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Assert.assertEquals(driver.getTitle(),"selenium - Buscar con Google","el titulo de la pagino no coincide");
        List<WebElement> resultados=driver.findElements(By.className("rc"));
        Assert.assertTrue(resultados.size()>0,"no hay resultados de la busqueda");
        driver.quit();*/
    }

    @Test
    public void loginIncorrecto(){
        System.setProperty("webdriver.chrome.driver","Driver/chromedriver.exe");
        WebDriver driver =new ChromeDriver();
        driver.get("https://verstandqa.com/login-employee-v2/");
        WebElement userLogin=driver.findElement(By.id("user"));
        userLogin.sendKeys("admin");
        WebElement passLogin=driver.findElement(By.id("pass"));
        passLogin.sendKeys("admin1234");
        WebElement clickLogIn=driver.findElement(By.id("loginButton"));
        clickLogIn.click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement errorMsj = driver.findElement(By.name("errorMessage"));
        Assert.assertTrue(errorMsj.isDisplayed()&&errorMsj.getText().equals("Bad credentials Please try again.."));
        //driver.quit();
    }

    @Test
    public void addEmployee(){
        System.setProperty("webdriver.chrome.driver","Driver/chromedriver.exe");
        WebDriver driver =new ChromeDriver();
        driver.get("https://verstandqa.com/login-employee-v2/");
        WebElement userLogin=driver.findElement(By.id("user"));
        userLogin.sendKeys("admin");
        WebElement passLogin=driver.findElement(By.id("pass"));
        passLogin.sendKeys("admin123");
        WebElement clickLogIn=driver.findElement(By.id("loginButton"));
        clickLogIn.click();
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        WebElement buttonAdd = driver.findElement(By.id("addButton"));
        Assert.assertTrue(buttonAdd.isDisplayed());

        WebElement name=driver.findElement(By.id("name"));
        name.sendKeys("Juan");
        WebElement address=driver.findElement(By.id("address"));
        address.sendKeys("Zapican");
        WebElement city=driver.findElement(By.cssSelector("[placeholder='City']"));
        city.sendKeys("City");
        WebElement state=driver.findElement(By.id("state"));
        state.sendKeys("Montevideo");
        WebElement postcode=driver.findElement(By.id("postcode"));
        postcode.sendKeys("11800");
        WebElement email=driver.findElement(By.id("email"));
        email.sendKeys("11800");
        WebElement phoneNumber=driver.findElement(By.id("phoneNumber"));
        phoneNumber.sendKeys("09940");

        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);

        WebElement clickAdd=driver.findElement(By.id("addButton"));
        clickAdd.click();


        ExpectedConditions.visibilityOfElementLocated(By.id("success-alert"));
        //Assert.assertEquals(ExpectedConditions.attributeContains(By.id(s));

        driver.quit();

    }

    @Test
    public void logout(){


        System.setProperty("webdriver.chrome.driver","Driver/chromedriver.exe");
        WebDriver driver =new ChromeDriver();
        driver.get("https://verstandqa.com/login-employee-v2/");
        WebElement userLogin=driver.findElement(By.id("user"));
        userLogin.sendKeys("admin");
        WebElement passLogin=driver.findElement(By.id("pass"));
        passLogin.sendKeys("admin123");
        WebElement clickLogIn=driver.findElement(By.id("loginButton"));
        clickLogIn.click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement buttonAdd = driver.findElement(By.id("addButton"));
        Assert.assertTrue(buttonAdd.isDisplayed());

        //WebElement clickLogout=driver.findElement(By.cssSelector("span.glyphicon-log-out"));
        WebElement clickLogout=driver.findElement(By.className("glyphicon-log-out"));
        clickLogout.click();


    }
}