# Proyecto Final Microservicios con Spring Boot

Este repositorio contiene el proyecto final para el curso 'Microservicios con Spring Boot', impartido por Escalab Academy.

## Descripción

Este proyecto simula un generador aleatorio de premios, o items coleccionables, que puede obtener un usuario registrado en la aplicación. Cada item posee un tipo, que determina su rareza y probabilidad de  aparición.

El proyecto consta de tres microservicios principales:

- ms-tipos: Contiene los datos asociados al tipo, y permite generar un tipo aleatorio para ser usado por otros microservicios.
- ms-items: Administra los distintos items disponibles en la aplicación. Contiene un método que permite obtener un item aleatorio según un tipo determinado.
- ms-usuarios: Posee el registro de los usuarios de la aplicación, junto con el registro de items que cada usuario ha obtenido. Es capaz de obtener un nuevo item aleatorio para un usuario, comprobar si es un item repetido, y asignarlo a su colección si es que no está repetido.

Además de estos tres microservicios, la arquitectura contempla la creación de:

- Un servidor de descubrimiento Eureka (eureka-server)
- Un servidor perimetral Zuul (zuul-server)
- Un servidor de configuración centralizada (cloud-config-server)
- Un servidor API Composer (ms-composer), que entrega la información detallada de un usuario, y su lista de items que ha coleccionado

## Bases de datos

Cada microservicio utiliza un sistema de bases de datos diferente para persistir los datos:

- ms-tipos: Utiliza PosgreSQL. El script con la estructura y los datos iniciales se puede encontrar en scripts-bbdd/ms-tipos_tipo.sql
- ms-items: Utiliza MongoDB. El script con la data inicial se encuentra en scripts-bbdd/ms-items_item.json
- ms-usuarios: Utiliza MySQL. El script con la estructura y datos iniciales se encuentra en scripts-bbdd/ms-usuarios**.sql

## Rutas

Las rutas HTTP más destacadas de este proyecto son:

- ms-usuarios: POST /api/obtain
    - Otorga un item aleatorio al usuario especificado. El id del usuario debe enviarse a través de un objeto JSON, en un campo de nombre idUsuario.
- ms-composer: GET /api/userdetails/{userId}
    - Entrega la información detallada del usuario, junto con la lista de items obtenidos por el usuario hasta el momento.

Además, el servidor perimetral Zuul está configurado de la siguiente forma:

- /tipos/** : Deriva las solicitudes al microservicio ms-tipos
- /items/** : Deriva las solicitudes al microservicio ms-items
- /usuarios/** : Deriva las solicitudes al microservicio ms-usuarios