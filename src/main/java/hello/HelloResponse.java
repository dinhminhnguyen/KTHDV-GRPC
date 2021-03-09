package hello;

public class HelloResponse {
    public String message = " ";
    private HelloResponse() {
        message = "";
    }
    public HelloResponse(String id ){
        message = id;
    }
}
