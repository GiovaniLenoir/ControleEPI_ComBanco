public class Emprestimo {
    private int id;
    private int idColaborador;
    private int idEpi;
    private String dataEmprestimo;

    public Emprestimo(int id, int idColaborador, int idEpi, String dataEmprestimo) {
        this.id = id;
        this.idColaborador = idColaborador;
        this.idEpi = idEpi;
        this.dataEmprestimo = dataEmprestimo;
    }

    public Emprestimo(int idColaborador, int idEpi, String dataEmprestimo) {
        this.idColaborador = idColaborador;
        this.idEpi = idEpi;
        this.dataEmprestimo = dataEmprestimo;
    }

    public int getId() {
        return id;
    }
    public int getIdColaborador() {
        return idColaborador;
    }
    public int getIdEpi() {
        return idEpi;
    }
    public String getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setIdColaborador(int idColaborador) {
        this.idColaborador = idColaborador;
    }
    public void setIdEpi(int idEpi) {
        this.idEpi = idEpi;
    }
    public void setDataEmprestimo(String dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Colaborador: " + idColaborador + ", EPI: " + idEpi + ", Data: " + dataEmprestimo;
    }
}

