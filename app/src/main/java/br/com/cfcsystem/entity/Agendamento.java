package br.com.cfcsystem.entity;

public class Agendamento{

  private Integer id;
  private String dataAgendamento;
  private Integer instrutorCodigo;
  private Integer veiculoId;
  private Integer alunoId;
  private String categoria;

  public void setId(Integer id){
      this.id = id;
  }

  public Integer getId(){
      return id;
  }

  public void setDataAgendamento(String dataAgendamento){
      this.dataAgendamento = dataAgendamento;
  }

  public String getDataAgendamento(){
      return dataAgendamento;
  }

  public void setInstrutorCodigo(Integer instrutorCodigo){
      this.instrutorCodigo = instrutorCodigo;
  }

  public Integer getInstrutorCodigo(){
      return instrutorCodigo;
  }

  public void setVeiculoId(Integer veiculoId){
      this.veiculoId = veiculoId;
  }

  public Integer getVeiculoId(){
      return veiculoId;
  }

  public void setAlunoId(Integer alunoId){
      this.alunoId = alunoId;
  }

  public Integer getAlunoId(){
      return alunoId;
  }

  public void setCategoria(String categoria){
      this.categoria = categoria;
  }

  public String getCategoria(){
      return categoria;
  }

}