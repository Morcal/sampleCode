class FemaleFactory extends HumanFactory {

	@Override
	public Human createHuman(String gender) {
		// TODO Auto-generated method stub
		Woman woman = null;
		if (gender.equals("women")) {
			woman = new Woman();
		}
		return woman;
	}

}
