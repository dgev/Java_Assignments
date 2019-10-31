package example;

public class Dictionary<K, V> {

	private K key;
	private V value;
	private final int size;
	private DictionaryObject<K, V>[] objects;

	public Dictionary(int size) {
		this.size = size;
		objects = new DictionaryObject[size];
	}

	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}

	public int size() {
		return objects.length;
	}

	public boolean isEmpty() {
		return (objects.length == 0);
	}

	public boolean containsKey(K key) {
		if (objects[key.hashCode() % size] != null) {
			return true;
		}

		return false;

	}

	public boolean containsValue(V value) {
		for (DictionaryObject<K, V> obj : objects) {
			if (obj != null && obj.getValue().equals(value)) {
				return true;
			}
		}
		return false;

	}

	public void put(K key, V value) {
		int current_key = key.hashCode() % size;
		DictionaryObject<K, V> obj = new DictionaryObject<K, V>(key, value);
		objects[current_key] = obj;
	}

	public V get(K key) {
		return objects[key.hashCode() % size].getValue();
	}


	public static void main(String[] args) {
		Dictionary<Integer, String> dict = new Dictionary<Integer, String>(3);
		dict.put(1, "value");
		dict.put(2, "value2");
//		Dictionary <Integer, Integer> dict = new Dictionary<Integer, Integer>(3);
//		dict.put(1, 5);
		System.out.println(dict.containsKey(1));
		System.out.println(dict.get(1));
		System.out.println(dict.containsValue("value"));
		System.out.println(dict.isEmpty());

	}

}
