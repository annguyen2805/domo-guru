import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase

import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.testobject.TestObjectXpath
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.callTestCase(findTestCase('Test Steps/Change Password Page/Verify Change Password Successfully'), [('newPassword') : WebUI.callTestCase(
            findTestCase('Test Steps/Change Password Page/Submit Change'), [:], FailureHandling.STOP_ON_FAILURE)], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Test Steps/Common/Login'), [:], FailureHandling.STOP_ON_FAILURE)
