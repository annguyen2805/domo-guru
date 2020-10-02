package commonKeyword

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.TestObject
import internal.GlobalVariable
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords

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
}
