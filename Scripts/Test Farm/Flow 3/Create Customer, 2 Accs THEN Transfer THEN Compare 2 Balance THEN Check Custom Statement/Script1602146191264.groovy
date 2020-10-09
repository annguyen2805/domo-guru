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

//create a customer
String customerID = WebUI.callTestCase(findTestCase('Test Steps/Customer Pages/Create Customer'), 
    [('name') : name, ('gender') : gender, ('dOB') : dOB, ('address') : address, ('city') : city, ('state') : state, ('pin') : pin
        , ('phone') : phone, ('mail') : mail, ('pass') : pass], FailureHandling.STOP_ON_FAILURE)

//Create 2 accs
List account1 = WebUI.callTestCase(findTestCase('Test Steps/Account Pages/Create New Account'), 
    [('customerID') : customerID, ('accountType') : accountType, ('iniDeposit') : iniDeposit], FailureHandling.STOP_ON_FAILURE)

List account2 = WebUI.callTestCase(findTestCase('Test Steps/Account Pages/Create New Account'), 
    [('customerID') : customerID, ('accountType') : accountType, ('iniDeposit') : iniDeposit], FailureHandling.STOP_ON_FAILURE)

//list[0]: account ID, list[1]: inideposit
// Fund transfer
WebUI.callTestCase(findTestCase('Test Steps/Fund Transfer Page/Fund Transfer'), [('payerAccount') : account1[
        0], ('payeeAccount') : account2[0], ('amount') : amount, ('description') : description], FailureHandling.STOP_ON_FAILURE)

//Caculate expected balances
String payerExpectedBalance = (Integer.parseInt(account1[1]) - Integer.parseInt(amount)).toString()

String payeeExpectedBalance = (Integer.parseInt(account2[1]) + Integer.parseInt(amount)).toString()

//Check Balances
//Payer
WebUI.callTestCase(findTestCase('Test Steps/Balance Enquiry Page/Query Balance'), [('accountID') : account1[0], ('expectedBalance') : payerExpectedBalance], 
    FailureHandling.CONTINUE_ON_FAILURE)

//Payee
WebUI.callTestCase(findTestCase('Test Steps/Balance Enquiry Page/Query Balance'), [('accountID') : account2[0], ('expectedBalance') : payeeExpectedBalance], 
    FailureHandling.CONTINUE_ON_FAILURE)

//Check Custom Statment
WebUI.callTestCase(findTestCase('Test Steps/Custom Statement Page/Check Custom Statement After Transfer'), [('accountID') : account1[0]
        , ('fromDate') : fromDate, ('toDate') : toDate, ('minimumValue') : minimumValue, ('numOfTransaction') : numOfTransaction
        , ('description') : description, ('payeeAccount') : account2[0], ('amount') : amount], FailureHandling.CONTINUE_ON_FAILURE)

