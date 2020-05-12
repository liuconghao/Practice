with open('latex.log','r',encoding='utf-8') as f: #打开文件
    rows_set = set(f.readlines()) # 去除重复行就想到set去重
print('共{}关键行'.format(len(rows_set))) # format标准化输出 len直接取set的长度