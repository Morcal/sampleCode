//以具体工厂Akitchen为例
public class Akitchen implements KitchenFactory {

	@Override
	public Food getFood() {
		// TODO Auto-generated method stub
		return new Apple();
	}

	@Override
	public TableWare getTableWare() {
		// TODO Auto-generated method stub
		return new Knife();
	}

}
