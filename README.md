# Gestor de Listas de Reproducción

## 1. Descripción del proyecto

Este proyecto consiste en desarrollar un gestor de listas de reproducción musicales en Java, utilizando una **lista doblemente enlazada circular** implementada manualmente.

El programa permite administrar canciones y navegar entre ellas en ambos sentidos. Al llegar a la última canción y avanzar, se regresa a la primera. De igual manera, al retroceder desde la primera canción, se llega a la última.

La reproducción es simulada mediante mensajes en consola; no se utilizan archivos de audio.

## 2. Objetivo

Implementar una estructura de datos dinámica que permita insertar, buscar, seleccionar, eliminar y recorrer canciones, aplicando los conceptos de nodos, referencias, tipos abstractos de datos y análisis de complejidad temporal.

## 3. Tecnologías utilizadas

- **Lenguaje:** Java.
- **Entorno de desarrollo:** Apache NetBeans.
- **Interfaz:** Consola.
- **Estructura de datos:** Lista doblemente enlazada circular.
- **Entrada de datos:** Clase `Scanner`.

> Versión de Java: JDK 20.

## 4. Estructura del proyecto

Todas las clases pertenecen al paquete `examen`.

| Archivo | Responsabilidad |
|---|---|
| `Cancion.java` | Almacena el identificador, título, artista y duración de cada canción. |
| `Nodo.java` | Representa un nodo con una canción y referencias al nodo anterior y al siguiente. |
| `ListaRepro.java` | Implementa la lista circular y sus operaciones de inserción, búsqueda, eliminación y navegación. |
| `Examen.java` | Contiene el método `main` y el menú de interacción con el usuario. |

## 5. Funcionamiento de la estructura

Cada nodo contiene una referencia a una canción, una referencia al nodo anterior y otra al nodo siguiente.

La lista mantiene las referencias `inicio`, `fin` y `actual`, además de un contador llamado `tamaño`.

En una lista no vacía se cumplen las siguientes condiciones:

- El siguiente nodo de `fin` es `inicio`.
- El nodo anterior de `inicio` es `fin`.
- Los enlaces entre nodos son consistentes en ambos sentidos.
- La referencia `actual` señala a una canción perteneciente a la lista.
- Si existe una sola canción, sus referencias anterior y siguiente apuntan al mismo nodo.

Los identificadores de las canciones se generan automáticamente mediante un contador incremental.

## 6. Funcionalidades

El menú permite realizar las siguientes operaciones:

1. Agregar una canción al inicio.
2. Agregar una canción al final.
3. Buscar una canción por identificador.
4. Seleccionar una canción como actual.
5. Eliminar una canción por identificador.
6. Eliminar directamente la canción actual.
7. Consultar la canción actual.
8. Avanzar a la siguiente canción.
9. Retroceder a la canción anterior.
10. Mostrar todas las canciones en ambos sentidos.
11. Consultar la cantidad de canciones.
12. Simular la reproducción de una cantidad determinada de canciones.
13. Salir del programa.

El programa valida las entradas numéricas del menú y solicita una duración mayor que cero al registrar una canción.

## 7. Complejidad temporal

Sea `n` la cantidad de canciones y `k` la cantidad de canciones que se desean reproducir.

| Operación | Complejidad |
|---|---|
| Agregar al inicio | O(1) |
| Agregar al final | O(1) |
| Consultar la canción actual | O(1) |
| Avanzar o retroceder | O(1) |
| Eliminar la canción actual | O(1) |
| Consultar la cantidad de canciones | O(1) |
| Buscar por identificador | O(n) |
| Seleccionar por identificador | O(n) |
| Eliminar por identificador | O(n) |
| Mostrar todas las canciones | O(n) |
| Simular `k` reproducciones | O(k) |

Las inserciones y las eliminaciones directas utilizan referencias ya disponibles para modificar los enlaces sin recorrer la lista. En cambio, las operaciones por identificador requieren buscar la canción. La reproducción simulada realiza exactamente `k` iteraciones.

## 8. Comparación con un arreglo

Una lista doblemente enlazada circular permite insertar y eliminar elementos mediante referencias sin desplazar los demás elementos. También facilita la navegación hacia adelante y hacia atrás.

En un arreglo, el acceso por índice es O(1), pero insertar o eliminar elementos en posiciones intermedias puede requerir desplazar elementos, con un costo de O(n). Un arreglo también puede reservar espacio sin utilizar, mientras que la lista necesita memoria adicional para almacenar las referencias de cada nodo.

La lista circular resulta adecuada para este proyecto porque permite navegar continuamente entre canciones en ambos sentidos.

## 9. Pruebas de funcionamiento

Se deben realizar pruebas que contemplen los siguientes escenarios:

- Operaciones con la lista vacía.
- Inserción de la primera canción.
- Navegación con un solo nodo.
- Inserciones al inicio y al final.
- Recorridos hacia adelante y hacia atrás con cinco o más canciones.
- Navegación circular desde el último elemento al primero y viceversa.
- Eliminación del primero, último, un elemento intermedio y la canción actual.
- Eliminación de la única canción.
- Búsqueda y eliminación de identificadores inexistentes.
- Reproducción simulada con más canciones que las almacenadas.
- Manejo de entradas inválidas.

Después de cada modificación, se debe verificar la cantidad de canciones, los enlaces y la referencia a la canción actual. Los resultados obtenidos deben registrarse y compararse con los resultados esperados.

## 10. Requisitos y ejecución

### Requisitos previos

- Tener instalado el JDK de Java utilizado para compilar el proyecto.
- Contar con Apache NetBeans u otro entorno compatible.
- Tener los cuatro archivos fuente dentro del paquete `examen`.

### Ejecución en Apache NetBeans

1. Abrir el proyecto en NetBeans.
2. Verificar que las cuatro clases estén dentro del paquete `examen`.
3. Abrir `Examen.java`.
4. Ejecutar el archivo mediante **Run File** o configurar `examen.Examen` como clase principal del proyecto.
5. Utilizar las opciones del menú para administrar la lista.

### Compilación y ejecución desde la terminal

Desde la carpeta que contiene el directorio `examen`, ejecutar:

```
javac examen/Cancion.java examen/Nodo.java examen/ListaRepro.java examen/Examen.java
java examen.Examen
```

En Windows también pueden utilizarse estos comandos desde la terminal de comandos, siempre que el JDK esté correctamente configurado en el `PATH`.

## 11. Integrantes del equipo

1. Cervantes Márquez Joan Antonio
2. Espinosa Rojas Jonatan Mateo
3. García García Israel Isaac
4. Zamora Tierrablanca Saúl Isaí

## 12. Conclusión

El proyecto permite aplicar los fundamentos de las estructuras de datos mediante una lista doblemente enlazada circular. Su implementación demuestra la importancia de administrar correctamente las referencias entre nodos, conservar la integridad de la estructura y distinguir entre las operaciones que requieren recorrer la lista y aquellas que pueden realizarse en tiempo constante.
