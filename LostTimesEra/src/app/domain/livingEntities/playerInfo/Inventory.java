package app.domain.livingEntities.playerInfo;

import java.util.ArrayList;
import java.util.List;

import app.domain.Accessory;
import app.domain.accessories.Boots;
import app.domain.accessories.Collar;
import app.domain.accessories.Helmet;
import app.domain.accessories.Pants;
import app.domain.accessories.Shirt;
import app.domain.accessories.Weapon;

public class Inventory {

	private Weapon mainWeapon;
	private Boots boots;
	private Collar collar;
	private Helmet helmet;
	private Pants pants;
	private Shirt shirt;
	
	
	public List<Accessory> getAllAccessories(){
		ArrayList<Accessory> result = new ArrayList<>();
		if(mainWeapon != null) {
			result.add(mainWeapon);
		}
		if(boots != null) {
			result.add(boots);
		}
		if(collar != null) {
			result.add(collar);
		}
		if(helmet != null) {
			result.add(helmet);
		}
		if(pants != null) {
			result.add(pants);
		}
		if(shirt != null) {
			result.add(shirt);
		}
		
		return result;
	}
	
	public Weapon getWeapon() {
		return mainWeapon;
	}
	public void setWeapon(Weapon weapon) {
		this.mainWeapon = weapon;
	}
	public Boots getBoots() {
		return boots;
	}
	public void setBoots(Boots boots) {
		this.boots = boots;
	}
	public Collar getCollar() {
		return collar;
	}
	public void setCollar(Collar collar) {
		this.collar = collar;
	}
	public Helmet getHelmet() {
		return helmet;
	}
	public void setHelmet(Helmet helmet) {
		this.helmet = helmet;
	}
	public Pants getPants() {
		return pants;
	}
	public void setPants(Pants pants) {
		this.pants = pants;
	}
	public Shirt getShirt() {
		return shirt;
	}
	public void setShirt(Shirt shirt) {
		this.shirt = shirt;
	}
	
	
}
