package app.domain.livingEntities.characterClass;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CharacterClassFactory {
	
	private static final CharacterClassFactory INSTANCE = new CharacterClassFactory();
	
	public static CharacterClassFactory getInstance() {
		return INSTANCE;
	}

	private CharacterClassFactory() {
		List<CharacterClass> allClasses = new ArrayList<>();
		allClasses.add(new Archer());
		allClasses.add(new Assassin());
		allClasses.add(new Warrior());
		allClasses.add(new Wizard());
		for(CharacterClass characterClass : allClasses)
			characterClasses.put(characterClass.getCharacterClass().toLowerCase(), characterClass);
	}

	
	private HashMap<String, CharacterClass> characterClasses = new HashMap<>();

	public CharacterClass getCharacterClass(String className) {
		return characterClasses.get(className.toLowerCase());
	}

	public List<String> getCharacterClasses(){
		return new ArrayList<>(characterClasses.keySet());
	}
	
	public static void main(String[] args) {
		System.out.println(CharacterClassFactory.getInstance().getCharacterClasses());
	}
}
