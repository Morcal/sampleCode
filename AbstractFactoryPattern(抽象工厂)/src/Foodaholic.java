//�Ի�Ҫ��ʼ����
public class Foodaholic {

	/**
	 * ��������ģʽ�����󹤳�ģʽ�����������ڣ�
	 * ��������ģʽ����Ե���һ����Ʒ�ȼ��ṹ
	 * ���󹤳�����ģʽ����Զ����Ʒ�ȼ��ṹ
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Foodaholic fh = new Foodaholic();
		KitchenFactory kf = new Akitchen();
		fh.eat(kf);
	}

	public void eat(KitchenFactory kf) {
		System.out.println("A foodaholic is eating "
				+ kf.getFood().getFoodName() + " with "
				+ kf.getTableWare().getToolName());
	}

}
