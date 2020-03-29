def prime(m):
    flag = 0                 #定义一个标记，便于根据返回值判断是否是质数
    for i in range(2,m):
        if m % i == 0:
            flag = 1
            break 
    return flag
    
n = eval(input())
a = int(n)                   #强制转换为整数
a = a + 1 if a < n else a    #输出一个比n本身要大的整数,
                             #切记前面的a = a + 1不要写成a += 1,输出会不对的
count = 5                    #用于成功输出一个符合要求的质数的计数器
t = ""
while count > 0:
    if prime(a) == 0:
        t += "{},".format(str(a))
        count -= 1           #只有是质数方可减一
    a += 1                   #无论是否是质数均加一
print(t[:-1])
