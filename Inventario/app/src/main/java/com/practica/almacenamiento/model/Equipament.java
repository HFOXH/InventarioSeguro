package com.practica.almacenamiento.model;

public class Equipament {

    private int id;
    private String name;
    private String descrip;
    private String cant;
    private String precio;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return name;
    }

    public void setNombres(String nombre) {
        this.name = nombre;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public String getCant() {
        return cant;
    }

    public void setCant(String cant) {
        this.cant = cant;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public Equipament(){

    }

    public Equipament(String name, String descrip, String cant, String precio){

        this.name = name;
        this.descrip = descrip;
        this.cant = cant;
        this.precio = precio;

    }

}
