package conta;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class GerenciadorConta {

	static ArrayList<Conta> listaContas;

	public static void main(String[] args) {
		listaContas = new ArrayList<Conta>();
		operacoes();
	}

	public static void operacoes() {
		int operacao = Integer.parseInt(JOptionPane.showInputDialog("--- Selecione uma operção ---"  +
				"\n|   Opção 1 - Criar conta" + 
				"\n|   Opção 2 - Depositar" +
	            "\n|   Opção 3 - Sacar" +
				"\n|   Opção 4 - Transferir" +
	            "\n|   Opção 5 - Listar" +
				"\n|   Opção 6 - Sair"));

		switch (operacao) {
		case 1:
			criarConta();
			break;

		case 2:
			depositar();
			break;

		case 3:
			sacar();
			break;

		case 4:
			transferir();
			break;

		case 5:
			listarContas();
			break;

		case 6:
			JOptionPane.showMessageDialog(null, "Obrigado pela preferência!");
			System.exit(0);

		default:
			JOptionPane.showMessageDialog(null, "Opção inválida!");
			operacoes();
			break;
		}
	}

	public static void criarConta() {

		CriarConta conta = new CriarConta();
		conta.setNome(JOptionPane.showInputDialog("Nome:"));

		conta.setCpf(JOptionPane.showInputDialog("CPF:"));

		conta.setEmail(JOptionPane.showInputDialog("Email:"));
		Conta conta1 = new Conta(conta);

		listaContas.add(conta1);
		JOptionPane.showMessageDialog(null, "--- Sua conta foi criada com sucesso! ---");
		operacoes();

	}

	private static Conta encontrarConta(int numeroConta) {
		Conta conta = null;
		if (listaContas.size() > 0) {
			for (Conta cont : listaContas) {
				if (cont.getNumeroConta() == numeroConta) {
					conta = cont;
				}
			}
		}
		return conta;
	}

	public static void depositar() {
		int numeroConta = Integer.parseInt(JOptionPane.showInputDialog("Número da conta:"));

		Conta conta = encontrarConta(numeroConta);

		if (conta != null) {

			Double valorDeposito = Double.parseDouble(JOptionPane.showInputDialog("Qual valor deseja depositar? "));
			conta.depositar(valorDeposito);
			JOptionPane.showMessageDialog(null, "Depósito concluido com sucesso!");
		} else {
			JOptionPane.showMessageDialog(null, "Conta não encontrada!");
		}

		operacoes();

	}

	public static void sacar() {

		System.out.println("Número da conta: ");
		int numeroConta = Integer.parseInt(JOptionPane.showInputDialog("Número da conta:"));

		Conta conta = encontrarConta(numeroConta);

		if (conta != null) {

			Double valorSaque = Double.parseDouble(JOptionPane.showInputDialog("Qual valor deseja sacar?"));

			conta.sacar(valorSaque);

		} else {
			JOptionPane.showMessageDialog(null, "Conta não encontrada!");
		}

		operacoes();

	}

	public static void transferir() {

		int numeroContaRemetente = Integer.parseInt(JOptionPane.showInputDialog("Número da sua conta:"));

		Conta contaRemetente = encontrarConta(numeroContaRemetente);

		if (contaRemetente != null) {

			int numeroContaDestinatario = Integer
					.parseInt(JOptionPane.showInputDialog("Número da conta que deseja enviar a transferencia:"));
			;

			Conta contaDestinatario = encontrarConta(numeroContaDestinatario);

			if (contaDestinatario != null) {

				Double valor = Double.parseDouble(JOptionPane.showInputDialog("Quanto deseja transferir?:"));

				contaRemetente.transferir(contaDestinatario, valor);

			} else {
				JOptionPane.showMessageDialog(null, "A conta para depósito não foi encontrada");

			}

		} else {
			JOptionPane.showMessageDialog(null, "Conta para transferência não encontrada");

		}
		operacoes();
	}

	public static void listarContas() {
		if (listaContas.size() > 0) {
			for (Conta conta : listaContas) {

				JOptionPane.showMessageDialog(null, conta);
			}
		} else {
			JOptionPane.showMessageDialog(null, "Não há contas cadastradas");

		}

		operacoes();
	}
}
