package app.facade.handlers;

import java.util.List;

import app.domain.User;
import app.domain.livingEntities.Player;
import app.domain.livingEntities.characterClass.CharacterClass;
import app.domain.livingEntities.characterClass.CharacterClassFactory;
import app.facade.dto.Session;

public class CreateCharacterHandler {

	private User u;
	
	public CreateCharacterHandler(Session s) {
		u = s.getUser();
	}
	
	//TODO se calhar mudar forma como tratar isto
	public List<String> getClassNames(){
		return CharacterClassFactory.getInstance().getCharacterClasses();
	}
	
	public boolean chooseClass(String className) {
		CharacterClassFactory classFactory = CharacterClassFactory.getInstance();
		CharacterClass characterClass = classFactory.getCharacterClass(className);
		if(characterClass == null)
			return false;
		
		Player p = new Player(u.getName(), characterClass);
		u.setPlayer(p);
		return true;
	}

}
