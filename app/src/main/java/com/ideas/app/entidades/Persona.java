package com.ideas.app.entidades;

public class Persona {

    private String nombre;
    private String apelllido;
    private double estatura;
    private  double peso;
    private int edad;
    private String sexo;
    private double indiceMasaCorporal;


    public Persona(){}

    public Persona(String nombre, String apelllido, double estatura, double peso, int edad, String sexo, double indiceMasaCorporal) {
        this.nombre = nombre;
        this.apelllido = apelllido;
        this.estatura = estatura;
        this.peso = peso;
        this.edad = edad;
        this.sexo = sexo;
        this.indiceMasaCorporal = indiceMasaCorporal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApelllido() {
        return apelllido;
    }

    public void setApelllido(String apelllido) {
        this.apelllido = apelllido;
    }

    public double getEstatura() {
        return estatura;
    }

    public void setEstatura(double estatura) {
        this.estatura = estatura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public double getIndiceMasaCorporal() {
        return indiceMasaCorporal;
    }

    public void setIndiceMasaCorporal(double indiceMasaCorporal) {
        this.indiceMasaCorporal = indiceMasaCorporal;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", apelllido='" + apelllido + '\'' +
                ", estatura=" + estatura +
                ", peso=" + peso +
                ", edad=" + edad +
                ", sexo='" + sexo + '\'' +
                ", indiceMasaCorporal=" + indiceMasaCorporal +
                '}';
    }
}
