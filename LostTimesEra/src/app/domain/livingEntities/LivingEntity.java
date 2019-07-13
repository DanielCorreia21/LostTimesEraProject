package app.domain.livingEntities;

import app.domain.livingEntities.characterClass.CharacterClass;

public abstract class LivingEntity {
	
	private CharacterClass characterClass;
	private String name;
	private int constituition;
	private int baseDamage;
	private int lvl;
	
	
	
	public LivingEntity(CharacterClass characterClass, String name, int constituition, int baseDamage, int lvl) {
		this.constituition = constituition;
		this.baseDamage = baseDamage;
		this.lvl = lvl;
		this.characterClass = characterClass;
		this.name = name;
	}

	
	public String getName() {
		return name;
	}

	public int getConstituition() {
		return constituition;
	}

	protected void setConstituition(int constituition) {
		this.constituition = constituition;
	}
	
	public int getBaseDamage() {
		return baseDamage;
	}

	protected void setBaseDamage(int baseDamage) {
		this.baseDamage = baseDamage;
	}
	
	public int getLvl() {
		return lvl;
	}
	
	protected void setLvl(int newLvl) {
		lvl = newLvl;
	}

	public double getCritRate() {
		return characterClass.critRate();
	}

	public double getDefensePercentage() {
		return characterClass.defensePercentage();
	}
	
	public double getCritDamagePercentage() {
		return characterClass.critDamagePrecentage();
	}
	
	public int getDamage() {
		//default vai ser baseDamage, jogadores terao de variar funcao de acordo com acessorios
		return this.getBaseDamage();
	}
	
	/**
	 * 
	 * @return numero de ataques por ronda que o personagem pode fazer
	 */
	public int numAttacks() {
		return characterClass.numAttacks();
	}
	
	public String getCharacterClass() {
		return characterClass.getCharacterClass();
	}

}
