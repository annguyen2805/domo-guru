import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase

import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI


List account1 = WebUI.callTestCase(findTestCase('Test Farm/New Account/Create Account Successfully'), [('customerID') : customerID, ('accountType') : accountType
	, ('iniDeposit') : iniDeposit], FailureHandling.STOP_ON_FAILURE)

List account2 = WebUI.callTestCase(findTestCase('Test Farm/New Account/Create Account Successfully'), [('customerID') : customerID, ('accountType') : accountType
	, ('iniDeposit') : iniDeposit], FailureHandling.STOP_ON_FAILURE)

String payerAccount = account1[0]

String payerBalance = account1[1]

String payeeAccount = account2[0]

String payeeBalance = account2[1]

WebUI.callTestCase(findTestCase('Test Farm/Fund Transfer Page/Fund Transfer Successfully'), [('payerAccount') : payerAccount
        , ('payeeAccount') : payeeAccount, ('amount') : amount, ('description') : description], FailureHandling.STOP_ON_FAILURE)

String payerExpectedBalance = (Integer.parseInt(payerBalance) - Integer.parseInt(amount)).toString()

String payeeExpectedBalance = (Integer.parseInt(payeeBalance) + Integer.parseInt(amount)).toString()

WebUI.callTestCase(findTestCase('Test Farm/Balane Enquiry Page/Verify Balance'), [('accountID') : payerAccount, ('expectedBalance') : payerExpectedBalance], 
    FailureHandling.CONTINUE_ON_FAILURE)

WebUI.callTestCase(findTestCase('Test Farm/Balane Enquiry Page/Verify Balance'), [('accountID') : payeeAccount, ('expectedBalance') : payeeExpectedBalance], 
    FailureHandling.CONTINUE_ON_FAILURE)



