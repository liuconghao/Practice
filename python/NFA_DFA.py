# 构造NFA
class NFA:
    # 初始化NFA
    def __init__(self, S, s0, F, move):
        self.S = S  # 状态集(list)
        self.s0 = s0  # 初态(int)
        self.F = F  # 终态(int)
        self.move = move  # 状态转换函数（list套dict）
    # 计算状态集T的n(代替ε)闭包U
    def getClosure(self, T):
        U = list()  # 闭包集合
        Stack = list()  # 栈
        for t in T:
            Stack.append(t)  # 将t入栈
            U.append(t)  # 先将T加入U
        # 当栈非空
        while Stack:
            t = Stack.pop()  # 取出栈顶元素
            # 如果能转换(判断字典中是否存在key为'n')
            if 'n' in move[t]:
                u = self.move[t]['n']  # 得到转换后状态u
                # 若转换后状态不在闭包集合U中，加u入U
                if u not in U:
                    # 因为u为list类型，所以循环加入
                    for x in u:
                        Stack.append(x)
                        U.append(x)
            # 如果不能转换
            else:
                pass
        return U
    # smove方法,T为初态集，n为待识别字符(str类型),返回转换后的状态集U
    def smove(self, T, n):
        U = list()  # 存储smove后的状态集
        for t in T:
            # 如果能转换(判断字典中是否存在key为'n')
            if n in move[t]:
                u = self.move[t][n]  # 得到转换后状态u
                # 若转换后状态不在闭包集合U中，加u入U
                if u not in U:
                    # 因为u为list类型，所以循环加入
                    for x in u:
                        U.append(x)
            # 如果不能转换
            else:
                #print('不能转换，啥事都不干~')
                pass
        return U
# 构造DFA
class DFA:
    # 通过NFA对象N构造DFA
    def __init__(self, N):
        print('---------子集法构造DFA开始---------')
        self.s0 = N.getClosure([0])  # 初态(list)
        self.Dstates = [self.s0]  # 存储DFA的状态
        self.DstatesFlag = [0]  # 记录状态是否被标记过，元素个数代表还未被标记的数目
        self.F=N.F#终态
        curIndex = 0  # 当前处理到的Dstates的下标
        Dtran = list() # 状态转换矩阵
        U1 = list()#暂存器，用于存储转换后的状态集，便于写入转换矩阵
        U2 = list()#同上
        # 当DFA状态集中有尚未标记的状态T
        while self.DstatesFlag:
            self.DstatesFlag.pop()  # 取出一个标记
            #循环求闭包
            for ch in ['a', 'b']:
                #求出smove后的闭包U
                U = N.getClosure(N.smove(self.Dstates[curIndex], ch))
                #条件判断构造写入格式Dtran.append({'a': U1, 'b': U2})
                if ch == 'a':
                    U1 = U
                else:
                    U2 = U
                # 如果U不在Dstates中，将U作为未标记的状态加入Dstates中
                if U not in self.Dstates:
                    self.Dstates.append(U)#将U加入到状态集中
                    self.DstatesFlag.append(0)#长度增1，表示新增一个未标记状态

            Dtran.append({'a': U1, 'b': U2})#将转换结果写入转换矩阵中
            curIndex+=1 # 下标增1

        self.move = Dtran  # 构造状态转换函数（list套dict）
        print('DFA的初态:',self.s0)
        print('DFA的终态:', self.F)
        print('DFA的状态集:', self.Dstates)
        print('DFA的状态转换表:', self.move)

if __name__ == '__main__':

    print("---------请按提示操作---------' ")
    # 构造NFA  开始
    print("请输入状态集S,输入格式如'[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]'.")
    S =  eval(input(":"))
    s0 = int(input("请输入初态,如'0' :"))
    F = int(input("请输入终态,如'9' :"))
    print("请输入状态转移表('n'表示'ε'),输入格式如'[{'n':[1,7]},{'n':[2,4]},{'a':[3]},{'n':[6]},{'b':[5]},{'n':[6]},{'n':[1,7]},{'a':[8]},{'b':[9]},{}]'.")
    move = eval(input(":"))
    N = NFA(S, s0, F, move)
    print("---------NFA构造完成---------' ")
    # 构造NFA  结束
    D=DFA(N)#通过NFA对象N构造DFA
