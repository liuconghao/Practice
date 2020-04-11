package elements;

public class LinkedList<E> {
	int size = 0;

	Node<E> first;

	Node<E> last;

	public boolean isEmpty() {//判空
		return size == 0;
	}

	public boolean contains(Object o) {//判断是否包含该元素
		return indexOf(o) != -1;
	}

	public int size() {//元素个数
		return size;
	}

	public E get(int index) {//获取下标对应的节点中的元素
		return node(index).item;
	}

	private E unlink(Node<E> x) {//移除该节点
		E element = x.item;
		Node<E> next = x.next;
		Node<E> prev = x.prev;

		if (prev == null) {
			first = next;
		} else {
			prev.next = next;
			x.prev = null;
		}

		if (next == null) {
			last = prev;
		} else {
			next.prev = prev;
			x.next = null;
		}

		x.item = null;
		size--;
		return element;
	}

	public boolean remove(Object o) {
		if (o == null) {
			for (Node<E> x = first; x != null; x = x.next) {
				if (x.item == null) {
					unlink(x);

					return true;
				}
			}
		} else {
			for (Node<E> x = first; x != null; x = x.next) {
				if (o.equals(x.item)) {
					unlink(x);
					return true;
				}
			}
		}
		return false;
	}

	public boolean add(E e) {//插入节点
		Node<E> l = last;
		Node<E> newNode = new Node<>(l, e, null);
		last = newNode;
		if (l == null)
			first = newNode;
		else
			l.next = newNode;
		size++;
		return true;
	}

	public E remove(int index) {//移除指定下标节点
		 E element = node(index).item;
	     Node<E> next = node(index).next;
	     Node<E> prev = node(index).prev;
	        if (prev == null) {
	            first = next;
	        } else {
	            prev.next = next;
	            node(index).prev = null;
	        }

	        if (next == null) {
	            last = prev;
	        } else {
	            next.prev = prev;
	            node(index).next = null;
	        }
	       // node(index).item = null;
	        size--;
	        return element;
	}
	
	private Node<E> node(int index) {//二分搜索下标对应节点
		if (index < (size >> 1)) {
			Node<E> x = first;
			for (int i = 0; i < index; i++)
				x = x.next;
			return x;
		} else {
			Node<E> x = last;
			for (int i = size - 1; i > index; i--)
				x = x.prev;
			return x;
		}
	}

	public int indexOf(Object o) {//查找元素下标
		int index = 0;
		if (o == null) {
			for (Node<E> x = first; x != null; x = x.next) {
				if (x.item == null)
					return index;
				index++;
			}
		} else {
			for (Node<E> x = first; x != null; x = x.next) {
				if (o.equals(x.item))
					return index;
				index++;
			}
		}
		return -1;
	}

	public E remove() {//删除队首元素
		Node<E> f = first;
		E element = f.item;
		Node<E> next = f.next;
		f.item = null;
		f.next = null;
		first = next;
		if (next == null)
			last = next;
		else
			next.prev = null;
		size--;
		return element;
	}

	private static class Node<E> {//节点定义
		E item;
		Node<E> next;
		Node<E> prev;

		Node(Node<E> prev, E element, Node<E> next) {
			this.item = element;
			this.next = next;
			this.prev = prev;
		}
	}
}
