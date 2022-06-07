FROM openjdk:11
EXPOSE 8761
ADD /target/MSA-gestion-stock-product-0.0.1-SNAPSHOT.jar MSA-gestion-stock-product-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "MSA-gestion-stock-product-0.0.1-SNAPSHOT.jar"]