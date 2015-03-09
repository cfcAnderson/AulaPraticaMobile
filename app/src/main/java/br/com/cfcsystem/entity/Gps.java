package br.com.cfcsystem.entity;

public class Gps{

  private Integer id;
  private Double latitude;
  private Double longitude;
  private String dataHora;
  private String statusEnviado;
  private Integer idAula;

  public void setId(Integer id){
      this.id = id;
  }

  public Integer getId(){
      return id;
  }

  public void setLatitude(Double latitude){
      this.latitude = latitude;
  }

  public Double getLatitude(){
      return latitude;
  }

  public void setLongitude(Double longitude){
      this.longitude = longitude;
  }

  public Double getLongitude(){
      return longitude;
  }

  public void setDataHora(String dataHora){
      this.dataHora = dataHora;
  }

  public String getDataHora(){
      return dataHora;
  }

  public void setStatusEnviado(String statusEnviado){
      this.statusEnviado = statusEnviado;
  }

  public String getStatusEnviado(){
      return statusEnviado;
  }

  public void setIdAula(Integer idAula){
      this.idAula = idAula;
  }

  public Integer getIdAula(){
      return idAula;
  }

}