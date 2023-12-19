class Solution(object):
    def threeSum(self, nums):
        result = []
        nums.sort()

        for i in range(len(nums)):
            # 如果第一個元素已>0，不需進一步檢查
            if nums[i] > 0:
                return result

            # 跳過相同元素以避免重複
            if i > 0 and nums[i] == nums[i - 1]:
                continue

            left = i + 1
            right = len(nums) - 1

            while right > left:
                sum_ = nums[i] + nums[left] + nums[right]

                if sum_ < 0:
                    left += 1
                elif sum_ > 0:
                    right -= 1
                else:
                    result.append([nums[i], nums[left], nums[right]])

                    # 跳過相同元素以避免重複
                    while right > left and nums[right] == nums[right - 1]:
                        right -= 1
                    while right > left and nums[left] == nums[left + 1]:
                        left += 1

                    right -= 1
                    left += 1

        return result

