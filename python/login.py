
count=0
while (count < 3):
    username=input()
    userpwd=input()
    if ((username in["Kate","kate"] ) and (userpwd == "666666")):
        print("登录成功！")
        break
    else: 
        count += 1
        if (count >= 3):
            print("3次用户名或者密码均有误！退出程序。")

