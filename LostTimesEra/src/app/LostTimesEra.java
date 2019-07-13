package app;

import java.util.Optional;

import app.domain.UserCatalog;
import app.domain.livingEntities.Player;
import app.facade.dto.PlayerDTO;
import app.facade.dto.Session;
import app.facade.handlers.CreateAccountHandler;
import app.facade.handlers.CreateCharacterHandler;
import app.facade.handlers.DailyTrainingHandler;

public class LostTimesEra {

	private UserCatalog userCatalog = UserCatalog.getInstance();
	
	
	public Optional<Session> autenticate(String name, String pass){
		//TODO meter password nas contas...
		if(userCatalog.userExists(name))
			return Optional.of(new Session(userCatalog.getUser(name)));
		
		return Optional.empty();
	}
	
	public CreateAccountHandler getCreateAccountHandler() {
		return new CreateAccountHandler();
	}
	
	public CreateCharacterHandler getCreateCharacterHandler(Session s) {
		return new CreateCharacterHandler(s);
	}
	
	public boolean hasCharacter(Session s) {
		return s.getUser().getPlayer() != null;
	}
	
	/**
	 * @requires hasCharacter(s)
	 * @param s
	 * @return
	 */
	public PlayerDTO getCharacter(Session s) {
		Player p = s.getUser().getPlayer();
		String name = p.getName();
		int level = p.getLvl();
		int gold = p.getGold();
		String title = "prov_title";
		String rank = "prov_rank";
		return new PlayerDTO(name, title, rank, level, gold);
	}
	
	/**
	 * @requires hasCharacter(s)
	 * @param s
	 * @return
	 */
	public DailyTrainingHandler getDailyTrainingHandler(Session s) {
		return new DailyTrainingHandler(s);
	}
	
}
