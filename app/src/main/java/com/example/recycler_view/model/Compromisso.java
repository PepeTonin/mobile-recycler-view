package com.example.recycler_view.model;

public class Compromisso {
    private String titulo;
    private String local;
    private String data;
    private String horario;

    public Compromisso(String titulo, String local, String data, String horario) {
        this.titulo = titulo;
        this.local = local;
        this.data = data;
        this.horario = horario;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }
}
