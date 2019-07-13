package app.domain;

import java.util.HashMap;

public class UserCatalog {

	//String -> nome do jogador TODO - se calhar mudar para um id
	private HashMap<String, User> users = new HashMap<>();
	
	private static final UserCatalog INSTANCE = new UserCatalog();
	
	public static UserCatalog getInstance() {
		return INSTANCE;
	}
	
	private UserCatalog() {};
	
	public boolean userExists(String name) {
		return users.containsKey(name);
	}
	
	/**
	 * @requires !userExists(u.getName())
	 * @param u
	 */
	public void addUser(User u) {
		users.put(u.getName(), u);
	}
	
	/**
	 * @requires userExists(name)
	 * @param name
	 * @return
	 */
	public User getUser(String name) {
		return users.get(name);
	}
}
