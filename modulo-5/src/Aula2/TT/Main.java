package Aula2.TT;

public class Main {
    public static void main(String[] args) {
        FuncionarioCLT analista = new Analista("Lucas", 40, 1);
        FuncionarioCLT tecnico = new Tecnico("Lucas", 40, 1);
        FuncionarioCLT gerente = new Gerente("Lucas", 36, 1);
        FuncionarioCLT diretor = new Diretor("Lucas", 10000);
        FuncionarioPJ pj = new FuncionarioPJ("Lucas", 200, 20.40);

        System.out.println(analista.pagarSalario());
        System.out.println(tecnico.pagarSalario());
        System.out.println(gerente.pagarSalario());
        System.out.println(diretor.pagarSalario());
        System.out.println(pj.pagarSalario());
    }
}
