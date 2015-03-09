package br.com.cfcsystem.entity;

public class Veiculo{

  private Integer id;
  private String placa;
  private String nome;
  private String marca;
  private String modelo;

  public void setId(Integer id){
      this.id = id;
  }

  public Integer getId(){
      return id;
  }

  public void setPlaca(String placa){
      this.placa = placa;
  }

  public String getPlaca(){
      return placa;
  }

  public void setNome(String nome){
      this.nome = nome;
  }

  public String getNome(){
      return nome;
  }

  public void setMarca(String marca){
      this.marca = marca;
  }

  public String getMarca(){
      return marca;
  }

  public void setModelo(String modelo){
      this.modelo = modelo;
  }

  public String getModelo(){
      return modelo;
  }

}