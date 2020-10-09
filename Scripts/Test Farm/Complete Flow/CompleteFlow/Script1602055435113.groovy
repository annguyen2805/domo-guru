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

'create a customer'
String customerID = WebUI.callTestCase(findTestCase('Test Farm/Customer Page/Create Customer Successfully'), [('name') : name
        , ('gender') : gender, ('dOB') : dOB, ('address') : address, ('city') : city, ('state') : state, ('pin') : pin, ('phone') : phone
        , ('mail') : mail, ('pass') : pass], FailureHandling.STOP_ON_FAILURE)

'Create 2 accs in which list[0]: account ID, list[1]: inideposit'
List account1 = WebUI.callTestCase(findTestCase('Test Farm/Account Page/Create Account Successfully'), [('customerID') : customerID
        , ('accountType') : accountType, ('iniDeposit') : iniDeposit], FailureHandling.STOP_ON_FAILURE)

List account2 = WebUI.callTestCase(findTestCase('Test Farm/Account Page/Create Account Successfully'), [('customerID') : customerID
        , ('accountType') : accountType, ('iniDeposit') : iniDeposit], FailureHandling.STOP_ON_FAILURE)

String payerAccount = account1[0]

String payerBalance = account1[1]

String payeeAccount = account2[0]

String payeeBalance = account2[1]

'Fund transfer'
WebUI.callTestCase(findTestCase('Test Farm/Fund Transfer Page/Fund Transfer Successfully'), [('payerAccount') : payerAccount
        , ('payeeAccount') : payeeAccount, ('amount') : amount, ('description') : description], FailureHandling.STOP_ON_FAILURE)

'Caculate expected balances after transfer'
String payerExpectedBalance = (Integer.parseInt(payerBalance) - Integer.parseInt(amount)).toString()

String payeeExpectedBalance = (Integer.parseInt(payeeBalance) + Integer.parseInt(amount)).toString()

'Check Payer Balance after transfer'
WebUI.callTestCase(findTestCase('Test Farm/Balane Enquiry Page/Check Balance'), [('accountID') : payerAccount, ('expectedBalance') : payerExpectedBalance], 
    FailureHandling.CONTINUE_ON_FAILURE)

'Check Payee Balance after transfer'
WebUI.callTestCase(findTestCase('Test Farm/Balane Enquiry Page/Check Balance'), [('accountID') : payeeAccount, ('expectedBalance') : payeeExpectedBalance], 
    FailureHandling.CONTINUE_ON_FAILURE)

'Check Custom Statment After transfer'
WebUI.callTestCase(findTestCase('Test Farm/Cusomised Statement Page/Check Custom Statement After Transfer'), [('accountID') : payerAccount
        , ('fromDate') : fromDate, ('toDate') : toDate, ('minimumValue') : minimumValue, ('numOfTransaction') : numOfTransaction
        , ('description') : description, ('payeeAccount') : payeeAccount, ('amount') : amount], FailureHandling.STOP_ON_FAILURE)

'Deposit or Withdraw that returns idAndBalance list which list[0] is transactionID, list[1] is expectedBalance'
List idAndBalance = WebUI.callTestCase(findTestCase('Test Farm/Deposit - Withdraw Page/Deposit - Withdraw Successfully'), 
    [('type') : type, ('accountID') : payerAccount, ('amount') : amount, ('description') : description], FailureHandling.STOP_ON_FAILURE)

String transactionID = idAndBalance[0]

String expectedBalance = idAndBalance[1]

'Check balance after deposit or withdraw'
WebUI.callTestCase(findTestCase('Test Farm/Balane Enquiry Page/Check Balance'), [('accountID') : payerAccount, ('expectedBalance') : expectedBalance], 
    FailureHandling.CONTINUE_ON_FAILURE)

'Check Mini Statement After Deposit/Withdraw'
WebUI.callTestCase(findTestCase('Test Farm/Mini Statement Page/Check Mini Statment after Deposit - Withdraw'), [('accountID') : payerAccount
        , ('description') : description, ('transactionID') : transactionID, ('amount') : amount, ('type') : type], FailureHandling.CONTINUE_ON_FAILURE)

'Delete Payer Account'
WebUI.callTestCase(findTestCase('Test Farm/Account Page/Delete Account Sucessfully'), [('accountID') : payerAccount], FailureHandling.STOP_ON_FAILURE)

'Delete Payee Account'
WebUI.callTestCase(findTestCase('Test Farm/Account Page/Delete Account Sucessfully'), [('accountID') : payeeAccount], FailureHandling.STOP_ON_FAILURE)

'Delete Customer'
WebUI.callTestCase(findTestCase('Test Farm/Customer Page/Delete Customer Sucessfully'), [('customerID') : customerID], FailureHandling.STOP_ON_FAILURE)

