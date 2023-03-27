import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class Desafio1 {
  public static void main(String[] args) throws Exception {
    String url = "https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/MostPopularTVs.json";
    var endereço = URI.create(url);
    var client = HttpClient.newHttpClient();
    var request = HttpRequest.newBuilder(endereço).GET().build();
    var response =  client.send(request, BodyHandlers.ofString());
    String body = response.body();
    JsonParser parser = new JsonParser();
    List<Map<String, String>> filmeList = parser.parse(body);
    
    for (Map<String,String> filmes : filmeList) {
      System.out.println();
      System.out.println("\u001b[3mTitle: \u001b[m "+"\u001b[1m"+filmes.get("title"));
      System.out.println("Image: \u001b[m "+"\u001b[3m"+filmes.get("image"));
      System.out.println("\u001b[43;1mRating:\u001b[m "+ "\u001b[37m"+"\u001b[47m" + " "+filmes.get("imDbRating")+ " "+"\u001b[m");       
      int imDbRating = (int) Math.round(Double.parseDouble(filmes.get("imDbRating")));
        for (int i = 0; i <= 10 && i < imDbRating; i++) {
           System.out.print("⭐");
        }
      System.out.println();
      System.out.println();
    }
  }
}
