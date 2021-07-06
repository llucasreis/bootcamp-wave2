package com.bootcamp.grupo4.loja.repositories.dao;

import com.bootcamp.grupo4.loja.entities.Cliente;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class ClienteDAO {
    private final String FILE_PATH = "loja.json";
    private final String ENTITY = "Cliente";
    private final Gson gson = new Gson();

    public List<Cliente> find() {
        List<Cliente> clientes = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(this.FILE_PATH));
            JsonObject jsonObject = JsonParser.parseReader(br).getAsJsonObject();

            clientes = gson.fromJson(
                    jsonObject.get(this.ENTITY),
                    new TypeToken<List<Cliente>>(){}.getType());

        } catch (IOException e) {
            e.printStackTrace();
        }

        return clientes;
    }

    public boolean atualizarCliente(List<Cliente> clientes) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(this.FILE_PATH));
            JsonObject jsonObject = JsonParser.parseReader(br).getAsJsonObject();

            jsonObject.add(this.ENTITY, gson.toJsonTree(clientes));

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
