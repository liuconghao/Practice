sum=0
a=1
for i in range(1,967):
    sum+=i*a
    a=-a
print(sum)