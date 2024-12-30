package com.agile.crm.Utils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.google.common.io.Files;


public class Webutils {
	public ExtentReports extReport;
	public ExtentTest extTest;
	public WebDriver driver;

	
	public ExtentReports  MyExtentReport() {
		ExtentSparkReporter Spark = new ExtentSparkReporter("testcase1.html");

		extReport = new ExtentReports();

		extReport.attachReporter(Spark);
		return extReport;
	}

	public void createExtesntTestReport(String report) {
		extTest = extReport.createTest(report);
		extTest.log(Status.PASS, " test case is successfully pass");

	}

	public void flushMethod() {
		extReport.flush();

	}

	public WebDriver getDriver() {
		return driver;
	}

	public void SetDriver(WebDriver driver) {
		this.driver = driver;
	}
	public void maximizewindow() {
		driver.manage().window().maximize();
	}
	public void minimizewindow() {
		driver.manage().window().maximize();
	}

	public WebDriver launchBrowser(String browserName) {
		if (browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();

		} else if (browserName.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("Safari")) {
			driver = new SafariDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.manage().window().maximize();
		return driver;

	}

	public void Openurl(String urlName) {
		try {
			driver.get(urlName);
			driver.manage().window().maximize();
			//extTest.log(Status.INFO, "url opened successfully");
			System.out.println("open url successfully");
		} catch (Exception e) {
			//extTest.log(Status.FAIL, "Failed to opene URL");
			e.printStackTrace();
		}
		
	}
	public void closeCurrentWindow() {
		driver.close();
		System.out.println("closed");
		//extTest.log(Status.INFO,"Current window closed succesfully");
	}
	public void closeAll() {
		driver.quit();

		extTest.log(Status.INFO,"all window closed succesfully");
	}

	//////////////////////////Send keys/////////////////////////
	public void sendkeysElement(WebElement we,String value,String ElementNmae) {
		try {
			we.sendKeys(value);
			System.out.println(ElementNmae+"taxbox is fillup");
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("element is not send");
		}
	}
	public void JsSendkey(WebElement we,String value,String Name) {
		JavascriptExecutor jss=(JavascriptExecutor) driver;
		jss.executeScript("arguments[0].value='" + value + "';", we);
	}





	////////////////////////click/////////////////
	public void ClickElement(WebElement we,String ElementName) {
		try {
			we.click();
			System.out.println(ElementName+" click function is performed suceesfully");

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("click Elemnet performed suceefully");
		}
	}
	public void jsClick(WebElement we,String ElementName) {
		try {
			JavascriptExecutor js=(JavascriptExecutor) driver;
			js.executeScript("argument[0].click", we);
			extTest.log(Status.INFO,we+ " is clicked successfully by java script");
		} catch (Exception e) {
			e.printStackTrace();
		}
		extTest.log(Status.INFO,we+ " is notj clicked successfully by java script");
	}
	public void allOption(WebElement we ,String elementname) {
		try {
			Select st=	new Select(we);
			List<WebElement> listoptionElements=	st.getOptions();
			for (WebElement element : listoptionElements) {
				System.out.println(element.getText());
			}

		} catch (Exception e) {
			// TODO: handle exception
		}



	}
	public void DropDown(WebElement we,String value,String ElementName) {
		try {
			Select slt= new Select(we);
			slt.selectByValue(value);
			System.out.println("Dropdown perform sucessfully");
		} catch (Exception e) {

			e.printStackTrace();
		}

	}
	public void Verifytext(WebElement we,String Expected) {
		String Actual=we.getText();
		System.out.print(Actual);
		if (Actual.equalsIgnoreCase(Expected)) {
			System.out.println("taxt is matched  sucessfully");

		}else {
			System.out.println("text is misMatched");
		}       
	}
	public void MovingMouseover(WebElement we,String name) {
		try {
			Actions act=		new Actions(driver);
			act.moveToElement(we).build().perform();
			String st=	we.getText();
			System.out.println(st+"  moving mouse actoin is perfomed sucefully");
		} catch (Exception e) {
			// TODO: handle exception
		} 
	}
	public void Mouseover(List<WebElement> listWeb,List<WebElement> listElements, String element) {
		try {
			int count=listWeb.size();
			for (int i = 0; i <= count; i++) {
				WebElement wbElement=	listWeb.get(i); 
				Actions act=	new Actions(driver);
				act.moveToElement(wbElement).build().perform();
				String  actualtax=wbElement.getText();
				System.out.println(actualtax);
// jkvgkgvkg
				System.out.println("******");
				List<WebElement>lweb=driver.findElements(By.xpath("//div[@class='drop_mnu']["+(i+1)+"]//a"));
				int counts=	lweb.size();
				for (int j = 0; j <=counts-1; j++) {
					WebElement stlist=	lweb.get(j);
					String subtax=	stlist.getText();
					System.out.println(subtax);

				}

			}


		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public void Snapshot (String filepath) {
		try {
			TakesScreenshot tss= (TakesScreenshot) driver;
			File fileobj=	tss.getScreenshotAs(OutputType.FILE);
			File Filedestination=new File(filepath);

			Files.copy(fileobj, Filedestination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	


	}
}
