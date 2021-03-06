package elements;

public
class Stack<E> extends LinkedList<E> {
	
    public E push(E item) {
        add(item);
        return item;
    }

    public  E pop() {
        E obj;
        int len = size();
        obj = peek();
        remove(get(len - 1));
        return obj;
    }

    public  E peek() {
        int len = size();
        return get(len - 1);
    }
  
    public boolean empty() {
        return size() == 0;
    }
}