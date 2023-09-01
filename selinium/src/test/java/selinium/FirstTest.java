package selinium;


import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class FirstTest {
 
	static WebDriver driver;
	
	

	@Test
	public void loginWithSuccessTest() {
		
		loginWithSuccess();
		
		assertEquals("https://www.demo.guru99.com/V4/manager/Managerhomepage.php", driver.getCurrentUrl());
	
	}



	private void loginWithSuccess() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		 driver = new ChromeDriver(options);
		 driver.get("https://www.demo.guru99.com/V4");
         login("mngr521213","AguqAty");
		driver.findElement(By.name("btnLogin")).click();
		
	
	}

	
	
	@Test

    public void loginWithInvalidUserName() {
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		 driver = new ChromeDriver(options);
		 driver.get("https://www.demo.guru99.com/V4");
         
		 login("mngr521213","Aguq");
		
		driver.findElement(By.name("btnLogin")).click();

		
		driver.quit();
	}
	
	@Test

    public void loginWithInvalidPassword() {
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		 driver = new ChromeDriver(options);
		 driver.get("https://www.demo.guru99.com/V4");
		
		driver.get("https://www.demo.guru99.com/V4");
		login("123","AguqAty");
		
		driver.findElement(By.name("btnLogin")).click();
		
		
		driver.quit();
	}
	
	
	@Test

    public void resetBtnTest() {
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		 driver = new ChromeDriver(options);
		 driver.get("https://www.demo.guru99.com/V4");
		
		driver.get("https://www.demo.guru99.com/V4");
		
		login("123","AguqAty");
		
		driver.findElement(By.name("btnReset")).click();
		System.out.println("samir");
		
		System.out.println(driver.findElement(By.name("uid")).getText());
		
		assertEquals("",driver.findElement(By.name("uid")).getText());
		assertEquals("",driver.findElement(By.name("password")).getText());
		driver.quit();
	}
	
	@Test
	
	public void addnewCustomerTest() {
		loginWithSuccess();
		
		driver.findElement(By.xpath("//a[normalize-space()='New Customer']")).click();
		assertEquals("https://www.demo.guru99.com/V4/manager/addcustomerpage.php", driver.getCurrentUrl());
		driver.quit();
	}
	@Test
	public void EditCustomerTest() {
		
		loginWithSuccess();
		
		driver.findElement(By.xpath("//a[normalize-space()='Edit Customer']")).click();
		assertEquals("https://www.demo.guru99.com/V4/manager/EditCustomer.php", driver.getCurrentUrl());
		driver.quit();
	
		
	}
	
	@Test
	public void deleteCustomerTest() {
		loginWithSuccess();
		driver.findElement(By.xpath("//a[normalize-space()='Delete Customer']")).click();
		assertTrue( driver.getCurrentUrl().contains("DeleteCustomerInput"));
		driver.quit();
		
	}
	
	@Test
	public void logOutTest() {
		loginWithSuccess();
		driver.findElement(By.xpath("//a[normalize-space()='Log out']")).click();
		
		driver.quit();
		
	}
	
	
	private static void login(String username, String password) {
		driver.findElement(By.name("uid")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
	}

}
