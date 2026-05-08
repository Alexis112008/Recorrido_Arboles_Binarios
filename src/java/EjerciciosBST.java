import java.util.LinkedList;
import java.util.Queue;

public class EjerciciosBST {

    // ─────────────────────────────────────────
    //  Nodo genérico con dato String
    // ─────────────────────────────────────────
    static class NodoStr {
        String dato;
        NodoStr izq, der;
        NodoStr(String v) { dato = v; }
    }

    // ─────────────────────────────────────────
    //  Nodo numérico (BST)
    // ─────────────────────────────────────────
    static class Nodo {
        int dato;
        Nodo izq, der;
        Nodo(int v) { dato = v; }
    }

    // ─────────────────────────────────────────
    //  Insertar en BST
    // ─────────────────────────────────────────
    static Nodo insertar(Nodo raiz, int v) {
        if (raiz == null) return new Nodo(v);
        if (v < raiz.dato) raiz.izq = insertar(raiz.izq, v);
        else if (v > raiz.dato) raiz.der = insertar(raiz.der, v);
        return raiz;
    }

    // ─────────────────────────────────────────
    //  EJERCICIO 1 — Recorridos
    // ─────────────────────────────────────────
    static void preorden(Nodo n) {
        if (n == null) return;
        System.out.print(n.dato + " ");
        preorden(n.izq);
        preorden(n.der);
    }

    static void inorden(Nodo n) {
        if (n == null) return;
        inorden(n.izq);
        System.out.print(n.dato + " ");
        inorden(n.der);
    }

    static void postorden(Nodo n) {
        if (n == null) return;
        postorden(n.izq);
        postorden(n.der);
        System.out.print(n.dato + " ");
    }

    static void bfs(Nodo raiz) {
        if (raiz == null) return;
        Queue<Nodo> cola = new LinkedList<>();
        cola.add(raiz);
        while (!cola.isEmpty()) {
            Nodo actual = cola.poll();
            System.out.print(actual.dato + " ");
            if (actual.izq != null) cola.add(actual.izq);
            if (actual.der != null) cola.add(actual.der);
        }
    }

    // ─────────────────────────────────────────
    //  EJERCICIO 3 — Contar nodos totales
    // ─────────────────────────────────────────
    static int contarNodos(Nodo n) {
        if (n == null) return 0;
        return 1 + contarNodos(n.izq) + contarNodos(n.der);
    }

    // ─────────────────────────────────────────
    //  EJERCICIO 4 — Contar hojas
    // ─────────────────────────────────────────
    static int contarHojas(Nodo n) {
        if (n == null) return 0;
        if (n.izq == null && n.der == null) return 1;   // hoja
        return contarHojas(n.izq) + contarHojas(n.der);
    }

    // ─────────────────────────────────────────
    //  EJERCICIO 5 — Árbol de módulos
    // ─────────────────────────────────────────
    static void preordenStr(NodoStr n) {
        if (n == null) return;
        System.out.println(n.dato);
        preordenStr(n.izq);
        preordenStr(n.der);
    }

    static void postordenStr(NodoStr n) {
        if (n == null) return;
        postordenStr(n.izq);
        postordenStr(n.der);
        System.out.println(n.dato);
    }

    static void bfsStr(NodoStr raiz) {
        if (raiz == null) return;
        Queue<NodoStr> cola = new LinkedList<>();
        cola.add(raiz);
        while (!cola.isEmpty()) {
            NodoStr actual = cola.poll();
            System.out.println(actual.dato);
            if (actual.izq != null) cola.add(actual.izq);
            if (actual.der != null) cola.add(actual.der);
        }
    }

    // ─────────────────────────────────────────
    //  MAIN
    // ─────────────────────────────────────────
    public static void main(String[] args) {

        // ── Ejercicio 1: árbol original ──────
        Nodo arbol = null;
        for (int v : new int[]{10, 5, 15, 2, 7, 12, 20})
            arbol = insertar(arbol, v);

        System.out.println("=== EJERCICIO 1: Arbol original ===");
        System.out.print("Preorden  : "); preorden(arbol);  System.out.println();
        System.out.print("Inorden   : "); inorden(arbol);   System.out.println();
        System.out.print("Postorden : "); postorden(arbol); System.out.println();
        System.out.print("BFS       : "); bfs(arbol);       System.out.println("\n");

        // ── Ejercicio 2: agregar nodos ───────
        for (int v : new int[]{1, 3, 18, 25})
            arbol = insertar(arbol, v);

        System.out.println("=== EJERCICIO 2: Arbol ampliado (+1,3,18,25) ===");
        System.out.print("Preorden  : "); preorden(arbol);  System.out.println();
        System.out.print("Inorden   : "); inorden(arbol);   System.out.println();
        System.out.print("Postorden : "); postorden(arbol); System.out.println();
        System.out.print("BFS       : "); bfs(arbol);       System.out.println("\n");

        // ── Ejercicio 3: contar nodos ─────────
        System.out.println("=== EJERCICIO 3: Contar nodos ===");
        System.out.println("Total de nodos: " + contarNodos(arbol) + "\n");

        // ── Ejercicio 4: contar hojas ─────────
        System.out.println("=== EJERCICIO 4: Contar hojas ===");
        System.out.println("Total de hojas: " + contarHojas(arbol) + "\n");

        // ── Ejercicio 5: árbol de módulos ─────
        NodoStr sw         = new NodoStr("Sistema Web");
        NodoStr usuarios   = new NodoStr("Usuarios");
        NodoStr inventario = new NodoStr("Inventario");
        NodoStr reg        = new NodoStr("Registrar");
        NodoStr buscar     = new NodoStr("Buscar");
        NodoStr productos  = new NodoStr("Productos");
        NodoStr reportes   = new NodoStr("Reportes");

        sw.izq         = usuarios;
        sw.der         = inventario;
        usuarios.izq   = reg;
        usuarios.der   = buscar;
        inventario.izq = productos;
        inventario.der = reportes;

        System.out.println("=== EJERCICIO 5: Modulos del sistema web ===");
        System.out.println("-- Preorden  (menu principal) --");  preordenStr(sw);
        System.out.println("-- Postorden (modulos internos primero) --"); postordenStr(sw);
        System.out.println("-- BFS       (nivel por nivel) --"); bfsStr(sw);
    }
}