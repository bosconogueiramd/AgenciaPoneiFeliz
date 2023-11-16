package Programa;

import java.util.ArrayList;
import java.util.Scanner;

public class AgenciaPoneiFeliz {
	
	static Scanner input = new Scanner(System.in);
	static ArrayList<Conta> contasBancarias;
	
	public static void main(String[] args) {
		contasBancarias = new ArrayList<Conta>();
		operacoes();
	}
	

public static void operacoes() {

    System.out.println("------------------------------------------------------");
    System.out.println("-------------Agência Pônei Feliz---------------");
    System.out.println("------------------------------------------------------");
    System.out.println("** Selecione uma operação que deseja realizar **");
    System.out.println("------------------------------------------------------");
    System.out.println("|   Opção 1 - Criar conta   |");
    System.out.println("|   Opção 2 - Depositar     |");
    System.out.println("|   Opção 3 - Sacar         |");
    System.out.println("|   Opção 4 - Transferir    |");
    System.out.println("|   Opção 5 - Listar        |");
    System.out.println("|   Opção 6 - Sair          |");
    
    
    int operacao = input.nextInt();

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
            listar();
            break;

        case 6:
            System.out.println("Obrigada por usar nosso banco. Pônei Feliz, feito para você");
            System.exit(0); 

        default:
            System.out.println("Opção inválida!");
            operacoes();
            break;
    }
}

public static void criarConta() {
    //System.out.println("Criar conta nova\n");

    System.out.println("\nNome: ");
    String nome = input.next();

    System.out.println("\nCPF: ");
    String cpf = input.next();

    System.out.println("Email: ");
    String email = input.next();

    Pessoa cliente = new Pessoa(nome, cpf, email);

    Conta conta = new Conta(cliente);

    contasBancarias.add(conta);
    System.out.println("--- NOVA CONTA CRIADA. MAIS UM CLIENTE FELIZ! ---");

    operacoes();

}

private static Conta encontrarConta(int numeroConta) {
    Conta conta = null;
    if(contasBancarias.size() > 0) {
        for(Conta c: contasBancarias) {
            if(c.getNumeroConta() == numeroConta) {
                conta = c;
            }
        }}
    return conta;
}

public static void depositar() {
    System.out.println("Número da conta: ");
    int numeroConta = input.nextInt();
    Conta conta = encontrarConta(numeroConta);

    if(conta != null) {
        System.out.println("Qual valor deseja depositar? ");
        Double valorDeposito = input.nextDouble();
        conta.depositar(valorDeposito);
        System.out.println("DEPÓSITO REALIZADO");
    }else {
        System.out.println("--- CONTA NÃO ENCONTRADA ---");
    }
    operacoes();
}

	public static void sacar() {
		System.out.println("Número da conta: ");
		int numeroConta = input.nextInt();
		Conta conta = encontrarConta(numeroConta);

	if(conta != null) {
        System.out.println("Qual valor do saque? ");
        Double valorSaque = input.nextDouble();
        conta.sacar(valorSaque);
        System.out.println("SAQUE REALIZADO");
    }else {
        System.out.println("--- CONTA NÃO ENCONTRADA ---");
    }
    operacoes();
}

	public static void transferir() {
		System.out.println("Número da conta: ");
		int numeroContaRemetente = input.nextInt();
		
		Conta contaRemetente = encontrarConta(numeroContaRemetente);
		
		if(contaRemetente != null) {
			System.out.println("Conta Destintário: ");
			int numeroContaDestinatario = input.nextInt();
			
			Conta contaDestinatario = encontrarConta(numeroContaDestinatario);
			
			if(contaDestinatario != null) {
				System.out.println("Valor a ser transferido: ");
				Double valor = input.nextDouble();
				
				contaRemetente.transferir(contaDestinatario, valor);
			}else {
				System.out.println("--- CONTA NÃO ENCONTRADA ---");
			}
		}
		operacoes();
	}
	
		public static void listar() {
			if (contasBancarias.size() > 0) {
				for (Conta conta : contasBancarias) {
					System.out.println(conta);
				}
			}else {
				System.out.println("CONTA NÃO ENCONTRADA. Certifique que foi cadastrada");
			}
			operacoes();
				}
			}