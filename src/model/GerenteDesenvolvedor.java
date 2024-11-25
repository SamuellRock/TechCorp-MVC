package model;

public class GerenteDesenvolvedor extends Funcionario implements Desenvolve, Gerencia {
    public GerenteDesenvolvedor() {}

    public GerenteDesenvolvedor(int id, String nome, double salario) {
        super(id, nome, salario);
    }

    @Override
    public String getTipo() {
        return "GerenteDesenvolvedor";
    }

    @Override
    public String mostrarDetalhes() {
        return getTipo() + " [ID: " + getId() + ", Nome: " + getNome() + ", Salário: " + getSalario() + "]";
    }




    @Override
    public void codar() {
        System.out.println("Gerente Desenvolvendo código...");
    }

    @Override
    public void resolverProblemas() {
        System.out.println("Resolvendo problemas como gerente e desenvolvedor...");
    }

    @Override
    public void organizarEquipe() {
        System.out.println("Gerente Desenvolvedor organizando a equipe...");
    }

    @Override
    public void conduzirReunioes() {
        System.out.println("Gerente Desenvolvedor Conduz reuniões...");
    }
}
