import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable


CustomKeywords.'common.sendKeys'(CustomKeywords.'common.inputFieldByType'('text'), GlobalVariable.username)
CustomKeywords.'common.sendKeys'(CustomKeywords.'common.inputFieldByType'('password'), GlobalVariable.password)
WebUI.click(CustomKeywords.'common.inputFieldByType'('submit'))

