import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable


WebUI.sendKeys(CustomKeywords.'common.inputFieldByType'('text'), GlobalVariable.username)
WebUI.sendKeys(CustomKeywords.'common.inputFieldByType'('password'), GlobalVariable.password)
WebUI.click(CustomKeywords.'common.inputFieldByType'('submit'))

