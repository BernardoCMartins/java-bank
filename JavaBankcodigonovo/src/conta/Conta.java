package conta;



import javax.swing.JOptionPane;

import conta.CriarConta;
import util.Util;

public class Conta {

	private static int contadorDeContas = 0;
	private double saldo = 0.0;
	private int numeroConta;
	protected CriarConta CriarConta;

	public Conta(CriarConta criarconta) {

		this.numeroConta = contadorDeContas;
		CriarConta = criarconta;
		contadorDeContas += 1;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public int getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(int numeroConta) {
		this.numeroConta = numeroConta;
	}

	public CriarConta getCriarConta() {
		return CriarConta;
	}

	public void setCriarConta(CriarConta criarConta) {
		CriarConta = criarConta;
	}

	public void depositar(double valor) {
		saldo = saldo + valor;
	}

	public void depositar (Double valor) {
		if(valor > 0) {
			setSaldo(getSaldo() + valor);
			
			
		}else {
			
			
		}
		
	}
	
	public void sacar  (Double valor) {
		if(valor > 0 && this.getSaldo() >= valor) {
			setSaldo(getSaldo() - valor);
			JOptionPane.showMessageDialog(null, "Saque efetuado com êxito!");
			
		}else {
			JOptionPane.showMessageDialog(null, "Não foi possível efetuar o saque !");
			
		}
	}
	
	public void transferir (Conta contaParaDeposito, Double valor) {
		if(valor > 0 && this.getSaldo()>= valor ) {
			setSaldo(getSaldo() - valor);
			contaParaDeposito.saldo = contaParaDeposito.getSaldo() +valor;
			JOptionPane.showMessageDialog(null, "Transferência efetuada com sucesso!");
			
		}else { 
			JOptionPane.showMessageDialog(null, "Não foi possível efetuar a transferência !");
			
		}
	}
	public String toString() {
		return "\nNúmero da conta: " + this.getNumeroConta() + "\nNome: " + this.CriarConta.getNome() + "\nCPF: "
				+ this.CriarConta.getCpf() + "\nEmail: " + this.CriarConta.getEmail() + "\nSaldo: "
				+ Util.doubleToString(this.getSaldo()) + "\n";

	}
	
}
