package elements;

public class LinkedList<E> {
	int size = 0;

	Node<E> first;

	Node<E> last;

	public boolean isEmpty() {//�п�
		return size == 0;
	}

	public boolean contains(Object o) {//�ж��Ƿ������Ԫ��
		return indexOf(o) != -1;
	}

	public int size() {//Ԫ�ظ���
		return size;
	}

	public E get(int index) {//��ȡ�±��Ӧ�Ľڵ��е�Ԫ��
		return node(index).item;
	}

	private E unlink(Node<E> x) {//�Ƴ��ýڵ�
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

	public boolean add(E e) {//����ڵ�
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

	public E remove(int index) {//�Ƴ�ָ���±�ڵ�
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
	
	private Node<E> node(int index) {//���������±��Ӧ�ڵ�
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

	public int indexOf(Object o) {//����Ԫ���±�
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

	public E remove() {//ɾ������Ԫ��
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

	private static class Node<E> {//�ڵ㶨��
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
