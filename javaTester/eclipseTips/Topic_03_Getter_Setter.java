package eclipseTips;

public class Topic_03_Getter_Setter { // bài này khó hiểu vl, liên quan đến việc private, rồi truy cập từ bên ngoài gì đó
	private String carName; // như thằng vì private nên ở topic 04 dù new thằng topic 03 lên vẫn ko truy cập đc (qua topic4 xem)
	private String carType;
	private String carMachine;
	private String car;
	// ví dụ mà nhiều private như trên thì mình có cách nhanh ko phải trỏ vào từng cái create getter setter, đó là chuột phải chọn source, generate getter setter

	// Getter
	public String getCarName() {
		return carName;
	}

	// setter
	public void setCarName(String carName) {
		this.carName = carName;
	}

	public static void main(String[] args) {
		Topic_03_Getter_Setter topic_03 = new Topic_03_Getter_Setter();

	}
}
