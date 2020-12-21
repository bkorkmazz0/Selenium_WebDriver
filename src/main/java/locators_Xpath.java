import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class locators_Xpath {

    public static void main(String[] args) {

        WebDriver driver;
        //System.setProperty("webdriver.chrome.driver","C:\\browserDrivers\\chromedriver.exe");
        //driver = new ChromeDriver();
        //System.setProperty("webdriver.gecko.driver","C:\\browserDrivers\\geckodriver.exe");
        //driver = new FirefoxDriver();
        System.setProperty("webdriver.edge.driver","C:\\browserDrivers\\msedgedriver.exe");
        driver = new EdgeDriver();

        driver.manage().window().maximize();
        driver.get("http://www.tutorialsninja.com/demo/index.php?route=common/home");

        WebElement myAccountButton = driver.findElement(By.xpath("//span[contains(text(),'My Account')]"));
        myAccountButton.click();

        WebElement register = driver.findElement(By.xpath("//a[contains(text(),'Register')]"));
        register.click();

        WebElement inputFirstName = driver.findElement(By.xpath("//input[@id='input-firstname']"));
        inputFirstName.sendKeys("Berkan");

        WebElement inputLastName = driver.findElement(By.xpath("//input[@id='input-lastname']"));
        inputLastName.sendKeys("Korkmaz");

        WebElement inputEmail= driver.findElement(By.xpath("//input[@id='input-email']"));
        inputEmail.sendKeys("brknkrkmz@gmail.com");

        WebElement inputNumber = driver.findElement(By.xpath("//input[@id='input-telephone']"));
        inputNumber.sendKeys("05319513476");

        WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
        password.sendKeys("1234");

        WebElement passConfirm = driver.findElement(By.xpath("//input[@id='input-confirm']"));
        passConfirm.sendKeys("1234");

        WebElement checkButton  = driver.findElement(By.xpath("//input[@name='agree']"));
        checkButton.click();

        WebElement  accept = driver.findElement(By.xpath("//input[@value='Continue']"));
        accept.click();

        String title = driver.getTitle();
        String myMessage ="Your Account Has Been Created!";

        Assert.assertEquals(myMessage,title);
        System.out.println(myMessage);
    }
}
