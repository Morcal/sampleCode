
public class Goddess {

	/**
	 * 女娲造人
	 */
	public static void main(String[] args) {
		//造男人
		Human man=HumanFactory.creatHuman("man");
		man.eat();
		man.sleep();
		
		//造女人
		Human woman=HumanFactory.creatHuman("woman");
		woman.eat();
		woman.sleep();
	}

}
