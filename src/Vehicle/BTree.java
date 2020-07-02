/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vehicle;
import com.itextpdf.text.BaseColor;
import java.lang.reflect.Array;
import java.util.Arrays;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import java.awt.Desktop;
import java.awt.Font;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
/**
 *
 * @author dani3l8200
 * @param <T>
 */
public class BTree <T extends Comparable<T>> {
    private static final int ORDER = 6;
	private static final int MIN_KEYS = 2;
        private static final PdfPTable tabla = new PdfPTable(new float[]{7,20,20,20,20,20,20,20});
        private static PdfPCell  titleCell;
        private static Paragraph column1,column2,column3,column4,column5,column6,column7,column8,
                                  data1,data2,data3,data4,data5,data6,data7,data8;
        private static int counterPDF = 1;
	BTreeNode root;
        Vehicle vehicle;
	public class BTreeNode {
		int n;
		boolean leaf;
		BTreeNode children[];
		T[] keys;

		@SuppressWarnings("unchecked")
		BTreeNode() {
			n = 0;
                      
			leaf = true;
			keys = (T[]) new Comparable[ORDER-1];
			children = (BTree<T>.BTreeNode[]) Array.newInstance(BTreeNode.class, ORDER);
		}

		public boolean isFull() {
			return n == ORDER-1;
		}
                
                
                
                
                public int find(T k){
                  for(int i = 0; i < n; i++){
                      if(keys[i].compareTo(k) == 0){
                          return i;
                      }
                  }
                    return -1;
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
                
               public void traverse() {
                    String[] test;
                    int i = 0;
                    
                    for (; i < n; i++) {
                        if(leaf == false)
                          children[i].traverse();
                       test = keys[i].toString().split("\\\\n");
                       data1 = new Paragraph(Integer.toString(counterPDF),FontFactory.getFont(FontFactory.TIMES_ROMAN,12,Font.BOLD));
                       data2 = new Paragraph(test[0],FontFactory.getFont(FontFactory.TIMES_ROMAN,12,Font.BOLD));
                       data3 = new Paragraph(test[1],FontFactory.getFont(FontFactory.TIMES_ROMAN,12,Font.BOLD));
                       data4 = new Paragraph(test[2],FontFactory.getFont(FontFactory.TIMES_ROMAN,12,Font.BOLD));
                       data5 = new Paragraph(test[3],FontFactory.getFont(FontFactory.TIMES_ROMAN,12,Font.BOLD));
                       data6 = new Paragraph(test[4],FontFactory.getFont(FontFactory.TIMES_ROMAN,12,Font.BOLD));
                       data7 = new Paragraph(test[5],FontFactory.getFont(FontFactory.TIMES_ROMAN,12,Font.BOLD));
                       data8 = new Paragraph(test[6],FontFactory.getFont(FontFactory.TIMES_ROMAN,12,Font.BOLD));
                        tabla.addCell(data1);
                        tabla.addCell(data2);
                        tabla.addCell(data3);
                        tabla.addCell(data4);
                        tabla.addCell(data5);
                        tabla.addCell(data6);
                        tabla.addCell(data7);
                        tabla.addCell(data8);
                       counterPDF++;
                    }
                     if (!leaf) 
			   children[i].traverse();
                     
                   
                }
                
                public String generateDot(){
                    String graph = "";
                
                   
                     graph  += "node" + keys[0].hashCode() + "[label=\"";
                    for(int i = 0; i < n; i++){
                       
                        graph += "<f"+ i + "> |" + keys[i] + "|"; 
                    }
                    
                    graph += "<f" + n + ">\"];\n\t";
                 
                    for (int i = 0; i <= n; i++){
                        if(children[i] == null)
                            continue;
                          graph += children[i].generateDot();
                       
                       
                          graph +=  "node" + keys[0].hashCode() + ":f" + i + "-> node"+ children[i].keys[0].hashCode() + ";\n";
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
        
        
         public void generarPDF(){
            String RutaEDD = System.getProperty("user.dir") + "\\" + "TablaVehiculos" + ".pdf";
            try {
                counterPDF = 1;
                FileOutputStream archivo = new FileOutputStream(RutaEDD);
                File Archivo = new File(RutaEDD);
                Document doc = new Document();
                PdfWriter.getInstance(doc, archivo);
                doc.open();
                doc.add(new Paragraph("Vehicles",FontFactory.getFont(FontFactory.HELVETICA,20,BaseColor.RED)));
                doc.add(new Paragraph(new SimpleDateFormat("dd-MM-yyyy HH:mm").format(new Date())));
                doc.add(new Paragraph("----------------------------------------------------------------------------------------------------------------------------------"));
                tabla.setWidthPercentage(100);
                titleCell = new PdfPCell(new Paragraph("Table Vehicles"));
                titleCell.setColspan(8);
                titleCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                titleCell.setBackgroundColor(BaseColor.LIGHT_GRAY);
                tabla.deleteBodyRows();
                tabla.addCell(titleCell);
                column1 = new Paragraph( "ID",FontFactory.getFont(FontFactory.TIMES_ROMAN,14,Font.BOLD,BaseColor.BLUE));         
                column2 = new Paragraph( "License Plate",FontFactory.getFont(FontFactory.TIMES_ROMAN,14,Font.BOLD,BaseColor.BLUE));
                column3 = new Paragraph("Brand",FontFactory.getFont(FontFactory.TIMES_ROMAN,14,Font.BOLD,BaseColor.BLUE));
                column4 = new Paragraph("Model",FontFactory.getFont(FontFactory.TIMES_ROMAN,14,Font.BOLD,BaseColor.BLUE));
                column5 = new Paragraph("Year",FontFactory.getFont(FontFactory.TIMES_ROMAN,14,Font.BOLD,BaseColor.BLUE));
                column6 = new Paragraph("Color",FontFactory.getFont(FontFactory.TIMES_ROMAN,14,Font.BOLD,BaseColor.BLUE));
                column7 = new Paragraph("Price",FontFactory.getFont(FontFactory.TIMES_ROMAN,14,Font.BOLD,BaseColor.BLUE));
                column8 = new Paragraph("Type",FontFactory.getFont(FontFactory.TIMES_ROMAN,14,Font.BOLD,BaseColor.BLUE));
                tabla.addCell(column1);
                tabla.addCell(column2);
                tabla.addCell(column3);
                tabla.addCell(column4);
                tabla.addCell(column5);
                tabla.addCell(column6);
                tabla.addCell(column7);
                tabla.addCell(column8);
                try {
                    if(root != null)
                        root.traverse();
                } catch (Exception e) {
                     JOptionPane.showMessageDialog(null, e.getMessage());
                }       
                doc.add(tabla);
                doc.close();
                JOptionPane.showMessageDialog(null, "Tabla con todos los vehiculos generada");
                try {
                    if(!Desktop.isDesktopSupported()){
                        System.out.println("Desktop is not supported");
                        return;
                    }
                    Desktop desktop = Desktop.getDesktop();
                    if(Archivo.exists()) desktop.open(Archivo);
                } catch (Exception a) {
                    JOptionPane.showMessageDialog(null,a.getCause());
                }
            } catch (Exception ex) {
                 JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
        
        private void remove(BTree<T>.BTreeNode node, T k){
            System.out.println("The n is :" + node.n);
            int aux = node.find(search(k));
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
                if(tmp.n >= (MIN_KEYS+1)){
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
        
        public void searchForUpdate(T k, T k2){
            Delete(search(k));
            insert(k2);
        }
       
        public String GenerateReportTreeB(){
            String graph = "digraph btree {\n";
            if(root.n != 0){
                        graph+= "rankdir=TB;\n"
                             + "graph[fontcolor=white, bgcolor=black, color=white];\n"
                             + "node[style=filled, fillcolor=lemonchiffon1, shape=record, height=.1];\n"
                             + "edge[color=white];\n"
                             + root.generateDot();
            }
            graph +=  "}";
            return graph;
        }
        
        public String SubGrafo(){
            String graph = "subgraph cluster_btree {\n";
            if(root.n != 0){
                        graph+= "rankdir=TB;\n"
                             + "graph[fontcolor=white, bgcolor=black, color=white];\n"
                             + "node[style=filled, fillcolor=lemonchiffon1, shape=record, height=.1];\n"
                             + "edge[color=white];\n"
                             + root.generateDot();
            }
            graph +=  "}";
            return graph;
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
			BTreeNode s = new BTreeNode();
			s.children[0] = r;
			s.leaf = false;
			root = s;

			splitChild(s, 0, r);
			System.out.println("SplitChild" + s);
			insertNonFull(s, k);
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
		int i = node.n - 1;
		if (node.leaf) {
			for (; i >= 0 && k.compareTo(node.keys[i]) < 0; i--) {
				node.keys[i + 1] = node.keys[i];
			}
			node.keys[i + 1] = k;
			node.n++;
		} else {
			for (; i >= 0 && k.compareTo(node.keys[i]) < 0; i--) {

			}
			i++;
			BTree<T>.BTreeNode child = node.children[i];
			if (child.isFull()) {
				splitChild(node, i, child);
				if (k.compareTo(node.keys[i]) > 0) {
					i++;
				}
			}
			insertNonFull(node.children[i], k);
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

		for (int j = 0; j < z.n; j++) {
			z.keys[j] = y.keys[j + MIN_KEYS + 1];
		}

		if (!y.leaf) {
			for (int j = 0; j <= z.n; j++) {
				z.children[j] = y.children[j + MIN_KEYS + 1];
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

        
        BTree<Vehicle> tree = new BTree<>();
	
      Vehicle s = new Vehicle("001DJH", "Toyota","Corolla", 2005, "Negro", "2845.05","Automatico");
        Vehicle s1 = new Vehicle("002DJH", "Toyota","Corolla", 2005, "Negro", "2845.05","Automatico");
        Vehicle s2 = new Vehicle("003DJH", "Toyota","Corolla", 2005, "Negro", "2845.05","Automatico");
        Vehicle s3 = new Vehicle("004DJH", "Toyota","Corolla", 2005, "Negro", "2845.05","Automatico");
        Vehicle s4 = new Vehicle("005DJH", "Toyota","Corolla", 2005, "Negro", "2845.05","Automatico");
        Vehicle s5 = new Vehicle("006DJH", "Toyota","Corolla", 2005, "Negro", "2845.05","Automatico");
        Vehicle s6 = new Vehicle("007DJH", "Toyota","Corolla", 2005, "Negro", "2845.05","Automatico");
        Vehicle s7 = new Vehicle("008DJH", "Toyota","Corolla", 2005, "Negro", "2845.05","Automatico");
        Vehicle s8 = new Vehicle("009DJH", "Toyota","Corolla", 2005, "Negro", "2845.05","Automatico");
        Vehicle s9 = new Vehicle("010DJH", "Toyota","Corolla", 2005, "Negro", "2845.05","Automatico");
         Vehicle s10 = new Vehicle("011DJH", "Toyota","Corolla", 2005, "Negro", "2845.05","Automatico");
         Vehicle s11 = new Vehicle("012DJH", "Toyota","Corolla", 2005, "Negro", "2845.05","Automatico");
                tree.insert(s);
                tree.insert(s1);
                  tree.insert(s2);
                    tree.insert(s3);
                      tree.insert(s4);
                        tree.insert(s5);
                         tree.insert(s6);
                         tree.insert(s7);
                         tree.insert(s8);
                         
                         tree.insert(s9);
                         tree.insert(s10);
                         tree.insert(s11);
                         System.out.println();
                        tree.generarPDF();
            /*    tree.insert(0);
                tree.insert(1);
                tree.insert(2);
                tree.insert(3);
                tree.insert(4);
                tree.insert(5);
                tree.insert(6);
                tree.insert(7);
                tree.insert(8);
                tree.insert(9);
                tree.insert(10);
                tree.insert(11);
                tree.insert(12);
                tree.insert(13);
                tree.insert(14);
                tree.insert(15);
                tree.insert(16);
                tree.insert(17);
                tree.insert(18);
                tree.insert(19);
                tree.insert(20);
                tree.insert(21);
                tree.insert(22);
                tree.insert(23);
                tree.insert(24);
                tree.insert(25);
                tree.insert(26);
                tree.insert(27);
                tree.insert(28);
                tree.insert(29);
                tree.insert(30);
                tree.insert(31);
                tree.insert(32);
                tree.insert(33);
                tree.insert(34);
                tree.insert(35);
                tree.insert(36);
                tree.insert(37);
                tree.insert(38);
                tree.insert(39);
                tree.insert(40);
                tree.insert(41);
                tree.insert(42);
                tree.insert(43);
                tree.insert(44);
                tree.insert(45);
                tree.insert(46);
                tree.insert(47);
                tree.insert(48);
                tree.insert(49);*/
               
            
                        
                 //      System.out.println(tree.GenerateReportTreeB());;
	}
	
}
