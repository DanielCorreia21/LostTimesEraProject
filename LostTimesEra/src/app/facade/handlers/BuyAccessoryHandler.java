package app.facade.handlers;

import app.domain.livingEntities.Player;
import app.facade.dto.Session;

public class BuyAccessoryHandler {
	
	private Player p;

	public BuyAccessoryHandler(Session s) {
		this.p = s.getUser().getPlayer();
	}
	
	

}
