package co.udea.api.model;

import javax.persistence.*;

@Entity
@Table(name = "jugador")
public class Jugador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "id_equipo")
    private Integer id_equipo;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "edad")
    private Integer edad;

    @Column(name = "categoria")
    private String categoria;

    @Column(name = "nombre_equipo")
    private String nombre_equipo;

    @Column(name = "posicion")
    private String posicion;

    @Column(name = "n_camiseta")
    private Integer n_camiseta;

    @Column(name = "telefono")
    private Integer telefono;
    @Column(name = "correo")
    private String correo;

    @Column(name = "foto")
    private String foto;

    public Jugador() {
    }

    public Jugador(Integer id, Integer id_equipo, String nombre, Integer edad, String categoria, String nombre_equipo,
            String posicion, Integer n_camiseta, Integer telefono, String correo, String foto) {
        this.id = id;
        this.id_equipo = id_equipo;
        this.nombre = nombre;
        this.edad = edad;
        this.categoria = categoria;
        this.nombre_equipo = nombre_equipo;
        this.posicion = posicion;
        this.n_camiseta = n_camiseta;
        this.telefono = telefono;
        this.correo = correo;
        this.foto = foto;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId_equipo() {
        return id_equipo;
    }

    public void setId_equipo(Integer id_equipo) {
        this.id_equipo = id_equipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }


    public String getNombre_equipo() {
        return nombre_equipo;
    }

    public void setNombre_equipo(String nombre_equipo) {
        this.nombre_equipo = nombre_equipo;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public Integer getN_camiseta() {
        return n_camiseta;
    }

    public void setN_camiseta(Integer n_camiseta) {
        this.n_camiseta = n_camiseta;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    @Override
    public String toString() {
        return "Jugador [id=" + id + ", id_equipo=" + id_equipo + ", nombre=" + nombre + ", edad=" + edad
                + ", categoria=" + categoria + ", nombre_equipo=" + nombre_equipo + ", posicion=" + posicion
                + ", n_camiseta=" + n_camiseta + ", telefono=" + telefono + ", correo=" + correo + ", foto=" + foto
                + "]";
    }

    
}