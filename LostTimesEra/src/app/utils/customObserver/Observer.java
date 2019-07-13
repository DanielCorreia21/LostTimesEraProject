package app.utils.customObserver;

public interface Observer<E> {
	
	public void update(Observable<E> o, E arg);
}
