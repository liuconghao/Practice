public class Calculator {
public static void main(String[] args) {
	// TODO Auto-generated method stub

	//��ջ��ɱ��ʽ������
	//����һλ��λ����+��-��*��/���㣡��������
	String expression = "51-3*5-1-10";
	//��������ջ����ջ������ջ
	ArrayStack2 numStack = new ArrayStack2(10);
	ArrayStack2 operStack = new ArrayStack2(10);
	//������Ҫ����ر���
	int index = 0;//����ɨ��,�ж�ɨ���λ���Ƿ�Ϊ�ַ��������λ��
	int num1 = 0;
	int num2 = 0;
	int oper = 0;//�����
	int res = 0;//���㷵�صĽ�ֵ
	char ch =' ';//��ÿ��ɨ�赽��char���浽ch
	String keepNum = "";//����ƴ�Ӷ�λ��
	//��ʼwhileѭ����ɨ��expression
	while(true) {
		//���εõ�expression��ÿһ���ַ�
		ch = expression.substring(index,index+1).charAt(0);
		//�жϽ�ȡ��ch��ʲô�����Ż������֣�������Ӧ�Ĵ���
		if(operStack.isOper(ch)) {
			//����������
			//Ҫ���жϷ���ջ�Ƿ�Ϊ��
			if(!operStack.isEmpty()) {
				//�������ջ�в�������ջ�У��ͽ������ȼ��Ƚ�
				//�����ǰ���ŵ����ȼ�С�ڵ���ջ�з��ŵ����ȼ�������Ҫ����ջ��pop��������
				//������ջ�еĽϸߵ����ȼ��ķ���pop����������ֵ������Ӧ�ļ���
				//Ȼ���ٽ�������Ľ��ѹ����ջ
				if(operStack.priority(ch) <= operStack.priority(operStack.peek())) {
					num1 = numStack.pop();
					num2 = numStack.pop();
					oper = operStack.pop();
					res = numStack.cal(num1, num2, oper);
					//������Ľ������ջ
					numStack.push(res);
					//Ȼ�󽫵�ǰ�Ĳ����������ջ
					
					//�����������ʱ������������Ҫ�ٴκ�ջ����������бȽ�
					
					if(!operStack.isEmpty()) {
						if(operStack.priority(ch) <= operStack.priority(operStack.peek())) {
							num1 = numStack.pop();
							num2 = numStack.pop();
							oper = operStack.pop();
							res = numStack.cal(num1, num2, oper);
							//������Ľ������ջ
							numStack.push(res);
							//��������ջ
							operStack.push(ch);
						}
					}else {
						//���Ϊ��ջ����ֱ����ջ
						operStack.push(ch);
					}
					
				}else {
					//�����ǰ�����������ȼ�����ջ�в����������ȼ�����ֱ����ջ
					operStack.push(ch);
				}
			}else {
				//���Ϊ��ջ����ֱ����ջ
				operStack.push(ch);
			}
		}else {
			//���Ϊ���֣���ֱ����ջ
			//numStack.push(ch - 48);
			
			//����˼·��
			/**
			 * 1.�������λ��ʱ�����ܷ�����һ������������ջ����Ϊ�����Ƕ�λ��
			 * 2.�ڴ�������ʱ����Ҫ��expression�ı��ʽ��index���ٿ�һλ��������������ƴ�ӣ�����Ƿ�������ջ 
			 * 3.�����Ҫһ������ �ַ��� ����ƴ��
			 */

			// �����λ��
			keepNum += ch;
			// ���ch�Ѿ������һλ������Ҫ�ж�
			if (index == expression.length() - 1) {
				numStack.push(Integer.parseInt(keepNum));
			} else {
				// �ж���һ���ַ��ǲ������֣�����������ɨ�裬��������������ջ
				if (operStack.isOper(expression.substring(index + 1, index + 2).charAt(0))) {
					// �����һλ�������������ջ
					numStack.push(Integer.parseInt(keepNum));
					// ��ջ������ƴ�ӵı�����Ҫ���
					keepNum = "";
				}
			}

		}
		//��index + 1 ���ж��Ƿ�ɨ�赽expression���
		index++;
		if(index >= expression.length()) {
			break;
		}
	}
	
	//�����ʽɨ����ϣ�����ջ��ֻʣһ�����ţ�������һ�γ�ջ������
		
		num1 = numStack.pop();
		num2 = numStack.pop();
		oper = operStack.pop();
		res = numStack.cal(num1, num2, oper);
		numStack.push(res);//�����ջ
	
	System.out.println("���ʽ"+expression+"�Ľ��Ϊ��"+res);
	}

}


//�ȴ���һ��ArrayStack��
class ArrayStack2{
	private int maxSize;//ջ�Ĵ�С
	private int[] stack;//���飬����ģ��ջ���ݾͷ���������
	private int top = -1;//top��ʾջ������ʼ��Ϊ-1
	
	//������
public ArrayStack2(int maxSize) {
	this.maxSize = maxSize;
	stack = new int[this.maxSize];
}

//ջ��
public boolean isFull() {
	return top == maxSize - 1;
}
//ջ��
public boolean isEmpty() {
	return top == -1;
}

//��ջ
public void push(int value) {
	//���ж�ջ�Ƿ���
	if(isFull()) {
		System.out.println("ջ�Ѿ����ˣ�");
		return;
	}
	top++;
	stack[top] = value;
}
//��ջ
public int pop() {
	//���ж�ջ�Ƿ�Ϊ��
	if(isEmpty()) {
		//�׳��쳣
		throw new RuntimeException("ջΪ�գ�����");
	}
	int value = stack[top];
	top--;
	return value;
}
//��ʾջ�����[����ջ]������ʱ����Ҫ��ջ����ʼ��ʾ����
public void list() {
	if(isEmpty()) {
		System.out.println("ջΪ�գ�û������~~~");
		return;
	}
	//��Ҫ��ջ����ʼ��ʾ����
	for(int i = top; i >= 0; i--) {
		System.out.printf("stack[%d]=%d\t",i,stack[i]);
	}
}

//��������������ȼ������ȼ��ǳ���Ա��ȷ�������ȼ�ʹ��������ȷ��
//����Խ�󣬱�ʾ���ȼ�Խ��
public int priority(int oper) {
	if(oper == '*' || oper == '/') {
		return 1;
	}else if(oper == '+' || oper == '-') {
		return 0;
	}else {
		return -1;//�ٶ�Ŀǰ�ı��ʽֻ��+��-��*��/
	}
}

//���ص�ǰջ����ֵ
public int peek() {
	return stack[top];
}

//�ж��ǲ���һ�������
public boolean isOper(char val) {
	return val == '+' || val == '-' || val == '*' || val == '/';
}

//���㷽��
public int cal(int num1,int num2,int oper) {
	int res = 0;//���ڴ�ż���Ľ��
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
