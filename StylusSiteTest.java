package ui;

import com.google.common.base.Verify;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.swing.plaf.basic.BasicButtonListener;
import java.util.concurrent.TimeUnit;

/**
 * Created by c2612 on 07.11.2014.
 */
public class StylusSiteTest {
    WebDriver driver;
    //Precondition
    @BeforeClass
    public void setUp(){
        //initializes a browser
        driver = new FirefoxDriver();
       //set implicit wait
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //Maximizes a window size
        driver.manage().window().maximize();
        //opens a URL
        driver.get("http://stylus.com.ua");
    }

    @Test
    public  void searchTest() {
        //finds an element by name
        WebElement searchField = driver.findElement(By.id("search_text"));
        //sets "Selenium" text into an input field
        searchField.sendKeys("Sony Xperia Z2");
        WebElement btn = driver.findElement(By.id("button"));
        Actions builder = new Actions(driver);
        builder.moveToElement(btn);
        builder.click(btn);
        builder.perform();


        WebElement searchLink = driver.findElement(By.xpath(".//*[@id='col1_content']/table[2]/tbody/tr[1]/td[1]/table/tbody/tr/td[2]/h4/a"));
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Assert.assertEquals(searchLink.getText().toString().contains("Sony Xperia Z2"), true);
        searchLink.click();
        WebElement characteristicsTab = driver.findElement(By.xpath(".//*[@id='menulink']/ul/li[1]/a/span"));
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //Assert.assertEquals(charTab.getText().toString().contains("Характеристики"), true);
        characteristicsTab.click();
        WebElement internetAccessField = driver.findElement(By.xpath(".//*[@id='col1_content']/div[4]/div[1]/div[5]/table/tbody/tr[29]/td[2]/div"));
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Assert.assertEquals(internetAccessField.getText().toString().contains("HTML, HTML5, Adobe Flash, RSS"), true);

    }
    @AfterClass
    public void tearDown() {
        driver.quit();

    }
}
