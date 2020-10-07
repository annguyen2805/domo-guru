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

WebUI.callTestCase(findTestCase('Testcase Farm/payment/Login'), [:], FailureHandling.CONTINUE_ON_FAILURE)

WebUI.callTestCase(findTestCase('Testcase Farm/payment/Creat New Customer'), [('customName') : customName, ('dateBirth') : dateBirth, ('address') : address, ('city') : city, ('state') : state, ('pin') : pin, ('telephone') : telephone, ('email') : email, ('password') : password], FailureHandling.CONTINUE_ON_FAILURE)

WebUI.callTestCase(findTestCase('Testcase Farm/payment/Edit Customer'), [('editCity') : editCity, ('editState') : editState, ('editMobile') : editMobile], FailureHandling.CONTINUE_ON_FAILURE)

WebUI.callTestCase(findTestCase('Testcase Farm/payment/New Account'), [('accountType') : accountType], FailureHandling.CONTINUE_ON_FAILURE)

WebUI.callTestCase(findTestCase('Testcase Farm/payment/Edit Account'), [('editAccountType') : editAccountType], FailureHandling.CONTINUE_ON_FAILURE)

WebUI.callTestCase(findTestCase('Testcase Farm/payment/Deposit'), [:], FailureHandling.CONTINUE_ON_FAILURE)

WebUI.callTestCase(findTestCase('Testcase Farm/payment/Fund Tranfer'), [:], FailureHandling.CONTINUE_ON_FAILURE)

WebUI.callTestCase(findTestCase('Testcase Farm/payment/Withdrawall'), [:], FailureHandling.CONTINUE_ON_FAILURE)

