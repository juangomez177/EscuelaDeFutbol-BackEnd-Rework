package co.udea.api.model;

import javax.persistence.*;

@Entity
@Table(name = "equipo")
public class Equipo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nombre_equipo", unique=true)
    private String nombre_equipo;

    @Column(name = "categoria_nombre")
    private String categoria;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "capitan")
    private String capitan;

    @Column(name = "entrenador")
    private String entrenador;

    @Column(name = "logo")
    private String logo;


    public Equipo() {
    }

    

    public Equipo(Integer id, String nombre_equipo, String categoria, String descripcion, String capitan,
            String entrenador, String logo) {
        this.id = id;
        this.nombre_equipo = nombre_equipo;
        this.categoria = categoria;
        this.descripcion = descripcion;
        this.capitan = capitan;
        this.entrenador = entrenador;
        this.logo = logo;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre_equipo() {
        return nombre_equipo;
    }

    public void setNombre_equipo(String nombre_equipo) {
        this.nombre_equipo = nombre_equipo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getCapitan() {
        return capitan;
    }

    public void setCapitan(String capitan) {
        this.capitan = capitan;
    }

    public String getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(String entrenador) {
        this.entrenador = entrenador;
    }

    

    public String getDescripcion() {
        return descripcion;
    }



    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }



    public String getLogo() {
        return logo;
    }



    public void setLogo(String logo) {
        this.logo = logo;
    }



    @Override
    public String toString() {
        return "Equipo [id=" + id + ", nombre_equipo=" + nombre_equipo + ", categoria=" + categoria + ", descripcion="
                + descripcion + ", capitan=" + capitan + ", entrenador=" + entrenador + ", logo=" + logo + "]";
    }



}
