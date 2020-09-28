package commonKeyword

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords

import pageUI.CommonPageUI

public class ClickToDynamicPage {
	@Keyword
	public ClickToDynamicPageLink(String namePage){
		String xpath = String.format(CommonPageUI.DYNAMIC_PAGE_LOCATOR, namePage)
		println xpath
		TestObject to = new TestObject("objectName")
		to.addProperty("xpath", ConditionType.EQUALS, xpath)
		WebUiBuiltInKeywords.waitForElementClickable(to, 10)
		WebUiBuiltInKeywords.click(to);
	}
}
