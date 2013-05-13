/**
 * 
 */
package nl.bitwalker.useragentutils;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author harald
 *
 */
public class UserAgentTest {

	/**
	 * Test method for {@link nl.bitwalker.useragentutils.UserAgent#parseUserAgentString(java.lang.String)}.
	 */
	@Test
	public void testParseUserAgentString() {
		UserAgent userAgent = UserAgent.parseUserAgentString("Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.2; SV1; .NET CLR 1.1.4322; .NET CLR 2.0.50727)");
		assertEquals(OperatingSystem.WINDOWS_XP, userAgent.getOperatingSystem());
		assertEquals(Browser.IE6, userAgent.getBrowser());
	}

	/**
	 * Test method for {@link nl.bitwalker.useragentutils.UserAgent#toString()}.
	 */
	@Test
	public void testToString() {
		UserAgent userAgent = UserAgent.parseUserAgentString("Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.2; SV1; .NET CLR 1.1.4322; .NET CLR 2.0.50727)");
		assertEquals(OperatingSystem.WINDOWS_XP.toString() + "-" + Browser.IE6.toString(), userAgent.toString());
	}

	/**
	 * Test method for {@link nl.bitwalker.useragentutils.UserAgent#valueOf(int)}.
	 */
	@Test
	public void testValueOf() {
		UserAgent userAgent = UserAgent.parseUserAgentString("Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.2; SV1; .NET CLR 1.1.4322; .NET CLR 2.0.50727)");
		UserAgent retrievedUserAgent = UserAgent.valueOf(userAgent.getId());
		assertEquals(userAgent, retrievedUserAgent);
	}

	/**
	 * Test method for {@link nl.bitwalker.useragentutils.UserAgent#valueOf(String)}.
	 */
	@Test
	public void testValueOf2() {
		UserAgent userAgent = UserAgent.parseUserAgentString("Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.2; SV1; .NET CLR 1.1.4322; .NET CLR 2.0.50727)");
		UserAgent retrievedUserAgent = UserAgent.valueOf(userAgent.toString());
		assertEquals(userAgent, retrievedUserAgent);
	}

    @Test
    public void testParseUserAgentStringForChromeIOS() {
        UserAgent userAgent = UserAgent.parseUserAgentString("Mozilla/5.0 (iPad; CPU OS 6_1_3 like Mac OS X) AppleWebKit/536.26 (KHTML, like Gecko) CriOS/26.0.1410.53 Mobile/10B329 Safari/8536.25");
        assertEquals(OperatingSystem.MAC_OS_X_IPAD, userAgent.getOperatingSystem());
        assertEquals(BrowserType.MOBILE_BROWSER, userAgent.getBrowser().getBrowserType());
        assertEquals(Browser.MOBILE_SAFARI, userAgent.getBrowser());
    }

    @Test
    public void testParseUserAgentStringForSamsungAndriod() {
        UserAgent userAgent = UserAgent.parseUserAgentString("Mozilla/5.0 (Linux; U; Android 2.3.6; zh-cn; SCH-I699 Build/GINGERBREAD) AppleWebKit/533.1 (KHTML, like Gecko) Version/4.0 Mobile Safari/533.1");
        assertEquals(BrowserType.MOBILE_BROWSER, userAgent.getBrowser().getBrowserType());
        assertEquals(OperatingSystem.ANDROID2, userAgent.getOperatingSystem());
        assertEquals(Browser.MOBILE_SAFARI, userAgent.getBrowser());
    }

}
