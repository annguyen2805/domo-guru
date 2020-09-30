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

WebUI.callTestCase(findTestCase('Common Page Action/Login'), [:], FailureHandling.CONTINUE_ON_FAILURE)

WebUI.callTestCase(findTestCase('New Customer Page/Creat New Customer'), [('customName') : 'katalon', ('dateBirth') : '01/01/1999'
        , ('address') : 'ha noi cau giay ho chi minh', ('city') : 'ha noi', ('state') : 'nghia hung', ('pin') : '565422'
        , ('telephone') : '0123456789', ('email') : 'annguyen23728@gmail.com', ('password') : '1111111'], FailureHandling.CONTINUE_ON_FAILURE)

WebUI.callTestCase(findTestCase('Edit Customer/Edit Customer'), [('editCity') : '', ('editState') : '', ('editMobile') : ''], 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.callTestCase(findTestCase('New Account/New Account'), [('accountType') : 'Savings'], FailureHandling.CONTINUE_ON_FAILURE)

WebUI.callTestCase(findTestCase('Edit Account/Edit Account'), [('editAccountType') : 'Current'], FailureHandling.CONTINUE_ON_FAILURE)

WebUI.callTestCase(findTestCase('Deposit/Deposit'), [:], FailureHandling.CONTINUE_ON_FAILURE)

WebUI.callTestCase(findTestCase('Withdrawall/Withdrawall'), [:], FailureHandling.CONTINUE_ON_FAILURE)

WebUI.callTestCase(findTestCase('Fund Tranfer/Fund Tranfer'), [:], FailureHandling.CONTINUE_ON_FAILURE)

