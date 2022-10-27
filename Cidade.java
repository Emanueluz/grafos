/** @author Emanuel Norjosa Luz e Giovanni Sencioles */

package grafos;

public class Cidade <Tipo extends Comparable<Tipo>>{
    private int codigo;
    private String nome;
    Cidade(int c, String nm){
        this.codigo = c;
        this.nome = nm;
    }
    public int getCodigo(){
        return this.codigo;
    }
    public String getNome(){
        return this.nome;
    }
    public void setCodigo(int c){
        this.codigo = c;
    }
    public void setNome(String nm){
        this.nome = nm;
    }
    @Override
    public int compareTo(Cidade o) {
        if (this.codigo == o.codigo){
            return 0;
        }
        else if (this.codigo > o.codigo){
            return 1;
        }
        else{
            return -1;
        }
    }
    @Override
    public String toString() {
	return ("Codigo: " + Integer.toString(this.codigo) + " - Nome: " + this.nome);
    }
}
