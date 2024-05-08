# Alien Game

## Requisitos
- Java 17 o superior
- Windonws 10 o superior

## Funcionamiento
El programa consta de eliminar aliens. Dichos aliens se van generando, ya sea en izquierda o derecha, y se van moviendo hacia el otro lado con diferentes velocidades.

Al iniciar el programa saldra un menu que le pedira ingresar la tecla para disparar, sin embargo, hay algunas teclas que no estan disponibles como shift,control,alt, las tecla F (F1,F2,etc)

Cada alien tiene valores diferentes generados aleatoriamente como el tamaño, velocidad, coordenada  Y y lugar de aparición (izquierda o derecha).

El cañón con el que se pueden eliminar los aliens, se mueve con las flechas `right` y `left`.

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
- `fontPath` es la ruta de la fuente que maneja el juego.
- `frameWidth` es el ancho inicial de la ventana de juego.
- `frameHeight` es el alto inicial de la ventana de juego.
- `alienImage` es la ruta de la imagen de los aliens.
- `bulletImage` es la ruta de la imagen de la bala.
- `cannonImage` es la ruta de la imagen del cañon.
- `backgroundImage` es la ruta de la imagen del fondo del panel.
- `aliensAliveTitle` es el texto que aparece al lado de los aliens vivos.
- `aliensKilledTitle` es el texto que aparece al lado de los aliens eliminados.
- `timeTitle` es el texto que aparece al lado del texto.
- `menuWidth` es el ancho del menu.
- `menuHeight` es el alto del menu.
- `menuKeyLabel` es el texto que aparece en el menu para presionar una tecla.
- `beforeSelectKeyLabel` es el texto que avisa al usuario que debe presionar una tecla para disparar.
- `keySelectedLabel` es el texto que notifica al usuario que se ha guardado la tecla.
- `startButtonText` es el texto del boton del menu.
- `errorText` es el texto del error que sale si no se pone una tecla.
- `titleGameLabel` es el titulo del juego que aparece en el menu.
- `noteLabel` es un mensaje que aparece notificando al usuario algunas de las teclas que no estan permitidas.

IMPORTANTE: El tamaño de la ventana se puede modificar en ejecución del código, sus componentes se reubican automáticamente, **excepto** si se modifica el ancho, el cañón **no** se reubica automáticamente, lo demás se modifica de forma automatica.
