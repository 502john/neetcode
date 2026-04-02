class Solution:
    def compareMaps(self, map1, map2):
        if (len(map1) != len(map2)):
            return False
        
        for item1 in map1:
            if map1.get(item1, 0) != map2.get(item1, 0):
                return False
        
        return True
    

    def checkInclusion(self, s1: str, s2: str) -> bool:
        # Permutation means we need a substring of s2
        # where the length is the same, and the same
        # frequency of characters occur.

        # Strategy:
        # 1. Sliding Window of s1 length
        # 2. Maintaining a static freq map of s1
        # 3. Maintaining a dynamic freq map of our window
        # 4. Map comparison is capped at 26, so we can still
        #    achieve O(26*n) -> O(n)
        s1_map = dict()
        s2_map = dict()
        k = len(s1)

        # Build comparison map
        for ch in s1:
            s1_map[ch] = s1_map.get(ch, 0) + 1

        # Static Sliding Window
        # First create k sized window
        for i in range(k):
            if i > len(s2) - 1:
                break
            ch = s2[i]
            s2_map[ch] = s2_map.get(ch, 0) + 1

        # Verify Window
        if self.compareMaps(s1_map, s2_map) == True:
            return True


        for i in range( len(s2) - k ):
            if i > len(s2) - 1:
                break
            j = i + k
            left_ch = s2[i]
            right_ch = s2[j]

            # Remove Left Element
            s2_map[left_ch] = s2_map.get(left_ch, 0) - 1
            if s2_map[left_ch] <= 0:
                del s2_map[left_ch]

            # Add Right Element
            s2_map[right_ch] = s2_map.get(right_ch, 0) + 1

            # Compare
            if self.compareMaps(s1_map, s2_map) == True:
                return True
        
        return False

        




        





        