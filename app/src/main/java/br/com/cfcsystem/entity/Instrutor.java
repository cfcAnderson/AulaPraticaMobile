package br.com.cfcsystem.entity;

public class Instrutor{

  private Integer codigo;
  private String nome;
  private String digital;
  private byte[] foto;

  public void setCodigo(Integer codigo){
      this.codigo = codigo;
  }

  public Integer getCodigo(){
      return codigo;
  }

  public void setNome(String nome){
      this.nome = nome;
  }

  public String getNome(){
      return nome;
  }

  public void setDigital(String digital){
      this.digital = digital;
  }

  public String getDigital(){
      return digital;
  }

  public void setFoto(byte[] foto){
      this.foto = foto;
  }

  public byte[] getFoto(){
      return foto;
  }

}