package br.com.cfcsystem.entity;

/**
 * Created by Androider on 20/02/2015.
 */
public class Aula {

    private Integer id;
    private Integer idCar;
    private long horaInit;
    private long horaFim;
    private double trajeto;
    private Integer instrutor;
    private Integer aluno;
    private Integer veiculo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdCar() {
        return idCar;
    }

    public void setIdCar(Integer idCar) {
        this.idCar = idCar;
    }

    public long getHoraInit() {
        return horaInit;
    }

    public void setHoraInit(long horaInit) {
        this.horaInit = horaInit;
    }

    public long getHoraFim() {
        return horaFim;
    }

    public void setHoraFim(long horaFim) {
        this.horaFim = horaFim;
    }

    public double getTrajeto() {
        return trajeto;
    }

    public void setTrajeto(double trajeto) {
        this.trajeto = trajeto;
    }

    public Integer getInstrutor() {
        return instrutor;
    }

    public void setInstrutor(Integer instrutor) {
        this.instrutor = instrutor;
    }

    public Integer getAluno() {
        return aluno;
    }

    public void setAluno(Integer aluno) {
        this.aluno = aluno;
    }

    public Integer getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Integer veiculo) {
        this.veiculo = veiculo;
    }
}
