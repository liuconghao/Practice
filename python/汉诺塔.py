
steps = 1
def hanoi(src, des, mid, n):
    global steps
    if n == 1 :       
        print("[STEP{:>4}] {}->{}".format(steps, src, des))
        steps += 1
    else :
        hanoi(src, mid, des, n - 1)       
        print("[STEP{:>4}] {}->{}".format(steps, src, des))
        steps += 1     
        hanoi( mid, des, src,n - 1)
n=eval(input())
hanoi("A", "C", "B",n )
'''
count = 0
def hanoi(n, src, dst, mid):
    global count
    if n == 1 :
        print("{}:{}->{}".format(1,src,dst))
        count += 1
    else :
        hanoi(n-1, src, mid, dst)
        print("{}:{}->{}".format(n,src,dst))
        count += 1
        hanoi(n-1, mid, dst, src)
'''