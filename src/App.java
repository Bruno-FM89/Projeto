import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class App {
    List<Usuario> listaDeUsuarios = new ArrayList<>();
    List<Equipe> listaDeEquipes = new ArrayList<>();
    DateTimeFormatter formato01 = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Usuario criaUsuario(Scanner sc) {

        System.out.println("Qual o seu Cargo (Membro ou Líder) ? :");
        System.out.println("1-Lider");
        System.out.println("2-Membro");

        int cargo = sc.nextInt();
        sc.nextLine();

        System.out.println("Nome: ");

        String nomeUsuario = sc.nextLine();

        System.out.print("RA:");

        String ra = sc.nextLine();

        System.out.println("Curso: ");

        String curso = sc.nextLine();

        System.out.println("Ano em que está: ");

        int ano = sc.nextInt();
        sc.nextLine();

        switch (cargo) {
            case 1:

                System.out.println("Cargo que lidera:");

                String cargoDeLideranca = sc.nextLine();

                Usuario usuario = new Lider(nomeUsuario, ra, curso, ano, cargoDeLideranca);
                listaDeUsuarios.add(usuario);

                System.out.println("Cadastro concluido com sucesso!");
                System.out.println();

                return usuario;

            case 2:

                usuario = new Membro(nomeUsuario, ra, curso, ano, null);

                System.out.println("Cadastro concluido com sucesso !");
                System.out.println();
                listaDeUsuarios.add(usuario);

                return usuario;

            default:
                System.out.println("Não foi possivel realizar seu cadastro , por favor tente novamente");

                return null;

        }
    }

    public void mostraMenu(Usuario usuario) {

        if (usuario instanceof Lider) {

            System.out.println();

            System.out.println("1-criar uma equipe");
            System.out.println("2-Adicionar uma tarefa a uma equipe sua ");
            System.out.println("3-Verificar o status da tarefas da sua equipe");
            System.out.println("4-adicionar um membro a sua equipe ");
            System.out.println("5-Verifica os membros na sua equipe");
            System.out.println("6-sair");

            System.out.println();
        } else {
            System.out.println();
            System.out.println("1-Visualizar tarefas");
            System.out.println("2-Atualizar status de uma tarefa");
            System.out.println("6-sair");
            System.out.println();

        }
    }

    public static void main(String[] agrs) {
        Scanner sc = new Scanner(System.in);
        App app = new App();

        System.out.println("Iniciando seu aplicativo , por favor aguarde ");
        Lider usuarioLider = null;
        Membro usuarioMembro = null;
        // Cadastrando o usuario

        Usuario usuario = app.criaUsuario(sc);

        if (usuario instanceof Lider) {
            usuarioLider = (Lider) usuario;
            System.out.println(usuarioLider);

        } else {
            usuarioMembro = (Membro) usuario;

        }
        System.out.println();

        // Cadastro feito , agora iremos chamar o menu

        int escolha = 0;

        System.out.println("Seja bem vindo , oque deseja fazer ? ");

        while (escolha != 6) {
            app.mostraMenu(usuario);// mostra o menu de opções do usuarios com base no tipo de usuario q você é

            escolha = sc.nextInt();// escolhe a ação que vai fazer
            sc.nextLine();

            if (usuarioLider != null) {

                switch (escolha) {
                    case 1:
                        System.out.println("Digite o nome da equipe: ");

                        String nomeEquipe = sc.nextLine();

                        System.out.println("Agora digite a area de atuação da sua equipe: ");

                        String areaDeAtuacao = sc.nextLine();

                        usuarioLider.criarEquipe(nomeEquipe, areaDeAtuacao);

                        System.out.println("Equipe criada com sucesso ! Retornando ao Menu");

                        break;

                    case 2:

                        if (usuarioLider.getEquipe() == null) {
                            System.out.println("Você precisa criar uma equipe antes de criar tarefas.");
                            break;
                        }

                        System.out.println("Digite o titulo da sua tarefa");

                        String titulo = sc.nextLine();

                        System.out.println("Descrição da tarefa ? ");

                        String descricao = sc.nextLine();

                        System.out.println("Data de entrega(dd/mm/aaaa): ");

                        String data = sc.nextLine();

                        LocalDate prazoDeEntrega = LocalDate.parse(data, app.formato01);

                        StatusTarefa status;

                        if (prazoDeEntrega.isAfter(LocalDate.now())) {
                            status = StatusTarefa.PENDENTE;
                        } else {
                            if (prazoDeEntrega.isBefore(LocalDate.now())) {
                                status = StatusTarefa.ATRASADA;
                            } else {
                                status = StatusTarefa.EM_ANDAMENTO;
                            }
                        }

                        Tarefa tarefa = new Tarefa(titulo, descricao, prazoDeEntrega, status);

                        usuarioLider.criarTarefa(tarefa);

                        System.out.println("Tarefa criada com sucessso! retornando ao menu ");
                        break;

                    case 3:
                        if (usuarioLider.getEquipe() == null) {
                            System.out
                                    .println("Você precisa criar uma equipe antes de visualizar os status das tarefas");
                            break;
                        }

                        for (Tarefa t : usuarioLider.getEquipe().getListaDeTarefas()) {
                            System.out.println("Título: " + t.getTitulo());
                            System.out.println("Status: " + t.getStatusTarefa());
                            System.out.println("-------------------");

                        }
                        break;

                    case 4:
                        if (usuarioLider.getEquipe() == null) {
                            System.out.println("Você primeiro precisa de uma equipe para poder adicionar membros:");
                            break;
                        }

                        System.out.println("Nome do membro: ");

                        String nome = sc.nextLine();

                        System.out.println("Ra do membro:");

                        String ra = sc.nextLine();

                        System.out.println("Curso: ");

                        String curso = sc.nextLine();

                        System.out.println("Ano em que está: ");

                        int ano = sc.nextInt();
                        sc.nextLine();

                        Membro membro = new Membro(nome, ra, curso, ano, null);

                        usuarioLider.adicionaMembro(membro);

                        System.out.println("Membro adicionado com sucesso !");

                        app.listaDeUsuarios.add(membro);

                        break;

                    case 5:

                        if (usuarioLider.getEquipe() == null) {
                            System.out.println("Você primeiro precisa de uma equipe para poder ver os membros");
                            break;
                        }

                        for (Membro m : usuarioLider.getEquipe().getListaDeMembros()) {
                            System.out.println("Nome: " + m.getNome() + " (RA: " + m.getRA() + " )");

                        }
                        System.out.println("Membros mostrados , voltando ao menu.");

                    default:

                        System.out.println("Digite uma opção válida por favor ");
                        break;
                }

            }

            else {
                if (usuarioMembro != null) {

                    switch (escolha) {
                        case 1:
                            if (usuarioMembro.getEquipe() == null) {
                                System.out.println("Você ainda não está em nenhuma equipe.");
                                break;
                            }

                            if (usuarioMembro.getEquipe().getListaDeTarefas().isEmpty()) {
                                System.out.println("Sua equipe ainda não tem tarefas.");
                                break;
                            }

                            for (Tarefa t : usuarioMembro.getEquipe().getListaDeTarefas()) {
                                System.out.println(t);
                            }

                            break;

                        case 2:
                            if (usuarioMembro.getEquipe() == null) {
                                System.out.println("Você ainda não está em nenhuma equipe.");
                                break;
                            }

                            List<Tarefa> tarefas = usuarioMembro.getEquipe().getListaDeTarefas();

                            if (tarefas.isEmpty()) {
                                System.out.println("Sua equipe ainda não tem tarefas.");
                                break;
                            }

                            for (int i = 0; i < tarefas.size(); i++) {
                                System.out.println((i + 1) + " - " + tarefas.get(i).getTitulo()
                                        + " | Status: " + tarefas.get(i).getStatusTarefa());
                            }

                            System.out.println("Escolha o número da tarefa:");
                            int indice = sc.nextInt();
                            sc.nextLine();

                            if (indice < 1 || indice > tarefas.size()) {
                                System.out.println("Tarefa inválida.");
                                break;
                            }

                            Tarefa tarefaEscolhida = tarefas.get(indice - 1);

                            System.out.println("Novo status:");
                            System.out.println("1 - PENDENTE");
                            System.out.println("2 - EM_ANDAMENTO");
                            System.out.println("3 - CONCLUIDA");

                            int opcaoStatus = sc.nextInt();
                            sc.nextLine();

                            switch (opcaoStatus) {
                                case 1:
                                    tarefaEscolhida.setStatusTarefa(StatusTarefa.PENDENTE);
                                    break;
                                case 2:
                                    tarefaEscolhida.setStatusTarefa(StatusTarefa.EM_ANDAMENTO);
                                    break;
                                case 3:
                                    tarefaEscolhida.setStatusTarefa(StatusTarefa.CONCLUIDA);
                                    break;
                                default:
                                    System.out.println("Status inválido.");
                                    break;
                            }

                            System.out.println("Status atualizado com sucesso!");
                            break;

                        default:
                            break;
                    }

                }

            }

        }

        sc.close();
    }

}
