import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import com.kms.katalon.core.webui.driver.WebUIDriverType as WebUIDriverType
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import net.sf.jasperreports.web.util.WebUtil as WebUtil

CustomKeywords.'common.clickMainOptions'('Change Password')

WebUI.sendKeys(CustomKeywords.'common.inputFieldByName'('oldpassword'), GlobalVariable.password)

String newPassword = CustomKeywords.'common.randomPassword'()

WebUI.sendKeys(CustomKeywords.'common.inputFieldByName'('newpassword'), newPassword)

WebUI.sendKeys(CustomKeywords.'common.inputFieldByName'('confirmpassword'), newPassword)

WebUI.click(CustomKeywords.'common.inputFieldByName'('sub'))

WebUI.verifyMatch(WebUI.getAlertText().toLowerCase(), 'password is changed', false)

println(newPassword)

CustomKeywords.'common.updatePassword'(newPassword)

GlobalVariable.password = newPassword

WebUI.acceptAlert()