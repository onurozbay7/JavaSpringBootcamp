# isbasi

docker run -p 5050:80 -e 'PGADMIN_DEFAULT_EMAIL=pgadmin4@pgadmin.org' -e 'PGADMIN_DEFAULT_PASSWORD=admin' -d --name pgadmin4 dpage/pgadmin4


docker run -d --hostname my-rabbit --name myrabbit -e RABBITMQ_DEFAULT_USER=admin -e RABBITMQ_DEFAULT_PASS=123456 -p 5672:5672 -p 15672:15672 rabbitmq:3-management