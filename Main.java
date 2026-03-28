import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
    Scanner teclado = new Scanner(System.in);
    Map<String, UserData> bancoDeDados = new HashMap<>();

    boolean rodando = true;

    while (rodando) {
        System.out.println("\n--- SISTEMA DE ACESSO ---");
        System.out.println("1. Cadastrar Novo Usuário");
        System.out.println("2. Fazer Login");
        System.out.println("3. Sair");
        System.out.print("Escolha uma opção: ");

        String opcao = teclado.nextLine();

        switch (opcao) {
            case "1":
                System.out.print("Crie um ID de usuário: ");
                String novoId = teclado.nextLine();

                if (bancoDeDados.containsKey(novoId)) {
                    System.out.println("Erro: Este ID já existe!");
                } else {
                    System.out.print("Digite seu nome completo: ");
                    String nome = teclado.nextLine();
                    System.out.print("Crie uma senha: ");
                    String senha = teclado.nextLine();

                    bancoDeDados.put(novoId, new UserData(nome, senha));
                    System.out.println("Usuário cadastrado com sucesso!");
                }
                break;

            case "2":
                System.out.print("ID: ");
                String idLogin = teclado.nextLine();

                if (!bancoDeDados.containsKey(idLogin)) {
                    System.out.println("Usuário não encontrado.");
                    break;
                }

                UserData usuario = bancoDeDados.get(idLogin);

                // Verifica se está bloqueado
                if (usuario.estaBloqueado()) {
                    System.out.println("Conta bloqueada! Tente novamente após: " + usuario.getHorarioDesbloqueio());
                    break;
                }

                System.out.print("Senha: ");
                String senhaLogin = teclado.nextLine();

                if (usuario.getSenha().equals(senhaLogin)) {
                    System.out.println("\nBem vindo, " + usuario.getNome());
                    usuario.resetarFalhas(); // limpa o contador se entrar com sucesso
                } else {
                    usuario.registrarFalha();
                    int falhas = usuario.getTentativasFalhas();

                    if (falhas >= 3) {
                        int minutos = 5 * (falhas - 2);
                        usuario.bloquear(minutos);
                        System.out.println("\nSenha incorreta! Limite de 3 tentativas atingido.");
                        System.out.println("Você foi bloqueado por " + minutos + " minutos.");
                    } else {
                        System.out.println("\nSenha incorreta! Tentativas: " + falhas + "/3");
                    }
                }
                break;

            case "3":
                System.out.println("Encerrando sistema...");
                rodando = false;
                break;

            default:
                System.out.println("Opção inválida!");
        }
    }
    teclado.close();
 }
}
