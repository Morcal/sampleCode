public class Goddess {

	/**
	 * Ů�����
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// ������
		HumanFactory humanFactory1 = new ManFactory();
		Human man = humanFactory1.createHuman("man");
		man.eat();
		man.sleep();
		// ��Ů��
		HumanFactory humanFactory2=new FemaleFactory();
		Human women = humanFactory2.createHuman("women");
		women.eat();
		women.sleep();
	}

}
