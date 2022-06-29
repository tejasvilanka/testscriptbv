package betvictor;

import org.openqa.selenium.By;

public class Constants {
	
	//exercise one
	
	public static final By privacypolicy = By.id("popupPPC");
	public static final By iagree = By.xpath("//a[@class='iAgreeButton']");
	public static final By animalfield = By.id("isc_2L");
	public static final By slidebar = By.id("isc_2D");
	public static final By slidebargettext = By.id("isc_5D");
	public static final By sortfield = By.xpath("//*[@id='isc_3C']");
	public static final By lifespan = By.xpath("//td[@class='pickListCell']//div[text()='Life Span']");
	public static final By ascendingcheckbox = By.id("isc_3J");
	public static final By filterbutton = By.xpath("//td[@class='button' and text() ='Filter']");
	public static final By countoffilter = By.xpath("//table[@class='normal']");
	
	//exercisetwo
	public static final By itemdropdown = By.xpath("//table[@id='isc_2A']");
	public static final By itemheader = By.xpath("//table[@class='headerButtonTable']//div[contains(text(), 'Item')]");
	public static final By scrollbar = By.xpath("(//div[@class='vScrollThumb']/table/tbody/tr/td)[2]");
	public static final By itemexercise = By.xpath("//div[contains(text(),'Exercise')]");
	public static final By units = By.xpath("//div[contains(text(),'Exercise')]//following::div[1]");
	public static final By unitprice = By.xpath("//div[contains(text(),'Exercise')]//following::div[2]");

	
	public static final By itemcorrection = By.xpath("//div[contains(text(),'Correction')]");
	public static final By itemcorrectionexpansion = By.xpath("//div[contains(text(),'Correction')]/preceding::div[1]");
	public static final By decriptionfield = By.xpath("//table[@class='listTable']/tbody/tr/td[3]");
	public static final By savebutton = By.xpath("//td[@class='button']//div[text()='Save']");
	public static final By closebutton = By.xpath("//td[@class='button']//div[text()='Close']");

}
