package Aula4.SaveTheRopa;

import java.util.*;

public class GuardaRoupa {
    private int contador;
    private Map<Integer, List<Vestuario>> listaVestuario;

    public GuardaRoupa() {
        this.contador = 0;
        this.listaVestuario = new HashMap<>();
    }

    public Integer guardarVestuarios(List<Vestuario> listaVestuario) {
        int index = this.contador;
        this.listaVestuario.put(index, listaVestuario);

        this.contador++;
        return index;
    }

    public void mostrarVestuarios() {
        for (Map.Entry<Integer, List<Vestuario>> data : listaVestuario.entrySet()) {
            System.out.println(data.getKey() + " -> " + Collections.singletonList(data.getValue()));
        }
    }

    public List<Vestuario> devolverVestuarios(Integer id) {
        if (listaVestuario.containsKey(id)) {
            return listaVestuario.get(id);
        }
        return null;
    }
}
