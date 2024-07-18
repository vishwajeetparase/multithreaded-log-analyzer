/**
 * This class provides a simple in-memory storage mechanism using a ConcurrentHashMap.
 * It's intended for temporary storage of data during log processing and can be particularly
 * useful for multi-threaded scenarios to avoid race conditions.
 */
public class InMemoryStorage {

  /**
   * A ConcurrentHashMap to store key-value pairs representing temporary data.
   */
  private final ConcurrentHashMap<String, Object> dataMap;

  /**
   * Constructor to initialize the ConcurrentHashMap for in-memory storage.
   */
  public InMemoryStorage() {
    this.dataMap = new ConcurrentHashMap<>();
  }

  /**
   * Stores a key-value pair in the in-memory storage.
   * 
   * @param key A unique identifier for the data being stored.
   * @param value The actual data object to be stored.
   */
  public void put(String key, Object value) {
    dataMap.put(key, value);
  }

  /**
   * Retrieves a value from the in-memory storage based on the provided key.
   * 
   * @param key The unique identifier for the data to be retrieved.
   * @return The data object associated with the key, or null if not found.
   */
  public Object get(String key) {
    return dataMap.get(key);
  }

  /**
   * Removes a key-value pair from the in-memory storage.
   * 
   * @param key The unique identifier for the data to be removed.
   */
  public void remove(String key) {
    dataMap.remove(key);
  }

  /**
   * Checks if the in-memory storage contains a specific key.
   * 
   * @param key The unique identifier to check for existence.
   * @return True if the key exists in the storage, false otherwise.
   */
  public boolean containsKey(String key) {
    return dataMap.containsKey(key);
  }
}
