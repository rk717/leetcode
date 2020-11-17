class Solution:
    def reconstructQueue(self, people: List[List[int]]) -> List[List[int]]:
        #result = []
        #[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
        #先从大到小 排序
        #[[7,0], [7,1], [6,1], [5,0], [5,2], [4,4]]
        #iterration 1: result = [[7,0], [7,1]]
        
        #[[6,1], [5,0], [5,2], [4,4]]
        #interation 2:  result = [[7,0], [6,1], [7,1]]

        #[[5,0],[5,2],[4,4]]
        #interation 3: result = [[5,0], [7,0], [5,2], [6,1], [7,1]]

        #[[4,4]]
        #interation 4: result = [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]

        #建立一个 dictionary 
        people_dict = {}

        for p in people: 
            h, k = p[0], p[1] 
            people_dict.setdefault(h, [])
            people_dict[h].append(k) 

        result = []

        #开始排序
        for h in sorted(people_dict.keys(), reverse = True):
            people_dict[h].sort()
            for k in people_dict[h]:
                result.insert(k, [h,k])
        
        return result