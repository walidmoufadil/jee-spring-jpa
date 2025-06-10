# Application de Gestion des Rendez-vous Médicaux

## Description du projet

Cette application est un système de gestion des rendez-vous médicaux développé avec Spring Boot, JPA et MySQL. Elle permet de gérer les médecins, les patients, les rendez-vous et les consultations médicales au sein d'une clinique ou d'un hôpital.

## Table des matières

1. [Technologies utilisées](#technologies-utilisées)
2. [Structure du projet](#structure-du-projet)
3. [Modèle de données](#modèle-de-données)
4. [Configuration](#configuration)
5. [API REST](#api-rest)
6. [Installation et déploiement](#installation-et-déploiement)
7. [Sécurité](#sécurité)
8. [Auteurs](#auteurs)

## Technologies utilisées

- **Java 17**
- **Spring Boot**
- **Spring Data JPA**
- **MySQL**
- **Lombok**
- **Maven**

## Structure du projet

Le projet suit une architecture en couches classique pour une application Spring Boot :

```
src/
├── main/
│   ├── java/
│   │   └── com/
│   │       └── enset/
│   │           └── sdia/
│   │               ├── entity/        # Entités JPA
│   │               ├── repository/    # Repositories JPA
│   │               ├── service/       # Services métier
│   │               │   └── Impl/      # Implémentations des services
│   │               └── web/           # Contrôleurs REST
│   └── resources/
│       └── application.properties     # Configuration de l'application
```

## Modèle de données

L'application est construite autour des entités principales suivantes :

### Diagramme de classes

```
+----------------+      +----------------+      +----------------+
|    Patient     |      |  RendezVous    |      |   Medecin     |
+----------------+      +----------------+      +----------------+
| id             |<---->| id             |<---->| id             |
| name           |      | dateRDV        |      | nom            |
| dateNaissance  |      | heureRDV       |      | email          |
| malade         |      | statusRdv      |      | specialite     |
| score          |      |                |      |                |
+----------------+      +----------------+      +----------------+
                              |
                              |
                              v
                        +----------------+
                        | Consultation   |
                        +----------------+
                        | id             |
                        | dateConsultation|
                        | rapportConsultation |
                        +----------------+

+----------------+      +----------------+
|     User       |      |     Role       |
+----------------+      +----------------+
| id             |<---->| id             |
| username       |      | rolename       |
| password       |      | description    |
+----------------+      +----------------+
```

### Description des entités

1. **Patient** : Représente les informations du patient (nom, date de naissance, état de santé).
2. **Medecin** : Contient les informations sur les médecins (nom, email, spécialité).
3. **RendezVous** : Gère les rendez-vous entre patients et médecins (date, heure, statut).
4. **Consultation** : Enregistre les détails d'une consultation médicale suite à un rendez-vous.
5. **User** et **Role** : Gèrent les utilisateurs et leurs rôles dans le système.

## Configuration

La configuration de l'application se fait via le fichier `application.properties` :

```properties
spring.application.name=jee-spring-jpa
server.port=8000
spring.datasource.url=jdbc:mysql://localhost:3306/patientDB?createDatabaseIfNotExist=True
spring.datasource.username=root
spring.datasource.password=walid123
spring.jpa.hibernate.ddl-auto=create
```

## API REST

L'application expose plusieurs endpoints REST pour gérer les différentes entités :

### Gestion des patients

- `GET /patient/all` : Récupérer tous les patients
- `GET /patient/{id}` : Récupérer un patient par son ID
- `POST /patient/add` : Ajouter un nouveau patient

### Gestion des médecins

- `GET /medecin/all` : Récupérer tous les médecins
- `GET /medecin/id` : Récupérer un médecin par son ID
- `POST /medecin/add` : Ajouter un nouveau médecin

### Gestion des rendez-vous

- `GET /rendezvous/all` : Récupérer tous les rendez-vous
- `GET /rendezvous/{id}` : Récupérer un rendez-vous par son ID
- `POST /rendezvous/add` : Ajouter un nouveau rendez-vous

### Gestion des consultations

- `GET /consultation/all` : Récupérer toutes les consultations
- `GET /consultation/{id}` : Récupérer une consultation par son ID
- `POST /consultation/add` : Ajouter une nouvelle consultation

### Gestion des utilisateurs

- `GET /user/all` : Récupérer tous les utilisateurs
- `GET /user/{id}` : Récupérer un utilisateur par son ID
- `POST /user/add` : Ajouter un nouvel utilisateur

## Installation et déploiement

### Prérequis

- JDK 17 ou supérieur
- MySQL 8.0 ou supérieur
- Maven 3.6 ou supérieur

### Étapes d'installation

1. **Cloner le dépôt Git**
   ```bash
   git clone https://github.com/votre-nom/jee-spring-jpa.git
   cd jee-spring-jpa
   ```

2. **Configurer la base de données**
   
   Assurez-vous que MySQL est installé et en cours d'exécution.
   Modifiez les paramètres de connexion dans `src/main/resources/application.properties` selon votre configuration locale.

3. **Compiler et exécuter l'application**
   ```bash
   ./mvnw clean install
   ./mvnw spring-boot:run
   ```
   
   L'application sera accessible à l'adresse : http://localhost:8000

## Sécurité

L'application implémente une gestion basique des utilisateurs et des rôles. Le système d'authentification est basé sur un modèle simple d'utilisateurs et de rôles, avec des méthodes d'authentification intégrées dans le service `IUserService`.

## Auteurs

Développé par MOUFADIL WALID.

---

© 2025 | Application de Gestion des Rendez-vous Médicaux
