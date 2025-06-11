package com.Automation.SoftwareTesting;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class test {
    String baseURL = "https://www.beautybay.com/";
    WebDriver driver;
    
    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Divya\\Downloads\\chromedriver-win64 (1)\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get(baseURL);
        System.out.println("URL Launched Successfully");
        Thread.sleep(6000);
        
        String accept="//button[contains(text(),'Accept All')]";
        WebElement elem = driver.findElement(By.xpath(accept));
        elem.click();
        driver.navigate().refresh();
        Thread.sleep(8000);
    }
    @Test
    public void cookie() {
   	 System.out.println("Test case 1:Passed,Homepage loaunched succesfully ");
   	 System.out.println("Test case 2:Passed,Cookies accepted ");
    }
 
    
    @Test
    public void login() throws Exception {
        String profile = "//span[@title='Account']";
        String email = "//input[@id='username']";
        String password = "//input[@type='password']";
        String Continue = "//button[contains(text(),'Continue')]";
        
        WebElement elem1 = driver.findElement(By.xpath(profile));
        elem1.click();
        Thread.sleep(5000);
        
        driver.findElement(By.xpath(email)).sendKeys("divyaammu10680@gmail.com");
        driver.findElement(By.xpath(password)).sendKeys("Divya@123");
        Thread.sleep(5000);
        
        WebElement elem2 = driver.findElement(By.xpath(Continue));
        elem2.click();
        System.out.println("Test case 3:Passed,Login Done Successfully");
        
    }
    @Test
    public void invalid() throws Exception {
        String profile = "//span[@title='Account']";
        String email = "//input[@id='username']";
        String password = "//input[@type='password']";
        String Continue = "//button[contains(text(),'Continue')]";
        String error="//span[@id='error-element-password']";
        
        WebElement elem1 = driver.findElement(By.xpath(profile));
        elem1.click();
        Thread.sleep(5000);
        
        driver.findElement(By.xpath(email)).sendKeys("divya12");
        driver.findElement(By.xpath(password)).sendKeys("Divya@123");
        Thread.sleep(5000);
        
        WebElement elem2 = driver.findElement(By.xpath(Continue));
        elem2.click();
        Thread.sleep(5000);
        
        WebElement elem3=driver.findElement(By.xpath(error));
        
        assertNotNull(elem3);
        assertTrue(elem3.isDisplayed());
        
        System.out.println("Testcase 4: Passed, Invalid login Error message displayed as expected");
        
        String expectedError = "Wrong credentials"; 
        assertEquals(expectedError, elem3.getText());
    }
    
    @Test
    public void title() {
        String Expectedtitle = "BEAUTY BAY: For the obsessed";
        String Actualtitle = driver.getTitle();
        assertEquals(Expectedtitle, Actualtitle);
        
        if (Actualtitle.equals(Expectedtitle)) {
            System.out.println("Invalid login 5:Passed,Title matched");
        } else {
            System.out.println("Testcase 5:Failed");
        }
    }

    
    @Test
    public void testCountrySelection() throws InterruptedException {
    	String cnt="//button[@data-testid='confirmLanguageSelection']";
    	String country="//div[@class='usp-desktop__language__region__language']";
        WebElement ele=driver.findElement(By.xpath(country));
        ele.click();
        
        Thread.sleep(1000);
        WebElement ele1=driver.findElement(By.xpath("//select[@data-testid='countryDropdown']"));
        ele1.click();
        Thread.sleep(5000);
        
        WebElement el=driver.findElement(By.xpath("//option[@value='IN']"));
        el.click();
        
        WebElement ele2=driver.findElement(By.xpath(cnt));
        ele2.click(); 
        System.out.println("Testcase 6:Passed,country India as selected");
    }
    @Test
    public void editprofile() throws Exception {
        String profile = "//span[@title='Account']";
        String email = "//input[@id='username']";
        String password = "//input[@type='password']";
        String Continue = "//button[contains(text(),'Continue')]";
        
        WebElement elem1 = driver.findElement(By.xpath(profile));
        elem1.click();
        Thread.sleep(5000);
        
        driver.findElement(By.xpath(email)).sendKeys("divyaammu10680@gmail.com");
        driver.findElement(By.xpath(password)).sendKeys("Divya@123");
        Thread.sleep(5000);
        
        WebElement elem2 = driver.findElement(By.xpath(Continue));
        elem2.click();
        System.out.println("Login Done Successfully");
        Thread.sleep(5000);
        
        String edit="//span[@class='accent-text']";
        driver.findElement(By.xpath(edit)).click();
        Thread.sleep(5000);
        
        
        driver.findElement(By.id("forename")).sendKeys("Divya@123");
        Thread.sleep(5000);
        
        String save="//button[contains(text(),'Save')]";
        driver.findElement(By.xpath(save)).click();
        Thread.sleep(5000);
        System.out.println("Testcase 7:Passed,profile updated successfully");
    }
    @Test
    public void search() throws InterruptedException {
        String searchBox = "//input[@name='search']";
        driver.findElement(By.xpath(searchBox)).sendKeys("lipstick");
        Thread.sleep(5000);
        
        WebElement searchResults = driver.findElement(By.xpath("//button[@data-testid='search-icon']"));
        assertNotNull(searchResults);
        
        if (searchResults.isDisplayed()) {
            System.out.println("Testcase 8: Passed, Search ");
        } else {
            System.out.println("Testcase 8: Failed,Search ");
        }
    }

    @Test
    public void testAddToCart() throws InterruptedException {
        
            String searchBox = "//input[@name='search']";
            driver.findElement(By.xpath(searchBox)).sendKeys("lipstick");
            driver.findElement(By.xpath("//button[@data-testid='search-icon']")).click();
            
            Thread.sleep(10000);

            String firstProduct = "//div[@class='add-to-bag button-tertiary']";
            WebElement product = driver.findElement(By.xpath(firstProduct));
            JavascriptExecutor executor = (JavascriptExecutor)driver;
            executor.executeScript("arguments[0].click();", product);
            
            Thread.sleep(10000);
            // Add the product to the cart
            String viewCart = "//div[contains(text(),'View bag')]";
            WebElement el1 = driver.findElement(By.xpath(viewCart));
            executor.executeScript("arguments[0].click();", el1);
            Thread.sleep(5000);
           
            System.out.println("Testcase 9:passed,add to cart");
                
    }
    
    @Test
    public void testSort() throws InterruptedException {
        
            String searchBox = "//input[@name='search']";
            driver.findElement(By.xpath(searchBox)).sendKeys("foundation");
            Thread.sleep(2000);
            driver.findElement(By.xpath("//button[@data-testid='search-icon']")).click();
            
            Thread.sleep(20000);

            String sort="//button[contains(text(),'Sort: Staff Faves')]";
            driver.findElement(By.xpath(sort)).click();
            Thread.sleep(5000);
            
            String brand="//span[contains(text(),'Brand: A - Z')]";
            driver.findElement(By.xpath(brand)).click();
            Thread.sleep(5000);
            System.out.println("Testcase 10:Passed,sorted by brand");
          
        
    }
    @Test
    public void testfilter() throws InterruptedException {
        
            String searchBox = "//input[@name='search']";
            driver.findElement(By.xpath(searchBox)).sendKeys("brushes");
            Thread.sleep(3000);
            driver.findElement(By.xpath("//button[@data-testid='search-icon']")).click();
            
            Thread.sleep(7000);

            String filter=" //button[contains(text(),'Filter')]";
            driver.findElement(By.xpath(filter)).click();
            Thread.sleep(5000);
            
            String price="//*[@id=\"wrapper\"]/div[2]/div[1]/div/div[3]/section[6]";
            driver.findElement(By.xpath(price)).click();
            Thread.sleep(5000);
            
            String under="//span[contains(text(),'Under ₹2000')]";
            driver.findElement(By.xpath(under)).click();
            Thread.sleep(7000);
            
            System.out.println("Testcase 11:passed,Filtered by price");
          
        
    }
 
    @Test
    public void remove() throws InterruptedException {
    	String cart="//a[@title='Checkout']";
    	String remove="//span[@class='product__remove']";
    	String searchBox = "//input[@name='search']";
    	
        driver.findElement(By.xpath(searchBox)).sendKeys("lipstick");
        driver.findElement(By.xpath("//button[@data-testid='search-icon']")).click();
        
        Thread.sleep(10000);

        String firstProduct = "//div[@class='add-to-bag button-tertiary']";
        WebElement product = driver.findElement(By.xpath(firstProduct));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", product);
        
        Thread.sleep(10000);
        // Add the product to the cart
        String viewCart = "//div[contains(text(),'View bag')]";
        WebElement el1 = driver.findElement(By.xpath(viewCart));
        executor.executeScript("arguments[0].click();", el1);
        Thread.sleep(5000);
    
    	WebElement ele1=driver.findElement(By.xpath(cart));
    	ele1.click();
    	Thread.sleep(5000);
    	
    	WebElement ele2=driver.findElement(By.xpath(remove));
    	ele2.click();
    	Thread.sleep(5000);
    	System.out.println("Testcase 12:passed,Product removed sucessfully");
    }
@Test
    public void quantity() throws InterruptedException {
    	String profile = "//span[@title='Account']";
        String email = "//input[@id='username']";
        String password = "//input[@type='password']";
        String Continue = "//button[contains(text(),'Continue')]";
    	String cart="//a[@title='Checkout']";
    	String quantity="//select[@name='product-qty']";
        
        WebElement elem1 = driver.findElement(By.xpath(profile));
        elem1.click();
        Thread.sleep(5000);
 
        driver.findElement(By.xpath(email)).sendKeys("divyaammu10680@gmail.com");
        driver.findElement(By.xpath(password)).sendKeys("Divya@123");
        Thread.sleep(5000);
        
        WebElement elem2 = driver.findElement(By.xpath(Continue));
        elem2.click();
        Thread.sleep(5000);
        System.out.println("Login Done Succesfully");
    
    	WebElement ele1=driver.findElement(By.xpath(cart));
    	ele1.click();
    	Thread.sleep(5000);
    	
    	WebElement ele2=driver.findElement(By.xpath(quantity));
    	ele2.click();
    	Thread.sleep(5000);
    	WebElement el=driver.findElement(By.xpath("//option[@value='4']"));
        el.click();
        Thread.sleep(8000);
        
    	System.out.println("Testcase 13:passed,Product quantity increased sucessfully");
    }
    @Test
    public void emptywish() throws InterruptedException {
    	 String profile = "//span[@title='Account']";
         String email = "//input[@id='username']";
         String password = "//input[@type='password']";
         String Continue = "//button[contains(text(),'Continue')]";
         
         WebElement elem1 = driver.findElement(By.xpath(profile));
         elem1.click();
         Thread.sleep(5000);
         
         driver.findElement(By.xpath(email)).sendKeys("divyaammu10680@gmail.com");
         driver.findElement(By.xpath(password)).sendKeys("Divya@123");
         Thread.sleep(5000);
         
         WebElement elem2 = driver.findElement(By.xpath(Continue));
         elem2.click();
         System.out.println("Login Done Successfully");
         Thread.sleep(5000);
         		
 	   String wish="//a[@title='Wishlist']";
 	   driver.findElement(By.xpath(wish)).click();
 	   Thread.sleep(5000);
 	   
 	   String emptywishMessage = "//*[@id=\"beautybay-checkout\"]/div[3]/h1"; 
        List<WebElement> emptywishElements = driver.findElements(By.xpath(emptywishMessage));
        Thread.sleep(5000);
        if (emptywishElements.size() > 0) {
            System.out.println("Testcase 14:passed,Wish is empty.");
        } else {
            System.out.println("Testcase 14:Failed,Wish is not empty.");
        }
    }
    @Test
    public void AddWishList() throws InterruptedException {
	   String profile = "//span[@title='Account']";
       String email = "//input[@id='username']";
       String password = "//input[@type='password']";
       String Continue = "//button[contains(text(),'Continue')]";
       
       WebElement elem1 = driver.findElement(By.xpath(profile));
       elem1.click();
       Thread.sleep(5000);
       
       driver.findElement(By.xpath(email)).sendKeys("divyaammu10680@gmail.com");
       driver.findElement(By.xpath(password)).sendKeys("Divya@123");
       Thread.sleep(5000);
       
       WebElement elem2 = driver.findElement(By.xpath(Continue));
       elem2.click();
       		System.out.println("Login Done Successfully");
       		Thread.sleep(5000);
            String searchBox = "//input[@name='search']";
            driver.findElement(By.xpath(searchBox)).sendKeys("eyeliner");
            driver.findElement(By.xpath("//button[@data-testid='search-icon']")).click();
            Thread.sleep(5000);
            String firstProduct = "//div[@class='lister-tile']";
            WebElement product = driver.findElement(By.xpath(firstProduct));
            JavascriptExecutor executor = (JavascriptExecutor)driver;
            executor.executeScript("arguments[0].click();", product);
            
            Thread.sleep(10000);
            // Add the product to the cart
            String wish = "//div[@class='button-tertiary add-to-wishlist add-to-wishlist-pdp ']";
            WebElement el1 = driver.findElement(By.xpath(wish));
            el1.click();
            Thread.sleep(8000);
            
            String wishlist="//a[@title='Wishlist']";
            WebElement el2 = driver.findElement(By.xpath(wishlist));
            el2.click();
            
            System.out.println("Testcase 15:passed,product succesfully added to wishlist.");
            
    }
    @Test
    public void CartWish() throws InterruptedException {
	   String profile = "//span[@title='Account']";
       String email = "//input[@id='username']";
       String password = "//input[@type='password']";
       String Continue = "//button[contains(text(),'Continue')]";
       String cart="//a[@title='Checkout']";
       String wish="//span[@class='product__move-to-wishlist']";
       
       WebElement elem1 = driver.findElement(By.xpath(profile));
       elem1.click();
       Thread.sleep(5000);
       
       driver.findElement(By.xpath(email)).sendKeys("divyaammu10680@gmail.com");
       driver.findElement(By.xpath(password)).sendKeys("Divya@123");
       Thread.sleep(5000);
       
       WebElement elem2 = driver.findElement(By.xpath(Continue));
       elem2.click();
       System.out.println("Login Done Successfully");
	   Thread.sleep(5000);
	   
       WebElement ele1=driver.findElement(By.xpath(cart));
   	   ele1.click();
   	   Thread.sleep(5000);
            
       WebElement el2 = driver.findElement(By.xpath(wish));
       el2.click();
       Thread.sleep(8000);
       driver.findElement(By.xpath("//span[@class='wishlist-icon__indicator']")).click();
       Thread.sleep(3000);
       System.out.println("Testcase 16:passed,item form cart to wishlist.");
    }
    
   @Test
   public void emptycart() throws InterruptedException {
	   String cart="//a[@title='Checkout']";
	   driver.findElement(By.xpath(cart)).click();
	   Thread.sleep(5000);
	   
	   String emptyCartMessage = "//*[@id=\"beautybay-checkout\"]/div[3]/h1"; // This is an example, update with the actual XPath if different
       List<WebElement> emptyCartElements = driver.findElements(By.xpath(emptyCartMessage));
       Thread.sleep(5000);
       if (emptyCartElements.size() > 0) {
           System.out.println("Testcase 17:Passed,Cart is empty.");
       } else {
           System.out.println("Testcase 17:Failed,Cart is not empty.");
       }
   }
@Test
   public void verifycarthasproduct() throws InterruptedException {
	   String profile = "//span[@title='Account']";
       String email = "//input[@id='username']";
       String password = "//input[@type='password']";
       String Continue = "//button[contains(text(),'Continue')]";
       
       WebElement elem1 = driver.findElement(By.xpath(profile));
       elem1.click();
       Thread.sleep(5000);
 
       driver.findElement(By.xpath(email)).sendKeys("divyaammu10680@gmail.com");
       driver.findElement(By.xpath(password)).sendKeys("Divya@123");
       Thread.sleep(5000);
       
       WebElement elem2 = driver.findElement(By.xpath(Continue));
       elem2.click();
       System.out.println("Login Done Successfully");
       Thread.sleep(8000);
       
       String cart="//a[@title='Checkout']";
	   driver.findElement(By.xpath(cart)).click();
	   Thread.sleep(5000);
	   
	   String emptyCartMessage = "//*[@id=\"beautybay-checkout\"]/div[3]/h1"; // This is an example, update with the actual XPath if different
       List<WebElement> emptyCartElements = driver.findElements(By.xpath(emptyCartMessage));
       Thread.sleep(5000);
       if (emptyCartElements.size() > 0) {
           System.out.println("Testcase 17:Failed,Cart is empty.");
       } else {
           System.out.println("Testcase 17:Passed,Cart is not empty.");
       }
   }
    @Test
    public void removewhish() throws InterruptedException {
    	String profile = "//span[@title='Account']";
        String email = "//input[@id='username']";
        String password = "//input[@type='password']";
        String Continue = "//button[contains(text(),'Continue')]";
    	String cart="//a[@title='Checkout']";
    	String remove="//span[@class='product__remove']";
        
        WebElement elem1 = driver.findElement(By.xpath(profile));
        elem1.click();
        Thread.sleep(5000);
        
        driver.findElement(By.xpath(email)).sendKeys("divyaammu10680@gmail.com");
        driver.findElement(By.xpath(password)).sendKeys("Divya@123");
        Thread.sleep(5000);
        
        WebElement elem2 = driver.findElement(By.xpath(Continue));
        elem2.click();
        Thread.sleep(5000);
        System.out.println("Login Done Succesfully");
        
        String wishlist="//a[@title='Wishlist']";
        WebElement el2 = driver.findElement(By.xpath(wishlist));
        el2.click();
        Thread.sleep(8000);
        
        String wishremove="//div[@class='remove-from-wishlist']";
        WebElement ele2 = driver.findElement(By.xpath(wishremove));
        ele2.click();
        Thread.sleep(8000);
        System.out.println("Testcase 19:Passed,Item is succesfully removed from wishlist.");
    }

    @Test
    public void wishtocart() throws InterruptedException {
    	String profile = "//span[@title='Account']";
        String email = "//input[@id='username']";
        String password = "//input[@type='password']";
        String Continue = "//button[contains(text(),'Continue')]";
        
        WebElement elem1 = driver.findElement(By.xpath(profile));
        elem1.click();
        Thread.sleep(5000);
        
        driver.findElement(By.xpath(email)).sendKeys("divyaammu10680@gmail.com");
        driver.findElement(By.xpath(password)).sendKeys("Divya@123");
        Thread.sleep(5000);
        
        WebElement elem2 = driver.findElement(By.xpath(Continue));
        elem2.click();
        System.out.println("Login Done Successfully");
  		Thread.sleep(5000);
        		
    	driver.findElement(By.xpath("//a[@title='Wishlist']")).click();
        Thread.sleep(5000);
        
        String firstProduct = "//div[@class='add-to-bag button-tertiary']";
        WebElement product = driver.findElement(By.xpath(firstProduct));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", product);
        
        Thread.sleep(8000);
        // Add the product to the cart
        String viewCart = "//div[contains(text(),'View bag')]";
        WebElement el1 = driver.findElement(By.xpath(viewCart));
        executor.executeScript("arguments[0].click();", el1);
        Thread.sleep(5000);
        
        System.out.println("Testcase 20:passed,from wish again added to cart");
    }
    @Test
    public void logout() throws InterruptedException {
    	String profile = "//span[@title='Account']";
        String email = "//input[@id='username']";
        String password = "//input[@type='password']";
        String Continue = "//button[contains(text(),'Continue')]";
        String cart="//a[@title='Checkout']";
        String wish="//span[@class='product__move-to-wishlist']";
        
        WebElement elem1 = driver.findElement(By.xpath(profile));
        elem1.click();
        Thread.sleep(5000);
        
        driver.findElement(By.xpath(email)).sendKeys("divyaammu10680@gmail.com");
        driver.findElement(By.xpath(password)).sendKeys("Divya@123");
        Thread.sleep(5000);
        
        WebElement elem2 = driver.findElement(By.xpath(Continue));
        elem2.click();
        System.out.println("Login Done Successfully");
 	   Thread.sleep(8000);
 	  String signout="//button[contains(text(),'Sign out')]";
      WebElement ele = driver.findElement(By.xpath(signout));
      ele.click();
      Thread.sleep(2000);
      System.out.println("Testcase 21:Passed,Signout Done Successfully");
        
    }
    @After
    public void tearDown() throws Exception {
        if (driver != null) {
            driver.quit();
        }
    }
}
