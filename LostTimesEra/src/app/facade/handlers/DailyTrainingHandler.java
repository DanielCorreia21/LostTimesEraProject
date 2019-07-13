package app.facade.handlers;

import java.time.Duration;

import app.domain.livingEntities.Player;
import app.domain.livingEntities.playerInfo.DailyTraining;
import app.facade.dto.Pair;
import app.facade.dto.Session;

public class DailyTrainingHandler {

	private Player p;
	private DailyTraining dt;
	
	/**
	 * @requires s.getUser().getPlayer() != null
	 * @param s
	 */
	public DailyTrainingHandler(Session s) {
		p = s.getUser().getPlayer();
		dt = p.getDailyTraining();
	}
	
	//TODO n sei se devolvo Duration, apenas inteiro ou String
	public Duration timeLeft() {
		return dt.timeLeft();
	}
	
	public int trainingsLeft() {
		return dt.getTrainingLeft();
	}
	
	public boolean canTrain() {
		return dt.canTrain();
	}
	
	public Pair<Integer, Integer> train() {
		dt.train();
		int gainedXp = (int) (p.getLvl() / 2.0 * 200);
		int gainedGold = (int) (p.getLvl() * 3.5 * 200);
		p.giveXp(gainedXp);
		p.giveGold(gainedGold);
		return new Pair<>(gainedXp, gainedGold);
	}
}
