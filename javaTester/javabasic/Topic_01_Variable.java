package javabasic;

public class Topic_01_Variable {
 static int studentNumber;   //tại sao phải có static - vì các tc ở dưới muốn dùng cái int studentnumber này phải thêm static vào do nó là biến bên ngoài, biến của cả class
 static boolean status;
 String studentName = "AutoFC"; //nên như thằng string này ở dưới muốn in ra  System.out.println(studentName); xem kq thì phải thêm static vào (static String studentName = "AutoFC";) nếu ko sẽ bị lỗi với void có static 
 								//hoặc trong cái TC sẽ phải khai báo cái class tổng Topic_01_Variable như dưới
 								//System.out.println(topic.studentName); cái này sẽ dùng đc còn System.out.println(studentName); ko dùng đc
 
 public static void main(String[] args) {
	 System.out.println(studentNumber); //default value của int nếu mình run là 0
	 System.out.println(status); //default value của int là false
	 
	 Topic_01_Variable topic = new Topic_01_Variable();
	 System.out.println(topic.studentName);
	 //xem thêm mấy cái thông tin cơ bản này trong ggdocs topic 02
 }
 
 public void getStudentNumber() {
	// return this.studentName;  //void ko thể trả về return
 }
 
 //Getter - lấy dữ liệu (sẽ đc học thêm trong javaoop)
 //loại hàm này giống mấy cái getcurrenturl, gettitle, gettext...
 public String getStudentName() {
	 return this.studentName;
 }
 
//Setter - set dữ liệu (sẽ đc học thêm trong javaoop)
 //loại hàm này giống mấy hàm action click sendkeys ...
public void setStudentName(String stdName) {
	 this.studentName = stdName;
}
}
