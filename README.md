# Alien Game

## Requisitos
Java 17 o superior
Windonws 10 o superior

## Funcionamiento
El programa consta de eliminar aliens. Dichos aliens se van generando, ya sea en izquierda o derecha, y se van moviendo hacia el otro lado con diferentes velocidades.

Cada alien tiene valores diferentes generados aleatoriamente como el tamaño, velocidad, coordenada  Y y lugar de aparición (izquierda o derecha).

El cañón con el que se pueden eliminar los aliens, se mueve con las flechas `right` y `left`, además para disparar se asignó la tecla `space`.

### Valores ajustables por el usuario
El programa cuenta con 2 archivos de configuración `ModelConfig.properties` y `ViewConfig.properties` que se encuentran en la carpeta `src` del proyecto.

Cada archivo permite modificar valores que afectan diferentes parámetros del código, por ejemplo:

En el archivo `ModelConfig.properties` tenemos las siguientes claves.

- `initTime` es el tiempo inicial del contador de tiempo, el cual su valor predeterminado es 0.
- `maxSecondsAndMinutes` y `maxHours` son los valores máximos que pueden tomar los segundos, minutos y horas respectivamente, sus valores predeterminados son 59 y 23.
- `speedTimeThread` es la velocidad del hilo que controla el tiempo en juego, su valor predeterminado es de 1000 para que se vaya sumando como un segundo real.
- `cannonWidth` es el ancho del cañón.
- `cannonHeight` es el alto del cañón.
- `cannonPixelMovement` es la cantidad de píxeles que se va a mover el cañón al presionar una tecla para que este se mueva.
- `bulletWidth` es el ancho de la bala.
- `bulletHeight` es el alto de la bala.
- `bulletPixelMovement` es la cantidad de píxeles que se va a mover la bala por cada ejecución del hilo que la mueve.
- `minAlienWidth` es el valor mínimo que pueden tener de ancho los aliens
- `maxAlienWidth` es el valor máximo que pueden tener de ancho los aliens
- `minAlienHeight` es el valor mínimo que pueden tener de alto los aliens
- `maxAlienHeight` es el valor máximo que pueden tener de alto los aliens
- `minAlienSpeed` es el valor mínimo que pueden tener de velocidad los aliens
- `maxAlienSpeed` es el valor máximo que pueden tener de velocidad los aliens
- `timeToSpawnAlien` es el tiempo en milisegundos que tarda en crear un alien nuevo.
- `speedAliens` es la velocidad del hilo que se encarga de mover los hilos.

En el archivo `ViewConfig.properties` tenemos las siguientes claves.

- `paintSpeedThread` es la velocidad del hilo que actuliza el panel y sus componentes gráficos, su valor predeterminado es 1.
- `fontName`, `fontSize` y `fontStyle` son los valores que permiten modificar toda la letra que maneja el panel de información del juego. Sus valores predeterminados son `Arial`, `20` y `1`.
- `frameWidth` es el ancho inicial de la ventana de juego.
- `frameHeight` es el alto inicial de la ventana de juego.
- `alienImage` es la ruta de la imagen de los aliens.
- `bulletImage` es la ruta de la imagen de la bala.
- `cannonImage` es la ruta de la imagen del cañon.



IMPORTANTE: El tamaño de la ventana se puede modificar en ejecución del código, sus componentes se reubican automáticamente, **excepto** si se modifica el ancho, el cañón **no** se reubica automáticamente, lo demás se modifica de forma automatica.
