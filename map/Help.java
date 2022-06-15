public class Help implements myContainer{					//реализация итератора
	Map m = new Map();

	public Help(Map m){							//копирующий конструктор присваивания (экземпляр класса Map пригодится далее)
		this.m = m;
	}

   	public myIterator getIterator(){					//реализация интерефейса myContainer
		return new NameIterator(m);
   	}

   	private class NameIterator implements myIterator{
		int i = 0;
		Map m = new Map();

		public NameIterator(Map m){
			this.m = m;
		}
										//реализация интерфейса myInterator

		public boolean hasNext(){					//проверка наличия элемента
         		if(i < m.size())
            			return true;
         		return false;
      		}

      		public Object next(){						//если элемент имеется, он будет передан (вернется)
         		if(this.hasNext())
            			return m.get(++i);
         		return null;
      		}
  	 }
}
