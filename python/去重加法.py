nums={}
ipt=input()
numstr = str(ipt)
ls = set()
for c in numstr:
    ls.add(c)
sum=0
for i in ls:
    sum=sum+int(i)
print(sum)