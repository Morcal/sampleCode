/***
 * 
 * 抽象工厂模式（Abstract Factory Pattern） 是一种软件开发设计模式。抽象工厂模式提供了一种方式，
 * 可以将一组具有同一主题的单独的工厂封装起来。 如果比较抽象工厂模式和工厂模式，我们不难发现前者只 是在工厂模式之上增加了一层抽象的概念。抽象工厂是一
 * 个父类工厂，可以创建其它工厂类。所以我们也叫 它 “工厂的工厂”。
 * 
 */
// 抽象工厂
public interface KitchenFactory {
	public Food getFood();

	public TableWare getTableWare();
}
