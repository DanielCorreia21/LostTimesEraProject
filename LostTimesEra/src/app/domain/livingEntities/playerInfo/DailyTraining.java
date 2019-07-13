package app.domain.livingEntities.playerInfo;

import java.time.Duration;
import java.time.LocalDateTime;

public class DailyTraining {

	public static final int PREMIUM_DAILY_TRAININGS = 30;
	public static final int PREMIUM_TRAININGS_COOLDOWN = 30;
	public static final int NORMAL_DAILY_TRAININGS = 20;
	public static final int NORMAL_TRAININGS_COOLDOWN = 60;
	
	private int dailyCooldown = NORMAL_TRAININGS_COOLDOWN;
	private int dailyTrainings = NORMAL_DAILY_TRAININGS;
	private int trainingLeft;
	private LocalDateTime nextTime;
	
	public DailyTraining() {
		trainingLeft = dailyTrainings;
		nextTime = LocalDateTime.now();
	}
	
	public void train() {
		//TODO do some training
		trainingLeft -= 1;
		nextTime = LocalDateTime.now().plusSeconds(dailyCooldown);
	}
	
	public boolean canTrain() {
		return trainingLeft > 0 && LocalDateTime.now().isAfter(nextTime);
	}
	
	public void toPremium() {
		dailyCooldown = PREMIUM_TRAININGS_COOLDOWN;
		dailyTrainings = PREMIUM_DAILY_TRAININGS;
	}
	
	public void toNormal() {
		dailyCooldown = NORMAL_TRAININGS_COOLDOWN;
		dailyTrainings = NORMAL_DAILY_TRAININGS;
	}

	public int getDailyCooldown() {
		return dailyCooldown;
	}

	public int getDailyTrainings() {
		return dailyTrainings;
	}

	public int getTrainingLeft() {
		return trainingLeft;
	}

	public LocalDateTime getNextTime() {
		return nextTime;
	}

	public Duration timeLeft() {
		Duration dur = Duration.between(LocalDateTime.now(), nextTime);
		if(dur.isNegative())
			dur = Duration.ZERO;
		return dur;
	}
}
