import java.util.ArrayList;

public class HashMap<Key, Value>{
	private int N;								//число элементов
	private int M;								//размер хеш-таблицы
	private double a = 2.0;							//вещественный коэффициент
	private SeqSearch<Key, Value>[] st;					//массив элементов SeqSearch (где хранятся элементы)

	public HashMap(){
		this(5);							//изначально размер хеш-таблицы равен 5 (далее, из-за resize он может расти)
	}

	public HashMap(int M){
		this.M = M;
		st = (SeqSearch<Key, Value>[]) new SeqSearch[M];
		for(int i = 0; i<M; i++)
			st[i] = new SeqSearch<Key, Value>();
	}

	public int size(){							//число пар
		return N;
	}
	
	private int hash(Key key){				
		return (key.hashCode() & 0x7fffffff) % M;
	}

	public Value get(Key key){						//получить значение по ключу
		return (Value) st[hash(key)].get(key);
	}

	public void put(Key key, Value val){					//добавить пару
		if (key == null)
			return;
        	if (val == null){
            		delete(key);
            		return;
        	}

		if((double)N/M>=a){
			resize(2*M+1);			
		}

		if(st[hash(key)].contains(key)){
			st[hash(key)].put(key, val);
		}
		else{
			N++;
			st[hash(key)].put(key, val);
		}
	}
	
	public boolean contains(Key key){					//проверка ключа
        	return get(key) != null;
    	}

	public void delete(Key key){						//удаление по ключу
        	if (key == null)
			return;
        	int i = hash(key);
        	if (st[i].contains(key))
			N--;
        	st[i].delete(key);
	}

	public void delAll(){							//удалить все элементы
		st[0].delAll();
		N=0;
	}

	public double getCoef(){						//получить вещественный коэффициент (коэффициент по умолчанию)
		return a;
	}

	public void changeCoef(double a){					//изменить коэффициент
		this.a = a;
		if(nowCoef()>=this.a)
			resize(2*M+1);
	}

	public double nowCoef(){						//загруженность
		return (double)N/M;
	}
		
	private void resize(int chains){					//перехеширование
        	HashMap<Key, Value> temp = new HashMap<Key, Value>(chains);
        	for (int i = 0; i < M; i++) {
            		for (Key key : st[i].keys()){
                		temp.put(key, st[i].get(key));
			}
            	}
        	this.M  = temp.M;
		this.N  = temp.N;
        	this.st = temp.st;
    	}

   	public Iterable<Key> keys(){
        	ArrayList<Key> queue = new ArrayList<Key>();
        	for (int i = 0; i < M; i++){
            		for (Key key : st[i].keys())
                		queue.add(key);
        	}
        	return queue;
    	}
}
