package commonKeyword



import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords

import pageUI.CommonPageUI

public class getDynamicTextHeaderMessage {
	@Keyword
	public verifyDynamicTextHeaderMessage(String messageText){
		String xpath = String.format(CommonPageUI.DYNAMIC_HEADER_MESSEAGE, messageText)
		println xpath
		TestObject to = new TestObject("objectName")
		to.addProperty("xpath", ConditionType.EQUALS, xpath)
		WebUiBuiltInKeywords.waitForElementVisible(to, 20)
		String message= WebUiBuiltInKeywords.getText(to);
		WebUiBuiltInKeywords.verifyElementText(to, message)
	}
	@Keyword
	public String getDynamicTextTable(String rowName){
		String xpath = String.format(CommonPageUI.DYNAMIC_TABLE, rowName)
		println xpath
		TestObject to = new TestObject("objectName")
		to.addProperty("xpath", ConditionType.EQUALS, xpath)
		WebUiBuiltInKeywords.waitForElementVisible(to, 20)
		return WebUiBuiltInKeywords.getText(to);
	}
}
