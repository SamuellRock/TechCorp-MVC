package model;

public class Treinador extends Funcionario implements Treina {
    public Treinador() {}

    public Treinador(int id, String nome, double salario) {
        super(id, nome, salario);
    }

    @Override
    public String getTipo() {
        return "Treinador";
    }

    @Override
    public String mostrarDetalhes() {
        return getTipo() + " [ID: " + getId() + ", Nome: " + getNome() + ", Salário: " + getSalario() + "]";
    }


    
    @Override
    public void ensinarTecnologia() {
        System.out.println("Ensinando tecnologia...");
    }
    @Override
    public void motivarEquipe() {
        System.out.println("Motivando equipe...");
    }

}
