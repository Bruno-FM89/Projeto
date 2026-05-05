public  abstract class Usuario {
    private String nome;
    private String ra;
    private String curso;
    private int ano;

    public Usuario(){};
    
    public Usuario(String nome, String ra,String curso, int ano){
        this.nome=nome;
        this.ra=ra;
        this.curso=curso;
        this.ano=ano;
    }
    public void setNome(String nome){
        this.nome=nome;
    }
    public String getNome(){
        return nome;
    }
    public void setRa(String ra){
        this.ra=ra;
    }
    public String getRA(){
        return ra;
    }
    public void setCurso(String curso){
        this.curso=curso;
    }
    public String getCurso(){
        return curso;
    }
    public void setAno(int ano){
        this.ano=ano;
    }
    public int getAno(){
        return ano;
    }
    
}
