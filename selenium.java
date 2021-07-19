package Selenium01;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;

@Parameterized.Parameters
	public static LinkedList<String[]> getEnvironments() throws Exception {
		LinkedList<String[]> env = new LinkedList<String[]>();
		env.add(new String[] { "Windows 10", "chrome", "latest" });
		env.add(new String[] { "Windows 10", "firefox", "latest" });
		env.add(new String[] { "Windows 7", "internet explorer", "latest" });


		return env;
	}


public class test {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.lambdatest.com/automation-demos/");
	    driver.findElement(By.id("Username")).sendKeys("lamda");
	    driver.findElement(By.name("Password")).sendKeys("abhilashaseth21@gmail.com");
	    driver.findElement(By.cssSelector("(id='alertbtn')")).click();
	    driver.switchTo().alert().accept();
	    driver.findElement(By.id("confirmbtn")).click();
	    System.out.println(driver.switchTo().alert().getText());
	    driver.switchTo().alert().dismiss();
	    driver.findElement(By.xpath("//a[@value=Every month]")).click();
	    driver.findElement(By.cssSelector("input[id='Discounts']")).isSelected();
	    driver.findElement(By.id("autosuggest")).sendKeys("Credit or Debit card");
	    driver.findElement(By.cssSelector("input[id='tried-section']")).isSelected();
	    driver.findElement(By.id("comments")).sendKeys("NA");
	    driver.get("https://blueimp.github.io/jQuery-File-Upload/");
		WebElement addFile = driver.findElement(By.xpath(".//input[@type='file']"));
		addFile.sendKeys("//C:/Users/X1ABHISE/Desktop/jenkins.svg");
		driver.findElement(By.className("submit")).click();





	    


	    
	}

}
