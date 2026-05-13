Tarea Evaluación Módulo 15
Fecha de entrega 8 de abr a las 23:30 Puntos 10 Entregando una URL de página web Disponible después de 7 de abr en 13:00
Práctica: Pruebas Unitarias con JUnit 5 en VS Code
Objetivo:
Aprender a configurar un entorno de desarrollo para Java fuera de IntelliJ, utilizando Visual Studio Code y Maven para gestionar tests unitarios.

1. Configuración del proyecto
No vamos a crear carpetas a mano. Usaremos el asistente de VS Code:

Abre VS Code y pulsa F1 (o Ctrl+Shift+P).

Busca: Java: Create Java Project.

Elige Maven y luego la opción maven-archetype-quickstart.

Versión: dale a la última que te salga.

GroupId: entornos | ArtifactId: test-vscode.

Elige una carpeta y, cuando termines en la terminal inferior, pulsa Enter hasta que te diga que el proyecto se ha creado. Ábrelo.

2. El archivo de configuración (pom.xml)
Para que VS Code entienda JUnit 5, abre el archivo pom.xml y asegúrate de que en el apartado de <dependencies> aparece esto (si sale JUnit 4, cámbialo por esto):

3. Código a probar
En la ruta src/main/java/entornos, crea el archivo CalculadoraRiesgo.java. Vamos a programar una lógica sencilla de seguros:

package entornos;

public class CalculadoraRiesgo {
    public String evaluarEdad(int edad) {
        if (edad < 0 || edad > 120) return "Error";
        if (edad < 18) return "Joven";
        if (edad <= 65) return "Adulto";
        return "Senior";
    }
}

4. Creación del Test
Vete a la carpeta src/test/java/entornos. Crea un archivo llamado CalculadoraRiesgoTest.java:

package entornos;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class CalculadoraRiesgoTest {
    CalculadoraRiesgo calc = new CalculadoraRiesgo();

    @Test
    void testEdadNegativa() {
        assertEquals("Error", calc.evaluarEdad(-5));
    }

    @Test
    void testAdulto() {
        assertEquals("Adulto", calc.evaluarEdad(25));
    }
    
    // TODO: Añade tú un test para el caso "Senior" y otro para el límite de 18 años
}

<dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter-api</artifactId>
    <version>5.10.0</version>
    <scope>test</scope>
</dependency>

5. Cómo manejar los tests en VS Code (Lo que se evalúa)
Para superar la práctica, debes manejar estas tres herramientas de la interfaz:

El Matraz: En la barra lateral izquierda verás un icono de un matraz de laboratorio. Es el Testing Explorer. Úsalo para ejecutar todos los tests de golpe.

Codelens: Mira que encima de cada @Test te sale un texto pequeño que dice Run | Debug. Pulsa en Run para lanzar solo ese test.

Depuración: Pon un punto rojo (clic a la izquierda del número de línea) en el código de la calculadora y usa el botón Debug del test para ver cómo va saltando el programa paso a paso.
