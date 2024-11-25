package view;

import controller.FuncionarioController;
import model.*;

import java.util.Scanner;

public class FuncionarioView {
    private final FuncionarioController controller = new FuncionarioController();
    private final Scanner scanner = new Scanner(System.in);

    public void menuPrincipal() {
        int opcao;
        do {
            System.out.println("\n1. Adicionar Funcionário");
            System.out.println("2. Listar Funcionários");
            System.out.println("3. Atualizar Funcionário");
            System.out.println("4. Excluir Funcionário");
            System.out.println("0. Sair");
            System.out.print("\nEscolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                	adicionarFuncionario();
                	break;
                case 2:
                	listarFuncionarios();
                	break;
                case 3:
                	atualizarFuncionario();
                	break;
                case 4:
                	excluirFuncionario();
                	break;
                case 0:
                	System.out.println("Saindo...");
                	break;
                	
                default:
                	System.out.println("Opção inválida.");
                	break;
            }
        } while (opcao != 0);
    }

    private void adicionarFuncionario() {
        System.out.println("\n1. Desenvolvedor");
        System.out.println("2. Gerente");
        System.out.println("3. Treinador");
        System.out.println("4. Gerente Desenvolvedor");
        System.out.print("\nEscolha o tipo de funcionário: ");
        int tipo = scanner.nextInt();
        scanner.nextLine();

        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Salário: ");
        double salario = scanner.nextDouble();

        Funcionario funcionario;
        switch (tipo) {
            case 1:
                funcionario = new Desenvolvedor(id, nome, salario);
                break;
            case 2:
                funcionario = new Gerente(id, nome, salario);
                break;
            case 3:
                funcionario = new Treinador(id, nome, salario);
                break;
            case 4:
                funcionario = new GerenteDesenvolvedor(id, nome, salario);
                break;
            default:
                funcionario = null;
                break;
        }

        if (funcionario != null) {
            controller.adicionarFuncionario(funcionario);
            System.out.println("Funcionário adicionado com sucesso!");
        } else {
            System.out.println("Tipo inválido.");
        }

    }

    private void listarFuncionarios() {
        if (controller.listarFuncionarios().isEmpty()) {
            System.out.println("Lista de Funcionários Vazia...");
        } else {
            controller.listarFuncionarios().forEach(f -> System.out.println(f.mostrarDetalhes()));
        }
    }
    

    private void atualizarFuncionario() {
        System.out.print("ID do funcionário: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Novo Nome: ");
        String novoNome = scanner.nextLine();

        System.out.print("Novo Salário: ");
        double novoSalario = scanner.nextDouble();

        if (controller.atualizarFuncionario(id, novoNome, novoSalario)) {
            System.out.println("Funcionário atualizado com sucesso!");
        } else {
            System.out.println("Funcionário não encontrado.");
        }
    }

    private void excluirFuncionario() {
        System.out.print("ID do funcionário: ");
        int id = scanner.nextInt();

        if (controller.excluirFuncionario(id)) {
            System.out.println("Funcionário excluído com sucesso!");
        } else {
            System.out.println("Funcionário não encontrado.");
        }
    }

    public static void main(String[] args) {
        new FuncionarioView().menuPrincipal();
    }
}
