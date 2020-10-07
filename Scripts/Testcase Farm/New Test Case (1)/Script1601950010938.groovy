import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.openBrowser('http://demo.guru99.com/v4/')

WebUI.maximizeWindow()

WebUI.waitForElementVisible(findTestObject('RegisterPageUI/tesshightline'), 10)

CustomKeywords.'commonKeyword.Common_Funtion.highlightElement'(findTestObject('RegisterPageUI/tesshightline'))

