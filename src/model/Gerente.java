package model;

public class Gerente extends Funcionario implements Gerencia {
    public Gerente() {}

    public Gerente(int id, String nome, double salario) {
        super(id, nome, salario);
    }

    @Override
    public String getTipo() {
        return "Gerente";
    }
    
    @Override
    public String mostrarDetalhes() {
        return getTipo() + " [ID: " + getId() + ", Nome: " + getNome() + ", Salário: " + getSalario() + "]";
    }



    @Override
    public void organizarEquipe() {
        System.out.println("Organizando equipe...");
    }
    @Override
    public void conduzirReunioes() {
        System.out.println("Conduzindo reuniões...");
    }
}
