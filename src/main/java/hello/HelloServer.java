package hello;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class HelloServer {

    private Server server;

    private void start() throws IOException{
        int port = 50051;
        server = ServerBuilder.forPort(port)

                .build()
                .start();
        Runtime.getRuntime().addShutdownHook(new Thread(){
            @Override
            public void run(){
                HelloServer.this.stop();
            }
        });
    }

    private void stop() {
        if(server!=null){
            server.shutdown();
        }
    }

    /**
     * stop graciously
     */
    private void blockUntilShutdown() throws InterruptedException{
       if(server!=null){
           server.awaitTermination();
       }
    }


    public static void main(String[] args) {

        final HelloServer helloServer = new HelloServer();
        try {
            System.out.println("server \n");
            helloServer.start();
            System.out.println("end ");
        }catch (IOException e){
            System.out.println(e);
        }finally {
            try {
                helloServer.blockUntilShutdown();
            }catch (InterruptedException e){
                System.out.println(e);
            }
        }
    }
}
