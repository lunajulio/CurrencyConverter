import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaConversion {

    public Conversion buscarConversion (String base, String target, float amount){

        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/42892e3319bbf71695268113/pair/"+base+"/"+target+"/"+amount);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Conversion.class);
        } catch (Exception e) {
            throw new RuntimeException("No encontré esas monedas.");
        }

    }
}