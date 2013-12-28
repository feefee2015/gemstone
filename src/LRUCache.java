import java.util.HashMap;

public class LRUCache {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LRUCache lru = new LRUCache(3);

		lru.set(1, 1);
		lru.set(2, 2);
		lru.set(3, 3);
		lru.set(4, 4);
		// lru.get(4);

		lru.get(3);
		lru.get(2);
		// lru.get(1);
		lru.set(5, 5);
		// lru.get(1);
		lru.get(2);

		System.out.println(lru.get(3));

	}

	static class Item {
		int key;
		int val;

		public Item(int key, int value) {
			this.key = key;
			this.val = value;
		}

		Item pre;
		Item post;
	}

	int capacity;
	HashMap<Integer, Item> cache;
	Item oldest;
	Item newest;

	public LRUCache(int capacity) {
		this.capacity = capacity;
		cache = new HashMap<Integer, Item>();

	}

	public int get(int key) {
		Item item = get(new Integer(key));
		if (item == null) {
			return -1;
		}
		return item.val;

	}

	Item get(Integer key) {
		Item val = cache.get(key);
		if (val == null) {
			return null;
		}
		if (newest.key == val.key) {
			return val;
		}
		if (oldest.key == val.key && oldest.post != null) {
			oldest = oldest.post;
		}
		if (val.post != null) {
			val.post.pre = val.pre;
		}

		if (val.pre != null) {
			val.pre.post = val.post;
		}
		val.pre = newest;
		val.post = null;

		newest.post = val;

		newest = val;
		return val;

	}

	public void set(int key, int value) {

		Item old = get(new Integer(key));

		if (old != null) {
			old.val = value;
		} else {
			Item item = new Item(key, value);
			if (capacity == cache.size()) {
				cache.remove(oldest.key);
				if (oldest.post != null) {
					oldest.post.pre = null;
				}
				oldest = oldest.post;
			}

			cache.put(item.key, item);
			if (oldest == null) {
				oldest = item;
			}
			item.pre = newest;
			if (newest != null) {
				newest.post = item;
			}
			newest = item;

		}

	}
}
