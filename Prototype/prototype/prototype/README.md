README

Prototype

Par Laureline MARTIN
====================

Pré-requis :
------------
Avoir installer Zookeeper et Kafka.
Pour utiliser l'application, il faut :
* Lancer Zookeeper : sudo /usr/local/zookeeper/bin/zkServer.sh start
* Se connecter au port client : telnet localhost 2181 puis entrer srvr
* Lancer Kafka : sudo /usr/local/kafka/bin/kafka-server-start.sh -daemon /usr/local/kafka/config/server.properties
* 

Commandes :
-----------
* Lancer l'application : java -jar target/prototype-0.0.1-SNAPSHOT-jar-with-dependencies.jar
* Création d'un topic : /usr/local/kafka/bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic <nom>
* 

---------------
Classe Producer
===============
Contient un constructeur permettant d'appeler un producer. 
Le message est envoyer sur le topic "test" pour le moment.

----------
Classe App
==========
Classe principale permettant d'appeler le producer