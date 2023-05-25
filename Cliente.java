public class Cliente extends Parceiros {
    private String telefoneCelular;
    private String rg;
    private String cpf;

    public Cliente(int codigo, String nome, String telefone, String email, String telefoneCelular, String rg, String cpf) {
        super(codigo, nome, telefone, email);
        this.telefoneCelular = telefoneCelular;
        this.rg = rg;
        this.cpf = cpf;
    }

    // Getters e Setters
    public String getCelular() {
        return telefoneCelular;
    }

    public void setCelular(String telefoneCelular) {
        this.telefoneCelular = telefoneCelular;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
