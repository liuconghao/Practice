# 使用说明
无聊玩小程序的时候，发现一个api可以查询QQ绑定信息,遂查看提供的文档写了这个Q绑查询的小工具，仅供个人自查使用，请勿用作违法用途

使用前需安装项目需求库
- 单一Python环境使用以下语句
    ```python
    pip intsall -r requirements.txt
    ```
- 双环境共存使用以下语句
    ```python
    py -3 -m pip install -r requirements.txt
    ```
eg:
```python
python Q2Phone.py -h #查看帮助
python Q2Phone.py -v #查看版本
python Q2Phone.py -t qq -v [qq号码] #查找绑定手机号码
python Q2Phone.py -t phone -v [手机号码] #反查绑定QQ号码
``` 