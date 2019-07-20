def anagram(s,a):
    z=[]
    for i in a:
        x=''.join(sorted(i))
        if(s==x):
            z.append(i)
    return(z)
s=input()
s=s.replace('"',"")
s=s.replace(" ","")
s=s.replace("[","")
s=s.replace("]","")
a=s.split(',')
b=[]
for i in a:
    x=''.join(sorted(i))
    if(x not in b):
        b.append(x)

c=[]
b.sort()
for i in b:
    c.append(anagram(i,a))
print(c)
