import java.util.*;

/**
 * @author wjx
 * @date 2024/02/15 10:46 PM
 */
public class RandomizedSet {
    private List<Integer> data;
    private Random random;
    private HashMap<Integer, Integer> map;

    public RandomizedSet() {
        random = new Random();
        data = new ArrayList<>();
        map = new HashMap<>();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)){
            return false;
        }
        int index = data.size();
        data.add(val);
        map.put(val, index);
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val) || data.isEmpty()){
            return false;
        }
        int index = map.get(val);
        int last_value = data.getLast();
        map.replace(last_value, index);
        data.set(index, last_value);
        map.remove(val);
        data.removeLast();
        return true;
    }

    public int getRandom() {
        return data.get(random.nextInt(0, data.size()));
    }

    public static void main(String[] args) {
        RandomizedSet randomizedSet = new RandomizedSet();
//        System.out.println(randomizedSet.insert(1)); // Inserts 1 to the set. Returns true as 1 was inserted successfully.
//        System.out.println(randomizedSet.remove(2)); // Returns false as 2 does not exist in the set.
        System.out.println(randomizedSet.remove(0)); // Returns false as 2 does not exist in the set.
        System.out.println(randomizedSet.remove(0)); // Returns false as 2 does not exist in the set.
        System.out.println(randomizedSet.insert(0)); // Inserts 2 to the set, returns true. Set now contains [1,2].
        System.out.println(randomizedSet.remove(0)); // Returns false as 2 does not exist in the set.
//        System.out.println(randomizedSet.getRandom()); // getRandom() should return either 1 or 2 randomly.
//        System.out.println(randomizedSet.remove(1)); // Removes 1 from the set, returns true. Set now contains [2].
//        System.out.println(randomizedSet.insert(2)); // 2 was already in the set, so return false.
        System.out.println(randomizedSet.getRandom()); // Since 2 is the only number in the set, getRandom() will always return 2.
    }
}
