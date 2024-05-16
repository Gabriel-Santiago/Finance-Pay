package com.Finance_Pay.apiConsume;

import com.Finance_Pay.model.persons.Person;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ViaCep {

    public ViaCep(String cep) throws Exception {

        try {
            URL url = new URL("https://viacep.com.br/ws/" + cep + "/json/");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();

                Gson gson = new Gson();
                Address address = gson.fromJson(response.toString(), Address.class);

                Person person = new Person();
                person.setCep(address.getCep());
                person.setCity(address.getLocalidade());
                person.setState(address.getUf());
            } else {
                throw new Exception("Erro ao obter os dados do ViaCEP. Código de resposta: " + responseCode);
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }
}

