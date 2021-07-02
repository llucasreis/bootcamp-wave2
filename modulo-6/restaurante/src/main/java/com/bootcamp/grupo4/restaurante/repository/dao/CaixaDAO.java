package com.bootcamp.grupo4.restaurante.repository.dao;

import com.bootcamp.grupo4.restaurante.entities.Caixa;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class CaixaDAO {

    private final String FILE_PATH = "restaurante.json";
    private final String ENTITY = "Caixa";
    private final Gson gson = new Gson();

    public List<Caixa> find() {
        List<Caixa> caixas = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(this.FILE_PATH));
            JsonObject jsonObject = JsonParser.parseReader(br).getAsJsonObject();

            caixas = gson.fromJson(
                    jsonObject.get(this.ENTITY),
                    new TypeToken<List<Caixa>>(){}.getType());

        } catch (IOException e) {
            e.printStackTrace();
        }

        return caixas;
    }

    public Caixa findCaixaAtual(String dataAtual) {
        List<Caixa> caixas = this.find();

       return caixas.stream()
                .filter(c -> c.getData().equals(dataAtual)).findFirst().orElse(null);
    }

    public boolean atualizarCaixa(List<Caixa> caixas) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(this.FILE_PATH));
            JsonObject jsonObject = JsonParser.parseReader(br).getAsJsonObject();

            jsonObject.add(this.ENTITY, gson.toJsonTree(caixas));

            Writer writer = new FileWriter(this.FILE_PATH);
            Gson gsonWriter = new GsonBuilder().setPrettyPrinting().create();
            gsonWriter.toJson(jsonObject, writer);
            writer.flush();
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
