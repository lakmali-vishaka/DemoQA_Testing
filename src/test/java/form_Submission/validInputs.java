package form_Submission;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class validInputs {
		
		WebDriver driver;

	    @BeforeTest 
	    public void openUrl() throws InterruptedException {
	        System.setProperty("webdriver.chrome.driver", "C:\\Users\\visha\\eclipse-workspace\\ToolsQa\\src\\main\\resources\\chromedriver.exe");
	        driver = new ChromeDriver();
	        driver.get("https://demoqa.com/automation-practice-form");
	        driver.manage().window().maximize();

	       

	    }
	    
	    @Test
	    public void TC001() throws InterruptedException {
	    	
	    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
	    	
	    	driver.findElement(By.id("firstName")).sendKeys("Vishaka");//first name
	   
	    	driver.findElement(By.id("lastName")).sendKeys("Lakmali");//last name
	    
	    	driver.findElement(By.id("userEmail")).sendKeys("vishakalakmali623@gmail.com");//email address
	    	
	    	driver.findElement(By.xpath("//label[@for='gender-radio-2']")).click();//radio button

            driver.findElement(By.xpath("//input[@placeholder='Mobile Number']")).sendKeys("0750852603");//mobile number
            
            //birthoF date
            driver.findElement(By.id("dateOfBirthInput")).sendKeys("14/11/2000");
            driver.findElement(By.id("dateOfBirthInput")).sendKeys(Keys.RETURN);
	    	
            //add subject
            WebElement subjectInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='subjectsContainer']//input")));
            subjectInput.sendKeys("Maths");
            subjectInput.sendKeys(Keys.ENTER);
            
            
            //hobbies
            WebElement hobbyCheckbox1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[@for='hobbies-checkbox-1']")));
            hobbyCheckbox1.click();
            WebElement hobbyCheckbox2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[@for='hobbies-checkbox-2']")));
            hobbyCheckbox2.click();
            
           
            
            //image upload
            driver.findElement(By.id("uploadPicture")).sendKeys("C:\\Users\\visha\\eclipse-workspace\\ToolsQa\\src\\main\\resources\\download.jpg");
            driver.findElement(By.xpath("//label[@for='hobbies-checkbox-2']")).click();
            
            driver.findElement(By.id("currentAddress")).sendKeys("Nuwara Eliya");
            
            driver.findElement(By.id("state")).click();
            
            
            
            Thread.sleep(3000);
            
            driver.findElement(By.id("submit")).submit();
            
           
	    	 
	    }
	    @AfterTest 
	    public void tearDown() {
	        if (driver != null) { 
	            driver.quit();
	        }
	    }
	    
	    

	    
}

