FROM mysql:5.7.24

RUN mkdir /tempsql/
COPY db/sql /tempsql/sql
COPY db/development_only/initialize_dev.sql /tempsql/sql/00_init.sql

RUN cat /tempsql/sql/*  > /tempsql/schema-init.sql

EXPOSE 3306

ENTRYPOINT ["docker-entrypoint.sh"]
CMD ["mysqld","--init-file","/tempsql/schema-init.sql"]