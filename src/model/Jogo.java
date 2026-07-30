package model;

public class Jogo {

    private int id;
    private String nome;

    private int exigenciaCpu;
    private int exigenciaGpu;

    public Jogo() {
    }

    public Jogo(int id,
                String nome,
                int exigenciaCpu,
                int exigenciaGpu) {

        this.id = id;
        this.nome = nome;
        this.exigenciaCpu = exigenciaCpu;
        this.exigenciaGpu = exigenciaGpu;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getExigenciaCpu() {
        return exigenciaCpu;
    }

    public void setExigenciaCpu(int exigenciaCpu) {
        this.exigenciaCpu = exigenciaCpu;
    }

    public int getExigenciaGpu() {
        return exigenciaGpu;
    }

    public void setExigenciaGpu(int exigenciaGpu) {
        this.exigenciaGpu = exigenciaGpu;
    }

    @Override
    public String toString() {
        return id + " - " + nome;
    }
}