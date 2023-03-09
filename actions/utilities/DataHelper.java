package utilities;

import java.util.Locale;

import com.github.javafaker.Faker;

public class DataHelper { // thằng này học trong topic Faker libraries/ How to manage large testcases
	private Locale local = new Locale("en"); // mặc định khi dùng Faker là US, nếu mình muốn chỉ định nước nào đó thì tạo thêm local, ở đây mình dùng vi là VN hoặc đổi qua bất kì nc nào đó cũng đc
	private Faker faker = new Faker(local);

	public static DataHelper getDataHelper() {
		return new DataHelper();
	}

	// Những hàm ở dưới mình tạo ra để khi nào cần dùng thì mang ra dùng (thường xuyên dùng), trong project thực tế có thêm nhiều nhu cầu fake khác nữa thì mình lại tiếp tục tạo thêm

	public String getFirstName() {
		return faker.address().firstName();
	}

	public String getLastName() {
		return faker.address().lastName();
	}

	public String getEmailAdress() {
		return faker.internet().emailAddress();
	}

	public String getCompanyName() {

		return faker.company().name();

	}

	public String getFullName() {
		return faker.name().fullName();
	}

	public String getAddress() {
		return faker.address().streetAddress();
	}

	public String getPhone() {
		return faker.phoneNumber().phoneNumber();
	}

	public String getCity() {
		return faker.address().city();
	}

	public String getCityName() {
		return faker.address().cityName();
	}

	public String getPassword() {
		return faker.internet().password(8, 12, true, true); // 8 đến ký tự vừa số vừa chữ vừa có ký tự đặc biệt
	}
}
