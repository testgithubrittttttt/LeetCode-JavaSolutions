from typing import List

class Solution:
    def candy(self, ratings: List[int]) -> int:
        n = len(ratings)
        if n == 0:
            return 0
        
        # Step 1: Create a candies array initialized with 1 candy for each child
        candies = [1] * n#according to the first condition
        
        # we are doing the two passes kyu ki make sure kar sake ki lowest ke dono side vallo ko usse jyada candies mille.
        # Step 2: Left to Right pass
        for i in range(1, n):
            if ratings[i] > ratings[i - 1]:
                candies[i] = candies[i - 1] + 1
        
        # Step 3: Right to Left pass
        for i in range(n - 2, -1, -1):
            if ratings[i] > ratings[i + 1]:
                candies[i] = max(candies[i], candies[i + 1] + 1)
        
        # Step 4: Calculate the total number of candies
        return sum(candies)

#  Example usage:
# solution = Solution()
# ratings = [1, 0, 2]
# print(solution.candy(ratings))  # Output: 5
