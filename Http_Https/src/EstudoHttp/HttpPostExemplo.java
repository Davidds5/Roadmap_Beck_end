package EstudoHttp;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpPostExemplo {

    public static void main(String[] args) {

        String jsonBody = """
            {
              "title": "foo",
              "body": "bar",
              "userId": 1
            }
            """;

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://jsonplaceholder.typicode.com/posts"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(jsonBody))
                .build();

        try {
            // 2. Envia a Requisição
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // 3. Lida com a Resposta
            System.out.println("Status Code: " + response.statusCode()); // Espera-se 201 Created
            System.out.println("Resposta do Servidor (Novo Recurso):\n" + response.body());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}