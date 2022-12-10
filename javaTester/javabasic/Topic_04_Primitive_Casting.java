package javabasic;

public class Topic_04_Primitive_Casting {//cast (ép kiểu) nguyên thủy

	public static void main(String[] args) {
		//byte b = 126;
		//short s = b;
		//int i = s;
		//System.out.println(i);
		//in ra k/q c = 126 (y chang byte ban đầu)
		//này gọi là ép kiểu ngầm định (ko mất dữ liệu) từ byte ép sang short ...
		//ép tương tự cho mấy thằng long, float, double cũng y chang (có float và double thì = 126.0 vì bọn này là biến của số thập phân nên kiểu viết số thêm dấu chấm)
		
		
		
		double d = 654321789;
		System.out.println(d);
		float f = (float) d;
		System.out.println(f);
		long l = (long) f;
		System.out.println(l); //in ra l = 654321792 (mất dữ liệu so với ban đầu)
		//từ thằng lớn qua thằng nhỏ phải làm () như trên đó (hay còn gọi là cast)
		//đây đc gọi là ép kiểu tường minh tức chỉ rõ mình sẽ ép sang loại nào (mất dữ liệu so với ban đầu)
		//thằng này mình từng làm bên bài webdriver ấy, nhất là ép từ webdriver sang thành javascriptexecutor
	}

}
