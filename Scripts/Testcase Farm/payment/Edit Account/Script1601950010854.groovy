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
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable

CustomKeywords.'commonKeyword.Common_Funtion.clickDynamicPage'('Edit Account')

CustomKeywords.'commonKeyword.Common_Funtion.sendkeyTexboxDynamic'('accountno', GlobalVariable.FirstAccountID)

CustomKeywords.'commonKeyword.Common_Funtion.clickDynamicSubmitButton'('AccSubmit')

CustomKeywords.'commonKeyword.Common_Funtion.SelectDropDownAccountType'(findTestObject('Edit Account PageUI/TYPE_OF_ACCOUNT_LOCATOR'), 
    editAccountType)

CustomKeywords.'commonKeyword.Common_Funtion.clickDynamicSubmitButton'('AccSubmit')

CustomKeywords.'commonKeyword.Common_Funtion.verifyDynamicTextHeaderMessage'('Account details updated Successfully!!!')

CustomKeywords.'commonKeyword.Common_Funtion.verifyDynamicTextRowTable'('Account Type', editAccountType)

