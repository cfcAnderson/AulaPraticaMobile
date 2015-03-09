package br.com.cfcsystem.entity;

/**
 * Created by Androider on 20/02/2015.
 */
public class DataGps {

    private Integer Id; // Primary Key
    private Integer IdAula; // External Key
    private long hora;
    private double latitude;
    private double longitude;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public Integer getIdAula() {
        return IdAula;
    }

    public void setIdAula(Integer idAula) {
        IdAula = idAula;
    }

    public long getHora() {
        return hora;
    }

    public void setHora(long hora) {
        this.hora = hora;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
