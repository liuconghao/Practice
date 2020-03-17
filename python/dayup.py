#daydayup.py
base=1.0
up=0.01
dw=0.01
baseA=pow(1.01,365)
while base<baseA:
    # TODO: write code...
    for i in range(365):
        if i%7 in ['6','0']:
            base=base*(1-dw)
        else:
            base=base=(1+up)
    up+=0.01

print("工作日的努力参数为: {:.3f}".format(up))