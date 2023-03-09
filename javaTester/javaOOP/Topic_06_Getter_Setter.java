package javaOOP;

public class Topic_06_Getter_Setter {
	// public String personName;
	// public int personAge;
	// Note: khi dùng getter setter nếu mình mà để biến access modifier là public như này là vô nghĩa, vì nó sẽ dễ dàng bị truy xuất trực tiếp từ bên ngoài trong khi getter setter có mục đích để bảo mật cái biến

	private String personName;
	private int personAge;
	private int personPhone;
	private float personBankAccountAmount;

	protected String getPersonName() {
		return personName;
	}

	protected void setPersonName(String personName) {
		if (personName == null || personName.isEmpty()) {
			throw new IllegalArgumentException("Vui lòng nhập tên hợp lệ"); // này dùng cho unhappy case nếu user ko nhập gì vào mục tên chẳng hạn
		} else {
			this.personName = personName;
		}
	}

	protected int getPersonAge() {
		return personAge;
	}

	protected void setPersonAge(int personAge) {
		if (personAge > 0 && personAge < 120) {
			throw new IllegalArgumentException("Vui lòng nhập số tuổi hợp lệ"); // này dùng cho unhappy case nếu user ko nhập gì vào mục tên chẳng hạn
		} else {
			this.personAge = personAge;
		}
	}

	protected int getPersonPhone() {
		return personPhone;
	}

	protected void setPersonPhone(int personPhone) {
		if (!String.valueOf(personPhone).startsWith("0")) {
			throw new IllegalArgumentException("Số điện thoại bắt đầu bằng: 09 - 03 - 012 - 016 - 018 - 019");
		} else if (personPhone < 10 || personPhone > 11) {
			throw new IllegalArgumentException("Số điện thoại phải từ 10-11 số");
		} else {
			this.personPhone = personPhone;
		}
	}

	protected float getPersonBankAccountAmount() {
		return personBankAccountAmount;
	}

	protected void setPersonBankAccountAmount(float personBankAccountAmount) {
		this.personBankAccountAmount = personBankAccountAmount;
	}

}
