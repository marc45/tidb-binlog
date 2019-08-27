package com.liberxue.producer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public class Producer implements  Runnable{

    /**
     * @Title: Producer
     * @ProjectName 0.0.1
     * @Description: TODO
     * @author liberxue
     * @date 2019/8/2710:33
     */
    private final  String topic;

    private final KafkaProducer<String, String> producer;


    public Producer (String topic) {
        Properties props = new Properties();
        props.put("bootstrap.servers", "120.132.30.130:9092");
        //ack =0：如果设置为0，生产者不会等待kafka的响应。
        //ack =1：这个配置意味着kafka会把这条消息写到本地日志文件中，但是不会等待集群中其他机器的成功响应。
        //ack =all：这个配置意味着leader会等待所有的follower同步完成。这个确保消息不会丢失，除非kafka集群中所有机器挂掉。这是最强的可用性保证。
        props.put("ack ", "all");
        //配置为大于0的值的话，客户端会在消息发送失败时重新发送。
        props.put("retries", 0);
        //当多条消息需要发送到同一个分区时，生产者会尝试合并网络请求。这会提高client和生产者的效率
        props.put("batch.size", 16384);
        props.put("key.serializer", StringSerializer.class.getName());
        props.put("value.serializer", StringSerializer.class.getName());
        this.producer = new KafkaProducer<String, String>(props);
        this.topic = topic;
    }


    @Override
    public void run() {

         int messageID=1;
              System.out.print( messageID );
    }


}
