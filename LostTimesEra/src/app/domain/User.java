package app.domain;

import app.domain.livingEntities.Player;

public class User {

	private String name;
	private Player p;
	
	
	public User(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	public void setPlayer(Player p) {
		this.p = p;
	}
	
	public Player getPlayer() {
		return p;
	}
	
	public boolean hasCharacter() {
		return p != null;
	}

}
