FROM postgres
#context is ./database
COPY ./schema /docker-entrypoint-initdb.d/
CMD ["docker-entrypoint.sh", "postgres"]
