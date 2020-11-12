class Solution:
    def countRangeSum(self, nums: List[int], lower: int, upper: int) -> int:
        # result, current sum, array to keep the sum list
        res, cur, s = 0, 0, [0]
        for v in nums:
            cur += v
            # search in sorted sum list to get index between cur-lower and cur-upper
            res += bisect.bisect_right(s, cur-lower) - bisect.bisect_left(s, cur-upper)
            # insert with bisect and keep s sorted
            bisect.insort_right(s, cur)
        return res

