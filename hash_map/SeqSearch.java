import java.util.ArrayList;

public class SeqSearch<Key,Value>{
	private int N;
	private Node first;
	private class Node{
		Key key;
		Value val;
		Node next;
		
		public Node(Key key, Value val, Node next){
			this.key = key;
			this.val = val;
			this.next = next;
		}
	}
	
	public int size(){
		return N;
	}

	public Value get(Key key){
		for(Node x = first; x != null; x = x.next){
			if(key.equals(x.key))
				return x.val;
		}
		return null;
	}

	public void put(Key key, Value val){
		if (key == null)
			return; 
        	if (val == null){
            		delete(key);
            		return;
        	}

		for(Node x = first; x != null; x = x.next){
			if(key.equals(x.key)){
				x.val = val;
				return;
			}
		}
		first = new Node(key, val, first);
		N++;
	}

	public void delete(Key key){
        	if (key == null)
			return; 
        	first = delete(first, key);
    	}

	private Node delete(Node x, Key key){
        	if (x == null)
			return null;
        	if (key.equals(x.key)){
            		N--;
            		return x.next;
        	}
        	x.next = delete(x.next, key);
        	return x;
    	}
	
	public boolean contains(Key key){
        	return get(key) != null;
    	}

	public void delAll(){
		first = null;
	}

	public Iterable<Key> keys(){
        	ArrayList<Key> queue = new ArrayList<Key>();
        		for (Node x = first; x != null; x = x.next)
            			queue.add(x.key);
        	return queue;
    	}
}
