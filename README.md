
<div align="center">
    
## Cómo Levantar la API con HTTPS en Java Spring Boot

Este documento proporciona instrucciones detalladas para configurar y levantar la API desarrollada en Java Spring Boot con soporte para HTTPS.


Requisitos Previos
Antes de comenzar, asegúrate de tener los siguientes elementos:

1. Un certificado SSL/TLS válido (archivo `.pem` o `.crt`) y su clave privada (archivo `.key`).
2. Maven instalado en tu sistema.
3. Tener el proyecto Java Spring Boot para poder habilitar HTTPS.



## Pasos para Habilitar HTTPS

# Paso 1: Agregar Dependencia de Tomcat Embed

En tu archivo `pom.xml`, asegúrate de tener la dependencia de Tomcat Embed para poder configurar el servidor embebido con HTTPS.

Codigo:
```xml
<dependencies>
    ...
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-tomcat</artifactId>
    </dependency>
    ...
</dependencies>
```

Imagen:
 




# Paso 2: Configurar el archivo `application.properties`

Añade las siguientes propiedades al archivo `application.properties` de tu proyecto:

Codigo:
```properties
# Puerto HTTPS
server.port=8443

# Ubicación del certificado y clave privada
server.ssl.key-store=classpath:keystore.p12
server.ssl.key-store-password=password
server.ssl.keyStoreType=PKCS12
server.ssl.keyAlias=tomcat
```

Imagen:
 


Asegúrate de reemplazar `keystore.p12` con el nombre real de tu archivo de certificado y clave privada, y `password` con la contraseña correspondiente.

# Paso 3: Configurar el Certificado SSL

Coloca tu archivo de certificado y clave privada (por ejemplo, `keystore.p12`) en la carpeta `src/main/resources`.










# Paso 4: Habilitar HTTPS en tu Aplicación

En tu clase principal (por ejemplo, `MainApplication.java`), añade la anotación `@EnableWebSecurity`:

Codigo:

```java
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
public class MainApplication {
    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }
}
```

Imagen:
 


# Paso 5: Ejecutar la Aplicación

Ahora, puedes ejecutar el proyecto Java Spring Boot. Accederás a la API a través de HTTPS en el puerto 8443.

```
https://localhost:8443/tu-endpoint
```
 

# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.1.5/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.1.5/maven-plugin/reference/html/#build-image)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/3.1.5/reference/htmlsingle/index.html#using.devtools)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/3.1.5/reference/htmlsingle/index.html#data.sql.jpa-and-spring-data)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.1.5/reference/htmlsingle/index.html#web)

### Guides
The following guides illustrate how to use some features concretely:

* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)

# Spring Proyect
Para poder ejecutar adecuadamente este proyecto, se debe de tomar en cuenta los 
siguientes pasos a aseguir:

## Requirements
For building and running the application you need:

JDK 17
Maven 3.1.5
Running the application locally
There are several ways to run a Spring Boot application on your local machine. One way is to execute the main method in the de.codecentric.springbootsample.Application class from your IDE.

Alternatively you can use the Spring Boot Maven plugin like so:

mvn spring-boot:run
Deploying the application to OpenShift
The easiest way to deploy the sample application to OpenShift is to use the OpenShift CLI:

oc new-app codecentric/springboot-maven3-centos~https://github.com/codecentric/springboot-sample-app

This will create:

An ImageStream called "springboot-maven3-centos"
An ImageStream called "springboot-sample-app"
A BuildConfig called "springboot-sample-app"
DeploymentConfig called "springboot-sample-app"
Service called "springboot-sample-app"


If you want to access the app from outside your OpenShift installation, you have to expose the springboot-sample-app service:

oc expose springboot-sample-app --hostname=www.example.com

# Interprete

Intellij




[![jdkversions](https://img.shields.io/badge/Java-17%2B-yellow.svg)]()
[![ver](https://img.shields.io/badge/release-v0.1-red.svg)]()

## Overview

la app consta de un inventario en el cual se puede visualizar su contenido, a su vez de buscar, editar,y eliminar su contenido.


### Main technology stack

- Java 17
- Spring Boot 3.1.5
- Maven
- Mysql (not recommend, only convenience example)


### Preparation

- Por favor tener instalado Java en su version 17 o superiores
- install Node.js / NPM
- Clone Repository

        git clone https://github.com/.......
        
        cd Inventario


## Support

1. Github Issue

2. Contactame 

## Final
</div>

```
      .   ____          _
     /\\ / ___'_ __ _ _(_)_ __  __ _
    ( ( )\___ | '_ | '_| | '_ \/ _` |
     \\/  ___)| |_)| | | | | || (_| |
      '  |____| .__|_| |_|_| |_\__, |
\  ===========|_|==============|___/== ▀
\- ▌          SpringBoot-vue             ▀
 - ▌                            (o)        ▀
/- ▌            Go Go Go !               ▀
/  =================================== ▀
                    ██

*/

