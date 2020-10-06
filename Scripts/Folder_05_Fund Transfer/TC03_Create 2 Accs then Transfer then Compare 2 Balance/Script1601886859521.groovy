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
//Create 2 accs
List account1 = WebUI.callTestCase(findTestCase('Folder_02_Create_And_Edit_Account/TC01_1_Create New Account Successfully'), 
    [('customerID') : customerID, ('accountType') : accountType, ('iniDeposit') : iniDeposit], FailureHandling.STOP_ON_FAILURE)

List account2 = WebUI.callTestCase(findTestCase('Folder_02_Create_And_Edit_Account/TC01_1_Create New Account Successfully'), 
    [('customerID') : customerID, ('accountType') : accountType, ('iniDeposit') : iniDeposit], FailureHandling.STOP_ON_FAILURE)
//list[0]: account ID, list[1]: inideposit
// Fund transfer
WebUI.callTestCase(findTestCase('Folder_05_Fund Transfer/TC01_Fund Transfer Successfully'), [('payerAccount') : account1[0]
        , ('payeeAccount') : account2[0], ('amount') : amount, ('description') : description], FailureHandling.STOP_ON_FAILURE)


String payerExpectedBalance = (Integer.parseInt(account1[1]) - Integer.parseInt(amount)).toString()
println payerExpectedBalance

String payeeExpectedBalance = (Integer.parseInt(account2[1]) + Integer.parseInt(amount)).toString()
println payeeExpectedBalance

//Check Balances
WebUI.callTestCase(findTestCase('Folder_04_Balance Enquiry/TC01_Check Balance'), [('accountID') : account1[0], ('expectedBalance') : payerExpectedBalance], 
    FailureHandling.CONTINUE_ON_FAILURE)


WebUI.callTestCase(findTestCase('Folder_04_Balance Enquiry/TC01_Check Balance'), [('accountID') : account2[0], ('expectedBalance') : payeeExpectedBalance], 
    FailureHandling.CONTINUE_ON_FAILURE)

