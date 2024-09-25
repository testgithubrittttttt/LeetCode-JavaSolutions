class Solution:
    def maximumScore(self, a: int, b: int, c: int) -> int:
        # Sort the piles so that a >= b >= c
        piles = sorted([a, b, c], reverse=True)#so that a will be the largest, b will be the second largest, and c will be the smallest.
        #Sorting helps us consistently pick the two largest piles to maximize the number of moves (and hence the score) because choosing the largest available piles ensures the game lasts longer.
        a, b, c = piles[0], piles[1], piles[2]
        
        # Calculate the maximum score
        # If the sum of the two smaller piles is less than or equal to the largest pile
        if a >= b + c:
            return b + c#This is because, after exhausting b and c, you will have only one pile left (a), and no further moves can be mad
                        #Since no more moves can be made after b and c are exhausted, the maximum possible score is the total stones in the two smaller piles.
        else:
            # Otherwise, take as many stones as possible
            return (a + b + c) // 2#Each move reduces the total count of stones by 2 (one from each of the two piles). The total number of moves possible is therefore half the total stones.

