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

String customerID = WebUI.callTestCase(findTestCase('Folder_01_Create_And_Edit_Customer/TC01_Create Customer Successfully'), 
    [('name') : name, ('gender') : gender, ('dOB') : dOB, ('address') : address, ('city') : city, ('state') : state, ('pin') : pin
        , ('phone') : phone, ('mail') : mail, ('pass') : pass], FailureHandling.STOP_ON_FAILURE)

//Create account where list[0] is accountID and list[1] is iniDeposit/balance
List account = WebUI.callTestCase(findTestCase('Folder_02_Create_And_Edit_Account/TC01_1_Create New Account Successfully'), 
    [('customerID') : customerID, ('accountType') : accountType, ('iniDeposit') : iniDeposit], FailureHandling.STOP_ON_FAILURE)

String accountID = account[0]

String currentBalance = account[1]

//Deposit or Withdraw with List[0] is transID and List[1] is Balance
List idAndBalance = WebUI.callTestCase(findTestCase('Folder_03_Deposit_Withdrawal/TC01_Deposit or Withdraw successfully'), 
    [('type') : type, ('accountID') : accountID, ('amount') : amount, ('description') : description], FailureHandling.STOP_ON_FAILURE)

String transactionID = idAndBalance[0]

String expectedBalance = idAndBalance[1]

//Check balance
WebUI.callTestCase(findTestCase('Folder_04_Balance Enquiry/TC01_Check Balance'), [('accountID') : accountID, ('expectedBalance') : expectedBalance], 
    FailureHandling.STOP_ON_FAILURE)

//Check Mini statement after Withdraw
WebUI.callTestCase(findTestCase('Folder_06_Check Mini Statement/TC02_Check Mini Statement After Deposit_Withdraw'), [('accountID') : accountID
        , ('description') : description, ('transactionID') : transactionID, ('amount') : amount, ('type') : type], FailureHandling.STOP_ON_FAILURE)

//Check Custom statement after Withdraw
WebUI.callTestCase(findTestCase('Folder_07_Check Custom Statement/TC02_Check Custom Statement After Deposit-Withdraw'), 
    [('accountID') : accountID, ('fromDate') : fromDate, ('toDate') : toDate, ('minimumValue') : minimumValue, ('numOfTransaction') : numOfTransaction
        , ('description') : description, ('type') : type, ('amount') : amount, ('transactionID') : transactionID], 
    FailureHandling.STOP_ON_FAILURE)

