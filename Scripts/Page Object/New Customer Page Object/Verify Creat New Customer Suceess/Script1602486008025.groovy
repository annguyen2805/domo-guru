import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.verifyMatch(WebUI.callTestCase("Test Cases/Page Object/Common Page Object/Get Text Row Table", [('nameRow') : 'Customer Name']), customName, false)

WebUI.verifyMatch(WebUI.callTestCase("Test Cases/Page Object/Common Page Object/Get Text Row Table", [('nameRow') : 'Address']), address, false)

WebUI.verifyMatch(WebUI.callTestCase("Test Cases/Page Object/Common Page Object/Get Text Row Table", [('nameRow') : 'City']), city, false)

WebUI.verifyMatch(WebUI.callTestCase("Test Cases/Page Object/Common Page Object/Get Text Row Table", [('nameRow') : 'State']), state, false)

WebUI.verifyMatch(WebUI.callTestCase("Test Cases/Page Object/Common Page Object/Get Text Row Table", [('nameRow') : 'Pin']), pin, false)

WebUI.verifyMatch(WebUI.callTestCase("Test Cases/Page Object/Common Page Object/Get Text Row Table", [('nameRow') : 'Mobile No.']), mobile, false)

WebUI.verifyMatch(WebUI.callTestCase("Test Cases/Page Object/Common Page Object/Get Text Row Table", [('nameRow') : 'Email']), email, false)

