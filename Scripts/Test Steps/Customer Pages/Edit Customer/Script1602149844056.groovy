import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import org.openqa.selenium.Alert as Alert
import org.openqa.selenium.NoAlertPresentException as NoAlertPresentException
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.exception.WebElementNotFoundException as WebElementNotFoundException
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable


CustomKeywords.'common.sendKeys'(CustomKeywords.'common.textAreaByName'('addr'), address_edit)

CustomKeywords.'common.sendKeys'(CustomKeywords.'common.inputFieldByName'('city'), city_edit)

CustomKeywords.'common.sendKeys'(CustomKeywords.'common.inputFieldByName'('state'), state_edit)

CustomKeywords.'common.sendKeys'(CustomKeywords.'common.inputFieldByName'('pinno'), pin_edit)

CustomKeywords.'common.sendKeys'(CustomKeywords.'common.inputFieldByName'('telephoneno'), phone_edit)

CustomKeywords.'common.sendKeys'(CustomKeywords.'common.inputFieldByName'('emailid'), mail_edit)

WebUI.click(CustomKeywords.'common.inputFieldByType'('submit'))

