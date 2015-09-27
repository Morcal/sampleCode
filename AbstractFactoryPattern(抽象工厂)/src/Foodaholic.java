//吃货要开始吃了
public class Foodaholic {

	/**
	 * 工厂方法模式、抽象工厂模式最大的区别在于：
	 * 工厂方法模式：针对的是一个产品等级结构
	 * 抽象工厂方法模式：针对多个产品等级结构
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
