class Main{
	public static void main(String[] args){
		HashMap<Integer, Integer> h = new HashMap<Integer, Integer>();
		h.put(1, 1);
		h.put(2, 2);
		h.put(3, 3);
		h.put(4, 4);
		h.put(5, 5);
		h.put(6, 6);
		h.put(7, 7);
		h.put(8, 8);
		h.put(9, 9);
		h.put(10, 10);
		h.put(11, 11);
		h.put(11, 12);										//ключу 11 соответствует значение 12
		System.out.println();
		System.out.println("1) После того, как добавили элементы:");
		System.out.println("Всего элементов = " + h.size());
		System.out.println("Коэф. по умолчанию = " + h.getCoef());
		System.out.println("Нагрузка на данный момент = " + h.nowCoef());
		for(int i = 0; i<h.size(); i++)
			System.out.println(h.get(i+1));
		System.out.println();
		h.delete(11);
		System.out.println("2) После того, как удалили ключ 11:");
		System.out.println("Всего элементов = " + h.size());
		System.out.println("Коэф. по умолчанию = " + h.getCoef());
		System.out.println("Нагрузка на данный момент = " + h.nowCoef());
		for(int i = 0; i<h.size(); i++)
			System.out.println(h.get(i+1));
		System.out.println();
		h.changeCoef(5.0);
		System.out.println("3) После того, как изменили коэф. по умолчанию на 5.0:");
		System.out.println("Всего элементов = " + h.size());
		System.out.println("Коэф. по умолчанию = " + h.getCoef());
		System.out.println("Нагрузка на данный момент = " + h.nowCoef());
		for(int i = 0; i<h.size(); i++)
			System.out.println(h.get(i+1));
		System.out.println();
		h.delAll();
		System.out.println("4) После того, как все элементы:");
		System.out.println("Всего элементов = " + h.size());
		System.out.println("Коэф. по умолчанию = " + h.getCoef());
		System.out.println("Нагрузка на данный момент = " + h.nowCoef());
		for(int i = 0; i<h.size(); i++)
			System.out.println(h.get(i+1));
	}
}
