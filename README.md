# Projet Nouveau Yucca

## Pré-requis

Lombok doit être installé dans Eclipse (afin de voir le code généré à chaud), il est également utilisé par Maven lors de la compilation.

### Logiciels

Liste des pré-requis :
* [Eclipse](https://www.eclipse.org/), avec les plugins :
    * [Lombok](https://projectlombok.org/download)
* [NodeJS](https://nodejs.org/en/) En version LTS (8.x.x)
* [ng-cli](https://cli.angular.io/) L'outillage Angular en ligne de commande : `npm install -g @angular/cli` 

Toutefois, afin que Lombok fonctionne avec MapStruct, il est nécessaire de rajouter
la classe "org.mapstruct.ap.spi.AstModifyingAnnotationProcessor" de MapStruct dans le jar de lombok
utilisé par Eclipe.

### Configuration

Pensez également qu'il est nécessaire de configurer le proxy pour vos outils :
* git
    * `git config --global http.proxy http://proxy.in.ac-aix-marseille.fr:8080`
* npm
    * `npm config set proxy http://proxy.in.ac-aix-marseille.fr:8080`
    * `npm config set https-proxy http://proxy.in.ac-aix-marseille.fr:8080`
* eclipse
* maven

### Description

L'application est proposée avec les librairies suivantes :
* Spring Boot 2
* Spring 5
* Thymeleaf 3
* Lombok

### Configuration Eclipse

#### Encodage

Configurer l'encodage d'Eclipse en UTF-8 pour
* General / Workspace
* Web / CSS Files
* Web / HTML Files
* Web / JSP Files
* XML / XML Files

### Lancer le back

Par défaut, Yucca démarre en mode "production", il faut donc lui indiquer le profile "dev" pour le lancer depuis Eclipse.
Dans Spring, ceci peut être passé par une variable de la VM : `-Dspring.profiles.active=dev`

La classe de démarrage Spring Boot est : `fr.edu.aix.yuccaspringboot.YuccaApiDataApplication`

### Principe

#### Fichiers de configuration

Les fichiers de configuration de Spring Boot sont dans le répertoire `src/main/resources`

Par défaut, le fichier `application.properties` est toujours lu, il est ensuite enrichi et surchargé par les fichiers `application-<env>.properties`.

Notez également qu'il est possible de fournir plusieurs environnements.

Ces fichiers seront dans le war, il ne s'agit donc pas d'une configuration externe.

Dans notre cas, la configuration générale est donc dans le fichier `application.properties`
et les spécificités de l'environnement de dev dans le fichier `application-dev.properties`.

En plus de l'application, de nombreux comportements de Spring peut être configurés par ce fichier :
[Référence de la configuration](https://docs.spring.io/spring-boot/docs/current/reference/html/common-application-properties.html)

#### Configuration

Toute la configuration de notre application se fait dans le package `fr.edu.aix.yuccaspringboot.config`
* TODO