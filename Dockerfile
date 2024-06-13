#This is a work-queue-services docker file

FROM docker-images.labcorp.com/mi/jre21:latest

# Lock container down with SSL
#ENV SERVER_PORT=8443
#ENV SERVER_SSL_KEY_STORE=/etc/ssl/labcorp/camp_default.p12
#ENV SERVER_SSL_KEY_STORE_TYPE=PKCS12
#ENV SERVER_SSL_KEY_ALIAS=tomcat
#ENV SERVER_SSL_KEY_STORE_PASSWORD=changeit

#ADD ./ssl/* /etc/ssl/labcorp/
ADD ./target/ddt-lcls-result-manager.jar /opt/apps/ddt-lcls-result-manager.jar

WORKDIR /opt/apps

CMD java -XshowSettings:vm \
         -XX:+UnlockExperimentalVMOptions \         
         -XX:MaxRAMFraction=1 \
         $JAVA_OPTIONS	\
         -jar \
         ddt-lcls-result-manager.jar

#EXPOSE 8443
EXPOSE 8080
