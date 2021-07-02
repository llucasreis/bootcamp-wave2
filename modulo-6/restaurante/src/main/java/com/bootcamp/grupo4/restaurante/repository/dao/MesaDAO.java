package com.bootcamp.grupo4.restaurante.repository.dao;

import com.bootcamp.grupo4.restaurante.entities.Mesa;
import com.bootcamp.grupo4.restaurante.mappers.MesaMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class MesaDAO {

    private final String FILE_PATH = "restaurante.json";
    private final String ENTITY = "Mesa";
    private final Gson gson = new Gson();

    public List<Mesa> find() {
        List<MesaMapper> mesas = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(this.FILE_PATH));
            JsonObject jsonObject = JsonParser.parseReader(br).getAsJsonObject();

            mesas = gson.fromJson(
                    jsonObject.get(this.ENTITY),
                    new TypeToken<List<MesaMapper>>(){}.getType()
            );

        } catch (IOException e) {
            e.printStackTrace();
        }
        return MesaMapper.toDomain(mesas);
    }

    public Mesa findOne(Long id) {
        List<Mesa> mesas = this.find();

        Mesa mesa = mesas.stream().filter(m -> m.getId().equals(id)).findFirst().orElse(null);

        return mesa;
    }

    public boolean atualizarMesa(List<MesaMapper> mesaMappers) {

        try {
            BufferedReader br = new BufferedReader(new FileReader(this.FILE_PATH));
            JsonObject jsonObject = JsonParser.parseReader(br).getAsJsonObject();

            jsonObject.add(this.ENTITY, gson.toJsonTree(mesaMappers));

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
