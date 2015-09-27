
class ManFactory extends HumanFactory{

	@Override
	public Human createHuman(String gender) {
		// TODO Auto-generated method stub
		Man man=null;
		if (gender.equals("man")) {
			man=new Man();
		}
		return man;
	}


}
