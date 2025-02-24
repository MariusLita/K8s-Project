FROM tomcat:9-jdk11-openjdk

# Copy WAR file to the webapps folder of Tomcat
COPY target/test-mysql-connection.war /usr/local/tomcat/webapps/

# Expose port 8080
EXPOSE 8080

