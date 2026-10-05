class HashTable {

    int capacity;
    int size;
    Pair[] map;

    public HashTable(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.map = new Pair[capacity];
    }

    public void insert(int key, int value) {
        int idx = hash(key);

        while (true) {
            if (map[idx] == null) {
                map[idx] = new Pair(key, value);
                size++;
                if (size >= capacity / 2) {
                    resize();
                }
                return;
            } else if (map[idx].key == key) {
                map[idx].value = value;
                return;
            }
            idx++;
            idx = idx % capacity;
        }
    }

    public int get(int key) {
        int idx = hash(key);

        while (map[idx] != null) {
            if (map[idx].key == key) {
                return map[idx].value;
            }
            idx++;
            idx = idx % capacity;
        }

        return -1;
    }

    public boolean remove(int key) {
        if (get(key) == -1) {
            return false;
        }

        int idx = hash(key);

        while (map[idx] != null) {
            if (map[idx].key == key) {
                map[idx] = null;
                size--;
                return true;
            }
            idx++;
            idx = idx % capacity;
        }

        return false;
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }

    public void resize() {
        capacity = 2 * capacity;

        Pair[] newPair = new Pair[capacity];

        Pair[] oldPair = map;
        map = newPair;
        size = 0;

        for (Pair p : oldPair) {
            if (p != null) {
                insert(p.key, p.value);
            }
        }
    }

    private int hash(int key) {
        return key % capacity;
    }
}

class Pair {

    int key;
    int value;

    Pair(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
