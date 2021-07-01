package com.bootcamp.grupo4.restaurante.repository;

import com.bootcamp.grupo4.restaurante.entities.Caixa;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class CaixaRepository {
    private final List<Caixa> caixaList;

    CaixaRepository () {
        this.caixaList = new ArrayList<>(
                Arrays.asList(
                        new Caixa(1L)
                )
        );
    }

    private int findIndex(Long id) {
        int arrayIndex = -1;
        for (int i = 0; i< this.caixaList.size(); i++) {
            if (this.caixaList.get(i).getId().equals(id)) {
                arrayIndex = i;
            }
        }

        return arrayIndex;
    }

    public Caixa find() {
        return this.caixaList.get(0);
    }

    public Caixa find(Long id) {
        return this.caixaList.stream().filter(m -> m.getId().equals(id)).findFirst().orElse(null);
    }

    public void atualizaCaixa(Caixa caixa) {
        int index = this.findIndex(caixa.getId());

        this.caixaList.set(index, caixa);
    }
}
