package com.wordpress.admin;

import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.wordpress.AdminDashboardPO;
import pageObject.wordpress.AdminLoginPO;
import pageObject.wordpress.AdminPostAddNewPO;
import pageObject.wordpress.AdminPostSearchPO;
import pageObject.wordpress.PageGeneratorManager;
import pageObject.wordpress.UserHomePO;
import pageObject.wordpress.UserPostDetailsPO;
import pageObject.wordpress.UserSearchPostsPO;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class Post_01_Create_Post extends BaseTest {

	private WebDriver driver;
	private AdminLoginPO adminLoginPage;
	private AdminDashboardPO adminDashboardPage;
	private AdminPostSearchPO adminPostSearchPage;
	private AdminPostAddNewPO adminPostAddNewPage;
	private UserHomePO userHomePage;
	private UserPostDetailsPO userPostDetailPage;
	private UserSearchPostsPO userSearchPostFeature;
	String adminUserName = "hoangviet";
	String adminPassword = "hoangviet1205";
	String postSearchURL;
	int randomNumber = fakeNumber();
	String titleValue = "Live Coding Title " + randomNumber;
	String bodyValue = "Live Coding Body " + randomNumber;
	String editTitleValue = "Edit Live Coding Title " + randomNumber;
	String editBodyValue = "Edit Live Coding Body " + randomNumber;
	String authorName = "Hoang Viet";
	String adminURL, endUserURL;
	String currentDay = getToday();

	@Parameters({ "browser", "urlAdmin", "urlUser" })
	@BeforeClass
	public void beforeClass(String browserName, String adminURL, String endUserURL) {
		// khi làm thực tế việc viết log như này là việc nên làm để mình theo dõi đc chuẩn các bước sẽ lên script, nắm đc flow của TC
		log.info("Pre-condition - Step 01: Open browser and get admin/user page");
		this.adminURL = adminURL;
		this.endUserURL = endUserURL;
		driver = getMultipleBrowserDriver(browserName, this.adminURL);
		adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);

		log.info("Pre-condition - Step 02: Enter to Username textbox with value: " + adminUserName);
		adminLoginPage.enterToUsernameTextbox(adminUserName);

		log.info("Pre-condition - Step 03: Enter to Password textbox with value: " + adminPassword);
		adminLoginPage.enterToPasswordTextbox(adminPassword);

		log.info("Pre-condition - Step 04: Click to Login button");
		adminDashboardPage = adminLoginPage.clickToLoginButton(); // sau khi click login thì vào trang dashboard nên khởi tạo trang này là chuyện hiển nhiên
	}

	@Test
	public void Post_01_Create_Post() {
		log.info("Create Post - Step 01: Click to 'Posts' in Menu"); // bấm vào thằng posts thì thằng này có mấy cái submenu, default là luôn vào trang search post
		// đang ở trang dashboard thì nhấn vào posts trên menu
		adminPostSearchPage = adminDashboardPage.clickToPostsInMenu(); // vào trang post search nên mình khởi tạo

		log.info("Create Post - Step 02: Get Posts Search URL"); // lấy url để lát nữa sau khi tạo post và publish thì mình chỉ cần truyền cái url để về cái post search là xong để verify đã publish thành công chưa

		postSearchURL = adminPostSearchPage.getPageUrl(driver);

		log.info("Create Post - Step 03: Click to Add New Button");

		adminPostAddNewPage = adminPostSearchPage.clickToAddNewButton(); // sau khi click add new thì vào trang add new nên khởi tạo trang này là chuyện hiển nhiên

		log.info("Create Post - Step 04: Enter to Add Title");

		adminPostAddNewPage.enterToAddTitleInAddNewOrEdit(titleValue);

		log.info("Create Post - Step 05: Enter to body");

		adminPostAddNewPage.enterToAddBodyInAddNew(bodyValue);

		log.info("Create Post - Step 06: Click to Publish button");

		adminPostAddNewPage.clickToPublishOrUpdateButton();

		adminPostAddNewPage.clickToPublishButtonAgain();

		log.info("Create Post - Step 07: Verify 'Post published' popup message is displayed");

		verifyTrue(adminPostAddNewPage.isPostPublishedOrUpdatedPopupDisplayed("Post published."));
	}

	@Test
	public void Post_02_Open_Post_Search_Page() { // mở lại page post search (hay cũng chính là cái submenu all posts), mình nhìn bằng mắt xem đã tạo post sau khi chạy TC1 chưa
		log.info("Post Search - Step 01: Open 'Search Post' page");

		adminPostSearchPage = adminPostAddNewPage.openPostSearchPageURL(postSearchURL); // sau khi mở url cái post search thì vào trang post search nên khởi tạo trang này là chuyện hiển nhiên

		log.info("Post Search - Step 02: Enter to Search Post textbox");

		adminPostSearchPage.enterToSearchTextbox(titleValue);

		log.info("Post Search - Step 03: Click Search Post button");

		adminPostSearchPage.clickToSearchPostButton();

		log.info("Post Search - Step 04: Verify Search table contains with value '" + titleValue + "'"); // verify cái tên title đã tạo nó chuẩn chưa

		verifyTrue(adminPostSearchPage.isPostSearchTableDisplayedWithValue("title", titleValue)); // chỗ này verify muốn chính xác tên title thì mình phải xác định đúng cột của nó nữa, ở đây là cột Title

		log.info("Post Search - Step 05: Verify Search table contains with value '" + authorName + "'"); // verify tên người đăng

		verifyTrue(adminPostSearchPage.isPostSearchTableDisplayedWithValue("author", authorName)); // chỗ này verify muốn chính xác tên author thì mình phải xác định đúng cột của nó nữa, ở đây là cột Author

		// chuyển qua page mà enduser xài xem post mình tạo đã lên chưa
		log.info("Post Search - Step 06: Open User URL");
		// step này cần để ý 1 chút là vì mở URL thì có thể mở ở bất cứ đâu nên ta ko nên viết hàm này ở 1 class cụ thể, viết ở 1 class chung là basepage

		userHomePage = adminPostSearchPage.openEndUserPage(driver, this.endUserURL); // mở url user page là ra home page nên mình khởi tạo biến cho nó là điều bth

		log.info("Post Search - Step 07: Verify New Post is uploaded in User site"); // Verify cái post đã ở trên trang chủ bằng các yếu tố dưới đây

		verifyTrue(userHomePage.isPostTitleDisplayed(titleValue));

		verifyTrue(userHomePage.isPostBodyDisplayed(bodyValue));

		verifyTrue(userHomePage.isPostAuthorNameDisplayed(titleValue, authorName));

		// và verify thời gian đăng bài (phần này setting hơi hơi khó xíu)
		verifyTrue(userHomePage.isPostDateDisplayed(titleValue, currentDay));

		log.info("Post Search - Step 08: Click to Title to see the Post detail"); // bấm vào post xem chi tiết

		userPostDetailPage = userHomePage.clickToPostTitle(titleValue);

		log.info("Post Search - Step 09: Verify post Detail is updated");

		verifyTrue(userPostDetailPage.isPostTitleDisplayed(titleValue));

		verifyTrue(userPostDetailPage.isPostBodyDisplayed(titleValue, bodyValue));

		verifyTrue(userPostDetailPage.isPostAuthorNameDisplayed(titleValue, authorName));

		verifyTrue(userPostDetailPage.isPostDateDisplayed(titleValue, currentDay));

	}

	@Test
	public void Post_03_Edit_Post() {
		log.info("Post Edit - Step 01: Open Admin URL");

		adminDashboardPage = userPostDetailPage.openAdminURL(driver, this.adminURL);

		log.info("Post Edit - Step 02: Click to 'Posts' in Menu");

		adminPostSearchPage = adminDashboardPage.clickToPostsInMenu();

		log.info("Post Edit - Step 03: Enter to Search Post textbox");

		adminPostSearchPage.enterToSearchTextbox(titleValue);

		log.info("Post Edit - Step 04: Click Search Post button");

		adminPostSearchPage.clickToSearchPostButton();

		log.info("Post Edit - Step 05: Click Post title link and navigate to edit detail");
		adminPostAddNewPage = adminPostSearchPage.clickToPostTitleLink(titleValue); // chỗ này lại phải để ý 1 điều là thằng post edit nó cũng chính là thằng post add new, nên ở đây chúng ta ko cần phải khai báo 1 class mới
		// nên cái adminPostAddNewPage phía trên ta tự hiểu nó cũng chính là cái page edit (mà thôi lười chỉnh lại tên vì sẽ làm tên hàm quá dài)

		// do edit cùng chức năng (cùng element luôn) với add new nên mình dùng lại các hàm add new ở TC1 đc nhé, nhưng ở đây công dụng của nó là edit
		// thằng này trùng
		log.info("Post Edit - Step 06: Enter to Edit/Add Title");

		adminPostAddNewPage.enterToAddTitleInAddNewOrEdit(editTitleValue);

		// thằng này ko trùng
		// nhưng riêng phần body nó hơi rắc rối - bên phần page object của hàm này đã ghi chú nó rắc rối chỗ nào rồi, nên ở đây ta phải viết 1 hàm khác cho nó
		log.info("Post Edit - Step 07: Enter to Edit/Add body");

		adminPostAddNewPage.enterToEditBody(editBodyValue);

		// thằng này trùng
		log.info("Post Edit - Step 08: Click to Update button");

		adminPostAddNewPage.clickToPublishOrUpdateButton();

		// thằng này trùng
		log.info("Post Edit - Step 09: Verify 'Post updated' popup message is displayed");

		verifyTrue(adminPostAddNewPage.isPostPublishedOrUpdatedPopupDisplayed("Post updated."));

		// sau khi update thì lại quay lại trang Post search để verify xem đã đc cập nhật chưa
		// rồi lại nhảy qua trang của end user xem post đã đc cập nhật chưa
		// nói chung chỗ này mình dùng lại các bước đã làm ở TC số 2

		log.info("Post Edit - Step 10: Open 'Search Post' page");

		adminPostSearchPage = adminPostAddNewPage.openPostSearchPageURL(postSearchURL);

		log.info("Post Edit - Step 11: Enter to Search Post textbox");

		adminPostSearchPage.enterToSearchTextbox(editTitleValue);

		log.info("Post Edit - Step 12: Click Search Post button");

		adminPostSearchPage.clickToSearchPostButton();

		log.info("Post Edit - Step 13: Verify Search table contains with value '" + editTitleValue + "'");

		verifyTrue(adminPostSearchPage.isPostSearchTableDisplayedWithValue("title", editTitleValue));

		log.info("Post Edit - Step 14: Verify Search table contains with value '" + authorName + "'");

		verifyTrue(adminPostSearchPage.isPostSearchTableDisplayedWithValue("author", authorName));

		log.info("Post Edit - Step 15: Open User URL");
		userHomePage = adminPostSearchPage.openEndUserPage(driver, this.endUserURL);

		log.info("Post Edit - Step 16: Verify New Post is uploaded in User site");

		verifyTrue(userHomePage.isPostTitleDisplayed(editTitleValue));

		verifyTrue(userHomePage.isPostBodyDisplayed(editBodyValue));

		verifyTrue(userHomePage.isPostAuthorNameDisplayed(editTitleValue, authorName));

		verifyTrue(userHomePage.isPostDateDisplayed(editTitleValue, currentDay));

		log.info("Post Edit - Step 17: Click to Title to see the Post detail");

		userPostDetailPage = userHomePage.clickToPostTitle(editTitleValue);

		log.info("Post Edit - Step 18: Verify post Detail is updated");

		verifyTrue(userPostDetailPage.isPostTitleDisplayed(editTitleValue));

		verifyTrue(userPostDetailPage.isPostBodyDisplayed(editTitleValue, editBodyValue));

		verifyTrue(userPostDetailPage.isPostAuthorNameDisplayed(editTitleValue, authorName));

		verifyTrue(userPostDetailPage.isPostDateDisplayed(editTitleValue, currentDay));
	}

	@Test
	public void Post_04_Delete_Post() { // cũng tái chế lại các bước bên trên kha khá
		log.info("Post Delete - Step 01: Open Admin URL");

		adminDashboardPage = userPostDetailPage.openAdminURL(driver, this.adminURL);

		log.info("Post Delete - Step 02: Click to 'Posts' in Menu");

		adminPostSearchPage = adminDashboardPage.clickToPostsInMenu();

		log.info("Post Delete - Step 03: Enter to Search Post textbox");

		adminPostSearchPage.enterToSearchTextbox(editTitleValue);

		log.info("Post Delete - Step 04: Click Search Post button");

		adminPostSearchPage.clickToSearchPostButton();

		log.info("Post Delete - Step 05: Select newest edit post by checkbox");

		adminPostSearchPage.selectPostInTableByCheckbox(editTitleValue);

		log.info("Post Delete - Step 06: Select 'Move to trash' item in the dropdown");

		adminPostSearchPage.selectItemInActionDropdown("Move to Trash");

		log.info("Post Delete - Step 07: Click to 'Apply' button");

		adminPostSearchPage.clickToApplyButton();

		log.info("Post Delete - Step 08: Verify '1 post moved to the Trash.' message is displayed");

		verifyTrue(adminPostSearchPage.isTrashMessageDisplayed("1 post moved to the Trash."));

		log.info("Post Delete - Step 09: Enter to Search Post textbox");

		adminPostSearchPage.enterToSearchTextbox(editTitleValue);

		log.info("Post Delete - Step 10: Click Search Post button");
		adminPostSearchPage.clickToSearchPostButton();

		log.info("Post Delete - Step 11: Verify the edit post is deleted by the message 'No posts found.'");

		verifyTrue(adminPostSearchPage.isThePostDeletedInAdminSite("No posts found."));

		log.info("Post Delete - Step 12: Open User URL");
		userHomePage = adminPostSearchPage.openEndUserPage(driver, this.endUserURL);

		log.info("Post Delete - Step 13: Verify the edit post is undisplayed");

		verifyTrue(userHomePage.isThePostUndisplayed(editTitleValue)); // hàm này mình dùng chung cái biến POST_TITLE đã tạo từ TC tr đó (để verify xem post đã đc đăng thành công chưa và giờ thì verify ngược lại)

		log.info("Post Delete - Step 14: Enter to search posts textbox to find the edit post");

		userHomePage.enterTheTitleToSearchPostTextbox(editTitleValue);

		log.info("Post Delete - Step 15: Click Search Post button");

		userSearchPostFeature = userHomePage.clickToSearchPostButton();

		log.info("Post Delete - Step 16: Verify the edit post is deleted by the message 'Nothing Found'");

		verifyTrue(userSearchPostFeature.isThePostDeletedInUserSite("Nothing Found"));

	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}

}
