import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase

import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.callTestCase(findTestCase('Test Steps/Mini Statement Page/Query Mini Statement'), [('accountID') : '86011'], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Test Steps/Common/Verify Not Authorzized'), [:], FailureHandling.STOP_ON_FAILURE)

