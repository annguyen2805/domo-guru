package commonKeyword

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords

import internal.GlobalVariable
import pageUI.CommonPageUI

public class New_Customer_PageObject extends Common_Funtion {

	@Keyword
	public inputToDateOfBirthField(TestObject to, String value){
		WebUiBuiltInKeywords.waitForElementVisible(to, GlobalVariable.timeOut)
		to = WebUiBuiltInKeywords.removeObjectProperty(to, 'type')
		senkeyToTestObject(to, value)
	}
	@Keyword
	public inputToAddressField(TestObject to,String value){
		senkeyToTestObject(to, value)
	}

	@Keyword
	public verifyDynamicNameErrorMessage(String messageText){
		TestObject to = getDynamicTestObject(CommonPageUI.DYNAMIC_ERROR_NAME_MESSEAGE, messageText)
		WebUiBuiltInKeywords.waitForElementVisible(to, GlobalVariable.timeOut)

		WebUI.verifyElementText(to, messageText, FailureHandling.CONTINUE_ON_FAILURE)
	}

	@Keyword
	public verifyDynamicAddreesErrorMessage(String messageText){
		TestObject to = getDynamicTestObject(CommonPageUI.DYNAMIC_ERROR_ADDRESS_MESSEAGE, messageText)
		WebUiBuiltInKeywords.waitForElementVisible(to, GlobalVariable.timeOut)
		WebUI.verifyElementText(to, messageText, FailureHandling.CONTINUE_ON_FAILURE)
	}

	@Keyword
	public verifyDynamicCityErrorMessage(String messageText){
		TestObject to = getDynamicTestObject(CommonPageUI.DYNAMIC_ERROR_CITY_MESSEAGE, messageText)
		WebUiBuiltInKeywords.waitForElementVisible(to, GlobalVariable.timeOut)
		WebUI.verifyElementText(to, messageText, FailureHandling.CONTINUE_ON_FAILURE)
	}

	@Keyword
	public verifyDynamicStateErrorMessage(String messageText){
		TestObject to = getDynamicTestObject(CommonPageUI.DYNAMIC_ERROR_STATE_MESSEAGE, messageText)
		WebUiBuiltInKeywords.waitForElementVisible(to, GlobalVariable.timeOut)
		WebUI.verifyElementText(to, messageText, FailureHandling.CONTINUE_ON_FAILURE)
	}

	@Keyword
	public verifyDynamicPINErrorMessage(String messageText){
		TestObject to = getDynamicTestObject(CommonPageUI.DYNAMIC_ERROR_PIN_MESSEAGE, messageText)
		WebUiBuiltInKeywords.waitForElementVisible(to, GlobalVariable.timeOut)
		WebUI.verifyElementText(to, messageText, FailureHandling.CONTINUE_ON_FAILURE)
	}

	@Keyword
	public verifyDynamicMobileErrorMessage(String messageText){
		TestObject to = getDynamicTestObject(CommonPageUI.DYNAMIC_ERROR_MOBILE_MESSEAGE, messageText)
		WebUiBuiltInKeywords.waitForElementVisible(to, GlobalVariable.timeOut)
		WebUI.verifyElementText(to, messageText, FailureHandling.CONTINUE_ON_FAILURE)
	}

	@Keyword
	public verifyDynamicEmailErrorMessage(String messageText){
		TestObject to = getDynamicTestObject(CommonPageUI.DYNAMIC_ERROR_EMAIL_MESSEAGE, messageText)
		WebUiBuiltInKeywords.waitForElementVisible(to, GlobalVariable.timeOut)
		WebUI.verifyElementText(to, messageText, FailureHandling.CONTINUE_ON_FAILURE)
	}
}
