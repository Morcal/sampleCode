public class Goddess {

	/**
	 * 女娲造人
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 造男人
		HumanFactory humanFactory1 = new ManFactory();
		Human man = humanFactory1.createHuman("man");
		man.eat();
		man.sleep();
		// 造女人
		HumanFactory humanFactory2=new FemaleFactory();
		Human women = humanFactory2.createHuman("women");
		women.eat();
		women.sleep();
	}

}
