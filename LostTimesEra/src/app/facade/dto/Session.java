package app.facade.dto;

import app.domain.User;

public class Session {

	private User u;
	
	public Session(User u) {
		this.u = u;
	}
	
	public User getUser() {
		return u;
	}
	
	public boolean hasCharacter() {
		return u.hasCharacter();
	}

}
