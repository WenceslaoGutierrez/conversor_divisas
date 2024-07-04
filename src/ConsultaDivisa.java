import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaDivisa {
    public Divisa buscarDivisa(int opcionDivisa,double cantidad){
        //INGRESAR LLAVE PERSONAL
        String key="";
        String [][] divisas={
                {"USD","MXN"},
                {"MXN","USD"},
                {"USD","ARG"},
                {"ARG","USD"},
                {"USD","JPY"},
                {"JPY","USD"}
        };
        URI direccion=URI.create("https://v6.exchangerate-api.com/v6/"+key+"/pair/"+divisas[opcionDivisa-1][0]+"/"+divisas[opcionDivisa-1][1]+"/"+cantidad);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();
        HttpResponse<String> response= null;
        try {
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(direccion);
        return new Gson().fromJson(response.body(),Divisa.class);
    }
}
