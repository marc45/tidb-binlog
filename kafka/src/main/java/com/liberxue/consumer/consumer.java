package com.liberxue.consumer;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.IntegerDeserializer;
import org.apache.kafka.common.serialization.LongDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

public class Consumer {
    /**
     * @Title: consumer
     * @ProjectName 0.0.1
     * @Description: Kafka Consumer
     * @author liberxue
     * @date 2019/8/2710:11
     */
    private  static  final Logger log = LoggerFactory.getLogger( Consumer.class );
    private  final String topic;

    @Override
    public boolean equals(Object obj) {
        return super.equals( obj );
    }

    public  Consumer(String topic,String broker,String group){
        Properties props =new Properties(  );
        // consumer  broker  address config
        props.put( ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,broker );
        // consumer group config
        props.put(ConsumerConfig.GROUP_ID_CONFIG,group);
        // auto commit status config
        props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG,true);
        // auto commit interval messages config ps :ms
        props.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG,1000);
        // session timeout config ps: ms
        props.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG,3000);
        consumer = new KafaConsumer<Integer, Binlog>(props,new IntegerDeserializer(),new LongDeserializer() );
        this.topic=topic;
    }

    public String StartConsumer() {

        while (true){


        }
    }
}
