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

String emailvalue = ('katalon' + randomNumber()) + '@hotmail.com'
CustomKeywords.'commonKeyword.Common_Funtion.clickDynamicPage'('New Customer')

CustomKeywords.'commonKeyword.Common_Funtion.sendkeyTexboxDynamic'('name', customName)

CustomKeywords.'commonKeyword.New_Customer_PageObject.inputToDateOfBirthField'(findTestObject('NewCustomerPageUI/DATE_BIRTH_TEXTBOX'), 
    dateBirth)

CustomKeywords.'commonKeyword.New_Customer_PageObject.inputToAddressField'(findTestObject('NewCustomerPageUI/ADDRESS_TEXTAREA'), 
    address)

CustomKeywords.'commonKeyword.Common_Funtion.sendkeyTexboxDynamic'('city', city)

CustomKeywords.'commonKeyword.Common_Funtion.sendkeyTexboxDynamic'('state', state)

CustomKeywords.'commonKeyword.Common_Funtion.sendkeyTexboxDynamic'('pinno', pin)

CustomKeywords.'commonKeyword.Common_Funtion.sendkeyTexboxDynamic'('telephoneno', telephone)

CustomKeywords.'commonKeyword.Common_Funtion.sendkeyTexboxDynamic'('emailid', emailvalue)

CustomKeywords.'commonKeyword.Common_Funtion.sendkeyTexboxDynamic'('password', password)

CustomKeywords.'commonKeyword.Common_Funtion.clickDynamicSubmitButton'('sub')

CustomKeywords.'commonKeyword.Common_Funtion.verifyDynamicTextHeaderMessage'('Customer Registered Successfully!!!')

GlobalVariable.customerID = CustomKeywords.'commonKeyword.Common_Funtion.getDynamicTextTable'('Customer ID')

println(GlobalVariable.customerID)

protected int randomNumber() {
	Random rand = new Random()

	return rand.nextInt(999999)
}

