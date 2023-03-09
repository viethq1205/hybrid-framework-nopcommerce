package commons;

import java.io.File;

public class GlobalConstants { // tại sao đặt là static vì các hằng số này có thể dùng chung/truy cập cho tất cả các class của framework
	public static final String PORTAL_PAGE_URL = "https://demo.nopcommerce.com/"; // Portal là trang của user (nhiều cty gọi như này)

	public static final String ADMIN_PAGE_URL = "https://admin-demo.nopcommerce.com/";

	public static final String PROJECT_PATH = System.getProperty("user.dir");

	public static final String OS_NAME = System.getProperty("os.name");

	// Window/Mac/Linux deu co the lay dc duong dan nay
	public static final String UPLOAD_FILE = PROJECT_PATH + File.separator + "uploadFiles" + File.separator;

	public static final String DOWNLOAD_FILE = PROJECT_PATH + File.separator + "downloadFiles";

	public static final String BROWSER_LOG = PROJECT_PATH + File.separator + "browserLogs";

	public static final String DRAG_DROP_HTML5 = PROJECT_PATH + File.separator + "dragDropHTML5";

	public static final String AUTO_IT = PROJECT_PATH + File.separator + "autoITscript";

	public static final String REPORTNG_SCREENSHOT = PROJECT_PATH + File.separator + "ReportNGImages" + File.separator;

	public static final long SHORT_TIMEOUT = 5;

	public static final long LONG_TIMEOUT = 10;

	public static final long RETRY_TEST_FAIL = 3;

	public static final String EXTENT_PATH = PROJECT_PATH + File.separator;

	public static final String JAVA_VERSION = System.getProperty("java.version");
}
