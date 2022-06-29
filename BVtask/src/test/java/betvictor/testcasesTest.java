package betvictor;

import org.testng.annotations.Test;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import io.github.bonigarcia.wdm.WebDriverManager;

@Test
public class testcasesTest {

	
	public static WebDriver driver;

	
	@BeforeTest
	public void launchBrowser() {
	 
		//Setting system properties of ChromeDriver
		WebDriverManager.chromedriver().setup();
		
		//Creating an object of ChromeDriver
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
		
	@Test

	public void exerciseone() throws Exception {
		try {
			
			//launch browser and open url
			String url= "http://www.smartclient.com/smartgwt/showcase/#featured_tile_filtering";
			driver.get(url);
			
			//agree privacypolicy
			if(driver.findElement(Constants.privacypolicy).isDisplayed()) {
				driver.findElement(Constants.iagree).click();
			}
			//fill in fields			
			//Animal set using letter „a”
		    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			WebElement name = driver.findElement(Constants.animalfield);
			name.sendKeys("a");
			
			//Max life span set to  40		
				
			//Element which needs to drag.   
        	WebElement From=driver.findElement(Constants.slidebar);
        	
            //Using Action class to scroll  slidebar.		
            Actions act=new Actions(driver);					
          
            //Drag and Drop by Offset.		
            act.dragAndDropBy(From, -70, 0).perform();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            
            //check the output value i.e check if slidebar is corrctly pointing to age 40
        	WebElement Output = driver.findElement(Constants.slidebargettext);
        	int outputtext = Integer.parseInt(Output.getText().trim());        	
            System.out.println("Output=" +outputtext);            
            Assert.assertEquals(outputtext == 40, true);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
            
            //Sort order by „Life Span” 
            //click sortfield
            WebElement sortfield = driver.findElement(Constants.sortfield);
            sortfield.click();
            
            //select lifespan
            driver.findElement(Constants.lifespan).click();
            driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(1));
          
            
            //Select checkbox  to Ascending
            WebElement checkbox =driver.findElement(Constants.ascendingcheckbox);
            checkbox.click();
            
            //click filter to see the results
            WebElement filter = driver.findElement(Constants.filterbutton);
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].scrollIntoView(true);", filter);
            filter.click();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
            
            //Assert that results contains more than 12 items
            List<WebElement> count = driver.findElements(Constants.countoffilter);
            System.out.println("Count =" +count);
            Assert.assertTrue(count.size() > 12, "results contains less than 12 items");
            
		}catch (Exception | AssertionError e)
		{
			Assert.fail("Testcase exerciseone - Failed" + e);
	    }	
	}

	@Test
public static void exercisetwo() throws Exception {
		
		try {
		
	
	//launch browser and open url
	String url= "http://www.smartclient.com/smartgwt/showcase/#featured_dropdown_grid_category";
	driver.get(url);
	
	//agree privacypolicy
	if(driver.findElement(Constants.privacypolicy).isDisplayed()) {
		driver.findElement(Constants.iagree).click();
	}
	
	//click on dropdown
	WebElement item = driver.findElement(Constants.itemdropdown);
	item.click();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
	
	 //filter items by clicking on item header button
	 driver.findElement(Constants.itemheader).click();
	 
		
	//Element which needs to drag.   
 	WebElement From=driver.findElement(Constants.scrollbar);
 	
 	 //Using Action class for drag and drop.		
     Actions act=new Actions(driver);	
     //Drag and Drop by Offset.		
     act.dragAndDropBy(From, 0, 132).perform();
     
     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	 
     //verifying the size of exercise items
     List<WebElement> items = driver.findElements(Constants.itemexercise);
     Assert.assertTrue(items.size() == 8, "less than 8 items");
     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
     
     //	Units contains  Ea
     //	Unit Cost greater than 1.1

     List<WebElement> units = driver.findElements(Constants.units);
     
     for(int i =0 ; i< units.size(); i++) 
     {
		 
    	 if(units.get(i).getText().contains("Ea")) 
    	 {
    		 
    		 System.out.println("Units value=" +units.get(i).getText());
    		 
    		 List<WebElement> price = driver.findElements(Constants.unitprice);
    		 String val = price.get(i).getText();
    		 double val1 = Double.parseDouble(val);
    		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
    		 
    		 if(val1 > 1.1) 
    		 {
    			 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    			 units.get(i).click();
    			  break;
    		 
    		 }
    	 }
    		 
     }
		}catch (Exception | AssertionError e) {
			Assert.fail("Testcase exercisetwo - Failed" + e);
	}	
	 
 }
	
    

	@Test
public static void exercisethree() throws Exception {
		
		try {
	
	//launch browser and open url
	String url= "http://www.smartclient.com/smartgwt/showcase/#featured_nested_grid";
	driver.get(url);
	
	//agree privacypolicy
		if(driver.findElement(Constants.privacypolicy).isDisplayed()) {
			driver.findElement(Constants.iagree).click();
		}
		
	 //filter items by clicking on item header button
	 driver.findElement(Constants.itemheader).click();
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
	 
		
	//Element which needs to drag.   
 	WebElement From=driver.findElement(Constants.scrollbar);
 	
 	 //Using Action class for drag and drop.		
     Actions act=new Actions(driver);	
     //Drag and Drop by Offset.		
     act.dragAndDropBy(From, 0, 55).perform();
     
     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	 
     //verifying the size of correction items
     List<WebElement> items = driver.findElements(Constants.itemcorrection);
     Assert.assertTrue(items.size() == 3, "less than 3 items");
     

     
    for(int i =0 ; i< items.size(); i++) 
     {
        //expnading the items
        List<WebElement> expansion = driver.findElements(Constants.itemcorrectionexpansion);
    	expansion.get(i).click();
    	
    	//modify the description
    	List<WebElement> description = driver.findElements(Constants.decriptionfield);
      

		  if(description.isEmpty()) 
		  {
			  WebElement closebtn = driver.findElement(By.xpath("//td[@class='button']//div[text()='Close']"));
			  ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", closebtn);
			  driver.findElement(Constants.closebutton).click();
	      }
		  
		  else 
		  { 
		  
			  //enter new description for all the sub items available 
    	     for(int j=0; j<description.size(); j++)
    	     {
    	  			  
    		 description = driver.findElements(Constants.decriptionfield);
    		
    		 //scrolls to the exact location
    		 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", description.get(j));
    		 description.get(j).click();
    		 
    		 //switch to frame
    	     driver.switchTo().defaultContent();
    	     Actions act1 = new Actions(driver);
    	     
    	     //enter text into description field
    	     act1.sendKeys("sdfsdfsfd" +j).perform();
    	     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    	     
    	     //click save
    	     WebElement save=  driver.findElement(Constants.savebutton);
      	     save.click();
    	
      	     //if description is updated for all the sub items click close
    		  if(j==description.size()-1)
    	    
    	     {
    		 
    	    	 driver.findElement(Constants.closebutton).click();
    		    
    	     }
    	    }
      }
     }
		}catch (Exception | AssertionError e) {
			Assert.fail("Testcase exercisethree - Failed" + e);
	}	
	    	
     }
    
    	 
	
	
	@AfterTest
	public void exit() throws Exception {
		
		driver.quit();
	}
  }

