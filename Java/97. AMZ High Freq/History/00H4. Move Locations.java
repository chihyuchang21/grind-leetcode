import java.util.*;

public class Main {
    public static List<Integer> findDataLocations(List<Integer> locations, List<Integer> movedFrom, List<Integer> movedTo) {
        // 用 HashSet 來存放資料的位置
        Set<Integer> dataLocations = new HashSet<>(locations);

        // 模擬每次資料的搬移過程
        for (int i = 0; i < movedFrom.size(); i++) {
            // 從 movedFrom 移出資料
            dataLocations.remove(movedFrom.get(i));
            // 將資料移入 movedTo
            dataLocations.add(movedTo.get(i));
        }

        // 將 HashSet 轉換為 List 並進行排序 (HashSet本身無序)
        List<Integer> result = new ArrayList<>(dataLocations);
        Collections.sort(result);

        return result;
    }

    public static void main(String[] args) {
        // 測試數據
        List<Integer> locations = Arrays.asList(1, 7, 6, 8);
        List<Integer> movedFrom = Arrays.asList(1, 7, 2);
        List<Integer> movedTo = Arrays.asList(2, 9, 5);

        // 調用方法並打印結果
        List<Integer> result = findDataLocations(locations, movedFrom, movedTo);
        System.out.println(result); // 輸出應該是 [5, 6, 8, 9]
    }
}
