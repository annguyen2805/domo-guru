package commonKeyword



import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import org.openqa.selenium.WebElement
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import internal.GlobalVariable
import pageUI.CommonPageUI

public class Common_Funtion {

	public getDynamicTestObject(String xpathValue,String... values){
		String xpath = String.format(xpathValue, values)
		TestObject to = new TestObject("objectName")
		return to.addProperty("xpath", ConditionType.EQUALS, xpath)
	}
	public senkeyToTestObject(TestObject to,String value){
		WebUiBuiltInKeywords.waitForElementVisible(to, GlobalVariable.timeOut)
		WebUiBuiltInKeywords.clearText(to)
		WebUiBuiltInKeywords.sendKeys(to, value)
	}
	@Keyword
	public void highlightElement(TestObject to) {
		WebElement element = WebUiCommonHelper.findWebElement(to,30)
		String originalStyle = element.getAttribute("style");
		WebUI.executeJavaScript("arguments[0].setAttribute(arguments[1], arguments[2])", Arrays.asList(element), "style", "border: 5px solid red; border-style: dashed;");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		WebUI.executeJavaScript("arguments[0].setAttribute(arguments[1], arguments[2])", Arrays.asList(element), "style", originalStyle);
	}


	@Keyword
	public verifyDynamicTextHeaderMessage(String messageText){
		TestObject to = getDynamicTestObject(CommonPageUI.DYNAMIC_HEADER_MESSEAGE, messageText)
		WebUiBuiltInKeywords.waitForElementVisible(to, GlobalVariable.timeOut)
		String message= WebUiBuiltInKeywords.getText(to);
		WebUiBuiltInKeywords.verifyElementText(to, message)
	}

	@Keyword
	public String getDynamicTextTable(String rowName){
		TestObject to = getDynamicTestObject(CommonPageUI.DYNAMIC_TABLE, rowName)
		WebUiBuiltInKeywords.waitForElementVisible(to, GlobalVariable.timeOut)
		return WebUiBuiltInKeywords.getText(to);
	}
	@Keyword
	public clickDynamicSubmitButton(String dynamicName){
		TestObject to = getDynamicTestObject(CommonPageUI.DYNAMIC_BUTTON, dynamicName)
		WebUiBuiltInKeywords.waitForElementClickable(to, GlobalVariable.timeOut)
		WebUiBuiltInKeywords.click(to);
	}
	@Keyword
	public sendkeyTexboxDynamic(String dynamicName, String value){
		TestObject to = getDynamicTestObject(CommonPageUI.DYNAMIC_TEXT_BOX, dynamicName)
		senkeyToTestObject(to,value)
	}
	@Keyword
	public clickDynamicPage(String namePage){
		TestObject to = getDynamicTestObject(CommonPageUI.DYNAMIC_PAGE_LOCATOR, namePage)
		WebUiBuiltInKeywords.waitForElementClickable(to, GlobalVariable.timeOut)
		WebUiBuiltInKeywords.click(to);
	}
	@Keyword
	public verifyDynamicTextRowTable(String nameRow, String value ){
		String text=getDynamicTextTable(nameRow)
		WebUiBuiltInKeywords.verifyMatch(text, value, false)
	}
	@Keyword
	public SelectDropDownAccountType(TestObject to, String value ){
		WebUiBuiltInKeywords.waitForElementVisible(to, GlobalVariable.timeOut)
		WebUiBuiltInKeywords.selectOptionByValue(to, value, false)
	}
}
