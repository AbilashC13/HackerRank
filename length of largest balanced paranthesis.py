s=input()
m=0
stk=[]
stk.append(-1)
for i in range(len(s)):
    if s[i]=='(':
        stk.append(i)
    else:
        stk.pop()
    if(len(stk)!=0):
        m=max(m,i-stk[len(stk)-1])
    else:
        stk.append(i)
print(m)
