package co.udea.api.model;

import javax.persistence.*;

@Entity
@Table(name = "info")
public class AsoFutbol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "correo")
    private String correo;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "sponsor1")
    private String sponsor1;

    @Column(name = "sponsor2")
    private String sponsor2;

    @Column(name = "sponsor3")
    private String sponsor3;

    @Column(name = "facebook")
    private String facebook;

    @Column(name = "x")
    private String x;

    @Column(name = "instagram")
    private String instagram;


    public AsoFutbol() {
     
    }

    public AsoFutbol(Integer id, String nombre, String telefono, String correo, String direccion, String sponsor1,
            String sponsor2, String sponsor3, String facebook, String x, String instagram) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
        this.direccion = direccion;
        this.sponsor1 = sponsor1;
        this.sponsor2 = sponsor2;
        this.sponsor3 = sponsor3;
        this.facebook = facebook;
        this.x = x;
        this.instagram = instagram;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    
    public String getSponsor1() {
        return sponsor1;
    }

    public void setSponsor1(String sponsor1) {
        this.sponsor1 = sponsor1;
    }

    public String getSponsor2() {
        return sponsor2;
    }

    public void setSponsor2(String sponsor2) {
        this.sponsor2 = sponsor2;
    }

    public String getSponsor3() {
        return sponsor3;
    }

    public void setSponsor3(String sponsor3) {
        this.sponsor3 = sponsor3;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    @Override
    public String toString() {
        return "AsoFutbol [id=" + id + ", nombre=" + nombre + ", telefono=" + telefono + ", correo=" + correo
                + ", direccion=" + direccion + ", sponsor1=" + sponsor1 + ", sponsor2=" + sponsor2 + ", sponsor3="
                + sponsor3 + ", facebook=" + facebook + ", x=" + x + ", instagram=" + instagram + "]";
    }

   


}
