import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

CustomKeywords.'common.clickMainOptions'('Change Password')

CustomKeywords.'common.sendKeys'(CustomKeywords.'common.inputFieldByName'('oldpassword'), oldPassword)

CustomKeywords.'common.sendKeys'(CustomKeywords.'common.inputFieldByName'('newpassword'), newPassword)

CustomKeywords.'common.sendKeys'(CustomKeywords.'common.inputFieldByName'('confirmpassword'), confirmPassword)

WebUI.click(CustomKeywords.'common.inputFieldByName'('sub'))





