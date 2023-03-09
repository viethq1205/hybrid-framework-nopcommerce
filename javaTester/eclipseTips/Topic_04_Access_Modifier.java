package eclipseTips;

public class Topic_04_Access_Modifier {

	public static void main(String[] args) {
		Topic_03_Getter_Setter topic_03 = new Topic_03_Getter_Setter();
		// như ở đây new topic03 lên để truy cập từ topic này nhưng chỉ truy cập đc cái get set đã cài ở topic 03 chứ ko truy cập đc cái carName vì nó private
		topic_03.setCarName("BMW i8");
	}

}
