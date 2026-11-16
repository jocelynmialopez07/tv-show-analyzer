import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class tvAnalyzer {

    public static void main(String[] args) throws Exception {
        getAndPrint("https://api.tvmaze.com/singlesearch/shows?q=breaking+bad");
    }

    public static void getAndPrint(String url) throws Exception {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) {
            System.out.println(response.body());
        }
    }
}