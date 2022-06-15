class Main{
	public static void main(String[] args){
		Map<Integer, String, Integer> m = new Map<Integer, String, Integer>();	//здесь ключ - целочисленное, значение - строковое, тип критерия сравнения - целочисленный
		System.out.println("(1) Изначально было:");
		m.put(1,"a");
		m.put(2,"b");
		m.put(3,"c");
		int i = 1;
		System.out.println("Size: " + m.size());
		while(i<=m.size()){
			System.out.println(m.get(i));
			i++;
		}

		System.out.println("(2) Стало после изменения по ключу:");
		m.put(3,"d");
		m.put(4,"e");
		m.put(4,"f");
		System.out.println("Size: " + m.size());
		i = 1;
		while(i<=m.size()){
			System.out.println(m.get(i));
			i++;
		}

		System.out.println("(3) Как работает итератор:");
		Help h = new Help(m);
		myIterator iter = h.getIterator();
		while(iter.hasNext()){
			System.out.println(iter.next());
		}

		System.out.println("(4) После удаления всех элементов");
		m.delAll();
		System.out.println("Size: " + m.size());
		i = 1;
		while(i<=m.size()){
			System.out.println(m.get(i));
			i++;
		}
	}
}
