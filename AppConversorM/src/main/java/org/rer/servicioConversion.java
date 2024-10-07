package org.rer;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Iterator;
import java.util.Map;

public class servicioConversion {

    public double convertirMoneda(String codBaseDe, String codBaseA){

    String direccion = "https://v6.exchangerate-api.com/v6/42e3869f124f920c42566739/latest/"+codBaseDe;
    HttpClient client = HttpClient.newHttpClient();
    HttpRequest request = HttpRequest.newBuilder().uri(URI.create(direccion)).build();
    HttpResponse<String> response = null;

       try {
          response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
          throw new RuntimeException(e);
        }

    String json = response.body();
    Gson gson = new Gson();
    DatosConversion datosConversion = gson.fromJson(json, DatosConversion.class);

    Iterator<Map.Entry<String, Double>> iterator = datosConversion.conversion_rates.entrySet().iterator();
    while (iterator.hasNext())
      {
          Map.Entry<String, Double> entry = iterator.next();
          System.out.println("codigo Base = " + entry.getKey() + ", tasa = " + entry.getValue());

      }
        Map<String, Double> conversionRates = datosConversion.getConversion_rates();
        // Buscar la tasa de cambio
        double tasaConversion = conversionRates.getOrDefault(codBaseA, 0.0);

        return tasaConversion;
  }
}

