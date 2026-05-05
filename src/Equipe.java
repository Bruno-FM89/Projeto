import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
public class Equipe {
    private String nome;
    private String areaAtuacao;
    private Lider lider;
    private List<Membro> listaDeMembros;
    private List<Tarefa> listaDeTarefas;

    public Equipe(){}

    public Equipe(String nome, String areaAtuacao, Lider lider) {
        this.nome = nome;
        this.areaAtuacao = areaAtuacao;
        this.lider = lider;
        this.listaDeMembros=new ArrayList<>();
        this.listaDeTarefas=new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAreaAtuacao() {
        return areaAtuacao;
    }

    public void setAreaAtuacao(String areaAtuacao) {
        this.areaAtuacao = areaAtuacao;
    }

    public Lider getLider() {
        return lider;
    }

    public List<Membro> getListaDeMembros() {
        return Collections.unmodifiableList(listaDeMembros);
    }

    public List<Tarefa> getListaDeTarefas() {
        return Collections.unmodifiableList(listaDeTarefas);
    }

    public void setLider(Lider lider) {
        this.lider = lider;
    }

    public void adicionaMembro(Membro membro){
        listaDeMembros.add(membro);    
        membro.setEquipe(this);
    }
    public void adicionaTarefa(Tarefa tarefa){
        listaDeTarefas.add(tarefa);
        tarefa.setEquipe(this);
    }    
    
}
