import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject

import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.remote.DesiredCapabilities
import com.kms.katalon.core.annotation.BeforeTestCase
import com.kms.katalon.core.annotation.BeforeTestSuite
import com.kms.katalon.core.annotation.AfterTestCase
import com.kms.katalon.core.annotation.AfterTestSuite
import com.kms.katalon.core.context.TestCaseContext
import com.kms.katalon.core.context.TestSuiteContext
import com.kms.katalon.core.webui.driver.DriverFactory

class NewTestListener {
	/**
	 * Executes before every test case starts.
	 * @param testCaseContext related information of the executed test case.
	 */
	
	
	@BeforeTestSuite
	def setUp() {
		//WebUI.openBrowser("")
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe")
		ChromeOptions options = new ChromeOptions()
		options.addArguments("start-maximized")
		options.addExtensions(new File("C:\\Users\\lqduy\\Downloads\\extension_4_22_0_0.crx"))
		DesiredCapabilities capa = new DesiredCapabilities()
		capa.setCapability(ChromeOptions.CAPABILITY, options)
		WebDriver driver = new ChromeDriver(capa)
		//DriverFactory.closeWebDriver()
		DriverFactory.changeWebDriver(driver)
		WebUI.closeWindowIndex(1)
		WebUI.switchToWindowIndex(0, FailureHandling.STOP_ON_FAILURE)
		WebUI.delay(5)
		
		WebUI.navigateToUrl(GlobalVariable.url)
	}

	@AfterTestSuite
	def tearDown()
	{
		WebUI.closeBrowser()
	}
	
}