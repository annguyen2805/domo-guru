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

WebUI.callTestCase(findTestCase('Test Steps/Deposit and Withdrawal Pages/Deposit or Withdraw'), [('type') : type, ('accountID') : accountID
        , ('amount') : amount, ('description') : description], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Test Steps/Deposit and Withdrawal Pages/Verify Successful Deposit or Withdrawal'), [('accountID') : accountID
        , ('amount') : amount, ('type') : type, ('description') : description], FailureHandling.CONTINUE_ON_FAILURE)

String transactionID = WebUI.getText(CustomKeywords.'common.outputObject'('Transaction ID'))

String currentBalance = WebUI.getText(CustomKeywords.'common.outputObject'('Current Balance'))

ArrayList<String> idAndBalance = new ArrayList<String>()

idAndBalance.add(transactionID)

idAndBalance.add(currentBalance)

return idAndBalance