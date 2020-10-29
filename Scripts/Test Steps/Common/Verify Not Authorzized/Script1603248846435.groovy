import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

if(WebUI.getAlertText().startsWith('You are not authorize to'))
{
	KeywordUtil.markPassed("Alert Verified")
}