import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint

GlobalVariable.email = (('katalon' + randomNumber()) + '@hotmail.com')

WebUI.openBrowser('http://demo.guru99.com/')

WebUI.maximizeWindow()

WebUI.callTestCase(findTestCase('Page Object/Common Page Object/Input Danamic Textbox'), [('value') : GlobalVariable.email, ('atributeValue') : 'emailid'], FailureHandling.CONTINUE_ON_FAILURE)

//CustomKeywords.'commonKeywork.commonFuntion.sendkeyTexboxDynamic'('emailid', GlobalVariable.email)

CustomKeywords.'commonKeywork.commonFuntion.clickDynamicSubmitButton'('btnLogin')

String userID = WebUI.getText(findTestObject('RegisterPageUI/USER_ID'))

String Password = WebUI.getText(findTestObject('RegisterPageUI/PASSWORD'))

WebUI.navigateToUrl('http://demo.guru99.com/v4/')

CustomKeywords.'commonKeywork.commonFuntion.sendkeyTexboxDynamic'('uid', userID)

CustomKeywords.'commonKeywork.commonFuntion.sendkeyTexboxDynamic'('password', Password)

CustomKeywords.'commonKeywork.commonFuntion.clickDynamicSubmitButton'('btnLogin')

protected int randomNumber() {
    Random rand = new Random()

    return rand.nextInt(999999)
}

