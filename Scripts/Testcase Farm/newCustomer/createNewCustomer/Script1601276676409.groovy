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

WebUI.callTestCase(findTestCase('Common/Common Page Action/Login'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Common/New Customer Page/Creat New Customer'), [('customName') : findTestData(null).getValue(2, 2)
        , ('dateBirth') : findTestData('dataNewCustomer').getValue(3, 2), ('address') : findTestData(null).getValue(4, 2)
        , ('city') : findTestData('dataNewCustomer').getValue(5, 2), ('state') : findTestData(null).getValue(1, 1), ('pin') : findTestData(null).getValue(1, 1)
        , ('telephone') : findTestData(null).getValue(1, 1), ('email') : findTestData(null).getValue(1, 1), ('password') : findTestData(null).getValue(1, 1)], 
    FailureHandling.STOP_ON_FAILURE)

