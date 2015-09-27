//¼òµ¥¹¤³§
public class HumanFactory {

	public static Human creatHuman(String gender){
		Human human=null;
		if (gender.equals("man")) {
			human=new Man();
		}else if(gender.equals("woman")){
			human=new Woman();
		}
		return human;
	}
}
