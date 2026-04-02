class Solution:
    def search(self, nums: List[int], target: int) -> int:
        left = 0
        right = len(nums) - 1
        
        while (left <= right):
            mid = left + ((right - left ) // 2)
            # target < mid
            if target < nums[mid]:
                right = mid - 1
                continue
                
            
            # target > mid
            elif target > nums[mid]:
                left = mid + 1
                continue

            # target == mid
            else:
                return mid
        
        return -1
        
            


        