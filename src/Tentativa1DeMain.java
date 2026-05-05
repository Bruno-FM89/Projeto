public class Tentativa1DeMain {
    /*import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.text.Normalizer;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class App {
    List<Usuario> listaDeUsuarios = new ArrayList<>();
    List<Equipe> listaDEquipes = new ArrayList<>();

    public Usuario cadastrarUsuario(Scanner sc) {

        System.out.println("Que tipo de usuário você é? Membro ou líder?");
        String cargo = sc.nextLine();

        String cargoNormalizado = Normalizer.normalize(cargo, Normalizer.Form.NFD)
                .replaceAll("[\\p{InCombiningDiacriticalMarks}]", "")
                .toLowerCase();

        System.out.println("Perfeito, agora digite seu nome:");
        String nome = sc.nextLine();

        System.out.println("Agora seu RA:");
        String RA = sc.nextLine();

        System.out.println("Seu curso:");
        String curso = sc.nextLine();

        System.out.println("Ano em que está na Mauá:");
        int anoQueEstaNaMaua = sc.nextInt();
        sc.nextLine();

        switch (cargoNormalizado) {
            case "lider":
                System.out.println("Digite qual é a sua área de liderança:");
                String areaDeLideranca = sc.nextLine();

                Lider lider = new Lider(nome, RA, curso, anoQueEstaNaMaua, areaDeLideranca);
                listaDeUsuarios.add(lider);

                System.out.println("Cadastro concluído com sucesso!");
                return lider;

            case "membro":
                Membro membro = new Membro(nome, RA, curso, anoQueEstaNaMaua, null);
                listaDeUsuarios.add(membro);

                System.out.println("Cadastro concluído com sucesso!");
                return membro;

            default:
                System.out.println("Cargo inválido. Tente novamente.");

                return null;
        }
    }

    public void mostraMenu(Usuario usuario) {
        System.out.println();
        System.out.println("Olá " + usuario.getNome() + " oque deseja fazer ? ");

        if (usuario instanceof Lider) {

            System.out.println("1-criar uma equipe");
            System.out.println("2-Adicionar uma tarefa a uma equipe sua ");
            System.out.println("3-Verificar o status da tarefas da sua equipe");
            System.out.println("4-adicionar um membro a sua equipe ");
            System.out.println("5-sair");

            System.out.println("---------------------------------------------");
        } else {
            if (usuario instanceof Membro) {

                System.out.println("1-Visualizar tarefas");
                System.out.println("2-Atualizar status de uma tarefa");
                System.out.println("3-sair");

                System.out.println("-------------------------------------");

            }
        }

    }

    public static void main(String[] args) throws Exception {

        DateTimeFormatter formato01 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Scanner sc = new Scanner(System.in);
        Tarefa tarefa = null;
        Equipe equipe = null;

        App app = new App();

        Usuario usuario = app.cadastrarUsuario(sc);

        

        int escolha = 0;
        sc.nextLine();

        while (escolha != 5) {

            app.mostraMenu(usuario);

            escolha = sc.nextInt();
            sc.nextLine();

            if (usuario instanceof Lider) {
                switch (escolha) {
                    case 1:
                        Lider lider = (Lider) usuario;

                        System.out.println("Digite o nome da equipe:");
                        String nome = sc.nextLine();

                        System.out.println("Área:");
                        String area = sc.nextLine();

                        equipe = lider.criarEquipe(nome, area);

                        app.listaDEquipes.add(equipe);

                        System.out.println("Equipe criada com sucesso !");
                        break;

                    case 2:

                        if (!(usuario instanceof Lider)) {
                            System.out.println("Apenas líderes podem criar tarefas.");
                            break;
                        }

                        if (equipe == null) {
                            System.out.println("Crie uma equipe antes de criar uma tarefa.");
                            break;
                        }

                        lider = (Lider) usuario;

                        System.out.println("Título da tarefa:");
                        String titulo = sc.nextLine();

                        System.out.println("Descrição:");
                        String descricao = sc.nextLine();

                        System.out.println("Prazo de entrega (dd/MM/aaaa):");
                        String data = sc.nextLine();

                        LocalDate prazoDeEntrega = LocalDate.parse(data, formato01);

                        StatusTarefa status;

                        if (prazoDeEntrega.isBefore(LocalDate.now())) {
                            status = StatusTarefa.ATRASADA;
                        } else {
                            status = StatusTarefa.PENDENTE;
                        }

                        tarefa = new Tarefa(titulo, descricao, prazoDeEntrega, status, equipe);

                        lider.criarTarefa(equipe, tarefa);

                        System.out.println("Tarefa criada com sucesso!");

                        break;

                    case 3:

                        if (equipe == null) {
                            System.out.println("Nenhuma equipe criada.");
                            break;
                        }

                        if (equipe.getListaDeTarefas().isEmpty()) {
                            System.out.println("Nenhuma tarefa na equipe.");
                            break;
                        }

                        for (Tarefa t : equipe.getListaDeTarefas()) {
                            System.out.println("Tarefa: " + t.getTitulo());
                            System.out.println("Status: " + t.getStatusTarefa());
                            System.out.println("---------------------");
                        }

                        break;

                    default:
                        break;
                }

            }

        }

        sc.close();

    }
} */
    
}
