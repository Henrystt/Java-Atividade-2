public class Funcionarios extends Parceiros {
    private int ctps;

    public Funcionarios(int codigo, String nome, String telefone, String email, int ctps) {
        super(codigo, nome, telefone, email);
        this.ctps = ctps;
    }

    // Getters e Setters
    public int getCtps() {
        return ctps;
    }

    public void setCtps(int ctps) {
        this.ctps = ctps;
    }

}
