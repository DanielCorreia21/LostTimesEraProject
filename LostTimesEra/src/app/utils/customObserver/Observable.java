package app.utils.customObserver;
import java.util.ArrayList;
import java.util.List;

public abstract class Observable<E> {
	
	private List<Observer<E>> obs = new ArrayList<>(); 
	
	public void notifyObservers(E arg) {
		
		for(Observer<E> o : obs) {
			o.update(this, arg);
		}
	}
	
	public void addObserver(Observer<E> o) {
		this.obs.add(o);
	}
}
