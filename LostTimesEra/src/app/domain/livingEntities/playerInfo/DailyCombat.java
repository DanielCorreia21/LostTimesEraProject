package app.domain.livingEntities.playerInfo;

import java.time.LocalDateTime;

import app.utils.CustomTimerReceiver;

public class DailyCombat{
	
	public static final int PREMIUM_DAILY_COMBATS = 30;
	public static final int PREMIUM_COMBATS_COOLDOWN = 30;
	public static final int NORMAL_DAILY_COMBATS = 20;
	public static final int NORMAL_COMBATS_COOLDOWN = 60;
	
	private int dailyCooldown = NORMAL_COMBATS_COOLDOWN;
	private int dailyCombats = NORMAL_DAILY_COMBATS;
	private int combatsLeft;
	private LocalDateTime nextTime;
	
	public DailyCombat() {
		combatsLeft = dailyCombats;
		nextTime = LocalDateTime.now();
	}
	
	public void combat() {
		//TODO do some combat
		combatsLeft -= 1;
		nextTime = LocalDateTime.now().plusSeconds(dailyCooldown);
	}
	
	public boolean canCombatn() {
		return combatsLeft > 0 && LocalDateTime.now().isAfter(nextTime);
	}
	
	public void toPremium() {
		dailyCooldown = PREMIUM_COMBATS_COOLDOWN;
		dailyCombats = PREMIUM_DAILY_COMBATS;
	}
	
	public void toNormal() {
		dailyCooldown = NORMAL_COMBATS_COOLDOWN;
		dailyCombats = NORMAL_DAILY_COMBATS;
	}

}
