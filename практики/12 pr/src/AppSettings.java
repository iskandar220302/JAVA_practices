import java.util.HashMap;
import java.util.Map;
// Класс для управления настройками (Singleton)
public class AppSettings {
    private static final AppSettings INSTANCE = new AppSettings();
    private final Map<String, Setting> settings = new HashMap<>();

    private AppSettings() {}

    public static AppSettings getInstance() {
        return INSTANCE;
    }

    public synchronized void setSetting(String key, String value) {
        if (key == null || key.isBlank()) {
            throw new IllegalArgumentException("Key cannot be null or blank");
        }
        settings.compute(key, (k, v) -> new Setting(k, value)); //compute позволяет избежать null checks
    }

    public synchronized String getSetting(String key) {
        if (key == null || key.isBlank()) {
            throw new IllegalArgumentException("Key cannot be null or blank");
        }
        Setting setting = settings.get(key);
        return setting != null ? setting.getValue() : null;
    }

    public synchronized void printAllSettings(){
        System.out.println("\nCurrent settings:");
        if(settings.isEmpty()){
            System.out.println("No settings yet.");
            return;
        }
        settings.values().forEach(System.out::println);
    }
}