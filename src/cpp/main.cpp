#include <iostream>
#include <queue> // Lo UTILIZAREMOS PARA EL RECORRIDO BFS
using namespace std;

// ESTRUCTURA DEL NODO, cada uno guarda un dato y punteros a sus hijos izquierdo y derecho

struct Nodo {
    int dato;
    Nodo* izquierda;
    Nodo* derecha;

    // Constructor: inicializa el dato y deja los punteros a hijos como nullptr
    Nodo(int valor) {
        dato = valor;
        izquierda = nullptr;
        derecha = nullptr;
    }
};

// PREORDEN  →  Raíz - Izquierda - Derecha, utilizado para copiar árboles o evaluar expresiones
void preorden(Nodo* raiz) {       // Si el nodo es nulo, no hacemos nada
    if (raiz == nullptr) return;  
    cout << raiz->dato << " ";    // Primero visitamos la raíz
    preorden(raiz->izquierda);    // Luego visitamos el subárbol izquierdo
    preorden(raiz->derecha);      // Finalmente visitamos el subárbol derecho
}

// INORDEN  →  Izquierda - Raíz - Derecha, utilizado para obtener los elementos en orden ascendente 
void inorden(Nodo* raiz) {        // Si el nodo es nulo, no hacemos nada
    if (raiz == nullptr) return;
    inorden(raiz->izquierda);     // Primero visitamos el subárbol izquierdo
    cout << raiz->dato << " ";    // Luego visitamos la raíz
    inorden(raiz->derecha);       // Finalmente visitamos el subárbol derecho
}

// POSTORDEN →  Izquierda - Derecha - Raíz, utilizado para eliminar árboles o evaluar expresiones
void postorden(Nodo* raiz) {      // Si el nodo es nulo, no hacemos nada
    if (raiz == nullptr) return;
    postorden(raiz->izquierda);   // Primero visitamos el subárbol izquierdo
    postorden(raiz->derecha);     // Luego visitamos el subárbol derecho
    cout << raiz->dato << " ";    // Finalmente visitamos la raíz
}

// BFS (Breadth-First Search) → Nivel por nivel, utilizado para encontrar el camino más corto o recorrer árboles amplios
void bfs(Nodo* raiz) {
    if (raiz == nullptr) return;     // Si el árbol está vacío, no hacemos nada

    queue<Nodo*> cola;               // Creamos una cola para almacenar los nodos a visitar
    cola.push(raiz);                // Comenzamos con la raíz

    while (!cola.empty()) {          // Mientras haya nodos en la cola, seguimos procesando
        Nodo* actual = cola.front(); // Obtenemos el nodo al frente de la cola
        cola.pop();

        cout << actual->dato << " "; // Imprimimos el dato del nodo actual

        // Agregamos los hijos del nodo actual a la cola para procesarlos en el futuro
        if (actual->izquierda != nullptr) cola.push(actual->izquierda);
        if (actual->derecha != nullptr) cola.push(actual->derecha);
    }
}

// CASO REAL - SmartCampus UTA
void casoRealSmartCampus() {
    cout << "--------------------------------------------" << endl;
    cout << "  CASO REAL - SmartCampus UTA" << endl;
    cout << "  Arbol de Tramites Estudiantiles" << endl;
    cout << "--------------------------------------------" << endl;

    // Nodos base (7 originales)
    Nodo* tramites    = new Nodo(1);   // Raíz: Trámites
    Nodo* academicos  = new Nodo(2);   // Académicos
    Nodo* financieros = new Nodo(3);   // Financieros
    Nodo* matricula   = new Nodo(4);   // Matrícula
    Nodo* retiro      = new Nodo(5);   // Retiro de materia
    Nodo* beca        = new Nodo(6);   // Becas
    Nodo* pago        = new Nodo(7);   // Pagos

    // 5 nodos adicionales (actividad)
    Nodo* cambioCarrera  = new Nodo(8);   // Cambio de carrera
    Nodo* convalidacion  = new Nodo(9);   // Convalidación
    Nodo* apelacion      = new Nodo(10);  // Apelación de nota
    Nodo* revision       = new Nodo(11);  // Revisión de examen
    Nodo* certificado    = new Nodo(12);  // Certificado de estudios

    // Construcción del árbol
    tramites->izquierda    = academicos;
    tramites->derecha      = financieros;
    academicos->izquierda  = matricula;
    academicos->derecha    = retiro;
    financieros->izquierda = beca;
    financieros->derecha   = pago;

    // Nodos adicionales
    matricula->izquierda   = cambioCarrera;
    matricula->derecha     = convalidacion;
    convalidacion->derecha = apelacion;
    apelacion->izquierda   = revision;
    beca->izquierda        = certificado;

    // Leyenda de referencia
    cout << "\nLEYENDA DE NODOS:" << endl;
    cout << "  1 = Tramites  2 = Academicos  3 = Financieros" << endl;
    cout << "  4 = Matricula  5 = Retiro      6 = Beca" << endl;
    cout << "  7 = Pago      8 = CambioCarr  9 = Convalidacion" << endl;
    cout << " 10 = Apelacion 11 = Revision  12 = Certificado" << endl;

    cout << "\nPreorden  (jerarquia): ";
    preorden(tramites);

    cout << "\nInorden   (orden proc): ";
    inorden(tramites);

    cout << "\nPostorden (liberar mem): ";
    postorden(tramites);

    cout << "\nBFS       (nivel x nivel): ";
    bfs(tramites);
    cout << endl;
}


int main() {

    cout << "--------------------------------------------" << endl;
    cout << "  Recorrido de arboles binarios" << endl;
    cout << "--------------------------------------------" << endl;

    Nodo* raiz = new Nodo(10);
    raiz->izquierda = new Nodo(5);
    raiz->derecha = new Nodo(15);
    raiz->izquierda->izquierda = new Nodo(2);
    raiz->izquierda->derecha = new Nodo(7);
    raiz->derecha->izquierda = new Nodo(12);
    raiz->derecha->derecha = new Nodo(20);

    // 5 nodos adicionales 
    raiz->izquierda->izquierda->izquierda = new Nodo(1);   // Nodo adicional 1
    raiz->izquierda->izquierda->derecha   = new Nodo(3);   // Nodo adicional 2
    raiz->derecha->izquierda->derecha     = new Nodo(13);  // Nodo adicional 3
    raiz->derecha->izquierda->derecha->derecha           = new Nodo(14); // Nodo adicional 4
    raiz->derecha->izquierda->derecha->derecha->izquierda= new Nodo(11); // Nodo adicional 5


    cout << "RECORRIDOS DE ARBOLES BINARIOS - UTA" << endl;

    cout << "Preorden: ";
    preorden(raiz);

    cout << "\nInorden: ";
    inorden(raiz);

    cout << "\nPostorden: ";
    postorden(raiz);

    cout << "\nBFS: ";
    bfs(raiz);

    cout << endl;

    // caso real SmartCampus UTA
    casoRealSmartCampus();

    return 0;
}
