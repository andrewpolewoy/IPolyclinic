# Polyclinic website.

## Prerequisites:
* Docker
* JDK 1.7
* Maven 3.*

Implemented the ability to fill in and create a medical card, select a doctor and coupons for him, depending on the role. OAuth authorization is also implemented. The project is currently under refactoring.
## Install and run the project
1. download/clone the project

2. Build the project using following maven command from project root folder where pom.xml file place.
* `mvn clean package`
3. Run the docker-compose using the following command
* `docker-compose up`
4. Open the browser and hit the url.
* `http://localhost:8080/`
5. Next, you should register by clicking on the registration button on the menu.
6. Administrator role by default. To change the role, you need to uncomment the desired role in the class:
* 'src/main/java/com/it_academy/jd2/service/user/UserService.java'

> **Note:** Dockerfile and docker-compose.yml files are in project root dir.