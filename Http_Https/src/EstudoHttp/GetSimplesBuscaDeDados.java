package EstudoHttp;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class GetSimplesBuscaDeDados {
    public static void main(String[] args) {
        // estanciado a o client
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://jsonplaceholder.typicode.com/posts/1"))
                .GET()
                .build();

        try{
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println("status code: "+ response.statusCode());
            System.out.println("Corpo da Resposta:\n"+response.body());
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
