package Chetoos.demo.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class pais {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private String NOMBRE_PAIS;
    private char ESTADO_PAIS;

    // Getter and Setter for 'id'
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    // Getter and Setter for 'NOMBRE_PAIS'
    public String getNOMBRE_PAIS() {
        return NOMBRE_PAIS;
    }

    public void setNOMBRE_PAIS(String NOMBRE_PAIS) {
        this.NOMBRE_PAIS = NOMBRE_PAIS;
    }

    // Getter and Setter for 'ESTADO_PAIS'
    public char getESTADO_PAIS() {
        return ESTADO_PAIS;
    }

    public void setESTADO_PAIS(char ESTADO_PAIS) {
        this.ESTADO_PAIS = ESTADO_PAIS;
    }
}
