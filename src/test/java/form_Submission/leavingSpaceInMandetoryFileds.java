package form_Submission;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class leavingSpaceInMandetoryFileds {
		
		WebDriver driver;

	    @BeforeTest 
	    public void openUrl() throws InterruptedException {
	        System.setProperty("webdriver.chrome.driver", "C:\\Users\\visha\\eclipse-workspace\\ToolsQa\\src\\main\\resources\\chromedriver.exe");
	        driver = new ChromeDriver();
	        driver.get("https://demoqa.com/automation-practice-form");
	        driver.manage().window().maximize();

	        Thread.sleep(3000);

	    }
	    
	    @Test
	    public void TC002() throws InterruptedException {
	    	
	    	
	    	driver.findElement(By.id("firstName")).sendKeys("");//first name
	   
	    	driver.findElement(By.id("lastName")).sendKeys("");//last name
	    
	    	driver.findElement(By.id("userEmail")).sendKeys("vishakalakmali623@gmail.com");//email address
	    	
	    	
	    	//driver.findElement(By.xpath("//label[@for='gender-radio-2']")).click();//radio button

            //driver.findElement(By.xpath("//input[@placeholder='Mobile Number']")).sendKeys("0750852603");//mobile number
            
            //birthoF date
           driver.findElement(By.id("dateOfBirthInput")).sendKeys("14/11/2000");
           driver.findElement(By.id("dateOfBirthInput")).sendKeys(Keys.RETURN);
	    	
            
            
            //select subject
            driver.findElement(By.xpath("//div[@id='subjectsContainer']//input")).sendKeys("Maths");
            driver.findElement(By.xpath("//div[@id='subjectsContainer']//input")).sendKeys(Keys.ENTER);
            
            Thread.sleep(3000);
            
            //hobbies
            driver.findElement(By.xpath("//label[@for='hobbies-checkbox-1']")).click();
            driver.findElement(By.xpath("//label[@for='hobbies-checkbox-2']")).click();
            Thread.sleep(3000);
        
            
            //image upload
            driver.findElement(By.id("uploadPicture")).sendKeys("C:\\Users\\visha\\eclipse-workspace\\ToolsQa\\src\\main\\resources\\download.jpg");
            driver.findElement(By.xpath("//label[@for='hobbies-checkbox-2']")).click();
            
            driver.findElement(By.id("currentAddress")).sendKeys("Nuwara Eliya");
            
            driver.findElement(By.id("submit")).submit();
            
            
         
            // Check for a success message 
            boolean isSuccessMessageDisplayed = driver.findElement(By.xpath("//div[@class='modal-title h4']")).isDisplayed(); 
            Assert.assertTrue(isSuccessMessageDisplayed, "The success message is not displayed.");
            
            
	    	
            
            
            
          
	    }
	    
	    @AfterTest 
	    public void tearDown() {
	        if (driver != null) { 
	            driver.quit();
	        }
	    }
	    
	    

	    
}

