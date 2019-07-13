package app.domain.livingEntities.characterClass;

public interface CharacterClass {

	public int getLife(int constituition, int lvl);
	public double critDamagePrecentage();
	public double critRate();
	public double defensePercentage();
	public int numAttacks(); //numero de ataques num turno
	public String getCharacterClass();
}
