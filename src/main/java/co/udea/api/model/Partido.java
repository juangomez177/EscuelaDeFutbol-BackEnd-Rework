package co.udea.api.model;

import javax.persistence.*;

@Entity
@Table(name = "partido")
public class Partido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "id_equipo")
    private Integer id_equipo;

    @Column(name = "estado")
    private String estado;

    @Column(name = "goles_favor")
    private Integer goles_favor;

    @Column(name = "goles_contra")
    private Integer goles_contra;

    @Column(name = "faltas_cometidas")
    private Integer faltas_cometidas;

    @Column(name = "faltas_recibidas")
    private Integer faltas_recibidas;

    @Column(name = "fecha")
    private String fecha;

    @Column(name = "lugar")
    private String lugar;

    @Column(name = "equipo_rival")
    private String equipo_rival;


    public Partido() {
    }

    public Partido(Integer id, Integer id_equipo, String estado, Integer goles_favor, Integer goles_contra, Integer faltas_cometidas, Integer faltas_recibidas, String fecha, String lugar, String equipo_rival) {
        this.id = id;
        this.id_equipo = id_equipo;
        this.estado = estado;
        this.goles_favor = goles_favor;
        this.goles_contra = goles_contra;
        this.faltas_cometidas = faltas_cometidas;
        this.faltas_recibidas = faltas_recibidas;
        this.fecha = fecha;
        this.lugar = lugar;
        this.equipo_rival = equipo_rival;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Integer getGoles_favor() {
        return goles_favor;
    }

    public void setGoles_favor(Integer goles_favor) {
        this.goles_favor = goles_favor;
    }

    public Integer getGoles_contra() {
        return goles_contra;
    }

    public void setGoles_contra(Integer goles_contra) {
        this.goles_contra = goles_contra;
    }

    public Integer getFaltas_cometidas() {
        return faltas_cometidas;
    }

    public void setFaltas_cometidas(Integer faltas_cometidas) {
        this.faltas_cometidas = faltas_cometidas;
    }

    public Integer getFaltas_recibidas() {
        return faltas_recibidas;
    }

    public void setFaltas_recibidas(Integer faltas_recibidas) {
        this.faltas_recibidas = faltas_recibidas;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getEquipo_rival() {
        return equipo_rival;
    }

    public void setEquipo_rival(String equipo_rival) {
        this.equipo_rival = equipo_rival;
    }

    @Override
    public String toString() {
        return "Partido{" +
                "id=" + id +
                ", id_equipo=" + id_equipo +
                ", estado='" + estado + '\'' +
                ", goles_favor=" + goles_favor +
                ", goles_contra=" + goles_contra +
                ", faltas_cometidas=" + faltas_cometidas +
                ", faltas_recibidas=" + faltas_recibidas +
                ", fecha='" + fecha + '\'' +
                ", lugar='" + lugar + '\'' +
                ", equipo_rival='" + equipo_rival + '\'' +
                '}';
    }
}
