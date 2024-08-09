class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortedStr = String.valueOf(chars);

            if(!map.containsKey(sortedStr)) {
                map.put(sortedStr, new ArrayList<>());
            }

            map.get(sortedStr).add(str);
        }

        return new ArrayList<>(map.values());
    }
}

// with comments
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        // 創建 HashMap，key 為字母排序後的字串，value 為相同字母組成的字串列表
        HashMap<String, List<String>> hashMap = new HashMap<>();

        // for loop
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            // 將 String 轉為 CharArray 並排序
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortedStr = String.valueOf(chars);

            // 如果 HashMap 中不存在以 sortedStr為 key 的 entry，則新增到 HashMap 中
            if (!hashMap.containsKey(sortedStr)) {
                hashMap.put(sortedStr, new ArrayList<>());
            }
            // 將原始字串加入相應的 value 中
            hashMap.get(sortedStr).add(str);
        }

        // 返回所有 value
        return new ArrayList<>(hashMap.values());
    }
}



/**
 * 240809
 *
 * # Understand
 * 1. Are the strings in the input array guaranteed to contain only lowercase English letters,
 * or could there be uppercase letters or special characters?
 * 2. Is the input array expected to be large, and should we optimize for time or space complexity in our solution?
 *
 *
 * # Match
 * 1. Brute Force
 *      Tc:
 *      SC:
 * 2. HashMap
 *      TC: O(n * k log k), Assumed String avg length = k, for loop + sorting + hashmap O(1)
 *      SC: O(n * k)
 *
 * # Plan
 * # Impliment
 * # Review
 * # Evaluate
 *
 * # Notes
 * [HashMap]
 * 1. How to create a new HashMap<String, List<String>>
 * 2. What to put in K, V in map
 * 3. String.toCharArray --> leads to char[] chars
 * 4. new ArrayList --> map.put(sortedStr, new ArrayList)
 * 5. hashMap.get(sortedStr).add(str);
 */
