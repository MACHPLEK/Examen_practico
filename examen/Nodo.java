package examen;


public class Nodo {
    private Cancion cancion;
    private Nodo anterior;
    private Nodo siguiente;
    
  
//Cosntructor
    public Nodo(Cancion cancion) {
        this.cancion = cancion;
        this.anterior = null;
        this.siguiente = null;
    }

    
//Set and get
    public Cancion getCancion() {
        return cancion;
    }

    public void setCancion(Cancion cancion) {
        this.cancion = cancion;
    }

    public Nodo getAnterior() {
        return anterior;
    }

    public void setAnterior(Nodo anterior) {
        this.anterior = anterior;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
}