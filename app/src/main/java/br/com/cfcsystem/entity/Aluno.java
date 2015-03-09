package br.com.cfcsystem.entity;

public class Aluno{

  private Integer id;
  private String nome;
  private String cpf;
  private String dataCadastro;
  private String municipio;
  private String uf;
  private String digital;
  private byte[] foto;

  public void setId(Integer id){
      this.id = id;
  }

  public Integer getId(){
      return id;
  }

  public void setNome(String nome){
      this.nome = nome;
  }

  public String getNome(){
      return nome;
  }

  public void setCpf(String cpf){
      this.cpf = cpf;
  }

  public String getCpf(){
      return cpf;
  }

  public void setDataCadastro(String dataCadastro){
      this.dataCadastro = dataCadastro;
  }

  public String getDataCadastro(){
      return dataCadastro;
  }

  public void setMunicipio(String municipio){
      this.municipio = municipio;
  }

  public String getMunicipio(){
      return municipio;
  }

  public void setUf(String uf){
      this.uf = uf;
  }

  public String getUf(){
      return uf;
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