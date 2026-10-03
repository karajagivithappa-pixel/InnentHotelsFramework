package com.Innent.HotelsTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SampleTest1 {
	@Test
	public void m1() throws Exception {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://innent.com/hotel?locationInput=Bengaluru%2C+Karnataka%2C+India&departure=2026-10-07&return=2026-10-09&rooms%5B0%5D%5Badults%5D=2&rooms%5B0%5D%5Bchildren%5D=0&adult=2&child=0&children=0&room=1");
		/*
		driver.findElement(By.xpath("//li[.='Hotels']")).click();
		
		Actions a=new Actions(driver);
		a.moveToElement(driver.findElement(By.xpath("//div[@class='show-lang']"))).perform();
		
		a.click(driver.findElement(By.cssSelector(".modal-open"))).perform();
		
		a.sendKeys(driver.findElement(By.cssSelector("input[name='email']")),
				"karajagivithappa@gmail.com",Keys.TAB,"Innet@123",Keys.ENTER).perform();
		
		String s=driver.findElement(By.xpath("//span[@class='cur-code']")).getText();
		System.out.println(s);
		*/
		//Thread.sleep(3000);
		driver.findElement(By.cssSelector("#locationClearBtnListing")).click();
		
		//System.out.println(driver.findElement(By.xpath("//div[@class='api-info-row']/a[@target='_blank']")).getText());
		//driver.findElement(By.xpath("//div[@class='api-info-row']/a[@target='_blank']")).click();
		
		
	}
}
