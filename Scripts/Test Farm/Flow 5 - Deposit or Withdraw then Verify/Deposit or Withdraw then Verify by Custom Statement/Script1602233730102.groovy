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

List idAndBalance = WebUI.callTestCase(findTestCase('Test Farm/Deposit - Withdraw Page/Deposit - Withdraw Successfully'), [('type') : type, ('accountID') : accountID
        , ('amount') : amount, ('description') : description], FailureHandling.STOP_ON_FAILURE)

String transactionID = idAndBalance[0]

WebUI.callTestCase(findTestCase('Test Farm/Customised Statement Page/Check Custom Statement After Deposit-Withdraw'), [('accountID') : accountID
        , ('fromDate') : fromDate, ('toDate') : toDate, ('minimumValue') : minimumValue, ('numOfTransaction') : numOfTransaction
        , ('description') : description, ('type') : type, ('amount') : amount, ('transactionID') : transactionID], FailureHandling.STOP_ON_FAILURE)

