package aplication;

import conta.ContaTerminal;
import util.Fluxo;
import java.util.Scanner;

public class Interative {

    public static void main(String[] args) {

        // Instancias
        Scanner sc = new Scanner(System.in);
        ContaTerminal acs = new ContaTerminal();
        Fluxo fx = new Fluxo();

        // Mensagem
        System.out.println("--Bem vindo!--\n" + "-Siga o passo para interação\n");
        System.out.println("* (s) para cadastro\n* (n) para login \n");

        // variaveis
        char resp = sc.next().charAt(0);
        char exit = 0;
        int l = 1;

        // se for sim no cadastro
        if (resp == 's') {
            System.out.println("\nInsira seu nome completo em que os espaços utilize ( _ ): ");
            String nome = sc.next();
            acs.setNomeCliente(nome);

            System.out.println("Insira a Agencia");
            String agencia = sc.next();
            acs.setAgencia(agencia);

            System.out.println("Insira o Número");
            int numero = sc.nextInt();
            acs.setNumero(numero);

            System.out.println("Olá " + acs.getNomeCliente()
                    + ", obrigado por criar uma conta em nosso banco, sua agência é " + acs.getAgencia() + ", conta "
                    + acs.getNumero() + " e seu saldo R$ " +fx.getValorConta()+" já está disponível para saque!");

            // Senha correta e incorreta cadastro
            do {
                System.out.println("\nDefina sua Senha de 4 digitos");
                int rsenha = sc.nextInt();
                System.out.println("Repita a senha: ");
                int rrsenha = sc.nextInt();

                if (rsenha == rrsenha) {
                    System.out.println("* Senha definida *");
                    System.out.println("\nConta criada com sucesso!");
                    acs.setSenha(rsenha);
                    l = 2;

                    if (rsenha != rrsenha) {
                        System.out.println("Senhas não compativeis");
                        System.out.println("Insira novamente: ");
                        l += 1;
                    }
                }
            } while (l == 1);
        }

        // Realizar o login
        System.out.println("para realizar login s/n: ");
        char logincd = sc.next().charAt(0);
        if (logincd == 's') {
            int n = 0;
            System.out.println("Insira o número da Conta: ");
            int rconta = sc.nextInt();

            System.out.println("Insira a senha de 4 digitos: ");
            int rsenha = sc.nextInt();
            n += 2;

            do {
                if (n == 2 || resp == 'n') {
                    if (rsenha == acs.getSenha() && rconta == acs.getNumero()) {
                        System.out.println("Login com sucesso!\n");

                        System.out.println("\n- Nome: " + acs.getNomeCliente() + "\n- Conta: " + acs.getNumero()
                                + "\n- Valor em conta: " + fx.getValorConta() + " R$");
                        System.out.println("\nSegue os comandos\n  * (s) para depositar e (n) para ser retirado");
                        char cmda;
                        cmda = sc.next().charAt(0);

                        if (cmda == 's') {
                            System.out.println("* Valor a ser depositado: ");
                            double entradaC = sc.nextDouble();
                            fx.addValorC(entradaC);
                            System.out.println("\n- Nome: " + acs.getNomeCliente() + "\n- Conta: " + acs.getNumero()
                                    + "\n- Valor em conta: " + fx.getValorConta() + " R$");
                            System.out.println("* Deseja sair? s/n");
                            char sair = sc.next().charAt(0);
                            exit = sair;
                        }
                        if (cmda == 'n') {
                            System.out.println("Valor a ser retirado: ");
                            double saidaC = sc.nextDouble();
                            fx.removeValorC(saidaC);
                            System.out.println("\n- Nome: " + acs.getNomeCliente() + "\n- Conta: " + acs.getNumero()
                                    + "\n- Valor em conta: " + fx.getValorConta() + " R$");
                            System.out.println("Deseja sair? s/n");
                            char sair = sc.next().charAt(0);
                            exit = sair;
                        }
                    }
                }
            } while (exit == 'n');
        }
    }
}
// Rodrigo Rodrigues R Dutra - copyright