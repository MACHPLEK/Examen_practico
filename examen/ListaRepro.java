package examen;


public class ListaRepro {
    private Nodo inicio;
    private Nodo fin;
    private Nodo actual;
    private int tamaño;

    
  //Constructor Vacio 
    public ListaRepro() {
        this.inicio = null;
        this.fin = null;
        this.actual = null;
        this.tamaño = 0;
    }

    // --- INICIAR Y BUSCAR ---

    //Inicializa la lista cuando no hay ningun otro nodo, hace que los apuntadores se apunten a si mismos para crear nuestra lista circular  
    private void enlazarUnicoNodo(Nodo nuevo) {
        inicio = fin = actual = nuevo; //A partir de esta linea se crea el circulo, aqui se hace la referencias de creación, diciendo que como es la primera todo es igual 
        nuevo.setSiguiente(nuevo);
        nuevo.setAnterior(nuevo); //Aqui es donde el nodo ya se apunta a si mismo 
    }

    //Busca una canción por su ID
    private Nodo buscarNodo(int id) {
        if (tamaño == 0) return null; //Si la lista no tiene elementos nos regresa un null ya que esta vacia 
        Nodo temp = inicio; //Creamos un nodo temporal para no perder el inicio de la lista  
        do {
            if (temp.getCancion().getId() == id) return temp; //Revisa el ID de nuestro Nodo temporal para verificar si es el que estamos buscando
            temp = temp.getSiguiente(); //El apuntador se movio porque el ID no coincidio (If no cumplido) nueva vuelta de ciclo 
        } while (temp != inicio); //Evita un bucle infinito veridicando si la lista no ha vuelto a comenzar 
        return null; //En caso de recorrer toda la lista y no encontrar el ID nos regresara un null poruque no existe ese ID
    }

    // --- AGREGAR CANCIONES ---

    public void agregarAlFinal(Cancion cancion) {
        Nodo nuevo = new Nodo(cancion); //Creamos el nodo para agregar nuuestra canción
        if (tamaño == 0) {  
            enlazarUnicoNodo(nuevo); //Se pregunta si en la lista no hay nada mas, de ser cierto utilizar el metodo enlazarUnicoNodo para que se apunte a si mismo ya que es el primero 
        } else {
            nuevo.setAnterior(fin); //Toma el apuntador de atras del nuevo nodo y lo amarra con el nodo que actualmente es la cola de la lista 
            nuevo.setSiguiente(inicio); //Toma el apuntador de adelante del nuevo nodo y la amarra al primer nodo de la lista (cabeza) 
            fin.setSiguiente(nuevo); //Toma el nodo que actualmente era el ultimo de la lista y apunta su apuntador de adelante para que mire al nuevo nodo 
            inicio.setAnterior(nuevo); //Hace que el apuntador de atras de la cabeza mire hacia el nuevo nodo 
            fin = nuevo; //Actualiza la lista para que nuestro nuevo nodo a partir de ahora sea la cola de nuestra lista 
        }
        tamaño++; //Suma 1 al contador total de canciones que hay en la lista 
    }

    public void agregarAlInicio(Cancion cancion) {
        Nodo nuevo = new Nodo(cancion); //Creamos el nodo para agregar nuuestra canción
        if (tamaño == 0) {
            enlazarUnicoNodo(nuevo); //Se pregunta si en la lista no hay nada mas, de ser cierto utilizar el metodo enlazarUnicoNodo para que se apunte a si mismo ya que es el primero 
        } else {
            nuevo.setSiguiente(inicio); //Toma el apuntador de adelante del nuevo nodo y lo conecta con la cabeza 
            nuevo.setAnterior(fin); //Toma el apuntador de atras del nuevo nodo y lo conecta a la cola 
            inicio.setAnterior(nuevo); //Cambia el apuntador de detras de la cabeza y lo direcciona al nuevo nodo 
            fin.setSiguiente(nuevo); //Cambia el apuntador de adelante de la cola y lo direcciona al nuevo nodo
            inicio = nuevo; //Actualiza la lista para que nuestro nuevo nodo a partir de ahora sea la cola de nuestra lista
        }
        tamaño++; //Suma 1 al contador total de canciones que hay en la lista
    }

    // --- NAVEGACIÓN Y CONSULTA ---

    public Cancion consultarActual() {
        return (actual != null) //Pregunta si la cancion si existe 
                ? actual.getCancion() //Si la respuesta es si devuelve la cancion que tiene el nodo actual 
                 : null; //Si la respuesta es no devuelve null 
    }

    public void avanzar() {
        if (actual != null) // Pregunta si la lista no esta vacia 
             actual = actual.getSiguiente(); //Mueve la etiqueta actual al siguiente nodo 
    }

    public void retroceder() {
        if (actual != null) // Pregunta si la lista no esta vacia 
            actual = actual.getAnterior(); //Mueve la etiqueta actual al nodo anterior 
    }

    public int getTamaño() {
        return tamaño; //Retorna la cantidad de canciones que tiene nuestra lista hasta el momento 
    }

    // --- BÚSQUEDA Y SELECCIÓN ---

    public void buscarCancion(int id) {
        Nodo nodo = buscarNodo(id); //Llamamos al metodo buscarNodo
        if (nodo != null) { //Verifica si se encontro una canción 
            System.out.println("Encontrada: " + nodo.getCancion()); //Saca la cancion que encontro y la imprime
        } else {
            System.out.println("No existe una canción con el ID " + id); //Si no encuentra la canción imprime que no existe 
        }
    }

    public void seleccionarPorId(int id) {
        Nodo nodo = buscarNodo(id); //Llamamos al metodo buscarNodo
        if (nodo != null) { //Verifica si se encontro una canción 
            actual = nodo; //Cambia la cancion que esta sonando por nuestro nuevo nodo 
            System.out.println("Ahora reproduciendo: " + actual.getCancion()); //Imprime la información de la cancion nueva que esta sonando 
        } else {
            System.out.println("ID no encontrado. La canción actual no cambió."); //No enconrto el ID por lo tanto imprime que no existe y la cancion sigue sonando
        }
    }

    // --- ELIMINACIÓN ---

    // Elimina el nodo apuntado por el actual
    public boolean eliminarActual() {
        if (tamaño == 0) return false; //Revisa que la lista si contenga canciones para poder eliminarlas 

        if (tamaño == 1) { //Se pregunta si la cancion que va a eliminar
            inicio = fin = actual = null; //Si la pregunta es si, hace que que los apuntadores no señalen a nada 
        } else {
            Nodo aEliminar = actual;
            Nodo anterior = aEliminar.getAnterior(); 
            Nodo siguiente = aEliminar.getSiguiente(); //Estas tres lineas identifican a los involucrados en la eliminación 

            // Reconectar saltándose el nodo a eliminar
            anterior.setSiguiente(siguiente); //Basicamnete suelta al nodo eliminar y se señala al de la derecha
            siguiente.setAnterior(anterior); //Basicamnete suelta al nodo eliminar y se señala al de la izquierda

            
            if (aEliminar == inicio) inicio = siguiente; //Verifica si la cancion que eliminamos es la primera, de ser asi actualiza la etiqueta de inicio 
            if (aEliminar == fin) fin = anterior; //Verifica si la cancion que eliminamos es la ultima, de ser asi actualiza la etiqueta de fin

            
            actual = siguiente; //La nueva cancion actual es la que seguia en la lista 
        }
        tamaño--; //Resta una canción a nuestro total 
        return true; //Avisa que una cancion si fue eliminada 
    }

    // Busca y elimina manteniendo la actual si es otra
    public boolean eliminarPorId(int id) {
        Nodo nodo = buscarNodo(id); //Llama a nuestro metodo buscarNodo y guarda el ID de la cancion en el nodo nuevo 
        if (nodo == null) return false; //Verifica que el Id de la cancion sea existente y si no existe se detiene devolviendo false 

        if (nodo == actual) { //Verifica si la cancion que queremor borras es la que estamos escuchando 
            return eliminarActual(); //Si la respuesta fue si, llamamos al metodo eliminarActual 
        } else {
            Nodo anterior = nodo.getAnterior();
            Nodo siguiente = nodo.getSiguiente(); //Identificamos los involucrados ern la eliminacion 
            
            anterior.setSiguiente(siguiente); //Basicamnete suelta al nodo eliminar y se señala al de la derecha
            siguiente.setAnterior(anterior); //Basicamnete suelta al nodo eliminar y se señala al de la izquierda
            
            if (nodo == inicio) inicio = siguiente; //Verifica si la cancion que eliminamos es la primera, de ser asi actualiza la etiqueta de inicio 
            if (nodo == fin) fin = anterior; //Verifica si la cancion que eliminamos es la ultima, de ser asi actualiza la etiqueta de fin
            
            tamaño--; //Resta una canción a nuestro total
            return true; //Avisa que una cancion si fue eliminada 
        }
    }

    // --- RECORRIDOS (VER CANCIONES EN LA LISTA) ---

    public void mostrarHaciaAdelante() {
        if (tamaño == 0) { //Pregunta si la lista esta vacia 
            System.out.println("La lista está vacía."); 
            return; //Imprime que la lista esta vacia y detiene el proceso 
        }
        Nodo temp = inicio; //Crea el nodo temporar y lo coloca al inicio de nuestra lista, marcando donde vamos a iniciar
        do {
            System.out.println(temp.getCancion() + (temp == actual ? " <- ACTUAL " : "")); //Imprime la canción en la que estamos, si resulta que ek nodo temporal es el mismo que el actual igual lo imprime, ternarios 
            temp = temp.getSiguiente(); //Mueve el apuntador hacia la derecha 
        } while (temp != inicio); //Detecta si ya giramos completamente para evitar el bucle 
    }

    public void mostrarHaciaAtras() {
        if (tamaño == 0) { //Pregunta si la lista esta vacia 
            System.out.println("La lista está vacía.");
            return; //Imprime que la lista esta vacia y detiene el proceso 
        }
        Nodo temp = fin; //Crea el nodo temporar y lo coloca al final de nuestra lista, marcando donde vamos a iniciar
        do {
            System.out.println(temp.getCancion() + (temp == actual ? " <- ACTUAL " : "")); //Imprime la canción en la que estamos, si resulta que ek nodo temporal es el mismo que el actual igual lo imprime
            temp = temp.getAnterior(); //Mueve el apuntador hacia la izquierda 
        } while (temp != fin); //Detecta si ya giramos completamente para evitar el bucle 
    }

    // --- SIMULACIÓN  ---

    public void simularReproduccion(int k) {
        if (tamaño == 0) { //Pregunta si la lista esta vacia 
            System.out.println("La lista está vacía. Nada que reproducir.");
            return; //Imprime que la lista esta vacia y no se reproducira nada 
        }
        // Avanza k veces mostrando la actual
        for (int i = 0; i < k; i++) { //Usamos for para simular que dejamos reproduciendo nuestra lista, k representa las canciones seguidas que van a sonar 
            System.out.println("Reproduciendo: " + actual.getCancion()); //Imprime la canción actual para simular que esta sonando 
            avanzar(); //Llamamos al metodo avanzar para cambiar de cancion hacia la derecha 
        }
    }
}
