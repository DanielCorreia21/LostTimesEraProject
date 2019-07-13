package app.domain.livingEntities.characterClass;


public class Assassin implements CharacterClass{

	//private Random r = new Random();
	
	@Override
	public int getLife(int constituition, int lvl) {
		return constituition * lvl;
	}

	@Override
	public double critDamagePrecentage() {
		return 3.5;
	}

	@Override
	public double critRate() {
		return 0.7;
	}

	@Override
	public double defensePercentage() {
		//assassino nao tem defesa
		return 0;
	}

	@Override
	public int numAttacks() {
		return 1;
	}

	@Override
	public String getCharacterClass() {
		return "Assassin";
	}

}
