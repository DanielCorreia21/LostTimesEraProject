package app.domain.livingEntities.characterClass;

public class Archer implements CharacterClass{

	@Override
	public int getLife(int constituition, int lvl) {
		return (int) (constituition*lvl*2.0);
	}

	@Override
	public double critDamagePrecentage() {
		return 2.0;
	}

	@Override
	public double critRate() {
		return 0.6;
	}

	@Override
	public double defensePercentage() {
		return 0.1;
	}

	@Override
	public int numAttacks() {
		return 2;
	}

	@Override
	public String getCharacterClass() {
		return "Archer";
	}

}
