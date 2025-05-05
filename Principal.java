import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EPIDao epiDao = new EPIDao();
        UsuarioDao usuarioDao = new UsuarioDao();
        EmprestimoDao emprestimoDao = new EmprestimoDao();
        DevolucaoDao devolucaoDao = new DevolucaoDao();

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Inserir EPI");
            System.out.println("2. Listar EPIs");
            System.out.println("3. Inserir Usuário");
            System.out.println("4. Listar Usuários");
            System.out.println("5. Registrar Empréstimo");
            System.out.println("6. Listar Empréstimos");
            System.out.println("7. Registrar Devolução");
            System.out.println("8. Listar Devoluções");
            System.out.println("9. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome do EPI: ");
                    String nomeEpi = scanner.nextLine();
                    System.out.print("Digite a validade do EPI: ");
                    String validadeEpi = scanner.nextLine();
                    EPI epi = new EPI(nomeEpi, validadeEpi);
                    epiDao.inserirEPI(epi);
                    break;

                case 2:
                    ArrayList<EPI> epis = epiDao.listarEPIs();
                    epis.forEach(System.out::println);
                    break;

                case 3:
                    System.out.print("Digite o nome do usuário: ");
                    String nomeUsuario = scanner.nextLine();
                    System.out.print("Digite o e-mail do usuário: ");
                    String emailUsuario = scanner.nextLine();
                    System.out.print("Digite a senha do usuário: ");
                    String senhaUsuario = scanner.nextLine();
                    System.out.print("Digite o perfil do usuário: ");
                    String perfilUsuario = scanner.nextLine();
                    Usuario usuario = new Usuario(nomeUsuario, emailUsuario, senhaUsuario, perfilUsuario);
                    usuarioDao.inserirUsuario(usuario);
                    break;

                case 4:
                    ArrayList<Usuario> usuarios = usuarioDao.listarUsuarios();
                    usuarios.forEach(System.out::println);
                    break;

                case 5:
                    System.out.print("Digite o ID do colaborador: ");
                    int idColaborador = scanner.nextInt();
                    System.out.print("Digite o ID do EPI: ");
                    int idEpiEmprestimo = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Digite a data do empréstimo (dd/MM/yyyy): ");
                    String dataEmprestimo = scanner.nextLine();
                    Emprestimo emprestimo = new Emprestimo(idColaborador, idEpiEmprestimo, dataEmprestimo);
                    emprestimoDao.inserirEmprestimo(emprestimo);
                    break;

                case 6:
                    ArrayList<Emprestimo> emprestimos = emprestimoDao.listarEmprestimos();
                    emprestimos.forEach(System.out::println);
                    break;

                case 7:
                    System.out.print("Digite o ID do empréstimo: ");
                    int idEmprestimoDevolucao = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Digite a data da devolução (dd/MM/yyyy): ");
                    String dataDevolucao = scanner.nextLine();
                    Devolucao devolucao = new Devolucao(idEmprestimoDevolucao, dataDevolucao);
                    devolucaoDao.inserirDevolucao(devolucao);
                    break;

                case 8:
                    ArrayList<Devolucao> devolucoes = devolucaoDao.listarDevolucoes();
                    devolucoes.forEach(System.out::println);
                    break;

                case 9: 
                    System.out.println("Saindo...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}

