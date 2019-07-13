package app.facade.handlers;

import app.domain.User;
import app.domain.UserCatalog;

public class CreateAccountHandler {

	private UserCatalog userCat = UserCatalog.getInstance();;
	
	/**
	 * 
	 * @param name
	 * @return false se ja existe alguem com esse nome, true se correu tudo bem
	 */
	public boolean chooseName(String name) {
		if(userCat.userExists(name))
			return false;
		User u = new User(name);
		userCat.addUser(u);
		return true;
	}

	//TODO password, email, etc?
}
