import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import internal.GlobalVariable as GlobalVariable

List account1 = WebUI.callTestCase(findTestCase('Test Farm/Account Page/Create Account Successfully'), [('customerID') : customerID, ('accountType') : accountType
        , ('iniDeposit') : iniDeposit], FailureHandling.STOP_ON_FAILURE)

List account2 = WebUI.callTestCase(findTestCase('Test Farm/Account Page/Create Account Successfully'), [('customerID') : customerID, ('accountType') : accountType
        , ('iniDeposit') : iniDeposit], FailureHandling.STOP_ON_FAILURE)

String payerAccount = account1[0]

String payerBalance = account1[1]

String payeeAccount = account2[0]

String payeeBalance = account2[1]

WebUI.callTestCase(findTestCase('Test Farm/Fund Transfer Page/Fund Transfer Successfully'), [('payerAccount') : payerAccount
        , ('payeeAccount') : payeeAccount, ('amount') : amount, ('description') : description], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Test Farm/Customised Statement Page/Check Custom Statement After Transfer'), [('accountID') : payerAccount
        , ('fromDate') : fromDate, ('toDate') : toDate, ('minimumValue') : minimumValue, ('numOfTransaction') : numOfTransaction
        , ('description') : description, ('payeeAccount') : payeeAccount, ('amount') : amount], FailureHandling.STOP_ON_FAILURE)

