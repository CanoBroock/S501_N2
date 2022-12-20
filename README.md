Tenemos una entidad llamada FlorEntity, que dispone de las siguientes propiedades:

-          pk_FlorID entero

-          String nomFlor

-          Cuerda paisFlor

 

También tenemos una DTO llamada FlorDTO, que tendrá las mismas propiedades que la entidad Sucursal, añadiendo una:

-          Cuerda tipusFlor.

Esta propiedad, en función del país de origen de la flor, deberá indicar si es "UE" o "Fuera UE". Para hacer esto, puedes tener una lista privada en la misma DTO (por ejemplo: List<String> países), con los países que forman parte de la UE.

Aprovechando la especificación JPA, deberás persistir la entidad FlorEntity en una base de datos MySQL, siguiendo el patrón MVC.

Para ello, dependiendo del package principal, crearás una estructura de packages, donde ubicarás las clases que necesites:

-          cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n02.controllers

-          cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n02.model.domain

-          cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n02.model.dto

-          cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n02.model.services

-          cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n02.model.repository

La clase ubicada en el paquete controllers (FlorController, por ejemplo), deberá ser capaz de dar respuesta a las siguientes peticiones para actualizar y consultar información:

http://localhost:9001/flor/add

http://localhost:9001/flor/update

http://localhost:9001/flor/delete/{id}

http://localhost:9001/flor/getOne/{id}

http://localhost:9001/flor/getAll

 

Como puedes ver, en el archivo application.properties, deberás configurar que el puerto a usar sea el 9001.
