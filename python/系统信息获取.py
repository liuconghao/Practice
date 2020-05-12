import sys
d1 = sys.getrecursionlimit()
d2 = sys.executable
d3 = sys.maxunicode
print("RECLIMIT:{}, EXEPATH:{}, UNICODE:{}".format(d1,d2,d3))