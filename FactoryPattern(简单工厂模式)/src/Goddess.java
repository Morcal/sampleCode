
public class Goddess {

	/**
	 * Ů�����
	 */
	public static void main(String[] args) {
		//������
		Human man=HumanFactory.creatHuman("man");
		man.eat();
		man.sleep();
		
		//��Ů��
		Human woman=HumanFactory.creatHuman("woman");
		woman.eat();
		woman.sleep();
	}

}
