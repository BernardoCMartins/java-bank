package conta;

import java.util.Random;

public class CriarConta extends Conta {
		
	    
	
		private String cpf;
		private String nome;
		private String email;
		
		public CriarConta() {
			super(null);
			
		}
		
		public CriarConta(String cpf, String nome, String email) {
			super(null);
			this.cpf = cpf;
			this.nome = nome;
			this.email = email;
			
			
		}


		public String getCpf() {
			return cpf;
		}


		public void setCpf(String cpf) {
			this.cpf = cpf;
		}


		public String getNome() {
			return nome;
		}


		public void setNome(String nome) {
			this.nome = nome;
		}


		public String getEmail() {
			return email;
		}


		public void setEmail(String email) {
			this.email = email;
		}


		
		public String toString() {
			return "\nNome: " + this.getNome() +
					"\nCPF:" + this.getCpf()+
					"\nEmail" + this.getEmail();
		}

	
		
		

			
			
			
			
			
			
		}
		
	
		
		



