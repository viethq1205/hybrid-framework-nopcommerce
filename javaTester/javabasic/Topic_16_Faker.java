package javabasic;

import java.util.Locale;

import com.github.javafaker.CreditCardType;
import com.github.javafaker.Faker;

public class Topic_16_Faker {

	public static void main(String[] args) {
		Faker faker = new Faker(); // faker nó có tính đa hình
		// 1 loại faker có tham số là locale thì sẽ giúp fake ra các nước khác nhau
		// 1 loại faker có tham số random thì nó giống như cái Random vậy
		// 1 loại faker là sự kết hợp của 2 cái trên
		// còn bình thường ko có các yêu cầu gì thì cứ dùng cái thằng faker() là đc rồi
		System.out.println(faker.address().firstName());
		System.out.println(faker.address().lastName());
		System.out.println(faker.business().creditCardType());
		System.out.println(faker.business().creditCardNumber());
		System.out.println(faker.business().creditCardExpiry());

		// mấy thằng trên random 1 loại thẻ, còn đây có thể chỉ xác định 1 loại thẻ
		faker.finance().creditCard(CreditCardType.VISA);

		// fake ten VN
		Faker fakeVN = new Faker(new Locale("vi")); // vi la viet tat cho local-vi tri VN
		System.out.println(fakeVN.address().firstName());
		System.out.println(fakeVN.address().lastName());

	}

}
