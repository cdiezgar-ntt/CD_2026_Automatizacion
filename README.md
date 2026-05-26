# CD_2026_Auto

Framework Cartera Digital 2026

DESCRIPCION:
Este framework se encarga de automatizar la parte web (Portales) del proyecto Cartera Digital 2026
Portales está dividido en 4 webs (Portal Usuario, Wallet Provider, PID Provider, EAA Provider)
El framework permite lanzar de manera automatizada la pruebas de cada una de las webs tanto de manera independiente como conjunta, a través de los test (.features) de cucumber y posteriormente lanzar el resultado de la ejecución en un reporte.

TECNOLOGIAS:
-	Selenium
-	Gherkin/Cucumber
-	Extent reports

ESTRUCTURA:
El proyecto se divide en 3 carpeta principales (src, test y resources) y dos carpetas secundarias donde se encuentran las properties y los outputs generados.
-	SRC: En esta estructura se encuentra el grueso de la codificación, incluyendo una estructura similar al Base Page Object model. Además de encontrarse las utilidades como lectura de drivers, clases para controlar lo reportes y lectura de properties.
-	Test: En esta clase se encuentra el runner que es el encargado de ejecutar los test indicándoselo a través de paramentros y los steps de cucumber que se llaman en los test, estas clases se apoyan en el contenido insertado en SRC y son las que llaman a los métodos de estas.
-	Resources: Carpetas donde se encuentran los test (.feaure), los test vienen identificados como su ID correspondiente en JIRA, están divididas por cada Portal.
-	Properties: Carpeta de elemento de lectura externos y path de los elementos de los portales.
-	Outputs: Carpetas donde se encuentran los reportes de las ejecuciones realizadas.

RUNNER
La clase runner es la encarga del arranque del framework y la ejecución de las pruebas.
A continuación, se indican ciertas runner options de los tags que se puede incorporar a lanzamiento dependiendo de las necesidades:
- No ejecutar x test que se encuentre con la etiqueta base: @Test and not @noejecutar
- Ejecutar varias etiquetas en una sola ejecución: @Test and (@tag1 or @tag2 or @tag3)

EJECUCION:
Para ejecutar el framework se debe ejecutar la clase runner, esta se encuentra en la carpeta test y se llama TestRunner. Para ejecutar el runner se debe indicar a través de los parámetros que test se desea ejecutar, para esto se pueden usar los tags de cucumber.
Una vez ejecutado leera los test que se encuentren el tag indicado y comenzará a ejecutar cada uno de los test indicado, el sistema de ejecución empleado que realiza el programa sería el siguiente: 
1.	El runner lee el test indicado a través de los tags.
2.	El runner llama a los steps de cucumber que se encuentran en la carpeta test.
3.	Los steps de cucumber llaman a los métodos de las clases que se encuentran en la carpeta src.
4.	Los métodos de las clases de la carpeta src realizan las acciones indicadas en los test y generan el reporte de la ejecución.
5.	El reporte se guarda en la carpeta outputs con el nombre del test ejecutado y la fecha de ejecución.
Al tener una estructura base cada clase y método se puede reutilizar para otros test, lo que permite una mayor eficiencia en la codificación y mantenimiento del framework. Además, al tener los test divididos por portal, se puede ejecutar de manera independiente cada portal o de manera conjunta dependiendo de las necesidades.
