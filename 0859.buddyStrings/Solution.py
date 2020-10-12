class Solution:
    def buddyStrings(self, A: str, B: str) -> bool:
        if(len(A) != len(B)):
            #print("n")
            return False

        if(A == B):
            newli = split(set(A))
            if(len(newli) < len(A)):
                return True
                #print("y")
            else:
                #print("n")
                return False

        
        lista = []
        la = split(A)
        lb = split(B)
        for i in range(len(A)):
            if(la[i] != lb[i]):
                lista.append(i)

        if(len(lista) != 2):
            #print("n")
            return False
        else:
            if(la[lista[0]] == lb[lista[1]] and
                la[lista[1]] == lb[lista[0]]):
                #print("y")
                return True
                  
def split(word):
    return [char for char in word]

# s = Solution()
# s.buddyStrings("aaaaabc", "aaaaacb")

#859