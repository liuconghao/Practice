a = input()
try:  # 因为题目要求有输入错误时的输出 就考虑到异常处理
    a = eval(a)
    print(dict(zip(a.values(), a.keys()))) # 直接反向输出
    # 这里有两个函数 zip()  dict() 见下注释
except:
    print('输入错误') # 异常抛出