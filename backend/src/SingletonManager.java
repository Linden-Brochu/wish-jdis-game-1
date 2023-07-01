import java.util.HashMap;

public class SingletonManager {
    private static SingletonManager instance = new SingletonManager();
    private HashMap<String, Object> singletons = new HashMap<>();

    public static SingletonManager getInstance() {
        return instance;
    }

    public <T> T getSingleton(String key) {
        return (T) singletons.get(key);
    }

    public void setSingleton(String key, Object singleton) {
        singletons.put(key, singleton);
    }
}
