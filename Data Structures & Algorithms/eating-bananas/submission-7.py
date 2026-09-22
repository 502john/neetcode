import math
class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:

        """
        The easiest solution is to:

        find max k, should be needed the maximum number in the list to get it done

        Iterate over every single h from 1-k

            Iterate over every single pile and do a cieling division, add up hours.
            If you're under, you're done return h.



        This worked, we just need a binary search.

        If our total sum resulted in too big a number, in relation to h 



        """

        # 1 case
        if len(piles) == 1:
            return math.ceil(piles[0] / h)


        max_k = max(piles)
        
        left = 1
        right = max_k

        

        while left <= right:
                hours_sum = 0
                mid = (right - left) // 2 + left
                

                for pile in piles:
                    hours_sum += math.ceil( pile/ mid )


                # Did not reach the goal, increase our h to make it bigger
                if hours_sum > h:
                    left = mid + 1
                    continue 

                # Reached the goal
                # Maybe find a smaller one, since if we were doing it iteratively, we would return the first k we find going left to right.
                if hours_sum <= h:
                    right = mid - 1

        return left
        

        

        
                
                
                     
        