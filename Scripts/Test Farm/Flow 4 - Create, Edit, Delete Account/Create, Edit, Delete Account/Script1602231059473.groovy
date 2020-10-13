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
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable

String customerID = WebUI.callTestCase(findTestCase('Test Farm/Customer Page/Create Customer Successfully'), [('name') : name, ('gender') : gender
        , ('dOB') : dOB, ('address') : address, ('city') : city, ('state') : state, ('pin') : pin, ('phone') : phone, ('mail') : mail
        , ('pass') : pass], FailureHandling.STOP_ON_FAILURE)

List account = WebUI.callTestCase(findTestCase('Test Farm/Account Page/Create Account Successfully'), [('customerID') : customerID, ('accountType') : accountType
        , ('iniDeposit') : iniDeposit], FailureHandling.STOP_ON_FAILURE)
String accountID = account[0]
String currentBalance = account[1]
WebUI.callTestCase(findTestCase('Test Farm/Account Page/Edit Account Sucessfully'), [('accountID') : accountID, ('accountType_edit') : accountType_edit], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Test Farm/Account Page/Delete Account Sucessfully'), [('accountID') : accountID], FailureHandling.STOP_ON_FAILURE)

