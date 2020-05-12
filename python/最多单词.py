import jieba

with open('沉默的羔羊.txt','r',encoding='utf-8')as f: # 打开文件
    txt = f.read() # 读取为txt
    words = jieba.lcut(txt) # 利用jieba库的lcut分词
    counts={} # 创建字典
    for word in words: # 逐个遍历
        if len(word) == 1: # 若是当前词语只出现一次 跳过
            continue
        else:
            counts[word]=counts.get(word,0)+1 # 此时词语出现次数累加
list = list(counts.items()) # 字典中items（）方法见下
# 反向排列 key值为字典的[1]索引 = value
list.sort(key=lambda x:x[1],reverse=True) 
print(list[0][0]) # 输出第一