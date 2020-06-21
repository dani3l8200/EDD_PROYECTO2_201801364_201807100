/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vehicle;
import java.lang.reflect.Array;
/**
 *
 * @author dani3l8200
 */
public class BTree <T extends Comparable<T>> {
    private static final int ORDER = 5;
	private static final int MIN_KEYS = 2;
	BTreeNode root;

	public class BTreeNode {
		int n;
                int count;
             
		boolean leaf;
		BTreeNode children[];
		T[] keys;

		@SuppressWarnings("unchecked")
		BTreeNode() {
			n = 0;
                        count = 0;
			leaf = true;
			keys = (T[]) new Comparable[ORDER];
			children = (BTree<T>.BTreeNode[]) Array.newInstance(BTreeNode.class, ORDER);
		}

		public boolean isFull() {
			return n == ORDER-1;
		}
                
                
                
             
         
	
                @Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append("{\"keys\":[");
			String sep = "";
			for (int i = 0; i < n; i++) {
				sb.append(sep);
				sb.append(keys[i]);
				sep = ",";
			}
			sb.append("]");
			if (!leaf) {
				sb.append(", \"children\":[");
				 sep = "";
				for (int i = 0; i <= n; i++) {
					sb.append(sep);
					sb.append(children[i]);
					sep = ",";
				}
				sb.append("]");
			}
			sb.append("}");

			return sb.toString();
		}
	
             
	}

	public BTree() {
		root = new BTreeNode();
	}

	public T search(T k) {
		return search(root, k);
	}

	private T search(BTreeNode node, T k) {
		int i = 0;
		while (i < node.n) {
			int cmp = node.keys[i].compareTo(k);
			if (cmp == 0) {
				return node.keys[i];
			} else if (cmp > 0) {
				break;
			}
		}
		if (node.leaf) {
			return null;
		}
		return search(node.children[i], k);
	}

	/*
	 * B-Tree-Insert (T, k) r = root[T] if n[r] = 2t - 1 then // uh-oh, the root is
	 * full, we have to split it s = allocate-node () root[T] = s // new root node
	 * leaf[s] = False // will have some children n[s] = 0 // for now c1[s] = r //
	 * child is the old root node B-Tree-Split-Child (s, 1, r) // r is split
	 * B-Tree-Insert-Nonfull (s, k) // s is clearly not full else
	 * B-Tree-Insert-Nonfull (r, k) endif
	 */

	public void insert(T k) {
		BTree<T>.BTreeNode r = root;
		if (r.isFull()) {
                        insertNonFull(r, k);
			BTreeNode s = new BTreeNode();
                        
			s.children[0] = r;
			s.leaf = false;
			 root = s;

			splitChild(s, 0, r);
			System.out.println("SplitChild" + s);
			//insertNonFull(s, k);
		} else {
			insertNonFull(r, k);
		}
	}

	

	private void insertNonFull(BTree<T>.BTreeNode node, T k) {
		
		if (node.leaf) {
                    int i = 0;
                        for(i =  node.n-1;i>=0 && k.compareTo(node.keys[i]) < 0; i--){
                     
                            node.keys[i + 1] = node.keys[i];
                        }
                        
                        // is god
			node.keys[i + 1] = k;
			node.n++;
		} else {
                    int i  = 0;
                        for(i =  node.n-1; i>= 0 && k.compareTo(node.keys[i]) < 0 ;i--){}
			i++;
			BTree<T>.BTreeNode child = node.children[i];
			if (child.isFull()) {
                             insertNonFull(node.children[i], k);
				splitChild(node, i, child);
				if (k.compareTo(node.keys[i]) > 0) {
					i++;
				}
			}else{
                            insertNonFull(node.children[i], k);
                        }
		}

	}

	

	private void splitChild(BTreeNode x, int i, BTreeNode y) {
		BTreeNode z = new BTreeNode();
		z.leaf = y.leaf;
		z.n = MIN_KEYS;

		for (int j = 0; j < MIN_KEYS; j++) {
                    
			z.keys[j] = y.keys[j + MIN_KEYS+1];
                      
                    
                   
		}

		if (!y.leaf) {
			for (int j = 0; j <= z.n +1; j++) {
				z.children[j] = y.children[j + MIN_KEYS+1];
			}
		}
		y.n = MIN_KEYS;

		for (int j = x.n; j >= i + 1; j--) {
			x.children[j + 1] = x.children[j];
		}
		x.children[i + 1] = z;
		for (int j = x.n - 1; j >= i; j--) {
			x.keys[j + 1] = x.keys[j];
		}
		x.keys[i] = y.keys[MIN_KEYS];
                
		x.n++;
	}

       
	@Override
	public String toString() {
		return root.toString();
	}
        
        public static void main(String[] args) {
	/*	BTree<Vehicle> tree = new BTree<Vehicle>();
		Vehicle s = new Vehicle("XA19291", "Toyota","Corolla", 2005, "Negro", 2845.05,"Automatico");
                Vehicle s1 = new Vehicle("BA1321", "Toyota","Corolla", 2005, "Negro", 2845.05,"Automatico");
                  Vehicle s2 = new Vehicle("DA1321", "Toyota","Corolla", 2005, "Negro", 2845.05,"Automatico");
                    Vehicle s3 = new Vehicle("CA1321", "Toyota","Corolla", 2005, "Negro", 2845.05,"Automatico");
                      Vehicle s4 = new Vehicle("WA1321", "Toyota","Corolla", 2005, "Negro", 2845.05,"Automatico");
                        Vehicle s5 = new Vehicle("QA1321", "Toyota","Corolla", 2005, "Negro", 2845.05,"Automatico");
                tree.insert(s);
                tree.insert(s1);
                  tree.insert(s2);
                    tree.insert(s3);
                      tree.insert(s4);
                        tree.insert(s5);*/
        BTree<Integer> tree = new BTree<Integer>();
		
			tree.insert(1);
                        tree.insert(9);
                        tree.insert(32);
                        tree.insert(3);
                        tree.insert(53);
                        tree.insert(43);
                        tree.insert(44);
                        tree.insert(57);
                       tree.insert(67);
                       tree.insert(7);
                        tree.insert(45);
                        tree.insert(34);
                        tree.insert(23);
                        tree.insert(12);
                
                      
                System.out.println(tree);
	}
	
}
