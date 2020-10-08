import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import org.bouncycastle.jcajce.provider.asymmetric.util.KeyUtil as KeyUtil
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable

CustomKeywords.'common.clickMainOptions'(type)

WebUI.sendKeys(CustomKeywords.'common.inputFieldByName'('accountno'), accountID)

WebUI.sendKeys(CustomKeywords.'common.inputFieldByName'('ammount'), amount)

WebUI.sendKeys(CustomKeywords.'common.inputFieldByName'('desc'), description)

WebUI.click(CustomKeywords.'common.inputFieldByType'('submit'))

if (type.toString().equalsIgnoreCase('Deposit')) {
    WebUI.verifyElementVisible(CustomKeywords.'common.messageNoti'('Transaction details of Deposit for Account ' + accountID))

    WebUI.verifyMatch(WebUI.getText(CustomKeywords.'common.outputObject'('Account No')), accountID, false)

    WebUI.verifyMatch(WebUI.getText(CustomKeywords.'common.outputObject'('Amount Credited')), amount, false)

    WebUI.verifyMatch(WebUI.getText(CustomKeywords.'common.outputObject'('Type of Transaction')), type, false)

    WebUI.verifyMatch(WebUI.getText(CustomKeywords.'common.outputObject'('Description')), description, false)
} else if (type.toString().equalsIgnoreCase('Withdrawal')) {
    WebUI.verifyElementVisible(CustomKeywords.'common.messageNoti'('Transaction details of Withdrawal for Account ' + accountID))

    WebUI.verifyMatch(WebUI.getText(CustomKeywords.'common.outputObject'('Account No')), accountID, false)

    WebUI.verifyMatch(WebUI.getText(CustomKeywords.'common.outputObject'('Amount Debited')), amount, false)

    WebUI.verifyMatch(WebUI.getText(CustomKeywords.'common.outputObject'('Type of Transaction')), type, false)

    WebUI.verifyMatch(WebUI.getText(CustomKeywords.'common.outputObject'('Description')), description, false)
}

String transactionID = WebUI.getText(CustomKeywords.'common.outputObject'('Transaction ID'))

String currentBalance = WebUI.getText(CustomKeywords.'common.outputObject'('Current Balance'))

ArrayList<String> idAndBalance = new ArrayList<String>()

idAndBalance.add(transactionID)
idAndBalance.add(currentBalance)

return idAndBalance
