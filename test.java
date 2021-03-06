package com.lambdatest.Tests;

import java.net.URL;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


public class SingleTest {

    public static WebDriver driver;
    public static String status = "failed";

    @Before
    public void setUp() throws Exception {

        String browser = Configuration.readConfig("browser");
        String version = Configuration.readConfig("version");
        String os = Configuration.readConfig("os");
        String res = Configuration.readConfig("resolution");

        String username = System.getenv("LT_USERNAME") != null ? System.getenv("LT_USERNAME") : Configuration.readConfig("LambdaTest_UserName");
        String accesskey = System.getenv("LT_ACCESS_KEY") != null ? System.getenv("LT_ACCESS_KEY") : Configuration.readConfig("LambdaTest_AppKey");

        DesiredCapabilities capability = new DesiredCapabilities();
        capability.setCapability(CapabilityType.BROWSER_NAME, browser);
        capability.setCapability(CapabilityType.VERSION, version);
        capability.setCapability(CapabilityType.PLATFORM, os);
        capability.setCapability("build", "Junit Single Test");
        capability.setCapability("name", "JUnit Single");
        capability.setCapability("screen_resolution", res);

        String gridURL = "https://" + username + ":" + accesskey + "@hub.lambdatest.com/wd/hub";

        driver = new RemoteWebDriver(new URL(gridURL), capability);
    }

    @Test
    public void test() {

        // Launch the app
        driver.get("https://lambdatest.github.io/sample-todo-app/");

        // Click on First Item
        driver.findElement(By.name("li1")).click();

        // Click on Second Item
        driver.findElement(By.name("li2")).click();

        // Add new item is list
        driver.findElement(By.id("sampletodotext")).clear();
        driver.findElement(By.id("sampletodotext")).sendKeys("Yey, Let's add it to list");
        driver.findElement(By.id("addbutton")).click();

        // Verify Added item
        String item = driver.findElement(By.xpath("/html/body/div/div/div/ul/li[6]/span")).getText();
        Assert.assertTrue(item.contains("Yey, Let's add it to list"));
        status = "passed";

    }

    @After
    public void afterTest() {
        ((JavascriptExecutor) driver).executeScript("lambda-status=" + status + "");
        driver.quit();
    }

}