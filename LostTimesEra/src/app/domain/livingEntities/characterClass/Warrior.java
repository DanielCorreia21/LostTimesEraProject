package app.domain.livingEntities.characterClass;

import java.util.Random;

public class Warrior implements CharacterClass{

	private Random r = new Random();
	
	@Override
	public int getLife(int constituition, int lvl) {
		return (int) (lvl*constituition*2.5);
	}

	@Override
	public double critDamagePrecentage() {
		return 2.0;
	}

	@Override
	public double critRate() {
		return 0.3;
	}

	@Override
	public double defensePercentage() {
		//varia entre 0.3 - 0.5
		return ((double) r.nextInt(20) / 100.0) + 0.30;
	}

	@Override
	public int numAttacks() {
		return 1;
	}

	@Override
	public String getCharacterClass() {
		return "Warrior";
	}
}
