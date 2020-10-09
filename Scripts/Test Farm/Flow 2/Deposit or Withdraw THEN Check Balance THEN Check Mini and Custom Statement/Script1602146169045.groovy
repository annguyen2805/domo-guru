import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import internal.GlobalVariable as GlobalVariable

CustomKeywords.'common.clickMainOptions'(type)

WebUI.sendKeys(CustomKeywords.'common.inputFieldByName'('accountno'), accountID)

WebUI.sendKeys(CustomKeywords.'common.inputFieldByName'('ammount'), amount)

WebUI.sendKeys(CustomKeywords.'common.inputFieldByName'('desc'), description)

WebUI.click(CustomKeywords.'common.inputFieldByType'('submit'))

String miniType

if (type.toString().equalsIgnoreCase('Deposit')) {
    WebUI.verifyElementVisible(CustomKeywords.'common.messageNoti'('Transaction details of Deposit for Account ' + accountID))

    WebUI.verifyMatch(WebUI.getText(CustomKeywords.'common.outputObject'('Account No')), accountID, false)

    WebUI.verifyMatch(WebUI.getText(CustomKeywords.'common.outputObject'('Amount Credited')), amount, false)

    WebUI.verifyMatch(WebUI.getText(CustomKeywords.'common.outputObject'('Type of Transaction')), type, false)

    WebUI.verifyMatch(WebUI.getText(CustomKeywords.'common.outputObject'('Description')), description, false)

    miniType = 'd'
} else if (type.toString().equalsIgnoreCase('Withdrawal')) {
    WebUI.verifyElementVisible(CustomKeywords.'common.messageNoti'('Transaction details of Withdrawal for Account ' + accountID))

    WebUI.verifyMatch(WebUI.getText(CustomKeywords.'common.outputObject'('Account No')), accountID, false)

    WebUI.verifyMatch(WebUI.getText(CustomKeywords.'common.outputObject'('Amount Debited')), amount, false)

    WebUI.verifyMatch(WebUI.getText(CustomKeywords.'common.outputObject'('Type of Transaction')), type, false)

    WebUI.verifyMatch(WebUI.getText(CustomKeywords.'common.outputObject'('Description')), description, false)

    miniType = 'w'
}

String currentBalance = WebUI.getText(CustomKeywords.'common.outputObject'('Current Balance'))

String transactionID = WebUI.getText(CustomKeywords.'common.outputObject'('Transaction ID'))

//Check balance
WebUI.callTestCase(findTestCase('Test Steps/Balance Enquiry Page/Query Balance'), [('accountID') : accountID, ('expectedBalance') : currentBalance], 
    FailureHandling.STOP_ON_FAILURE)

//Check Mini statement
WebUI.callTestCase(findTestCase('Test Steps/Mini Statement Page/Check Mini Statement After Deposit_Withdraw'), [('accountID') : accountID
        , ('description') : description, ('transactionID') : transactionID, ('amount') : amount, ('miniType') : miniType], 
    FailureHandling.STOP_ON_FAILURE)

//Check Custom Statment
WebUI.callTestCase(findTestCase('Test Steps/Custom Statement Page/Check Custom Statement After Deposit-Withdraw'), 
    [('accountID') : accountID, ('fromDate') : fromDate, ('toDate') : toDate, ('minimumValue') : minimumValue, ('numOfTransaction') : numOfTransaction
        , ('description') : description, ('miniType') : miniType, ('amount') : amount, ('transactionID') : transactionID], 
    FailureHandling.CONTINUE_ON_FAILURE)

