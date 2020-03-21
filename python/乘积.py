def fact(*b) :
    s = 1
    for item in b:
        s *= item
    return s
print(fact(10,3,4,2))