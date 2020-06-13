import numpy as np
list=[];

with open(r'C:\Users\Luis\Desktop\pass.txt','r') as fp:
    done=False;
    while not done:
        line=fp.readline();
        if(line is ""):
            done =True;
        else:
            ascii = str(np.fromstring(line, dtype=np.uint8));
            list.append(ascii);
with open(r'C:\Users\Luis\Desktop\wordlist.txt','w') as f:
    for i in range(len(list)):
        s=list[i].replace('[','').replace(']','');
        s=s.replace(',','').replace('  ','-').replace(' ','-').replace('-10','')+ '\n'
        f.write(s)
print ("done")
        
