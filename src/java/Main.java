import java.util.LinkedList;
import java.util.Queue;

// Nodo de un árbol binario
class Nodo {
    int dato;
    Nodo izquierda;
    Nodo derecha;

    // Constructor
    public Nodo(int dato) {
        this.dato = dato;
        this.izquierda = null;
        this.derecha = null;
    }
}



public class Main {

    // Recorrido en preorden: Raíz -> Izquierda -> Derecha
    public static void preorden(Nodo raiz) {
        if (raiz == null) return;              // Caso base: Si el nodo es nulo, retornar
        System.out.print(raiz.dato + " ");     // Procesar el nodo actual (raíz)
        preorden(raiz.izquierda);           // Recorrer el subárbol izquierdo   
        preorden(raiz.derecha);      // Recorrer el subárbol derecho
    }

    // Recorrido en inorden: Izquierda -> Raíz -> Derecha   
    public static void inorden(Nodo raiz) {
        if (raiz == null) return;               // Caso base: Si el nodo es nulo, retornar
        inorden(raiz.izquierda);         // Recorrer el subárbol izquierdo
        System.out.print(raiz.dato + " ");   // Procesar el nodo actual (raíz)
        inorden(raiz.derecha);      // Recorrer el subárbol derecho
    }

    public static void postorden(Nodo raiz) {
        if (raiz == null) return;               // Caso base: Si el nodo es nulo, retornar
        postorden(raiz.izquierda);            // Recorrer el subárbol izquierdo                    
        postorden(raiz.derecha);    // Recorrer el subárbol derecho
        System.out.print(raiz.dato + " ");      // Procesar el nodo actual (raíz)
    }

    // Recorrido en anchura (BFS): Nivel por nivel
    public static void bfs(Nodo raiz) {
        if (raiz == null) return;             // Caso base: Si el nodo es nulo, retornar

        Queue<Nodo> cola = new LinkedList<>(); // Cola para almacenar los nodos a procesar
        cola.add(raiz);            // Agregar el nodo raíz a la cola

        while (!cola.isEmpty()) {    // Mientras haya nodos en la cola
            Nodo actual = cola.poll();  // Obtener el siguiente nodo de la cola
            System.out.print(actual.dato + " ");  // Procesar el nodo actual

            // Agregar los hijos del nodo actual a la cola
            if (actual.izquierda != null) cola.add(actual.izquierda);
            if (actual.derecha != null) cola.add(actual.derecha);
        }
    }

    // CASO REAL - SmartCampus UTA
    public static void casoRealSmartCampus() {
        System.out.println("\n----------------------------------------");
        System.out.println("  CASO REAL - SmartCampus UTA");
        System.out.println("  Arbol de Tramites Estudiantiles");
        System.out.println("------------------------------------------");

        // Nodos base
        Nodo tramites    = new Nodo(1);
        Nodo academicos  = new Nodo(2);
        Nodo financieros = new Nodo(3);
        Nodo matricula   = new Nodo(4);
        Nodo retiro      = new Nodo(5);
        Nodo beca        = new Nodo(6);
        Nodo pago        = new Nodo(7);

        // 5 nodos adicionales
        Nodo cambioCarrera = new Nodo(8);
        Nodo convalidacion = new Nodo(9);
        Nodo apelacion     = new Nodo(10);
        Nodo revision      = new Nodo(11);
        Nodo certificado   = new Nodo(12);

        // Construcción del árbol
        tramites.izquierda    = academicos;
        tramites.derecha      = financieros;
        academicos.izquierda  = matricula;
        academicos.derecha    = retiro;
        financieros.izquierda = beca;
        financieros.derecha   = pago;

        // Nodos adicionales
        matricula.izquierda    = cambioCarrera;
        matricula.derecha      = convalidacion;
        convalidacion.derecha  = apelacion;
        apelacion.izquierda    = revision;
        beca.izquierda         = certificado;

        System.out.println("\nLEYENDA DE NODOS:");
        System.out.println("  1 = Tramites  2 = Academicos  3 = Financieros");
        System.out.println("  4 = Matricula 5 = Retiro      6 = Beca");
        System.out.println("  7 = Pago      8 = CambioCarr  9 = Convalidacion");
        System.out.println(" 10 = Apelacion 11 = Revision  12 = Certificado");

        System.out.print("\nPreorden  (jerarquia): ");
        preorden(tramites);

        System.out.print("\nInorden   (orden proc): ");
        inorden(tramites);

        System.out.print("\nPostorden (liberar mem): ");
        postorden(tramites);

        System.out.print("\nBFS       (nivel x nivel): ");
        bfs(tramites);
        System.out.println();
    }

        public static void main(String[] args) {

            System.out.println("\n----------------------------------------");
            System.out.println("  Recorridos de Arboles Binarios");
            System.out.println("------------------------------------------");

            // Crear un árbol binario de ejemplo
            Nodo raiz = new Nodo(10);      // Nodo raíz con valor 10
            raiz.izquierda = new Nodo(5); // Hijo izquierdo del nodo raíz con valor 5
            raiz.derecha = new Nodo(15); // Hijo derecho del nodo raíz con valor 15
            raiz.izquierda.izquierda = new Nodo(2); // Hijo izquierdo del nodo 5 con valor 2
            raiz.izquierda.derecha = new Nodo(7); // Hijo derecho del nodo 5 con valor 7
            raiz.derecha.izquierda = new Nodo(12); // Hijo izquierdo del nodo 15 con valor 12
            raiz.derecha.derecha = new Nodo(20); // Hijo derecho del nodo 15 con valor 20

            // 5 nodos adicionales
            raiz.izquierda.izquierda.izquierda = new Nodo(1);
            raiz.izquierda.izquierda.derecha   = new Nodo(3);
            raiz.derecha.izquierda.derecha     = new Nodo(13);
            raiz.derecha.izquierda.derecha.derecha            = new Nodo(14);
            raiz.derecha.izquierda.derecha.derecha.izquierda  = new Nodo(11);

            System.out.println("RECORRIDOS DE ARBOLES BINARIOS - UTA");

            System.out.print("Preorden: ");
            preorden(raiz);

            System.out.print("\nInorden: ");
            inorden(raiz);

            System.out.print("\nPostorden: ");
            postorden(raiz);

            System.out.print("\nBFS: ");
            bfs(raiz);

            System.out.println();

            //caso real SmartCampus UTA
            casoRealSmartCampus();
        }
    }
