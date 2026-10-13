package examen;
import java.util.Scanner;
public class Examen {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        ListaRepro lista = new ListaRepro();
        int opcion;

        do {
            System.out.println("\n======================================");
            System.out.println("     GESTOR DE LISTA DE REPRODUCCION");
            System.out.println("======================================");
            System.out.println("1. Agregar cancion al inicio");
            System.out.println("2. Agregar cancion al final");
            System.out.println("3. Buscar cancion por ID");
            System.out.println("4. Seleccionar cancion por ID");
            System.out.println("5. Eliminar cancion por ID");
            System.out.println("6. Eliminar cancion actual");
            System.out.println("7. Consultar cancion actual");
            System.out.println("8. Avanzar a la siguiente cancion");
            System.out.println("9. Retroceder a la cancion anterior");
            System.out.println("10. Mostrar lista en ambos sentidos");
            System.out.println("11. Consultar cantidad de canciones");
            System.out.println("12. Simular reproduccion");
            System.out.println("13. Salir");
            System.out.println("======================================");

            opcion = leerEntero(teclado, "Selecciona una opcion: ");
            switch (opcion) {
                case 1: {
                    System.out.println("\n--- AGREGAR CANCION AL INICIO ---");
                    Cancion cancion = crearCancion(teclado);
                    lista.agregarAlInicio(cancion);
                    System.out.println("Cancion agregada correctamente.");
                    System.out.println("Datos: " + cancion);
                    break;
                }
                case 2: {
                    System.out.println("\n--- AGREGAR CANCION AL FINAL ---");

                    Cancion cancion = crearCancion(teclado);
                    lista.agregarAlFinal(cancion);

                    System.out.println("Cancion agregada correctamente.");
                    System.out.println("Datos: " + cancion);
                    break;
                }
                case 3: {
                    System.out.println("\n--- BUSCAR CANCION ---");

                    int id = leerEnteroPositivo(
                            teclado, "Ingresa el ID de la cancion: ");

                    lista.buscarCancion(id);
                    break;
                }
                case 4: {
                    System.out.println("\n--- SELECCIONAR CANCION ---");

                    int id = leerEnteroPositivo(
                            teclado, "Ingresa el ID de la cancion: ");

                    lista.seleccionarPorId(id);
                    break;
                }
                case 5: {
                    System.out.println("\n--- ELIMINAR CANCION POR ID ---");

                    int id = leerEnteroPositivo(
                            teclado, "Ingresa el ID de la cancion: ");

                    if (lista.eliminarPorId(id)) {
                        System.out.println("Cancion eliminada correctamente.");
                    } else {
                        System.out.println(
                                "No se pudo eliminar: el ID no existe "
                                + "o la lista esta vacia.");
                    }
                    break;
                }
                case 6: {
                    System.out.println("\n--- ELIMINAR CANCION ACTUAL ---");
                    Cancion actual = lista.consultarActual();

                    if (actual == null) {
                        System.out.println(
                                "La lista está vacia. No hay cancion que eliminar.");
                    } else {
                        System.out.println("Cancion eliminada: " + actual);
                        lista.eliminarActual();

                        if (lista.consultarActual() != null) {
                            System.out.println(
                                    "Nueva cancion actual: "
                                    + lista.consultarActual());
                        } else {
                            System.out.println(
                                    "La lista quedo vacia.");
                        }
                    }
                    break;
                }
                case 7: {
                    System.out.println("\n--- CANCION ACTUAL ---");
                    Cancion actual = lista.consultarActual();

                    if (actual == null) {
                        System.out.println("La lista esta vacia.");
                    } else {
                        System.out.println("Cancion actual: " + actual);
                    }
                    break;
                }

                case 8: {
                    System.out.println("\n--- SIGUIENTE CANCION ---");

                    if (lista.consultarActual() == null) {
                        System.out.println("La lista esta vacia.");
                    } else {
                        lista.avanzar();
                        System.out.println(
                                "Ahora reproduciendo: "
                                + lista.consultarActual());
                    }
                    break;
                }

                case 9: {
                    System.out.println("\n--- CANCION ANTERIOR ---");

                    if (lista.consultarActual() == null) {
                        System.out.println("La lista esta vacia.");
                    } else {
                        lista.retroceder();
                        System.out.println(
                                "Ahora reproduciendo: "
                                + lista.consultarActual());
                    }
                    break;
                }

                case 10: {
                    System.out.println("\n--- LISTA HACIA ADELANTE ---");
                    lista.mostrarHaciaAdelante();

                    System.out.println("\n--- LISTA HACIA ATRAS ---");
                    lista.mostrarHaciaAtras();
                    break;
                }

                case 11: {
                    System.out.println("\n--- CANTIDAD DE CANCIONES ---");
                    System.out.println(
                            "Total de canciones: " + lista.getTamaño());
                    break;
                }

                case 12: {
                    System.out.println("\n--- SIMULAR REPRODUCCION ---");

                    if (lista.consultarActual() == null) {
                        System.out.println(
                                "La lista esta vacia. No hay canciones que reproducir");
                    } else {
                        int cantidad = leerEnteroPositivo(
                                teclado,
                                "¿Cuantas canciones deseas reproducir? ");

                        System.out.println("\nIniciando reproducción...\n");
                        lista.simularReproduccion(cantidad);

                        System.out.println("\nFin de la reproducción simulada.");
                        System.out.println(
                                "Siguiente canción: "
                                + lista.consultarActual());
                    }
                    break;
                }

                case 13: {
                    System.out.println(
                            "\nSaliendo del gestor de reproduccion...");
                    System.out.println("¡Hasta pronto, Colega!");
                    break;
                }

                default: {
                    System.out.println(
                            "Opcion invalida. Selecciona un numero del 1 al 13");
                    break;
                }
            }
        } while (opcion != 13);
        teclado.close();
    }

    // Solicita los datos necesarios para crear una canción
    private static Cancion crearCancion(Scanner teclado) {

        System.out.print("Titulo de la cancion: ");
        String titulo = teclado.nextLine().trim();

        while (titulo.isEmpty()) {
            System.out.print("El titulo no puede estar vacio. Intentalo de nuevo: ");
            titulo = teclado.nextLine().trim();
        }

        System.out.print("Artista: ");
        String artista = teclado.nextLine().trim();

        while (artista.isEmpty()) {
            System.out.print("El artista no puede estar vacio. Intentalo de nuevo: ");
            artista = teclado.nextLine().trim();
        }

        int duracion = leerEnteroPositivo(
                teclado, "Duracion en segundos: ");

        return new Cancion(titulo, artista, duracion);
    }

    // Lee un entero y vuelve a solicitarlo si la entrada es inválida
    private static int leerEntero(Scanner teclado, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String entrada = teclado.nextLine().trim();

            try {
                return Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                System.out.println(
                        "Entrada invalida. Debes introducir un numero entero");
            }
        }
    }

    // Lee un entero estrictamente positivo
    private static int leerEnteroPositivo(
            Scanner teclado, String mensaje) {
        while (true) {
            int numero = leerEntero(teclado, mensaje);

            if (numero > 0) {
                return numero;
            }

            System.out.println(
                    "El numero debe ser mayor que cero. Intentalo de nuevo");
        }
    }
}