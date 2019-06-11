

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

    public class ejPaginaCura {

        @BeforeClass
        public void setup () {
            System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        }

        @Test
        public void logInTest () {
            //Open WebPage
            WebDriver driver = new ChromeDriver();
            driver.get("https://katalon-demo-cura.herokuapp.com/profile.php#login");

            //Seteo y localizacion de los WebElement
            WebElement userName = driver.findElement(By.id("txt-username"));
            WebElement password = driver.findElement(By.id("txt-password"));
            WebElement logInBttn = driver.findElement(By.id("btn-login"));

            //Ingreso de datos
            userName.sendKeys("John Doe");
            password.sendKeys("ThisIsNotAPassword");
            logInBttn.click();

            //Wait + Assertions
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("combo_facility")));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("txt_visit_date")));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("txt_comment")));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btn-book-appointment")));
        }

        @Test
        public void setAppointment () {
            //Open WebPage
            WebDriver driver = new ChromeDriver();
            driver.get("https://katalon-demo-cura.herokuapp.com/profile.php#login");

            //Seteo y localizacion de los WebElement
            WebElement userName = driver.findElement(By.id("txt-username"));
            WebElement password = driver.findElement(By.id("txt-password"));
            WebElement logInBttn = driver.findElement(By.id("btn-login"));

            //Ingreso de datos y LogIn
            userName.sendKeys("John Doe");
            password.sendKeys("ThisIsNotAPassword");
            logInBttn.click();

            //Seteo y localizacion de Elementos
            Select combo = new Select (driver.findElement(By.id("combo_facility")));
            WebElement medicaidSelect = driver.findElement(By.id("radio_program_medicaid"));
            WebElement dateCalendar = driver.findElement(By.id("txt_visit_date"));
            WebElement textInput = driver.findElement(By.id("txt_comment"));
            WebElement appointmntArrange = driver.findElement(By.id("btn-book-appointment"));

            //Ingreso de los datos
            combo.selectByValue("Hongkong CURA Healthcare Center");
            medicaidSelect.click();
            dateCalendar.sendKeys("01/08/2019");
            dateCalendar.sendKeys(Keys.TAB);
            textInput.sendKeys("Esto es una prueba");
            appointmntArrange.click();

            //Wait
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("btn btn-default")));

            //Final Elements and Assertions
            WebElement goBackBttn = new driver.findElement(By.className("btn btn-default"));
            Assert.assertTrue(goBackBttn.isDisplayed());

        }
    }

