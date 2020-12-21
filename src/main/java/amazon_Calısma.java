import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class amazon_Calısma {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver;
        System.setProperty("webdriver.chrome.driver", "C:\\browserDrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        //System.setProperty("webdriver.gecko.driver", "C:\\browserDrivers\\geckodriver.exe");
        //driver = new FirefoxDriver();
        //System.setProperty("webdriver.edge.driver", "C:\\browserDrivers\\msedgedriver.exe");
        //driver = new EdgeDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com.tr/ref=nav_logo");
        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement cookies = driver.findElement(By.xpath("//input[@id='sp-cc-accept']")); //click cookies
        cookies.click();

        //js.executeScript("window.scrollBy(0,1000)");
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)"); //page down

        Actions action = new Actions(driver); //action class

        List<WebElement> languagebars = driver.findElements(By.xpath("//div[@class='navFooterLine navFooterLinkLine navFooterPadItemLine ']/ul/li")); //list countries

        for (WebElement languagebar : languagebars) {

            if (languagebar.getText().equals("ABD")) {
                driver.findElement(By.xpath("/html/body/div[1]/div[5]/div[4]/ul/li[15]/a")).click();
                break;
            }

            action.moveToElement(languagebar).perform(); //move to countries
            Thread.sleep(500);

        }

        WebElement ship = driver.findElement(By.xpath("/html/body/div[1]/header/div/div[4]/div[1]/div/div/div[3]/span[1]/span/input"));
        ship.click();

        WebElement element = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select slc = new Select(element); //select class
        slc.selectByVisibleText("Digital Music"); //select drop-down
        Thread.sleep(1000);

        WebElement textArea = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        textArea.sendKeys("Samsung Galaxy M51");
        textArea.sendKeys(Keys.ENTER);
        Thread.sleep(1000);

        WebElement phone = driver.findElement(By.xpath("//span[contains(text(),'Samsung Galaxy A51 (SM-A515F/DS) Dual SIM 128GB, G')]"));
        phone.click();
        Thread.sleep(1000);

        List<WebElement> images = driver.findElements(By.xpath("(//div[@id='altImages']/ul/li)[position()>3]"));
        for (WebElement image : images) {
            action.moveToElement(image).perform(); //move to images
            Thread.sleep(1000);
        }

/*      String currentUrl = driver.getWindowHandle();
        System.out.printf("Parent window id is "+currentUrl);
        Set<String> allWindows=driver.getWindowHandles();
        ArrayList<String> tabs=new ArrayList<>(allWindows);*/

        WebElement contain = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[8]/div[4]/div[3]/div[1]/div[1]/div/div/div[2]/div[1]/div[1]/ul/li[8]/span/span"));
        contain.click();

        List<WebElement> innerimages = driver.findElements(By.xpath("//div[@class='ivThumb']"));
        for (WebElement innerimage : innerimages) {
            innerimage.click();
            Thread.sleep(1000);
        }
        WebElement innerimage2 = driver.findElement(By.xpath("(//div[@class='ivThumbImage'])[7]"));
        innerimage2.click();
        Thread.sleep(3000);
        WebElement closePopup =driver.findElement(By.xpath("//div[@id='a-popover-3']/div/header/button/i"));
        closePopup.click();

        //tab kontrolu
/*      driver.switchTo().window(tabs.get(1));
        driver.close();
        driver.switchTo().window(tabs.get(0));
        System.out.printf("Title of parent window is "+driver.getTitle());*/

        WebElement bluecolor = driver.findElement(By.xpath("//body/div[@id='a-page']/div[@id='dp']/div[@id='dp-container']/div[@id='ppd']/div[@id='centerCol']/div[@id='twister_feature_div']/div[@id='twisterContainer']/div[1]/form[1]/div[1]/ul[1]/li[2]/span[1]/div[1]/span[1]/span[1]/span[1]/button[1]/div[1]/div[1]/img[1]"));
        Thread.sleep(1000);
        bluecolor.click();
        Thread.sleep(1000);

        String stock = driver.findElement(By.xpath("//body/div[@id='a-page']/div[@id='dp']/div[@id='dp-container']/div[@id='ppd']/div[@id='centerCol']/div[@id='availability_feature_div']/div[@id='availability']/span[1]/span[2]")).getText();
        Assert.assertTrue(stock.contains("Available")); //import testng
        System.out.println("Available from these sellers."); //if text contains 'Available', keep it on

        WebElement addChart = driver.findElement(By.xpath("//*[@id=\"wishListMainButton-announce\"]"));
        addChart.click();
        Thread.sleep(1000);

        WebElement email = driver.findElement(By.xpath("//input[@id='ap_email']"));
        email.sendKeys("deneme@gmail.com");
        Thread.sleep(1000);

        driver.findElement(By.xpath("//input[@id='continue']")).click();

        WebElement password = driver.findElement(By.xpath("//input[@id='ap_password']"));
        password.sendKeys("deneme123");
        Thread.sleep(1000);

        driver.findElement(By.xpath("//input[@id='signInSubmit']")).click();

        String oops = "Important Message!";

        Assert.assertEquals(oops, driver.findElement(By.xpath("//h4[contains(text(),'Important Message!')]")).getText()); //if they are equal then ok
        System.out.println("To better protect your account, please re-enter your password and then enter the characters as they are shown in the image below.");

        Thread.sleep(3000);
        driver.quit();
    }
}