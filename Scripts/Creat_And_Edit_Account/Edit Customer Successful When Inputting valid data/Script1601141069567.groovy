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
import org.openqa.selenium.Keys as Keys

WebUI.callTestCase(findTestCase('Common Test Case/Login Successful'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('EditCustomerPageUI/Page_Guru99 Bank Manager HomePage/a_Edit Customer'))

WebUI.setText(findTestObject('Object Repository/EditCustomerPageUI/Page_Guru99 Bank Edit Customer Page/input_Customer ID_cusid'), 
    '24995')

WebUI.click(findTestObject('Object Repository/EditCustomerPageUI/Page_Guru99 Bank Edit Customer Page/input_Customer ID_AccSubmit'))

WebUI.setText(findTestObject('Object Repository/EditCustomerPageUI/Page_Guru99 Bank Edit Customer Entry Page/textarea_60 Hoang Quoc Viet Cau Giay'), 
    '60 Hoang Quoc Viet Cau Giay')

WebUI.click(findTestObject('Object Repository/EditCustomerPageUI/Page_Guru99 Bank Edit Customer Entry Page/tr_Address60 Hoang Quoc Viet Cau Giay'))

WebUI.setText(findTestObject('Object Repository/EditCustomerPageUI/Page_Guru99 Bank Edit Customer Entry Page/textarea_60 Hoang Quoc Viet Cau Giay'), 
    '60 Hoang Quoc Viet ')

WebUI.setText(findTestObject('Object Repository/EditCustomerPageUI/Page_Guru99 Bank Edit Customer Entry Page/input_City_city'), 
    'CG')

WebUI.setText(findTestObject('Object Repository/EditCustomerPageUI/Page_Guru99 Bank Edit Customer Entry Page/input_State_state'), 
    'HN')

WebUI.setText(findTestObject('Object Repository/EditCustomerPageUI/Page_Guru99 Bank Edit Customer Entry Page/input_Mobile Number_telephoneno'), 
    '0815957401')

WebUI.setText(findTestObject('Object Repository/EditCustomerPageUI/Page_Guru99 Bank Edit Customer Entry Page/input_E-mail_emailid'), 
    'anhnem@gmail.com')

WebUI.click(findTestObject('Object Repository/EditCustomerPageUI/Page_Guru99 Bank Edit Customer Entry Page/input_E-mail_sub'))

