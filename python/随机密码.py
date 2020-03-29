import random

def genpwd(length):
    range_start = 10**(length-1)
    range_end = (10**length)-1
    return random.randint(range_start, range_end)

length = eval(input())
random.seed(17)
for i in range(3):
    print(genpwd(length))