# ERP Authentication Service

## Maven

### Build

mvn clean install

### Run

cd target

java -jar file-name.jar

java -jar file-name.jar --spring.profiles.active=localhost

java -jar file-name.jar --spring.profiles.active=development

java -jar file-name.jar --spring.profiles.active=production

## Docker

### Build

docker build -t erp-authentication-service:latest -f Dockerfile .

### Run

docker run -it --restart always --name erp-authentication-service-localhost -p 1010:1010 -e SPRING_PROFILES_ACTIVE=localhost erp-authentication-service:latest

docker run -it --restart always --name erp-authentication-service-development -p 1010:1010 -e SPRING_PROFILES_ACTIVE=development erp-authentication-service:latest

docker run -it --restart always --name erp-authentication-service-production -p 1010:1010 -e SPRING_PROFILES_ACTIVE=production erp-authentication-service:latest

#### SPRING_PROFILES_ACTIVE (env)

localhost, development, production
