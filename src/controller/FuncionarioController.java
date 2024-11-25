package controller;

import model.Funcionario;
import model.Desenvolvedor;
import model.Gerente;
import model.Treinador;
import model.GerenteDesenvolvedor;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioController {
    private final List<Funcionario> funcionarios = new ArrayList<>();
    private final String arquivo = "funcionarios.txt";

    public FuncionarioController() {
        carregarDados();
    }

    public void adicionarFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
        salvarDados();
    }

    public List<Funcionario> listarFuncionarios() {
        return new ArrayList<>(funcionarios);
    }

    public boolean atualizarFuncionario(int id, String novoNome, double novoSalario) {
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getId() == id) {
                funcionario.setNome(novoNome);
                funcionario.setSalario(novoSalario);
                salvarDados();
                return true;
            }
        }
        return false;
    }

    public boolean excluirFuncionario(int id) {
        boolean removido = funcionarios.removeIf(funcionario -> funcionario.getId() == id);
        if (removido) {
            salvarDados();
        }
        return removido;
    }

    private void salvarDados() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivo))) {
            for (Funcionario funcionario : funcionarios) {
                writer.write(funcionario.getId() + ";" + funcionario.getTipo() + ";" + funcionario.getNome() + ";" + funcionario.getSalario());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Erro ao salvar dados: " + e.getMessage());
        }
    }

    private void carregarDados() {
        File file = new File(arquivo);
        if (!file.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(";");
                int id = Integer.parseInt(partes[0]);
                String tipo = partes[1];
                String nome = partes[2];
                double salario = Double.parseDouble(partes[3]);

                Funcionario funcionario;
                switch (tipo) {
                    case "Desenvolvedor":
                    	funcionario = new Desenvolvedor(id, nome, salario);
                    	break;
                    	
                    case "Gerente":
                    	funcionario = new Gerente(id, nome, salario);
                    	break;
                    	
                    case "Treinador":
                    	funcionario = new Treinador(id, nome, salario);
                    	break;
                    	
                    case "GerenteDesenvolvedor":
                    	funcionario = new GerenteDesenvolvedor(id, nome, salario);
                    	break;
                    	
                    default:
                    	funcionario = null;
                };

                if (funcionario != null) {
                    funcionarios.add(funcionario);
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao carregar dados: " + e.getMessage());
        }
    }
}
