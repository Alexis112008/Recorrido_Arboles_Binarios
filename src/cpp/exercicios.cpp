#include <iostream>
#include <queue>
using namespace std;

// ─────────────────────────────────────────────
//  Estructura del nodo
// ─────────────────────────────────────────────
struct Nodo {
    int dato;
    Nodo* izq;
    Nodo* der;
    Nodo(int v) : dato(v), izq(nullptr), der(nullptr) {}
};

// ─────────────────────────────────────────────
//  Insertar en BST
// ─────────────────────────────────────────────
Nodo* insertar(Nodo* raiz, int v) {
    if (!raiz) return new Nodo(v);
    if (v < raiz->dato) raiz->izq = insertar(raiz->izq, v);
    else if (v > raiz->dato) raiz->der = insertar(raiz->der, v);
    return raiz;
}

// ─────────────────────────────────────────────
//  EJERCICIO 1 — Recorridos del árbol original
// ─────────────────────────────────────────────
void preorden(Nodo* n) {
    if (!n) return;
    cout << n->dato << " ";
    preorden(n->izq);
    preorden(n->der);
}

void inorden(Nodo* n) {
    if (!n) return;
    inorden(n->izq);
    cout << n->dato << " ";
    inorden(n->der);
}

void postorden(Nodo* n) {
    if (!n) return;
    postorden(n->izq);
    postorden(n->der);
    cout << n->dato << " ";
}

void bfs(Nodo* raiz) {
    if (!raiz) return;
    queue<Nodo*> q;
    q.push(raiz);
    while (!q.empty()) {
        Nodo* actual = q.front(); q.pop();
        cout << actual->dato << " ";
        if (actual->izq) q.push(actual->izq);
        if (actual->der) q.push(actual->der);
    }
}

// ─────────────────────────────────────────────
//  EJERCICIO 3 — Contar nodos totales
// ─────────────────────────────────────────────
int contarNodos(Nodo* n) {
    if (!n) return 0;
    return 1 + contarNodos(n->izq) + contarNodos(n->der);
}

// ─────────────────────────────────────────────
//  EJERCICIO 4 — Contar hojas
// ─────────────────────────────────────────────
int contarHojas(Nodo* n) {
    if (!n) return 0;
    if (!n->izq && !n->der) return 1;          // nodo hoja
    return contarHojas(n->izq) + contarHojas(n->der);
}

// ─────────────────────────────────────────────
//  EJERCICIO 5 — Árbol de módulos (con strings)
// ─────────────────────────────────────────────
struct NodoStr {
    string dato;
    NodoStr* izq;
    NodoStr* der;
    NodoStr(string v) : dato(v), izq(nullptr), der(nullptr) {}
};

void preordenStr(NodoStr* n) {
    if (!n) return;
    cout << n->dato << "\n";
    preordenStr(n->izq);
    preordenStr(n->der);
}

void postordenStr(NodoStr* n) {
    if (!n) return;
    postordenStr(n->izq);
    postordenStr(n->der);
    cout << n->dato << "\n";
}

void bfsStr(NodoStr* raiz) {
    if (!raiz) return;
    queue<NodoStr*> q;
    q.push(raiz);
    while (!q.empty()) {
        NodoStr* actual = q.front(); q.pop();
        cout << actual->dato << "\n";
        if (actual->izq) q.push(actual->izq);
        if (actual->der) q.push(actual->der);
    }
}

// ─────────────────────────────────────────────
//  MAIN
// ─────────────────────────────────────────────
int main() {
    // ── Ejercicio 1: árbol original ──────────
    Nodo* arbol = nullptr;
    for (int v : {10, 5, 15, 2, 7, 12, 20})
        arbol = insertar(arbol, v);

    cout << "=== EJERCICIO 1: Arbol original ===\n";
    cout << "Preorden  : "; preorden(arbol);   cout << "\n";
    cout << "Inorden   : "; inorden(arbol);    cout << "\n";
    cout << "Postorden : "; postorden(arbol);  cout << "\n";
    cout << "BFS       : "; bfs(arbol);        cout << "\n\n";

    // ── Ejercicio 2: agregar nodos ───────────
    for (int v : {1, 3, 18, 25})
        arbol = insertar(arbol, v);

    cout << "=== EJERCICIO 2: Arbol ampliado (+1,3,18,25) ===\n";
    cout << "Preorden  : "; preorden(arbol);   cout << "\n";
    cout << "Inorden   : "; inorden(arbol);    cout << "\n";
    cout << "Postorden : "; postorden(arbol);  cout << "\n";
    cout << "BFS       : "; bfs(arbol);        cout << "\n\n";

    // ── Ejercicio 3: contar nodos ────────────
    cout << "=== EJERCICIO 3: Contar nodos ===\n";
    cout << "Total de nodos: " << contarNodos(arbol) << "\n\n";

    // ── Ejercicio 4: contar hojas ────────────
    cout << "=== EJERCICIO 4: Contar hojas ===\n";
    cout << "Total de hojas: " << contarHojas(arbol) << "\n\n";

    // ── Ejercicio 5: árbol de módulos ────────
    //         Sistema Web
    //        /           \
    //    Usuarios      Inventario
    //    /    \         /      \
    // Registrar Buscar Productos Reportes

    NodoStr* sw        = new NodoStr("Sistema Web");
    NodoStr* usuarios  = new NodoStr("Usuarios");
    NodoStr* inventario= new NodoStr("Inventario");
    NodoStr* reg       = new NodoStr("Registrar");
    NodoStr* buscar    = new NodoStr("Buscar");
    NodoStr* productos = new NodoStr("Productos");
    NodoStr* reportes  = new NodoStr("Reportes");

    sw->izq        = usuarios;
    sw->der        = inventario;
    usuarios->izq  = reg;
    usuarios->der  = buscar;
    inventario->izq= productos;
    inventario->der= reportes;

    cout << "=== EJERCICIO 5: Modulos del sistema web ===\n";
    cout << "-- Preorden  (menu principal) --\n";  preordenStr(sw);
    cout << "-- Postorden (modulos internos primero) --\n"; postordenStr(sw);
    cout << "-- BFS       (nivel por nivel) --\n"; bfsStr(sw);

    return 0;
}