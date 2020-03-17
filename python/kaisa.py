
str = input()
new = ""
for i in str:
    if 'a' <= i <= 'z':
        new += chr(ord('a')+((ord(i)-ord('a'))+3)%26)
    elif 'A' <= i <= 'Z':
        new += chr(ord('A')+((ord(i)-ord('A'))+3)%26)
    else:
        new += i
print(new)
