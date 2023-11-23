package Chetoos.demo.Model;

import java.sql.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Factura {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer idFactura;
    private Date fechaFactura;
    private Integer idTipoFac;
    private Integer clienteFactura;
    private Integer totalFactura = 0;
    private Integer descuentoFactura = 0;
    private Integer ivaFactura = 0;
    private Integer subtotalFactura = 0;
    private Integer saldoFactura = 0;
    private String estadoFactura;
}
