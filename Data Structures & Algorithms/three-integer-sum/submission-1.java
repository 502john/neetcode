class Solution {
    public List<List<Integer>> threeSum(int[] nums) 
    {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++)
        {
            if (i != 0 && nums[i] == nums[i - 1])
            {
                continue;
            }

            int target = 0 - nums[i];
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right )
            {
                int sum = nums[left] + nums[right];
                if (sum > target)
                {
                    right--;
                }
                else if (sum < target )
                {
                    left++;
                }
                else
                {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[left]);
                    temp.add(nums[right]);
                    res.add(temp);
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left - 1]) left++;

                }


            }

        }
        return res;
        
    }
}
