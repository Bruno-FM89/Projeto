public class Membro extends Usuario {
    private Equipe equipe;

    public Membro() {
       super();
    }

    public Membro(String nome, String ra, String curso, int ano, Equipe equipe) {
        super(nome, ra, curso, ano);
        this.equipe = equipe;
    }

    public Equipe getEquipe() {
        return equipe;
    }

    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }

    public void visualizarTarefa(){
             if (equipe == null) {
        System.out.println("Membro não pertence a nenhuma equipe.");
        return;
    }

    for (Tarefa t : equipe.getListaDeTarefas()) {
        System.out.println(t);
    }
    }
    public void atualizarStatusTarefa(Tarefa tarefa,StatusTarefa novoStatus) throws Excessao{
    if (equipe == null) {
        System.out.println("Membro não pertence a nenhuma equipe.");
        return;
    }

    if (!equipe.getListaDeTarefas().contains(tarefa)) {
        System.out.println("Essa tarefa não pertence à equipe do membro.");
        return;
    }
    
        tarefa.setStatusTarefa(novoStatus);
    System.out.println("Status atualizado com sucesso!");
    

    }

    public String toString(){
          return "Nome: "+getNome()+"\nCargo: Membro"+"\nRA: "+getRA()+"\nCurso: "+getCurso()+"\nAno: "+getAno(); 
    }
    }

    

