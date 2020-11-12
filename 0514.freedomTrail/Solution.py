#字符串 ring
#start 指向初始字母
#target 指向目标字母（我们要找的字母）
#test 字符串
#两个指针， left 向左移动， right 向右移动
#两个计数器 lc， rc。 

from collections import defaultdict as d 

class Solution: 
    def findRotateSteps(self, ring: str, key: str) -> int: 
        Choices = d() #把每个key 对应的可选的 ring 的字母 的index 做成字典
        for k in key: 
            if k in Choices:
                continue 
            else:
                Choices[k] = []
                for ri, r in enumerate(ring):
                    if r == k:
                        Choices[k].append(ri) 

        counter = [{0 : 0}]
        Path = d() 

        for keyi in range(len(key)): #一共len(key)格子
            counter.append({}) 
            for choice in Choices[key[keyi]]: ## choice是个index，是表示对于在key上第keyi个字母来说，ring里有哪几个位置的字母可以选择。
                temp = []
                for start in counter[keyi].keys(): #start表示上一个格子里，有几种情况可以到达当前的choice。
                    previous_distance = counter[keyi][start] 

                    s = str(start) + "-" + str(choice)
                    if s not in Path:
                        d1 = abs(choice - start)
                        d2 = abs(len(ring) - d1)
                        newc = min(d1, d2)
                        Path[s] = newc 
                    temp.append(previous_distance + Path[s])
                
                counter[keyi + 1][choice] = min(temp) + 1 #只需要保留最小值  再加1表示按下按钮。
        
        #print(Choices)
        final = min(counter[-1].values())

        return final 