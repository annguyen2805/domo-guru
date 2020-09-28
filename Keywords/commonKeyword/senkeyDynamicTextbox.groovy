package commonKeyword

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords

import pageUI.CommonPageUI

public class senkeyDynamicTextbox {

	@Keyword
	public sendkeyTexboxDynamic(String dynamicName, String value){
		String xpath = String.format(CommonPageUI.DYNAMIC_TEXT_BOX, dynamicName)
		println xpath
		TestObject to = new TestObject("objectName")
		to.addProperty("xpath", ConditionType.EQUALS, xpath)
		WebUiBuiltInKeywords.waitForElementVisible(to, 10)
		WebUiBuiltInKeywords.clearText(to)
		WebUiBuiltInKeywords.waitForElementVisible(to, 10)
		WebUiBuiltInKeywords.sendKeys(to, value)
	}
}