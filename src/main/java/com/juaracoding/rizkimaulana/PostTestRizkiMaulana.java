package com.juaracoding.rizkimaulana;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class PostTestRizkiMaulana  {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "F:\\Software\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        String url = "https://formy-project.herokuapp.com/form";
        driver.get(url);

        String titleMenu = driver.getTitle();
        System.out.println("Title Menu: "+titleMenu);

        int detik = 1;

        delay(detik);
        WebElement firstName = driver.findElement(By.xpath("//*[@id=\"first-name\"]"));
        firstName.sendKeys("Rizki Maulana");
        System.out.println("Enter first name");
        delay(detik);
        driver.findElement(By.id("last-name")).sendKeys("Azis");
        System.out.println("Enter last name");
        delay(detik);
        driver.findElement(By.id("job-title")).sendKeys("Software Quality Assurance");
        System.out.println("Enter your job title");

        delay(detik);
        driver.findElement(By.xpath("//*[@id=\"radio-button-2\"]")).click();
        System.out.println("College Clicked");
        delay(detik);
        driver.findElement(By.xpath("//*[@id=\"checkbox-1\"]")).click();
        System.out.println("Sex Male Clicked");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement college = driver.findElement(By.id("radio-button-2"));
        // Scroll Vertical 1000 pixel
        js.executeScript("window.scrollBy(0,1000)");
        WebElement sexMale = driver.findElement(By.id("radio-button-1"));
        js.executeScript("arguments[0].click();", college);
        System.out.println("Highest level of education Clicked use JavascriptExecutor");
        js.executeScript("arguments[0].click();", sexMale);
        System.out.println("Sex Clicked use JavascriptExecutor");
        delay(detik);
        WebElement elementSelect = driver.findElement(By.id("select-menu"));
        Select selectMenu = new Select(elementSelect);
        selectMenu.selectByValue("1");
        delay(detik);
        selectMenu.selectByVisibleText("0-1");
        System.out.println("Years of experience already selected");

        delay(detik);
        driver.findElement(By.xpath("//*[@id=\"datepicker\"]")).click();
        driver.findElement(By.cssSelector("div[class*='datepicker-dropdown']")).click();
        System.out.println("Date Selected");
        delay(detik);
        driver.findElement(By.cssSelector("a[class*='btn']")).click();
        System.out.println("Button Submit Clicked");

        // delay
        Thread.sleep(3000);

        driver.quit();

    }

    static void delay(int detik) {
        //delay
        try {
            Thread.sleep(1000 * detik);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
