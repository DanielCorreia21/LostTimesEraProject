package app.utils;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class CustomTimer {

	public static final int TIMER_INTERVAL = 30; //segundos
	
	private ArrayList<CustomTimerReceiver> allReceivers = new ArrayList<>();
	private LocalDateTime lastTime = LocalDateTime.now();
	
	
	public CustomTimer() {
	
		//TODO fazer algo que corra sempre para chamar 
		
	}
	
	public void addReceiver(CustomTimerReceiver receiver) {
		allReceivers.add(receiver);
	}
	
	public void removeReceiver(CustomTimerReceiver receiver) {
		allReceivers.remove(receiver);
	}
	
	private void updateAll() {
		lastTime = LocalDateTime.now();
		allReceivers.stream().forEach(x -> x.alarm(lastTime));;
	}
}
