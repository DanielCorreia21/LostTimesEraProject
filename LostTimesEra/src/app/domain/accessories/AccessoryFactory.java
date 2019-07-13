package app.domain.accessories;


public class AccessoryFactory {

	private static final AccessoryFactory INSTANCE = new AccessoryFactory();
	
	public static AccessoryFactory getInstance() {
		return INSTANCE;
	}
	
	private AccessoryFactory() {
		
	}

}
