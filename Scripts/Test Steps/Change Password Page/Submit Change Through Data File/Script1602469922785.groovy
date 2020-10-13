import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI


if(oldPassword.equals('<blank>'))
{
	oldPassword = ''
}
if(newPassword.equals('<blank>'))
{
	newPassword = ''
}
if(confirmPassword.equals('<blank>'))
{
	confirmPassword = ''
}
CustomKeywords.'common.clickMainOptions'('Change Password')

WebUI.sendKeys(CustomKeywords.'common.inputFieldByName'('oldpassword'), oldPassword)

WebUI.sendKeys(CustomKeywords.'common.inputFieldByName'('newpassword'), newPassword)

WebUI.sendKeys(CustomKeywords.'common.inputFieldByName'('confirmpassword'), confirmPassword)

WebUI.click(CustomKeywords.'common.inputFieldByName'('sub'))





