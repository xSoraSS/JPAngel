package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "Clase")
@Entity
public class Clase implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", insertable = false, nullable = false)
    private Integer id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "rama")
    private String rama;

    @Column(name = "n_Alumnos")
    private Integer nAlumnos;

    @Column(name = "instituto_id", nullable = false)
    private Integer institutoId;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRama() {
        return rama;
    }

    public void setRama(String rama) {
        this.rama = rama;
    }

    public Integer getnAlumnos() {
        return nAlumnos;
    }

    public void setnAlumnos(Integer nAlumnos) {
        this.nAlumnos = nAlumnos;
    }

    public Integer getInstitutoId() {
        return institutoId;
    }

    public void setInstitutoId(Integer institutoId) {
        this.institutoId = institutoId;
    }

    @Override
    public String toString() {
        return "Clase{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", rama='" + rama + '\'' +
                ", nAlumnos=" + nAlumnos +
                ", institutoId=" + institutoId +
                '}' + "\n";
    }
}