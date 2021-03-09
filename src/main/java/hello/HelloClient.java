package hello;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.concurrent.TimeUnit;

import java.util.Iterator;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class HelloClient {



    private final ManagedChannel channel;


    public HelloClient(ManagedChannel channel){
        this.channel =channel;

    }

    public HelloClient(String host, int port){
        this(ManagedChannelBuilder.forAddress(host, port)
                .usePlaintext()
                .build());
    }

    public String getInfoById(String id){
        return "djfksj";
    }

    /**
     * showdown positively
     * @throws InterruptedException
     */
    public void shutdown() throws InterruptedException{
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

    /**
     * send rpc req
     */

    public static void main(String[] args) {

        JSONParser parser = new JSONParser();

        try {
            System.out.println("abcdefg");
            Object obj = parser.parse(new FileReader("/home/nguyendinhminh/git_environment/GRPC/students.json"));
            System.out.println("abcdef");

        }catch (Exception e) {

        }




        HelloClient client = new HelloClient("127.0.0.1", 50051);
        try {
            System.out.println("hello");
        }catch (Exception e){
            System.out.println(e);
        }finally {
            try {
                client.shutdown();
            }catch (InterruptedException e){
                System.out.println(e);
            }

        }
    }

}
