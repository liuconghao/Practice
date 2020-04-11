public class Calculator {
public static void main(String[] args) {
	// TODO Auto-generated method stub

	//用栈完成表达式的运算
	//处理一位俩位数的+、-、*、/运算！！！！！
	String expression = "51-3*5-1-10";
	//创建俩个栈，数栈、符号栈
	ArrayStack2 numStack = new ArrayStack2(10);
	ArrayStack2 operStack = new ArrayStack2(10);
	//定义需要的相关变量
	int index = 0;//用于扫描,判断扫描的位置是否为字符串的最后位置
	int num1 = 0;
	int num2 = 0;
	int oper = 0;//运算符
	int res = 0;//计算返回的结值
	char ch =' ';//将每次扫描到的char保存到ch
	String keepNum = "";//用于拼接多位数
	//开始while循环的扫描expression
	while(true) {
		//依次得到expression的每一个字符
		ch = expression.substring(index,index+1).charAt(0);
		//判断截取的ch是什么，符号还是数字，做出相应的处理
		if(operStack.isOper(ch)) {
			//如果是运算符
			//要先判断符号栈是否为空
			if(!operStack.isEmpty()) {
				//如果符号栈有操作符在栈中，就进行优先级比较
				//如果当前符号的优先级小于等于栈中符号的优先级，则需要从数栈中pop出俩个数
				//将符号栈中的较高的优先级的符号pop出，将俩个值进行相应的计算
				//然后再将计算出的结果压入数栈
				if(operStack.priority(ch) <= operStack.priority(operStack.peek())) {
					num1 = numStack.pop();
					num2 = numStack.pop();
					oper = operStack.pop();
					res = numStack.cal(num1, num2, oper);
					//把运算的结果入数栈
					numStack.push(res);
					//然后将当前的操作符入符号栈
					
					//！！！！这个时候的运算符还需要再次和栈中运算符进行比较
					
					if(!operStack.isEmpty()) {
						if(operStack.priority(ch) <= operStack.priority(operStack.peek())) {
							num1 = numStack.pop();
							num2 = numStack.pop();
							oper = operStack.pop();
							res = numStack.cal(num1, num2, oper);
							//把运算的结果入数栈
							numStack.push(res);
							//将符号入栈
							operStack.push(ch);
						}
					}else {
						//如果为空栈，则直接入栈
						operStack.push(ch);
					}
					
				}else {
					//如果当前操作符的优先级大于栈中操作符的优先级，则直接入栈
					operStack.push(ch);
				}
			}else {
				//如果为空栈，则直接入栈
				operStack.push(ch);
			}
		}else {
			//如果为数字，则直接入栈
			//numStack.push(ch - 48);
			
			//分析思路：
			/**
			 * 1.当处理多位数时，不能发现是一个数就立即入栈，因为可能是多位数
			 * 2.在处理数的时候，需要向expression的表达式的index后再看一位，如果是数则进行拼接，如果是符号则入栈 
			 * 3.因此需要一个变量 字符串 用于拼接
			 */

			// 处理多位数
			keepNum += ch;
			// 如果ch已经是最后一位，则不需要判断
			if (index == expression.length() - 1) {
				numStack.push(Integer.parseInt(keepNum));
			} else {
				// 判断下一个字符是不是数字，如果是则继续扫描，如果是运算符则入栈
				if (operStack.isOper(expression.substring(index + 1, index + 2).charAt(0))) {
					// 如果后一位是运算符，则入栈
					numStack.push(Integer.parseInt(keepNum));
					// 入栈后，用于拼接的变量需要清空
					keepNum = "";
				}
			}

		}
		//让index + 1 并判断是否扫描到expression最后
		index++;
		if(index >= expression.length()) {
			break;
		}
	}
	
	//当表达式扫描完毕，符号栈就只剩一个符号，最后进行一次出栈并计算
		
		num1 = numStack.pop();
		num2 = numStack.pop();
		oper = operStack.pop();
		res = numStack.cal(num1, num2, oper);
		numStack.push(res);//结果入栈
	
	System.out.println("表达式"+expression+"的结果为："+res);
	}

}


//先创建一个ArrayStack类
class ArrayStack2{
	private int maxSize;//栈的大小
	private int[] stack;//数组，数组模拟栈数据就放在数组里
	private int top = -1;//top表示栈顶，初始化为-1
	
	//构造器
public ArrayStack2(int maxSize) {
	this.maxSize = maxSize;
	stack = new int[this.maxSize];
}

//栈满
public boolean isFull() {
	return top == maxSize - 1;
}
//栈空
public boolean isEmpty() {
	return top == -1;
}

//入栈
public void push(int value) {
	//先判断栈是否满
	if(isFull()) {
		System.out.println("栈已经满了！");
		return;
	}
	top++;
	stack[top] = value;
}
//出栈
public int pop() {
	//先判断栈是否为空
	if(isEmpty()) {
		//抛出异常
		throw new RuntimeException("栈为空！！！");
	}
	int value = stack[top];
	top--;
	return value;
}
//显示栈的情况[遍历栈]，遍历时，需要从栈顶开始显示数据
public void list() {
	if(isEmpty()) {
		System.out.println("栈为空，没有数据~~~");
		return;
	}
	//需要从栈顶开始显示数据
	for(int i = top; i >= 0; i--) {
		System.out.printf("stack[%d]=%d\t",i,stack[i]);
	}
}

//返回运算符的优先级，优先级是程序员来确定，优先级使用数字来确定
//数字越大，表示优先级越高
public int priority(int oper) {
	if(oper == '*' || oper == '/') {
		return 1;
	}else if(oper == '+' || oper == '-') {
		return 0;
	}else {
		return -1;//假定目前的表达式只有+，-，*，/
	}
}

//返回当前栈顶的值
public int peek() {
	return stack[top];
}

//判断是不是一个运算符
public boolean isOper(char val) {
	return val == '+' || val == '-' || val == '*' || val == '/';
}

//计算方法
public int cal(int num1,int num2,int oper) {
	int res = 0;//用于存放计算的结果
	switch(oper) {
	case '+':
		res = num1 + num2;
		break;
	case '-':
		res = num2 - num1;
		break;
	case '*':
		res = num1 * num2;
		break;
	case '/':
		res = num2 / num1;
		break;
	default:
		break;
	}
	return res;
	}
}
