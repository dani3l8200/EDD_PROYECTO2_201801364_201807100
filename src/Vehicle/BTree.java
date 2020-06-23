/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vehicle;
import java.lang.reflect.Array;
import Vehicle.Vehicle;
import java.util.Arrays;
/**
 *
 * @author dani3l8200
 */
public class BTree <T extends Comparable<T>> {
    private static final int ORDER = 6;
	private static final int MIN_KEYS = 2;
	BTreeNode root;
        Vehicle vehicle;
	public class BTreeNode {
		int n;
                int count = -1;
             
		boolean leaf;
		BTreeNode children[];
		T[] keys;

		@SuppressWarnings("unchecked")
		BTreeNode() {
			n = 0;
                      
			leaf = true;
			keys = (T[]) new Comparable[ORDER];
			children = (BTree<T>.BTreeNode[]) Array.newInstance(BTreeNode.class, ORDER);
		}

		public boolean isFull() {
			return n == ORDER-2;
		}
                
                public boolean isFullDelete(){
                    return n == ORDER-2;
                }
                
                
                
                public int find(T k){
                  for(int i = 0; i < n; i++){
                      if(keys[i].compareTo(k) == 0){
                          return i;
                      }
                  }
                    return -1;
                }
        
                public int counter(){
                    count++;
                    return count;
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
                
                public String generateDotV2(){
                    return generateDot(counter());
                }
                
                public String generateDot(int x){
                    String graph = "";
                    String aux  = "";
                    String try2 = "";
                     aux += "node" + x;
                     graph  += aux + "[label=\"";
                    for(int i = 0; i < n; i++){
                       
                        graph += "<f"+ i + "> |" + keys[i] + "|"; 
                    }
                    
                    graph += "<f" + n + ">\"];";
                   if (!leaf) {
                    for (int i = 0; i <= n; i++){
                        x += 1;              
                        String aux2 = "";
                        aux2 += children[i].generateDot(x);
                        graph += aux2;
                        String[] intento = aux2.split("\\[label");
                        String part1 = intento[0];
                        graph +=  aux + ":f" + i + "-> "+ part1 + ";\n";
                    }
                   }
                    return graph;
                }
	
             
	}

	public BTree() {
		root = new BTreeNode();
	}

	public T search(T k) {
            
		return search(root, k);
	}
        /**
         * Este metodo fue el mas dificultoso de todos los que se realizon, 
         * Para que funcionara se ralizo un metodo llamaro find, este lo que
         * realiza es que encuentra index del nodo ingresado a eliminar esto 
         * es para encontrar a los nodos hermanos que se encuentran previamente
         * o de siguientes hay 3 tipos de formas de eliminar en el metodo una 
         * seria para child que esta contendria el nodo a eliminar mas el balanceo a 
         * realizar, estaria de la manera nextChild que este lo que realiza es ver
         * el recorrido a la derecha y el otro seria de corriendo una rama mas 
         * con el nextChild. 
        */
        private void remove(BTree<T>.BTreeNode node, T k){
            System.out.println("The n is :" + node.n);
            int aux = node.find(k);
            System.out.println("The position is:"+ aux);
            if(aux != -1){
                if(node.leaf){
                    int i = 0;
                    for(;i<node.n && node.keys[i] != k;i++){}
                    
                    for(;i < node.n; i++){
                        if(i != ORDER-2){
                            node.keys[i] = node.keys[i+1];
                        }
                    }
                    node.n--;
                    return;
                }
                if(!node.leaf){
                   BTree<T>.BTreeNode child = node.children[aux];
                   T k1;
                   if(child.n >= (MIN_KEYS+1)){
                       for(;;){
                         if(child.leaf){
                             k1 = child.keys[child.n - 1];
                             break;
                         }else{
                            child = child.children[child.n];  
                         }
                       }
                    
                       remove(child, k1);
                       node.keys[aux] = k1;
                       return;
                   }
                   
                   BTree<T>.BTreeNode nextChild = node.children[aux+1];
                   if(nextChild.n >= (MIN_KEYS +1)){
                       T k2 = nextChild.keys[0];
                       if(!nextChild.leaf){
                           nextChild = nextChild.children[0];
                           while(!nextChild.leaf){
                               nextChild = nextChild.children[nextChild.n];
                           }
                           k2 = nextChild.keys[nextChild.n - 1];
                        }
                       remove(nextChild, k2);
                       node.keys[aux] = k2;
                       return;
                    }
                   
                   
                   int tmp = child.n+1;
                   child.keys[child.n++] = node.keys[aux];
                   
                   for(int i = 0,j = child.n; i <  nextChild.n;i++){
                       child.keys[j++] = nextChild.keys[i];
                       child.n++;
                   }
                   
                   for(int i = 0; i < nextChild.n+1;i++){
                       child.children[tmp++] = nextChild.children[i];
                       nextChild.children[i] = null;
                   }
                   
                   
                    
                /*   */
                   
                   node.children[aux] = child;
                   for(int i = aux; i < node.n; i++){
                       if(i != ORDER-2){
                           node.keys[i] = node.keys[i+1];
                       }
                   }
                   for(int i = aux+1; i < node.n+1;i++){
                       if(i != ORDER-1){
                           node.children[i] = node.children[i+1];
                       }
                   }
                   
                   node.n--;
                   if(node.n == 0){
                       if(node == root){
                           root = node.children[0];
                       }
                       node = node.children[0];
                   }
                   remove(child, k);
                   return;
               }  
            }else{
                for(aux = 0; aux<node.n;aux++){
                    if(node.keys[aux].compareTo(k) > 0){
                        break;
                    }
                }
                BTree<T>.BTreeNode tmp = node.children[aux];
                if(tmp.n >= (MIN_KEYS+1) || tmp.n >= (MIN_KEYS)){
                    remove(tmp, k);
                    return;
                }
               
                    BTree<T>.BTreeNode nb = null;
                    T k3;
                    if(aux != node.n && node.children[aux+1].n >= (MIN_KEYS+1)){
                        k3 = node.keys[aux];
                        nb = node.children[aux+1];
                        node.keys[aux] = nb.keys[0];
                        tmp.keys[tmp.n++] = k3;
                        tmp.children[tmp.n] = nb.children[0];
                        
                        for(int i = 1; i< nb.n; i++){
                            nb.keys[i-1] = nb.keys[i];
                            nb.children[i-1] = nb.children[i];
                        }
                        nb.n--;
                        remove(tmp, k);
                        return;
                    }else if(aux != 0  && node.children[aux-1].n >= (MIN_KEYS+1)){
                        k3 = node.keys[aux - 1];
                        nb = node.children[aux - 1];
                        node.keys[aux - 1] = nb.keys[nb.n - 1];
                        BTree<T>.BTreeNode child = nb.children[nb.n];
                        nb.n--;
                        
                        for(int i = tmp.n; i > 0;i--){
                            tmp.keys[i] =   tmp.keys[i-1];
                        }
                        tmp.keys[0] = k3;
                        
                        for(int i = tmp.n + 1; i > 0; i--){
                            tmp.children[i] = tmp.children[i-1];
                        }
                        tmp.children[0] = child;
                        tmp.n++;
                        
                        remove(tmp, k);
                        return;
                    }else{
                        BTree<T>.BTreeNode lt, rt;
                        boolean check = false;
                        
                        if(aux != node.n){
                            k3 = node.keys[aux];
                            lt = node.children[aux];
                            rt = node.children[aux +1];
                        }else{
                            k3 = node.keys[aux - 1];
                            rt = node.children[aux];
                            lt = node.children[aux - 1];
                            check = true;
                            aux--;
                        }
                        
                        for(int i = aux; i < node.n - 1; i++){
                            node.keys[i] = node.keys[i+1];
                        }
                        for(int i = aux + 1; i < node.n; i++){
                           node.children[i] = node.children[i+1]; 
                        }
                        node.n--;
                        lt.keys[lt.n++] = k3;
                        
                        for(int i = 0,j = lt.n;i< rt.n +1;i++,j++){
                            if(i < rt.n)
                                lt.keys[j] = rt.keys[i];
                            lt.children[j] = rt.children[i];
                        }
                        lt.n += rt.n;
                        if(node.n == 0){
                            if(node == root)
                                root = node.children[0];
                            node = node.children[0];
                                
                        }
                        remove(lt, k);
                        return;
                    }
                
            }
        
        }
        
      
        public void Delete(T k){
            remove(root, k);
        }

        
        
	private T search(BTreeNode node, T k) {
		int i = 0;
		while (i < node.n) {
			int cmp = node.keys[i].compareTo(k);
			if (cmp == 0) {
                            System.out.println(node.find(k));
				return node.keys[i];
			} else if (cmp > 0) {
				break;
			}
                    i++;
		}
		if (node.leaf) {
			return null;
		}
                
		return search(node.children[i], k);
	}
       
       
        public String GenerateReportTreeB(){
            if(root.n != 0){
                String graph = "digraph btree {\n"
                             + "rankdir=TB;\n"
                             + "graph[fontcolor=white, bgcolor=black, color=white];\n"
                             + "node[style=filled, fillcolor=lemonchiffon1, shape=record, height=.1];\n"
                             + "edge[color=white];\n"
                             + root.generateDotV2()
                             +  "}";
                return graph;
            }
            return null;
        }
        
	/*
	 * B-Tree-Insert (T, k) r = root[T] if n[r] = 2t - 1 then 
	 * // si la raiz esta llena, tenemos que dividirlo s = allocate-node () root[T] = s 
	 * // el no nueva raiz cambia su estado de leaf[s] = False // tendra algunos children n[s] = 0 // por ahora c1[s] = r 
	 * // el child es el viejo nodo raiz B-Tree-Split-Child (s, 1, r) 
	 * // r es dividido B-Tree-Insert-Nonfull (s, k) 
	 * // s no esta lleno else B-Tree-Insert-Nonfull (r, k) endif
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
                      // insertNonFull(s, k);
		} else {
			insertNonFull(r, k);
		}
	}

	/*
	 * B-Tree-Insert-Nonfull (x, k) i = n[x]
	 * 
	 * if leaf[x] then
	 * 
	 * // desplazar todo a la "right" hasta el punto donde debe ir la nueva key k
	 * 
	 * 
	 * while i >= 1 and k < keyi[x] do keyi+1[x] = keyi[x] i-- end while
	 * 
	 * //pegue k en su lugar correcto y se sube n[k]
	 * 
	 * keyi+1[x] = k n[x]++ else
	 * 
	 * // buscar child donde pertenece la nueva key:
	 * 
	 * while i >= 1 and k < keyi[x] do i-- end while
	 * 
	 * // si k está en ci[x], entonces k <= keyi[x] (de la definición) 
	 * // volveremos a la última key (menos i) donde encontramos esto
	 * // para ser verdad, luego lea en ese nodo child.
	 * 
	 * i++ Disk-Read (ci[x]) if n[ci[x]] = 2t - 1 then
	 * 
	 * // si el nodo child está lleno, tendremos que dividirlo
	 * 
	 * B-Tree-Split-Child (x, i, ci[x])
	 * 
	 * // ahora ci [x] y ci+1[x] son los nuevos childs,
	 * // y keyi[x] puede haber sido cambiado. 
	 * // Veremos si k pertenece en el primero o el segundo.
	 * if k > keyi[x] then i++ end if
	 * 
	 * // llamamos de manera recursivamente de nuevo para hacer la inserción
	 * 
	 * B-Tree-Insert-Nonfull (ci[x], k) end if
	 */

	private void insertNonFull(BTree<T>.BTreeNode node, T k) {
		int i = node.n-1;
		if (node.leaf) {

                        for(;i>=0 && k.compareTo(node.keys[i]) < 0; i--){
                     
                            node.keys[i + 1] = node.keys[i];
                        }
                        
                        // is god
			node.keys[i + 1] = k;
			node.n++;
		} else {
                   
                        for(; i>= 0 && k.compareTo(node.keys[i]) < 0 ;i--){}
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

	/*
	 * B-Tree-Split-Child (x, i, y) z = allocate-node ()
	 * 
	 * // nuevo nodo es una leaf si el antiguo nodo era
	 * 
	 * leaf[z] = leaf[y]
	 * 
	 * // ya que 'y' está lleno, el nuevo nodo debe tener claves t-1
	 * 
	 * n[z] = t - 1
	 * 
	 * // copia sobre la "mitad derecha" de 'y' en 'z'
	 * 
	 * para j en 1..t-1 do keyj [z] = keyj + t [y] finaliza 
	 * 
	 * // copia sobre los child secundarios si 'y' no es una leaf
	 * 
	 * si no leaf[y] entonces para j en 1..t cj [z] = cj + t [y] final para finalmente
	 * 
	 * // habiendo "cortado" la mitad derecha de y, ahora tiene t-1 keys
	 * 
	 * n[y] = t - 1
	 * 
	 * //cambia todo en x desde i + 1, luego pega el nuevo child en x;  
	 * // 'y' tendrá la mitad de su ser anterior como ci [x] yz lo hará
	 * // ser la otra mitad como ci + 1 [x]
	 * //para j en n [x] +1 hasta i + 1 a cj + 1 [x] = cj [x] final para ci + 1 = z
	 * 
	 * // las keys también deben ser cambiadas ...
	 * 
	 * para j en n[x] hasta i a keyj + 1 [x] = keyj [x] final para ... 
         * para acomodar la nueva key que estamos trayendo desde el medio de y
	 * (si se está preguntando, ya que (t-1) + (t-1) = 2t-2, donde fue la otra key, está entrando en x)
	 * 
	 * 
	 * keyi[x] = keyt[y] n[x]++
	 * 
	 * // escribir todo en el disco
	 * 
	 * Escritura en disco (y) Escritura en disco (z) Escritura en disco (x)
         */

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
		*/
        BTree<Vehicle> tree = new BTree<Vehicle>();
	
       Vehicle s = new Vehicle("XA19291", "Toyota","Corolla", 2005, "Negro", 2845.05,"Automatico");
        Vehicle s1 = new Vehicle("BA1321", "Toyota","Corolla", 2005, "Negro", 2845.05,"Automatico");
        Vehicle s2 = new Vehicle("DA1321", "Toyota","Corolla", 2005, "Negro", 2845.05,"Automatico");
        Vehicle s3 = new Vehicle("CA1321", "Toyota","Corolla", 2005, "Negro", 2845.05,"Automatico");
        Vehicle s4 = new Vehicle("WA1321", "Toyota","Corolla", 2005, "Negro", 2845.05,"Automatico");
        Vehicle s5 = new Vehicle("QA1321", "Toyota","Corolla", 2005, "Negro", 2845.05,"Automatico");
        Vehicle s6 = new Vehicle("AQ9102", "Toyota","Corolla", 2005, "Negro", 2845.05,"Automatico");
        Vehicle s7 = new Vehicle("AC9102", "Toyota","Corolla", 2005, "Negro", 2845.05,"Automatico");
        Vehicle s8 = new Vehicle("AD9102", "Toyota","Corolla", 2005, "Negro", 2845.05,"Automatico");
                tree.insert(s);
                tree.insert(s1);
                  tree.insert(s2);
                    tree.insert(s3);
                      tree.insert(s4);
                        tree.insert(s5);
                         tree.insert(s6);
                         tree.insert(s7);
                         tree.insert(s8);
                         tree.Delete(s3);
                        
                       System.out.println( tree.GenerateReportTreeB());;
	}
	
}
