package javaAccMod1st;

public class Dog {
	Animal animal = new Animal(); // gọi là instance hay object đều được //bước này gọi là khai báo sau = là khởi tạo
	Cat cat = new Cat(); // đc truy cập vào class khác nhưng phải cùng package, như nếu khai báo bên package javaaccmod2nd sẽ bị lỗi, nhưng cái cat chuyển thành public thì sẽ import đc

	public void showProperty() {
		System.out.println();
	}

}
