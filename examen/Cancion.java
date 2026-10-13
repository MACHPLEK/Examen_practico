package examen;


public class Cancion {
    
    private static int contadorId = 1;

    private int id;
    private String titulo;
    private String artista;
    private int duracion; 

  
  //Constructor 
    public Cancion(String titulo, String artista, int duracion) {
        this.id = contadorId++; 
        this.titulo = titulo;
        this.artista = artista;
        
      
        if (duracion > 0) {
            this.duracion = duracion;
        } else {
            this.duracion = 1; 
        }
    }

  //Get and Set 
    public static int getContadorId() {
        return contadorId;
    }

    public static void setContadorId(int contadorId) {
        Cancion.contadorId = contadorId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

  

  //Sirve para que cuando nosotros imprimamos, se impriman los datos reales de nuestra cancion [ID, Titulo, Artista,Duración] 
    @Override
    public String toString() {
        return "[" + id + "] " + titulo + " - " + artista + " (" + duracion + "s)";
    }
}
