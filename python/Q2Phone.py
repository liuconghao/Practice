#coding:utf-8
import requests
import time
import hashlib
import sys
import argparse

#定义选项以及命令使用帮助信息
parser = argparse.ArgumentParser(prog=None, usage='%(prog)s [-h] [-t qq/phone] [-v numstring] [-V]',description = 'QQ绑定手机互查',formatter_class=argparse.RawTextHelpFormatter)
parser.add_argument('-t','--type',dest='OperatorType',action='store',default='null',help='参数：qq\phone'+'\n'+'通过QQ查找手机号码\通过手机号码查找QQ')
parser.add_argument('-v','--value',dest='value',action='store',default='null',help='参数：QQ号码或手机号码')
parser.add_argument('-V','--version', action='version', version='Alpha Version')
args=parser.parse_args()

#功能函数定义
def getInfoByQQ(qqID):
    aid = 0
    t = time.time()
    aTime = int(round(t * 1000))
    hl = hashlib.md5()
    tmp = str(aid) + '369abc123' + str(aTime)
    hl.update(tmp.encode(encoding='utf-8'))
    key = hl.hexdigest()
    url = 'http://api.qb-api.com/qb-api.php'
    resp = requests.get(url, params={'mod': 'cha', 'qq':  qqID})
    result=resp.json()
    if result['code']==200:
        print ('QQ：'+result['data']['qq'])
        print ('手机号：'+result['data']['mobile'])
        print ('省份：'+result['place']['province'])
        print ('城市：'+result['place']['city'])
        print ('运营商：'+result['place']['sp'])
        print ('号码前缀：'+result['place']['tel_prefix'])
        print ('邮编：'+result['place']['postcode'])
    elif result['code']==202:
        print ('QQ：'+result['qq']+','+result['msg'])
    elif result['code']==203:
        print (result['msg'])

def getInfoByPhone(phone):
    aid = 0
    t = time.time()
    aTime = int(round(t * 1000))
    hl = hashlib.md5()
    tmp = str(aid) + '369abc123' + str(aTime)
    hl.update(tmp.encode(encoding='utf-8'))
    key = hl.hexdigest()
    url = 'http://api.qb-api.com/bq-api.php'
    resp = requests.get(url, params={'mobile':  phone})
    result=resp.json()
    if result['code']==200:
        print ('QQ：'+result['data']['qq'])
        print ('手机号：'+result['data']['mobile'])
    elif result['code']==202:
        print ('phone：'+result['qq']+','+result['msg'])
    elif result['code']==203:
        print (result['msg'])

def start():
#   print (args)
    if args.OperatorType is not 'null':
        if args.OperatorType.lower()=='qq':
            getInfoByQQ(args.value)
        if args.OperatorType.lower()=='phone':
            getInfoByPhone(args.value)
    else:
        sys.exit(1)

if __name__ == '__main__':
        start()


