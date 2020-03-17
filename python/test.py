#all of pratice code

#输入检查
def checkprint():
    tmp = input()
    tmp_value = int(tmp)
    str = "Hello World"
    if(tmp_value is 0):
        print(str)
    elif(tmp_value > 0):
        for i in range(0,len(str),2):
            print(str[i:i+2])
    elif(tmp_value < 0):
        for i in range(len(str)):
            print(str[i:i+1])
checkprint()

#计算
def cale():
    s = input()
    print("{:.2f}".format(eval(s)))
cale()

#turtle库练习
def drawpython():
    import turtle as t
    t.pu()
    t.setup(800,400,200,200)
    t.fd(-300)
    t.seth(-40)
    t.color("purple")
    t.pensize(40)
    t.pd()
    for i in range(4):  
        t.circle(50,80)
        t.circle(-50,80)
    t.circle(50,80/2)
    t.fd(40)
    t.circle(30,180)
    t.fd(20)
    t.done()
drawpython()

#温度转换
str=input()
if str[-2:] in ['cm']:
    f=(eval(str[0:-2]))*1.8+32
    print("{:.2f}F".format(f))
elif str[-2:] in ['Ff']:
    c=(eval(str[0:-2])-32)/1.8
    print("{:.2f}C".format(c))
else:
    print("输入格式错误")
def jl():
    juli=input("shuru:")
    if juli[-2:]in["cm"]:
        c=(eval(juli[0:-2]))/10
        d=(eval(juli[0:-2]))/100
        print("{:.2f}dm".format(c))
        print("{:.2f}m".format(d))
    elif juli[-2:]in["dm"]:
        c=(eval(juli[0:-2]))*10
        d=(eval(juli[0:-2]))/10
        print("{:.2f}cm".format(c))
        print("{:.2f}m".format(d))
    elif juli[-1]in["m"]:
        c= c=(eval(juli[0:-2]))*10
        d=(eval(juli[0:-2]))*100
        print("{:.2f}dm".format(c))
        print("{:.2f}cm".format(d))
jl()