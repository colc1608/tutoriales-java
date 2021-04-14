FROM openjdk:8-alpine

USER root

### Variables de Servicio
ENV SERVICE_PATH=/service.jar

### Variables de Spring Boot
ENV SPRING_PROFILES_ACTIVE=cloud

### Se copia el compilado del servicio.
ADD /target/exchange-operation-service-1.0.0.jar ${SERVICE_PATH}
CMD java -jar ${SERVICE_PATH}

#EXPOSE 8091



# docker build . 
# docker run -p 8091:8090 bb1ee98d2540 

## --------------------------------------------------
# docker build -t reactive/bcp-exchange:v1 . 
# docker run -p 8091:8090 -d --name reactive_bcp_exchange bb1ee98d2540 



