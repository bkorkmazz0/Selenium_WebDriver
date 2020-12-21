import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.Set;

public class windowHandling {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver;
        System.setProperty("webdriver.chrome.driver", "C:\\browserDrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        //System.setProperty("webdriver.gecko.driver", "C:\\browserDrivers\\geckodriver.exe");
        //driver = new FirefoxDriver();
        //System.setProperty("webdriver.edge.driver", "C:\\browserDrivers\\msedgedriver.exe");
        //driver = new EdgeDriver();

        driver.get("http://www.demo.guru99.com/popup.php");

        //ilk penceremi kaydettim
        String firstWin = driver.getWindowHandle();

        String firstWinUrl = driver.getCurrentUrl();
        System.out.println("Başlangıç pencerem :   " + firstWinUrl);

        driver.findElement(By.xpath("//a[text()='Click Here']")).click();

        //Pencere değişimi için set kullandım.
        Set<String> windowAllWindows = driver.getWindowHandles();

        for (String window : windowAllWindows) {

            driver.switchTo().window(window); //windowun parantez içine sıradaki pencereyi yazdım..
        }


        Thread.sleep(1300);
        driver.findElement(By.xpath("//input[@name='emailid']")).sendKeys("berkan123@gmail.com");

        driver.findElement(By.xpath("//input[@name='btnLogin']")).click();

        System.out.println("2. pencerenin Url'i =  " + driver.getCurrentUrl());

        //pencereyi kapatmak için driver.close();
        driver.close();

        driver.switchTo().window(firstWin);

        System.out.println("Şuanki sayfanın Url ' i =   " + driver.getCurrentUrl());


        Thread.sleep(2000);
        //sistemi kapatmak için driver.quit();
        driver.quit();

    }
}

