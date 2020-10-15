package commonKeywork
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.exception.WebElementNotFoundException
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords

import internal.GlobalVariable
import pageUI.commonPageUI

class commonFuntion {
	@Keyword
	public findTestObjectDynamicTextbox(String nameAtributeValue){
		return findTestObject('Object Repository/Common UI/DYNAMIC TEXT BOX', ['nameAtributeValue': nameAtributeValue])
	}
	@Keyword
	public findTestObjectDynamicPage(String namePage){
		return findTestObject('Object Repository/Common UI/DYNAMIC PAGE LOCATOR', ['namePage': namePage])
	}

	@Keyword
	public findTestObjectDynamicHeaderMessage(String MessageText){
		return findTestObject('Object Repository/Common UI/DYANMIC MESSAGE TEXT HEADER', ['textHeaderDynamic': MessageText])
	}

	@Keyword
	public findTestObjectDataTable(String nameRow){
		return findTestObject('Object Repository/Common UI/TEXT ROW TABLE', ['nameRow': nameRow])
	}

	@Keyword
	public sendkeyTexboxDynamic(String dynamicName, String value){
		TestObject to = getDynamicTestObject(commonPageUI.DYNAMIC_TEXT_BOX, dynamicName)
		senkeyToTestObject(to,value)
	}

	@Keyword
	public clickDynamicSubmitButton(String dynamicName){
		TestObject to = getDynamicTestObject(commonPageUI.DYNAMIC_BUTTON, dynamicName)
		WebUiBuiltInKeywords.waitForElementClickable(to, GlobalVariable.longTimeOut)
		WebUiBuiltInKeywords.click(to);
	}

	@Keyword
	def refreshBrowser() {
		KeywordUtil.logInfo("Refreshing")
		WebDriver webDriver = DriverFactory.getWebDriver()
		webDriver.navigate().refresh()
		KeywordUtil.markPassed("Refresh successfully")
	}
	@Keyword
	def clickElement(TestObject to) {
		try {
			WebElement element = WebUiBuiltInKeywords.findWebElement(to);
			KeywordUtil.logInfo("Clicking element")
			element.click()
			KeywordUtil.markPassed("Element has been clicked")
		} catch (WebElementNotFoundException e) {
			KeywordUtil.markFailed("Element not found")
		} catch (Exception e) {
			KeywordUtil.markFailed("Fail to click on element")
		}
	}

	@Keyword
	def List<WebElement> getHtmlTableRows(TestObject table, String outerTagName) {
		WebElement mailList = WebUiBuiltInKeywords.findWebElement(table)
		List<WebElement> selectedRows = mailList.findElements(By.xpath("./" + outerTagName + "/tr"))
		return selectedRows
	}
	public getDynamicTestObject(String xpathValue,String... values){
		String xpath = String.format(xpathValue, values)
		TestObject to = new TestObject("objectName")
		return to.addProperty("xpath", ConditionType.EQUALS, xpath)
	}
	public senkeyToTestObject(TestObject to,String value){
		WebUiBuiltInKeywords.waitForElementVisible(to, GlobalVariable.longTimeOut)
		WebUiBuiltInKeywords.clearText(to)
		WebUiBuiltInKeywords.sendKeys(to, value)
	}
}