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

String customerID = WebUI.callTestCase(findTestCase('Test Farm/Customer Page/Create Customer Successfully'), [('name') : name
        , ('gender') : gender, ('dOB') : dOB, ('address') : address, ('city') : city, ('state') : state, ('pin') : pin, ('phone') : phone
        , ('mail') : mail, ('pass') : pass], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Test Farm/Customer Page/Edit Customer Successfully'), [('customerID') : customerID, ('address_edit') : address_edit
        , ('city_edit') : city_edit, ('state_edit') : state_edit, ('pin_edit') : pin_edit, ('phone_edit') : phone_edit, ('mail_edit') : mail_edit], 
    FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Test Farm/Customer Page/Delete Customer Sucessfully'), [('customerID') : customerID], FailureHandling.STOP_ON_FAILURE)

