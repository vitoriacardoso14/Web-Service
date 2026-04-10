package webservice;

public class Vaga {
    private int id;
    private String cargo;
    private double salario;

    public Vaga() {}

    public Vaga(int id, String cargo, double salario) {
        this.id = id;
        this.cargo = cargo;
        this.salario = salario;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getCargo() { return cargo; }
    public void setCargo(String cargo) { this.cargo = cargo; }

    public double getSalario() { return salario; }
    public void setSalario(double salario) { this.salario = salario; }
}