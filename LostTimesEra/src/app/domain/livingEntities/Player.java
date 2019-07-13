package app.domain.livingEntities;

import app.domain.livingEntities.characterClass.CharacterClass;
import app.domain.livingEntities.playerInfo.DailyCombat;
import app.domain.livingEntities.playerInfo.DailyTraining;
import app.domain.livingEntities.playerInfo.Inventory;

public class Player extends LivingEntity{
	
	private int xp;
	private int gold;
	private boolean isPremium;
	private DailyCombat dailyCombat;
	private DailyTraining dailyTraining;
	private Inventory inventory;
	
	public Player(String name, CharacterClass characterClass) {
		//10 = constituition, 5 = base damage, 1 = lvl
		super(characterClass, name, 10, 5, 1);
		xp = 0;
		gold = 0;
		isPremium = false;
		dailyCombat = new DailyCombat();
		dailyTraining = new DailyTraining();
		inventory = new Inventory();
	}

	public int getXp() {
		return xp;
	}

	public int getGold() {
		return gold;
	}

	public boolean isPremium() {
		return isPremium;
	}

	public DailyCombat getDailyCombat() {
		return dailyCombat;
	}

	public DailyTraining getDailyTraining() {
		return dailyTraining;
	}

	public Inventory getInventory() {
		return inventory;
	}
	
	/**
	 * @requires ammount > 0
	 * @param ammount
	 */
	public void giveXp(int ammount) {
		this.xp += ammount;
	}

	/**
	 * @requires ammount > 0
	 * @param ammount
	 */
	public void giveGold(int ammount) {
		this.gold += ammount;
	}
	

}
