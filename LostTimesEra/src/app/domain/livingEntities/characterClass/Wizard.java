package app.domain.livingEntities.characterClass;

import java.util.Random;

public class Wizard implements CharacterClass{
	
	private Random r = new Random();
	
	@Override
	public int getLife(int constituition, int lvl) {
		return (int) (constituition*lvl*1.5);
	}

	@Override
	public double critDamagePrecentage() {
		return 2;
	}

	@Override
	public double critRate() {
		return 0.5;
	}

	@Override
	public double defensePercentage() {
		return 0.2;
	}

	@Override
	public int numAttacks() {
		//25% chance de 2 ataques numa ronda
		return r.nextDouble() < 0.25? 2 : 1;
	}

	@Override
	public String getCharacterClass() {
		return "Wizard";
	}
}
