package br.com.cfcsystem.entity;

public class AgendamentoHorario{

  private Integer id;
  private Integer agendamentoId;
  private String inicio;
  private String fim;
  private String dataAula;
  private Integer documento;
  private String validado;

  public void setId(Integer id){
      this.id = id;
  }

  public Integer getId(){
      return id;
  }

  public void setAgendamentoId(Integer agendamentoId){
      this.agendamentoId = agendamentoId;
  }

  public Integer getAgendamentoId(){
      return agendamentoId;
  }

  public void setInicio(String inicio){
      this.inicio = inicio;
  }

  public String getInicio(){
      return inicio;
  }

  public void setFim(String fim){
      this.fim = fim;
  }

  public String getFim(){
      return fim;
  }

  public void setDataAula(String dataAula){
      this.dataAula = dataAula;
  }

  public String getDataAula(){
      return dataAula;
  }

  public void setDocumento(Integer documento){
      this.documento = documento;
  }

  public Integer getDocumento(){
      return documento;
  }

  public void setValidado(String validado){
      this.validado = validado;
  }

  public String getValidado(){
      return validado;
  }

}