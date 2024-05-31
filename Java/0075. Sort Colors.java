class Solution {

    // 主函數，負責調用合併排序函數
    public void sortColors(int[] nums) {
        if (nums == null || nums.length < 2) {
            return; // 如果陣列為空或長度小於2，不需要排序
        }
        mergeSort(nums, 0, nums.length - 1); // 調用合併排序函數
    }

    // 合併排序函數，遞迴地將陣列分成兩半進行排序
    private void mergeSort(int[] nums, int left, int right) {
        if (left >= right) {
            return; // 基本情況：如果左指標大於或等於右指標，結束遞迴
        }
        int mid = left + (right - left) / 2; // 計算中間位置，防止溢位
        mergeSort(nums, left, mid); // 遞迴排序左半部分
        mergeSort(nums, mid + 1, right); // 遞迴排序右半部分
        merge(nums, left, mid, right); // 將兩部分合併
    }

    // 合併函數，將兩個已經排序的部分合併成一個排序的部分
    private void merge(int[] nums, int left, int mid, int right) {
        // 創建臨時陣列來存儲需要合併的部分
        int[] temp = new int[right - left + 1];
        int i = left; // 左半部分的起始指標
        int j = mid + 1; // 右半部分的起始指標
        int k = 0; // 臨時陣列的指標

        // 將兩個部分按順序合併到臨時陣列
        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }

        // 如果左半部分還有剩餘元素，將其全部放入臨時陣列
        while (i <= mid) {
            temp[k++] = nums[i++];
        }

        // 如果右半部分還有剩餘元素，將其全部放入臨時陣列
        while (j <= right) {
            temp[k++] = nums[j++];
        }

        // 將排序後的臨時陣列複製回原陣列相應位置
        for (i = left; i <= right; i++) {
            nums[i] = temp[i - left];
        }
    }
}

// Quick Sort
public void quickSort(int[] nums, int low, int high) {
    if (low < high) {
        int pi = partition(nums, low, high);

        quickSort(nums, low, pi - 1);  // 遞迴排序左半部分
        quickSort(nums, pi + 1, high); // 遞迴排序右半部分
    }
}

    // 分區函數，選取最右邊的元素作為樞紐
    public int partition(int[] nums, int low, int high) {
        int pivot = nums[high];
        int i = (low - 1); // 代表較小元素的索引

        for (int j = low; j < high; j++) {
            // 如果當前元素小於或等於樞紐
            if (nums[j] <= pivot) {
                i++;
                // 交換 nums[i] 和 nums[j]
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }

        // 交換 nums[i + 1] 和 nums[high] (或樞紐)
        int temp = nums[i + 1];
        nums[i + 1] = nums[high];
        nums[high] = temp;

        return i + 1;
    }

    // 主函數，用於調用快速排序
    public void sortColors(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }