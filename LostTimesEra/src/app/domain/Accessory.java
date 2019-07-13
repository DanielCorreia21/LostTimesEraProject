package app.domain;

public class Accessory {

	private String name;
	private int goldCost;
	private int lifeBoost;
	private int damageBoost;
	
	public Accessory(String name, int goldCost, int lifeBoost, int damageBoost) {
		this.name = name;
		this.goldCost = goldCost;
		this.lifeBoost = lifeBoost;
		this.damageBoost = damageBoost;
	}

	public String getName() {
		return name;
	}

	public int getGoldCost() {
		return goldCost;
	}

	public int getLifeBoost() {
		return lifeBoost;
	}

	public int getDamageBoost() {
		return damageBoost;
	}
	
}
