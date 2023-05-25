public class Fornecedor extends Parceiros {
    private String razaoSocial;
    private String inscricaoEstadual;
    private String cnpj;

    public Fornecedor(int codigo, String nome, String telefone, String email, String razaoSocial, String inscricaoEstadual, String cnpj) {
        super(codigo, nome, telefone, email);
        this.razaoSocial = razaoSocial;
        this.inscricaoEstadual = inscricaoEstadual;
        this.cnpj = cnpj;
    }

    // Getters e Setters
    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getInscricaoEstadual() {
        return inscricaoEstadual;
    }

    public void setInscricaoEstadual(String inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}
