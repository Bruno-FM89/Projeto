public class Lider extends Usuario {
    private String areaDeLideranca;
    private Equipe equipe;

    public Lider() {
        super();
    }

    public Lider(String nome, String ra, String curso, int ano, String areaDeLideranca) {
        super(nome, ra, curso, ano);
        this.areaDeLideranca = areaDeLideranca;
    }

    public String getAreaDeLideranca() {
        return areaDeLideranca;
    }

    public void setAreaDeLideranca(String areaDeLideranca) {
        this.areaDeLideranca = areaDeLideranca;
    }

    public Equipe criarEquipe(String nome, String areaDeAtuacao) {
        this.equipe = new Equipe(nome, areaDeAtuacao, this);
        return this.equipe;
    }

    public void adicionaMembro( Membro membro) { 
          if (this.equipe == null) {
        System.out.println("Crie uma equipe antes de adicionar tarefas.");
        return;}

        this.equipe.adicionaMembro(membro);

    }
    public void criarTarefa(Tarefa tarefa){

          if (this.equipe == null) {
        System.out.println("Crie uma equipe antes de adicionar tarefas.");
        return;}


        this.equipe.adicionaTarefa(tarefa);

    }

    public String toString(){
        return "Nome: "+getNome()+"\nCargo: Líder"+"\nRA: "+getRA()+"\nCurso: "+getCurso()+"\nAno: "+getAno()+"\nArea de liderança: "+areaDeLideranca; 
    }

    public Equipe getEquipe() {
        return equipe;
    }

}
