package model;

public class Desenvolvedor extends Funcionario implements Desenvolve {
    public Desenvolvedor() {}

    public Desenvolvedor(int id, String nome, double salario) {
        super(id, nome, salario);
    }

    @Override
    public String getTipo() {
        return "Desenvolvedor";
    }

    @Override
    public String mostrarDetalhes() {
        return getTipo() + " [ID: " + getId() + ", Nome: " + getNome() + ", Salário: " + getSalario() + "]";
    }




    @Override
    public void codar() {
        System.out.println("Desenvolvendo código...");
    }
    @Override
    public void resolverProblemas() {
        System.out.println("Resolvendo problemas...");
    }
}
