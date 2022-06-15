public class Map<Key extends Comparable<Key>, Value, E>{			//тип ключа, тип значения, тип компаратора
	private Node root;							//корень дерева
	
	private static final boolean RED = true;
	private static final boolean BLACK = false;
	
	private class Node{							//узел
		Key key;
		Value val;
		Node left, right;						//левый и правый сыны
		int n;
		boolean color;

		Node(Key key, Value val, int n, boolean color){			//копирующий оператор присваивания
			this.key = key;
			this.val = val;
			this.n = n;
			this.color = color;
		}
	}
	private interface Comparator<E>{					//функтор компаратор
    		int compare(E a, E b);
	} 
	
	private class KeyComparator implements Comparator<Key>{
		public int compare(Key a, Key b){
			return a.compareTo(b);
		}
	}

	private boolean isRed(Node x){						//проверка цвета
		if(x==null)
			return false;
		return x.color == RED;
	}

	private Node rotateLeft(Node h){					//вращение влево
		Node x = h.right;
		h.right = x.left;
		x.left = h;
		x.color = h.color;
		h.color = RED;
		x.n = h.n;
		h.n = 1 + size(h.left) + size(h.right);
		return x;
	}
	
	private Node rotateRight(Node h){					//вращение вправо
		Node x = h.left;
		h.left = x.right;
		x.right = h;
		x.color = h.color;
		h.color = RED;
		x.n = h.n;
		h.n = 1 + size(h.left) + size(h.right);
		return x;
	}

	public boolean isEmpty(){						//метод проверки на пустоту
                return size(root) == 0;
        }

	public int size(){							//размер
		return size(root);
	}

	private int size(Node x){
		if(x==null)
			return 0;
		else
			return x.n;
	}

	public void delAll(){							//удалить все элементы
		root=null;
	}

	void flipColors(Node h){						//смена цветов
		h.color = RED;
		h.left.color = BLACK;
		h.right.color = BLACK;
	}

	public void put(Key key, Value val){					//добавление пары ключ-значение
		root = put(root, key, val);
		root.color = BLACK;
	}

	private Node put(Node h, Key key, Value val){
		if(h==null)
			return new Node(key,val,1,RED);
		KeyComparator kcomp = new KeyComparator();
		int cmp = kcomp.compare(key, h.key);
		if(cmp<0)
			h.left = put(h.left,key,val);
		else if(cmp>0)
			h.right = put(h.right, key, val);
		else
			h.val = val;
		if(isRed(h.right) && !isRed(h.left))
			h=rotateLeft(h);
		if(isRed(h.left) && !isRed(h.left.left))
			h=rotateRight(h);
		if(isRed(h.left) && isRed(h.right))
			flipColors(h);
		h.n = size(h.left) + size(h.right) + 1;
		return h;
	}

	public Value get(Key key){						//получить значение по ключу
		return get(root,key);
	}

	private Value get(Node x, Key key){
		if(x==null)
			return null;
		KeyComparator kcomp = new KeyComparator();
		int cmp = kcomp.compare(key, x.key);
		if(cmp<0)
			return get(x.left, key);
		else if(cmp>0)
			return get(x.right, key);
		else
			return x.val;
	}
}
