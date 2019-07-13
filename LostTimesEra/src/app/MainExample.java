package app;

import java.util.List;
import java.util.Optional;

import javax.swing.plaf.synth.SynthSeparatorUI;

import app.facade.dto.Pair;
import app.facade.dto.Session;
import app.facade.handlers.CreateAccountHandler;
import app.facade.handlers.CreateCharacterHandler;
import app.facade.handlers.DailyTrainingHandler;

public class MainExample {

	public static void main(String[] args) {
		LostTimesEra l = new LostTimesEra();
		System.out.println("Criar Conta: ");
		CreateAccountHandler accHandler = l.getCreateAccountHandler();
		System.out.println(accHandler.chooseName("Dani"));
		Optional<Session> maybeSession = l.autenticate("Dani", "password");
		System.out.println(maybeSession.isPresent());
		maybeSession.ifPresent((Session s) -> {
			System.out.println(s.getUser().getName());
			System.out.println("-------------------------------------------");
			
			System.out.println("Criar personagem: ");
			CreateCharacterHandler charHandler = l.getCreateCharacterHandler(s);
			List<String> charClasses = charHandler.getClassNames();
			System.out.println(charClasses);
			
			System.out.println(charHandler.chooseClass(charClasses.get(0)));
			
			System.out.println(s.getUser().getPlayer().getName());
			System.out.println("-------------------------------------------");
			
			System.out.println("Treino Diario:");
			DailyTrainingHandler dt = l.getDailyTrainingHandler(s);
			
			System.out.println("Jogador: " + l.getCharacter(s));
			
			System.out.println("Consegue treinar: " + dt.canTrain() + " , tempo espera:" + dt.timeLeft().getSeconds() + "s");
			
			if(dt.canTrain()) {
				Pair<Integer, Integer> gainedValues = dt.train();
				System.out.println("XP ganho: " + gainedValues.getFirst() + ", Gold ganho: " + gainedValues.getSecond());
			}
			
			System.out.println("Consegue treinar: " + dt.canTrain() + " , tempo espera:" + dt.timeLeft().getSeconds() + "s");

			if(dt.canTrain()) {
				Pair<Integer, Integer> gainedValues = dt.train();
				System.out.println("XP ganho: " + gainedValues.getFirst() + ", Gold ganho: " + gainedValues.getSecond());
			}
			
			System.out.println("Jogador: " + l.getCharacter(s));
			System.out.println("-------------------------------------------");
			
		});
	}

}
