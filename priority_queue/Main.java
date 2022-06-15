/*Ubuntu 18.04
 *javac 11.0.13
 *RAM 4GB
 
javac Main.java -Xlint
java Main*/

class Main{
	public static void main(String[] args){
		Priorit<Integer> p = new Priorit<Integer>();
		p.add(7);
		p.add(2);
		p.add(3);
		p.add(9);
		p.add(1);
		int i = 1;
		while(p.isEmpty() == false){
			System.out.println("Прогон номер " + i + ":");
			p.print();
			System.out.println();
			System.out.println("Всего элементов на данный момент: " + p.size());
			System.out.println("Самый большой элемент перед удалением: " + p.delMax());
			i++;
			System.out.println("\n");
		}
	}
}
