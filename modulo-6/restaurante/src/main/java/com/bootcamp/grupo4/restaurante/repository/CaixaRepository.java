package com.bootcamp.grupo4.restaurante.repository;

import com.bootcamp.grupo4.restaurante.entities.Caixa;
import com.bootcamp.grupo4.restaurante.entities.Mesa;
import com.bootcamp.grupo4.restaurante.entities.Pedido;
import com.bootcamp.grupo4.restaurante.mappers.MesaMapper;
import com.bootcamp.grupo4.restaurante.repository.dao.CaixaDAO;
import com.bootcamp.grupo4.restaurante.utils.DataUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CaixaRepository {
    private final CaixaDAO caixaDAO;

    @Autowired
    CaixaRepository(CaixaDAO caixaDAO) {
        this.caixaDAO = caixaDAO;
    }

    private int findIndex(List<Caixa> caixaList, Long id) {
        int arrayIndex = -1;
        for (int i = 0; i<caixaList.size(); i++) {
            if (caixaList.get(i).getId().equals(id)) {
                arrayIndex = i;
            }
        }

        return arrayIndex;
    }

    public List<Caixa> find() {
        return this.caixaDAO.find();
    }

    public Caixa findCaixaAtual() {
        Caixa caixa = this.caixaDAO.findCaixaAtual(DataUtil.getDataAtual());

        if (caixa == null) {
            caixa = this.criarCaixaDoDia();
        }

        return caixa;
    }

    public Caixa find(Long id) {
        List<Caixa> caixas = this.caixaDAO.find();

        Caixa caixa = caixas.stream()
                .filter(m -> m.getId().equals(id)).findFirst().orElse(null);

        if (caixa == null) {
            caixa = this.criarCaixaDoDia();
        }
        return caixa;
    }

    public boolean atualizarCaixa(Caixa caixa) {
        List<Caixa> caixas = this.caixaDAO.find();

        int index = this.findIndex(caixas, caixa.getId());

        caixas.set(index, caixa);

        return this.caixaDAO.atualizarCaixa(caixas);
    }

    private Caixa criarCaixaDoDia() {
        List<Caixa> caixas = this.caixaDAO.find();

        Long nextId = caixas.get(caixas.size() - 1).getId() + 1L;

        Caixa novoCaixa = new Caixa(nextId);

        caixas.add(novoCaixa);

        this.caixaDAO.atualizarCaixa(caixas);

        return novoCaixa;
    }
}
