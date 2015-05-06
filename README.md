# Kafka, Java, Docker

Start a single Kafka and Zookeeper instance:
```
git clone https://github.com/wurstmeister/kafka-docker.git
cd kafka-docker
docker-compose -f docker-compose-single-broker.yml up
```

Consumer shell access to Kafka:
```
./start-kafka-shell.sh $(boot2docker ip) $(boot2docker ip)
$KAFKA_HOME/bin/kafka-console-consumer.sh --topic=topic --zookeeper=$ZK
```
        
Producer shell access to Kafka:
```
./start-kafka-shell.sh $(boot2docker ip) $(boot2docker ip)
$KAFKA_HOME/bin/kafka-console-producer.sh --topic=topic --broker-list=`broker-list.sh`
```
Type in the STDIN and see the lines appear in the consumer.
