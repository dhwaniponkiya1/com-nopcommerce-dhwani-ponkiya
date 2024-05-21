package browsertesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

/**
 * BaseUrl = https://demo.nopcommerce.com/
 * 1. Setup chrome browser.
 * 2. Open URL.
 * 3. Print the title of the page.
 * 4. Print the current url.
 * 5. Print the page source.
 * 6. Navigate to Url.
 * “https://demo.nopcommerce.com/login?returnUrl=%2F”
 * 7. Print the current url.
 * 8. Navigate back to the home page.
 * 9. Navigate to the login page.
 * 10. Print the current url.
 * 11. Refresh the page.
 * 12. Enter the email to email field.
 * 13. Enter the password to password field.
 * 14. Click on Login Button.
 * 15. Close the browser.
 */

public class ChromeBrowserTest {

    public static void main(String[] args) {
        String baseUrl = "https://demo.nopcommerce.com/";

        // Launch the Chrome browser
        WebDriver driver = new ChromeDriver();
        //open url into browser
        driver.get(baseUrl);
        //Maximise the browser window
        driver.manage().window().maximize();
        //Implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //To get the title of the page
        System.out.println("Title of page " + driver.getTitle());

        //Get current URL
        System.out.println("Current URL" + driver.getCurrentUrl());

        //Print the page source
        System.out.println("Page source" + driver.getPageSource());

        //Navigate to URL
        String loginUrl = "https://demo.nopcommerce.com/login?returnUrl=%2F";
        driver.navigate().to(loginUrl);

        System.out.println("Login URL after navigation- " + driver.getCurrentUrl());

        //Navigate back to home page
        driver.navigate().back();

        //Navigate to the login page
        driver.navigate().forward();
        System.out.println("Current URL- " + driver.getCurrentUrl());

        //Refresh the page
        driver.navigate().refresh();

        //Enter login credentials to email and password field
        //Find elements by ID
        WebElement email = driver.findElement(By.id("Email"));
        WebElement password = driver.findElement(By.id("Password"));

        email.sendKeys("prime@gmail.com");
        password.sendKeys("Prime@123");

        //Click on login button
        WebElement loginButton = driver.findElement(By.xpath("//button[contains(text(),'Log in')]"));
        loginButton.click();

        //Close the browser
        driver.quit();

    }
}
