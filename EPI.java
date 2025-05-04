public class EPI {
    private int id;
    private String nome;
    private String validade;

    public EPI(String nome, String validade) {
        this.nome = nome;
        this.validade = validade;
    }
    public EPI(int id, String nome, String validade) {
        this.id = id;
        this.nome = nome;
        this.validade = validade;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getValidade() {
        return validade;
    }
}
