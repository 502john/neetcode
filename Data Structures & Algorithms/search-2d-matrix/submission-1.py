class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:   
            def linear_binary_search(arr, target):
                left = 0 
                right = len(arr) - 1

                while left <= right:
                    mid = left + (right - left ) // 2
                    num_at_mid = arr[mid]

                    if target < num_at_mid:
                        right = mid - 1

                    elif target > num_at_mid:
                        left = mid + 1

                    else:
                        return True

                return False

            # Binary Search throught the rows
            row_len = len(matrix)
            col_len = len(matrix[0])

            top = 0
            bottom = row_len - 1

            
            while top <= bottom:
                mid_arr_idx = top + (bottom - top) // 2
                first_num = matrix[mid_arr_idx][0]
                last_num = matrix[mid_arr_idx][col_len - 1]
                if first_num <= target and target <= last_num:
                    return linear_binary_search(matrix[mid_arr_idx], target)
                elif target < first_num:
                    bottom = mid_arr_idx -1
                else:
                    top = mid_arr_idx + 1
            return False
            



            

        
                
        