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

    public static void main(String[] args) {

        // Crear un árbol binario de ejemplo
        Nodo raiz = new Nodo(10);      // Nodo raíz con valor 10
        raiz.izquierda = new Nodo(5); // Hijo izquierdo del nodo raíz con valor 5
        raiz.derecha = new Nodo(15); // Hijo derecho del nodo raíz con valor 15
        raiz.izquierda.izquierda = new Nodo(2); // Hijo izquierdo del nodo 5 con valor 2
        raiz.izquierda.derecha = new Nodo(7); // Hijo derecho del nodo 5 con valor 7
        raiz.derecha.izquierda = new Nodo(12); // Hijo izquierdo del nodo 15 con valor 12
        raiz.derecha.derecha = new Nodo(20); // Hijo derecho del nodo 15 con valor 20

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
    }
}
