class Priorit<Type extends Comparable<Type>>{
        private Type[] pq;
        private int n = 0;
        private int max = 1;

        public Priorit(){							//конструктор
                pq = (Type[]) new Comparable[max];
        }

        public boolean isEmpty(){						//метод проверки на пустоту
                return n == 0;
        }

        public int size(){							//число элементов
                return n;
        }

        public void add(Type el){						//добавить элемент
		if(n+1==max){
			Type[] newpq = (Type[]) new Comparable[max];		//расширение массива
			for(int i=1;i<=n;i++)
				newpq[i]=pq[i];
			max=max*2;
			pq=(Type[]) new Comparable[max];
			for(int i=1; i<=n; i++)
				pq[i]=newpq[i];	
		}
                pq[++n] = el;
                swim(n);
        }

        public Type delMax(){							//получить больший элемент и удалить
                Type max = pq[1];
                change(1, n--);
                pq[n+1] = null;
                sink(1);
                return max;
        }

        private boolean less(int i, int j){					//доп.методы
                return pq[i].compareTo(pq[j])<0;
        }

        private void change(int i, int j){
                Type t = pq[i];
                pq[i] = pq[j];
                pq[j]=t;
        }

        private void swim(int k){
                while(k>1 && less(k/2, k)){
                        change(k/2, k);
                        k=k/2;
                }
        }

        private void sink(int k){
                while(2*k<=n){
			int j = 2*k;
                        if(j<size() && less(j, j+1))
                                j++;
                        if(!less(k, j))
                                break;
                        change(k, j);
                        k=j;
                }
        }

        public void print(){							//вывести на экран пирамиду
                boolean a = isEmpty();
                if(a == false){
                        int size = pq.length;
                        for(int i=1;i<size;i++)
                                System.out.print(pq[i] + " ");
                }
                else{
                        System.out.println("Empty!");
                }
        }
}


