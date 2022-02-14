FROM postgres:alpine
#FROM mysql:8
#context is ./database
COPY ./schema/ /docker-entrypoint-initdb.d/
CMD ["docker-entrypoint.sh", "postgres"]
#CMD ["docker-entrypoint.sh", "mysql"]
