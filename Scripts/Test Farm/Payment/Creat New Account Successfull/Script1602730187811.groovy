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

// Creat New Customer
WebUI.callTestCase(findTestCase('Page Object/Common Page Object/Login'), [:], FailureHandling.CONTINUE_ON_FAILURE)

emailValue = GlobalVariable.email

WebUI.callTestCase(findTestCase('Page Object/Common Page Object/Click Switch Dynamic Page'), [('namePage') : 'New Customer'], FailureHandling.CONTINUE_ON_FAILURE)

WebUI.callTestCase(findTestCase('Page Object/Common Page Object/Input Danamic Textbox'), [('value') : nameValue, ('atributeValue') : 'name'], FailureHandling.CONTINUE_ON_FAILURE)

WebUI.callTestCase(findTestCase('Page Object/New Customer Page Object/Input To Date Of Birth Textbox'), [('dateOfBirth') : dateOfBirth], FailureHandling.CONTINUE_ON_FAILURE)

WebUI.callTestCase(findTestCase('Page Object/New Customer Page Object/Input To Address Textarea'), [('Value') : addressValue], FailureHandling.CONTINUE_ON_FAILURE)

WebUI.callTestCase(findTestCase('Page Object/Common Page Object/Input Danamic Textbox'), [('value') : cityValue, ('atributeValue') : 'city'], FailureHandling.CONTINUE_ON_FAILURE)

WebUI.callTestCase(findTestCase('Page Object/Common Page Object/Input Danamic Textbox'), [('value') : stateValue, ('atributeValue') : 'state'], FailureHandling.CONTINUE_ON_FAILURE)

WebUI.callTestCase(findTestCase('Page Object/Common Page Object/Input Danamic Textbox'), [('value') : pinValue, ('atributeValue') : 'pinno'], FailureHandling.CONTINUE_ON_FAILURE)

WebUI.callTestCase(findTestCase('Page Object/Common Page Object/Input Danamic Textbox'), [('value') : telephoneValue, ('atributeValue') : 'telephoneno'], FailureHandling.CONTINUE_ON_FAILURE)

WebUI.callTestCase(findTestCase('Page Object/Common Page Object/Input Danamic Textbox'), [('value') : emailValue, ('atributeValue') : 'emailid'], FailureHandling.CONTINUE_ON_FAILURE)

WebUI.callTestCase(findTestCase('Page Object/Common Page Object/Input Danamic Textbox'), [('value') : passValue, ('atributeValue') : 'password'], FailureHandling.CONTINUE_ON_FAILURE)

WebUI.callTestCase(findTestCase('Page Object/New Customer Page Object/Click Submit Button'), [:], FailureHandling.CONTINUE_ON_FAILURE)

WebUI.callTestCase(findTestCase('Page Object/Common Page Object/Verify Message Text Success Dynamic'), [('TextHeader') : TextHeaderNewCustomerSuccess], FailureHandling.CONTINUE_ON_FAILURE)

WebUI.callTestCase(findTestCase('Page Object/New Customer Page Object/Verify Creat New Customer Suceess'), [('customName') : nameValue, ('address') : addressValue, ('city') : cityValue, ('state') : stateValue, ('pin') : pinValue, ('mobile') : telephoneValue, ('email') : emailValue], FailureHandling.CONTINUE_ON_FAILURE)

