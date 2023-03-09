package nopcommerce.data;

import java.io.File;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import commons.GlobalConstants;

public class UserDataJson { // thằng này đc dùng trong class này-Level_19_Manage_Data_Cach_Khac2, ứng dụng json quản lý data

	// đầu tiên cần có 1 hàm để đọc cái dữ liệu file json
	public static UserDataJson getUserData() {
		try {

			ObjectMapper mapper = new ObjectMapper();

			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false); // dòng này đơn giản là có tác dụng cảnh báo thôi, bên json mình khai ra có biến gì mà bên đây thiếu thì nó sẽ báo

			return mapper.readValue(new File(GlobalConstants.PROJECT_PATH + "/resources/UserData.json"), UserDataJson.class);

		} catch (Exception ex) {

			ex.printStackTrace();

			return null;

		}
	}

	@JsonProperty("firstName") // dùng annotations để truyền biến giống xml, testng
	private String firstName;

	@JsonProperty("lastName")
	private String lastName;

	@JsonProperty("email")
	private String email;

	@JsonProperty("password")
	private String password;

	@JsonProperty("date")
	private String date;

	@JsonProperty("month")
	private String month;

	@JsonProperty("year")
	private String year;

	// chỉ tạo ra hàm getter thôi, thằng json sẽ giúp mình làm công việc setter tức set dữ liệu

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getDate() {
		return date;
	}

	public String getMonth() {
		return month;
	}

	public String getYear() {
		return year;
	}

	// Ngoài ra còn có thể tạo subclass cho tùy chức năng
	@JsonProperty("login")
	private Login login;

	static class Login {
		@JsonProperty("username")
		private String userName;

		@JsonProperty("password")
		private String password;
	}

	public String getLoginUserName() {
		return login.userName;
	}

	public String getLoginPassword() {
		return login.password;
	}
}
