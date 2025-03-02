FROM tomcat:9


COPY target/mysqlConnection-1.0.war ./webapps/ROOT.war

EXPOSE 8080

CMD ["catalina.sh", "run"]
