package pageUI

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

public class CommonPageUI {
	public static final String DYNAMIC_TEXT_BOX = "//input[@name='%s']"
	public static final String DYNAMIC_BUTTON = "//input[@name='%s']"
	public static final String DYNAMIC_PAGE_LOCATOR = "//ul[@class='menusubnav']//a[text()='%s']"
	public static final String DYNAMIC_HEADER_MESSEAGE = "//p[@class='heading3' and text()='%s']"
	public static final String DYNAMIC_TABLE="//td[contains(text(),'%s')]//following-sibling::td"

	public static final String DYNAMIC_ERROR_NAME_MESSEAGE="//label[@id='message' and text()='%s']"

	public static final String DYNAMIC_ERROR_ADDRESS_MESSEAGE="//label[@id='message3' and text()='%s']"

	public static final String DYNAMIC_ERROR_CITY_MESSEAGE="//label[@id='message4' and text()='%s']"

	public static final String DYNAMIC_ERROR_STATE_MESSEAGE="//label[@id='message5' and text()='%s']"
	public static final String DYNAMIC_ERROR_PIN_MESSEAGE="//label[@id='message6' and text()='%s']"
	public static final String DYNAMIC_ERROR_MOBILE_MESSEAGE="//label[@id='message7' and text()='%s']"
	public static final String DYNAMIC_ERROR_EMAIL_MESSEAGE="//label[@id='message9' and text()='%s']"
}
