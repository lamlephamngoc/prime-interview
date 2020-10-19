# Single Web Application find highest prime lower than input number

## Contents
 1. [Technical Stack](#technical-stack)
 2. [Setup](#setup)
 5. [Deploy Docker Datacenter](#deploy-docker-datacenter)
 4. [About author](#about-author)

### Technical Stack

  - Backend
    - JAVA jdk-11.0.5.jdk
    - maven 3.6.0
    - Spring boot 2.3.3.RELEASE
    - junit-jupiter 5.6.2
  - Frontend
    - Vuejs 2.5.13
    - Bootstrap 4.3.1
  - Deployment
    - Docker

### Setup

#### Build

```sh
$ docker build -t interview/spring-boot-vue-prime:1.0.0-SNAPSHOT .
```

#### Run application

```sh
$ docker run -d -p 9999:8080 -t interview/spring-boot-vue-prime:1.0.0-SNAPSHOT
```

Open browser and go to
```
http://localhost:9999
```

### About author
Copyright © lamle@gmx.com
