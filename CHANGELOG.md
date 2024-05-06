# CHANGELOG

## [v1.1] - Mayo 5, 2024

### Nuevo
- Se ha añadido la función para que los nuevos marcianos que vayan apareciendo en el panel se vayan moviendo automáticamente

### Modifcado
- Se ha modificado la imagen de los marcianos, cañón y balas, se han puesto imágenes mas acordes a la temática del juego
- Se ha modificado el método `startAlien` ya que ahora ya no itera sobre una lista de marciano si no sobre un marciano que se le pasa por parámetro
- Se ha modificado la lista `aliens` de tipo `ArrayList` a `CopyOnWriteArrayList` esto para evitar errores de concurrencia con los hilos y tenga mejor manejo el programa

## [v1.0] - Mayo 3, 2024

### Nuevo
- Se han creado 10 marciano en el panel
- Se ha creado la clase `ViewPropertiesUtil` que permite manejar toda la configuración del paquete `view`
- Se ha creado el método que permite eliminar los marcianos 
- Se ha creado el método que permite mover los marcianos

### Modificado
- Se han modificado las teclas de movimiento del cañón de `A` a `leftArrow` y `D` a `rightArrow`

## [v0.5] - Mayo 1, 2024

### Añadido
- Archivo `config.properties` para almacenar la configuración del paquete `model`.
- Paquete `util` con las clases `ModelPropertiesUtil` y `SleepUtil`.
  - `ModelPropertiesUtil` maneja el archivo `config.properties`.
  - `SleepUtil` maneja los `Sleep` para un código más limpio.

### Modificado
- Clases del paquete `model` para usar la configuración del archivo.
- Métodos que usaban `Thread.sleep` para usar el método de `SleepUtil`.

### Eliminado
- Información quemada del paquete `model` como tamaños, velocidades, coordenadas, etc.

## [v0.4] - Mayo 1, 2024

### Añadido
- Funcionalidad de disparar balas con la tecla espacio.

## [v0.3] - Abril 29, 2024

### Añadido
- Hilo que repinta la clase `Dashboard` periódicamente.
- `keyListener` para mover el cañón con las teclas A (izquierda) y D (derecha).

## [v0.2] - Abril 29, 2024

### Añadido
- Clases `Dashboard` e `InformationPanel` en el paquete `view`.
- Clase `ManageInfo` en `model` para contar tiempo con formato HH MM SS.
- Métodos en la interfaz `ContractPlay`.

## [v0.1] - Abril 29, 2024

### Añadido
- Estructura del proyecto bajo el patrón MVP.
