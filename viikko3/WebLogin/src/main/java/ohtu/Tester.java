package ohtu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.Random;

public class Tester {

    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();

        driver.get("http://localhost:4567");
        
        sleep(2);
        
        WebElement element = driver.findElement(By.linkText("login"));
        element.click();

        sleep(2);

        element = driver.findElement(By.name("username"));
        element.sendKeys("pekka");
        element = driver.findElement(By.name("password"));
        element.sendKeys("akkep");
        element = driver.findElement(By.name("login"));
        
        sleep(2);
        element.submit();

        sleep(3);
        
        WebElement elementvali = driver.findElement(By.linkText("logout"));
	elementvali.click();

        sleep(2);

//epäonnistunut kirjautuminen: oikea käyttäjätunnus, väärä salasana
        
        WebElement element2 = driver.findElement(By.linkText("login"));
        element2.click();

        sleep(2);

        element2 = driver.findElement(By.name("username"));
        element2.sendKeys("pekka");
        element2 = driver.findElement(By.name("password"));
        element2.sendKeys("pekka");
        element2 = driver.findElement(By.name("login"));
        
        sleep(2);
        element2.submit();

        sleep(3);

//uuden käyttäjätunnuksen luominen

	WebElement elementvali2 = driver.findElement(By.linkText("back to home"));
	elementvali2.click();

        sleep(2);

	WebElement element3 = driver.findElement(By.linkText("register new user"));
        element3.click();

        sleep(2);
	
	Random r = new Random();
    
	element3 = driver.findElement(By.name("username"));
	element3.sendKeys("komppa"+r.nextInt(100000));
        element3 = driver.findElement(By.name("password"));
        element3.sendKeys("123");
        element3 = driver.findElement(By.name("passwordConfirmation"));
        element3.sendKeys("123");
	element3 = driver.findElement(By.name("signup"));

        sleep(2);
        element3.submit();

//uuden käyttäjätunnuksen luomisen jälkeen tapahtuva ulkoskirjautuminen sovelluksesta

        
	sleep(3);

	elementvali2 = driver.findElement(By.linkText("continue to application mainpage"));
	elementvali2.click();

	sleep(1);
	
	elementvali2 = driver.findElement(By.linkText("logout"));
	elementvali2.click();

	sleep(3);

        driver.quit();
    }
    
    private static void sleep(int n){
        try{
            Thread.sleep(n*1000);
        } catch(Exception e){}
    }
}
