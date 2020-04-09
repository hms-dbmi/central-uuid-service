FROM jboss/wildfly:17.0.0.Final AS production

USER root

# copy modules
COPY target/modules/system/layers/base/com/sql/mysql/main/* /modules/

# install modules
RUN wildfly/bin/jboss-cli.sh --command="module add --name=com.sql.mysql \
    --resources=/modules/mysql-connector-java-5.1.38.jar --dependencies=javax.api"

# Copy standalone.xml
COPY src/main/resources/wildfly-configuration/standalone.xml wildfly/standalone/configuration/

# Copy war file
COPY target/uuid-rest-service.war wildfly/standalone/deployments/uuid-rest-service.war

ENTRYPOINT ["/opt/jboss/wildfly/bin/standalone.sh", "-b", "0.0.0.0"]
