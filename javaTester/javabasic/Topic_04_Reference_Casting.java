package javabasic;

public class Topic_04_Reference_Casting { //cast kiểu tham chiếu
	 protected String studentName;

     public String getStudentName() {
             return studentName;
     }

     public void setStudentName(String studentName) {
             this.studentName = studentName;
     }

     public void showStudentName() {
             System.out.println("Student name: " + studentName);
     }

     public static void main(String[] args) {
    	 Topic_04_Reference_Casting hocsinh1 = new Topic_04_Reference_Casting();
    	 Topic_04_Reference_Casting hocsinh2 = new Topic_04_Reference_Casting();

    	 	hocsinh1.setStudentName("Nguyen Hung Son");
    	 	hocsinh2.setStudentName("Tran Dinh Tan");

             hocsinh1.showStudentName();
             hocsinh2.showStudentName();

             // Ép kiểu
             hocsinh1 = hocsinh2;    //chỗ này như đã học ở data type ấy, thằng tham chiếu khi đổi value thì sẽ đổi hết luôn chứ ko cố định như nguyên thủy

             hocsinh1.showStudentName();
             hocsinh2.showStudentName();
             //như ở đây thằng số 1 phải theo thằng số 2 nên cả 2 thằng cùng tên trần đình tân
             

             hocsinh2.setStudentName("Hoang Quoc Hung"); //chỗ này như trên, thằng tham chiếu khi đổi value thì sẽ đổi hết luôn chứ ko cố định như nguyên thủy

             hocsinh1.showStudentName();
             hocsinh2.showStudentName();
             
             System.out.println(hocsinh1); 
             System.out.println(hocsinh2);
             //kết quả in là ra 2 thằng hs có cái tên đc thay đổi mới nhất là hoàng quốc hùng
     }

}
