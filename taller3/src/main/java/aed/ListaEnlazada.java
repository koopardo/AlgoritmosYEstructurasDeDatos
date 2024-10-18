package aed;

import java.util.*;

public class ListaEnlazada<T> implements Secuencia<T> {
    private Nodo primero;
    private Nodo ultimo;
    private int longitud;
    
    private class Nodo {
        private T valor;
        private Nodo siguiente;
        private Nodo anterior;

        public Nodo(T valor) {
            this.valor = valor;
            this.siguiente = null;
            this.anterior = null;
        }
    }

    public ListaEnlazada() {
        this.primero = null;
        this.ultimo = null;
        this.longitud = 0;
    }

    public int longitud() {
        int res = this.longitud;
        return res;
    }

    public void agregarAdelante(T elem) {
        Nodo nodoNuevo = new Nodo(elem);
        this.longitud += 1;
        if (this.primero == null) {
            this.primero = nodoNuevo;
            this.ultimo = nodoNuevo;
        } else {
            nodoNuevo.siguiente = this.primero;
            this.primero.anterior = nodoNuevo;
            this.primero = nodoNuevo;
        }
    }

    public void agregarAtras(T elem) {
        Nodo nodoNuevo = new Nodo(elem);
        this.longitud += 1;
        if (this.ultimo == null) {
            this.ultimo = nodoNuevo;
            this.primero = nodoNuevo;
        } else {
            nodoNuevo.anterior = this.ultimo;
            this.ultimo.siguiente = nodoNuevo;
            this.ultimo = nodoNuevo;
        }
    }

    public T obtener(int i) {
        Iterador<T> iterador = this.iterador();
        int j = 0;
        while(iterador.haySiguiente() && j < i) {
            j += 1;
            iterador.siguiente();
        }
        T res = iterador.siguiente();
        return res;
    }

    public void eliminar(int i) {
        if (this.longitud >=1 && i < this.longitud) {
            Iterador<T> iterador = this.iterador();
            int j = 0;
            Nodo auxiliar = this.primero;
            while (iterador.haySiguiente() && j < i) {
                j += 1;
                iterador.siguiente();
                auxiliar = auxiliar.siguiente;
            }
            if (this.longitud == 1) {           
                this.primero = null;
                this.ultimo = null;
                this.longitud -= 1;
            }    

            if (j < (this.longitud - 1) && j > 0) {
                auxiliar.anterior.siguiente = auxiliar.siguiente;
                auxiliar.siguiente.anterior = auxiliar.anterior;
                this.longitud -= 1;
            }
            if (auxiliar == this.primero && this.longitud > 1) {
                auxiliar = auxiliar.siguiente;
                auxiliar.anterior = null;
                this.primero = auxiliar;
                this.longitud -= 1;
            }
            if (auxiliar == this.ultimo && this.longitud > 1) {
                auxiliar = auxiliar.anterior;
                auxiliar.siguiente = null;
                this.ultimo = auxiliar;
                this.longitud -= 1;
            }
        }         
    }

    public void modificarPosicion(int indice, T elem) {
        Iterador<T> iterador = this.iterador();
        int j = 0;
        Nodo auxiliar = this.primero;
        while (iterador.haySiguiente() && j < indice) {
            j += 1;
            iterador.siguiente();
            auxiliar = auxiliar.siguiente;
        }
        auxiliar.valor = elem;
    }

    public ListaEnlazada(ListaEnlazada<T> lista) {
        ListaEnlazada<T> listaCopiada = new ListaEnlazada<T>();
        Iterador<T> iterador = lista.iterador();
        while (iterador.haySiguiente()) {
            listaCopiada.agregarAtras(iterador.siguiente());
        }
        this.primero = listaCopiada.primero;
        this.ultimo = listaCopiada.ultimo;
        this.longitud = listaCopiada.longitud;
    }
    
    @Override
    public String toString() {
        StringBuffer stringDinamico = new StringBuffer();
        Iterador<T> iterador = this.iterador();
        stringDinamico.append("[");
        int j = 0;
        while (iterador.haySiguiente() && j < (this.longitud - 1)) {
            stringDinamico.append(iterador.siguiente() + ", ");
            j += 1;
        }
        stringDinamico.append(iterador.siguiente() + "]");
        String res = stringDinamico.toString();
        return res;
    }

    private class ListaIterador implements Iterador<T> {
    	private Nodo nodoIterador;

        public ListaIterador(Nodo nodo) {
           this.nodoIterador = nodo;
        }

        public boolean haySiguiente() {
            boolean res = nodoIterador != null;
            return res;
        }

        public boolean hayAnterior() {
            boolean res = nodoIterador != primero;
            return res;
        }

        public T siguiente() {
            T res = this.nodoIterador.valor;
            this.nodoIterador = this.nodoIterador.siguiente;
            return res;
        }

        public T anterior() {
            if (nodoIterador == null) {
                nodoIterador = ultimo;
            } else {
                this.nodoIterador = this.nodoIterador.anterior;
            }
            T res = nodoIterador.valor;
            return res;
        }
    }    

    public Iterador<T> iterador() {
        Iterador<T> res = new ListaIterador(primero);
	    return res;
    }
}
