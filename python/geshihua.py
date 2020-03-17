import cmath
num=eval(input())
num=cmath.sqrt(num)
if num.imag==0:
    print("{:+>30.3f}".format(num.real))
else:
    print("{:+>30.3f}".format(num))