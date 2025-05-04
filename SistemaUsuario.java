import java.util.ArrayList;
import java.util.Scanner;

public class SistemaUsuario {
    private static ArrayList<Usuario> usuarios = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);
    private static int proximoId = 1;

    public static void main(String[] args) {
        int opcao;
        do {
            System.out.println("\n--- MENU USUÁRIOS ---");
            System.out.println("1. Cadastrar");
            System.out.println("2. Listar");
            System.out.println("3. Atualizar");
            System.out.println("4. Remover");
            System.out.println("0. Sair");
            System.out.print("Opção: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1: cadastrar(); break;
                case 2: listar(); break;
                case 3: atualizar(); break;
                case 4: remover(); break;
                case 0: System.out.println("Saindo..."); break;
                default: System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }

    private static void cadastrar() {
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Senha: ");
        String senha = sc.nextLine();
        System.out.print("Perfil (ADMIN/USER): ");
        String perfil = sc.nextLine();

        Usuario novo = new Usuario(proximoId++, nome, email, senha, perfil.toUpperCase());
        usuarios.add(novo);
        System.out.println("Usuário cadastrado com sucesso.");
    }

    private static void listar() {
        if (usuarios.isEmpty()) {
            System.out.println("Nenhum usuário cadastrado.");
            return;
        }
        for (Usuario u : usuarios) {
            System.out.println(u);
        }
    }

    private static void atualizar() {
        System.out.print("ID do usuário a atualizar: ");
        int id = sc.nextInt();
        sc.nextLine();
        for (Usuario u : usuarios) {
            if (u.getId() == id) {
                System.out.print("Novo nome: ");
                u.setNome(sc.nextLine());
                System.out.print("Novo email: ");
                u.setEmail(sc.nextLine());
                System.out.print("Nova senha: ");
                u.setSenha(sc.nextLine());
                System.out.print("Novo perfil: ");
                u.setPerfil(sc.nextLine().toUpperCase());
                System.out.println("Usuário atualizado.");
                return;
            }
        }
        System.out.println("Usuário não encontrado.");
    }

    private static void remover() {
        System.out.print("ID do usuário a remover: ");
        int id = sc.nextInt();
        sc.nextLine();
        for (Usuario u : usuarios) {
            if (u.getId() == id) {
                usuarios.remove(u);
                System.out.println("Usuário removido.");
                return;
            }
        }
        System.out.println("Usuário não encontrado.");
    }
}

