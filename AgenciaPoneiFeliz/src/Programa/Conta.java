package Programa;

import utilitarios.Utils;

public class Conta {
	
	private static int contadordecontas = 1;
	
	private int numeroConta;
	private Pessoa pessoa;
	private Double saldo = 0.0;
	
	public Conta( Pessoa pessoa) {
		this.numeroConta = contadordecontas;
		this.pessoa = pessoa;
		contadordecontas += 1;		
		
	}

	public int getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(int numeroConta) {
		this.numeroConta = numeroConta;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public String toString() {
		return "\nNúmero da conta:  " + this.getNumeroConta() +
				"\nNome:  " + this.pessoa.getNome() +
				"\nCPF: " + this.pessoa.getCpf() +
				"\nEmail: " + this.pessoa.getEmail() +
				"\nSaldo:  " + Utils.doubleToString(this.getSaldo()) +
				"\n";
	}
	
	public void depositar(Double valor) {
		if(valor > 0) {
			setSaldo(getSaldo() + valor);
			System.out.println("DEPÓSITO REALIZADO COM SUCESSO");
		}else {
			System.out.println("DEPÓSITO NÃO CONCLUÍDO");
		}
	}
	
	public void sacar(Double valor) {
		if(valor > 0 && this.getSaldo() >= valor) {
			setSaldo(getSaldo() - valor);
			System.out.println("SAQUE REALIZADO COM SUCESSO");
		}else {
			System.out.println("SAQUE NÃO CONCLUÍDO");
		}
	}
	
	public void transferir(Conta contaParaDeposito, Double valor) {
		if(valor > 0 && this.getSaldo() >= valor) {
			setSaldo(getSaldo() - valor);
			
			contaParaDeposito.saldo = contaParaDeposito.getSaldo() + valor;
			System.out.println("TRANSFERÊNCIA CONCLUÍDA");
		}else {
			System.out.println("TRANSFERÊNCIA NÃO CONCLUÍDA");
		}
	}}