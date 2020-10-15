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

WebUI.callTestCase(findTestCase('Test Steps/New Cusomter/Create Customer'), [('name') : name, ('gender') : gender, ('dOB') : dOB, ('address') : address
        , ('city') : city, ('state') : state, ('pin') : pin, ('phone') : phone, ('mail') : mail, ('pass') : pass], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Test Steps/New Cusomter/Verify Create Customer Successfully'), [('name') : name, ('gender') : gender
        , ('dOB') : dOB, ('address') : address, ('city') : city, ('state') : state, ('pin') : pin, ('phone') : phone, ('mail') : mail], 
    FailureHandling.STOP_ON_FAILURE)

int customerID = Integer.parseInt(WebUI.getText(CustomKeywords.'common.outputObject'('Customer ID')))

println(customerID)

return customerID.toString()