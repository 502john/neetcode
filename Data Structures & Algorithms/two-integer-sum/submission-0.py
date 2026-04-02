class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        map = dict()
        res = []

        for i in range(len(nums)):
            remainder = target - nums[i]
            if remainder in map:
                res.append(map.get(remainder))
                res.append(i)
            else:
                map[nums[i]] = i

        return res 
                
        