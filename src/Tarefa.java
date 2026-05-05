
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Tarefa {
    private String titulo;
    private String descricao;
    private LocalDate prazoDeEntrega;
    private StatusTarefa statusTarefa;
    private Equipe equipe;

    DateTimeFormatter formato1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Tarefa() {
    }

    public Tarefa(String titulo, String descricao, LocalDate prazoDeEntrega, StatusTarefa statusTarefa) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.prazoDeEntrega = prazoDeEntrega;
        this.statusTarefa = statusTarefa;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setPrazoDeEntrega(String prazoDeEntrega) {
        LocalDate dataFormatada = LocalDate.parse(prazoDeEntrega, formato1);

        this.prazoDeEntrega = dataFormatada;
    }

    public LocalDate getPrazoDeEntrega() {
        return prazoDeEntrega;
    }

    public void setStatusTarefa(StatusTarefa statusTarefa)  {

        
            this.statusTarefa = statusTarefa;
        
    }

    public StatusTarefa getStatusTarefa() {
        return statusTarefa;
    }

    public Equipe getEquipe() {
        return equipe;
    }

    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }

    public String toString() {
        return "Título: " + titulo +
                "\nDescrição: " + descricao +
                "\nPrazo: " + prazoDeEntrega +
                "\nStatus: " + statusTarefa +
                "\n---------------------";
    }

}
    