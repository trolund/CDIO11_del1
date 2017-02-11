
/**
 * Singleton object.
 *
 * Spørg Ronnie.
 * Er dette korrekt brug af et Singleton objekt?
 *
 */
public class LanguageHandler {
	
	private static final LanguageHandler instance = new LanguageHandler();

	private LanguageHandler() {

	}

	public static synchronized LanguageHandler getInstance() {
		return instance;
	}

}