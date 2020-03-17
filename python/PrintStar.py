a=eval(input())
for i in range(0,a,2):
    print("{0:^{1}}".format('*'*(i+1),a))