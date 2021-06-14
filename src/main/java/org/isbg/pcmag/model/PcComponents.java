package org.isbg.pcmag.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class PcComponents implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false,
            updatable = false)
    private Long id;
    private Long pcId;
    @OneToOne
    private Part part;
    @OneToOne
    private Peripheral peripheral;

    public PcComponents() {
    }

    public PcComponents(Long id, Long pcId, Part part) {
        this.id = id;
        this.pcId = pcId;
        this.part = part;

    }
    public PcComponents(Long id, Long pcId, Peripheral peripheral) {
        this.id = id;
        this.pcId = pcId;

        this.peripheral = peripheral;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPcId() {
        return pcId;
    }

    public void setPcId(Long pcId) {
        this.pcId = pcId;
    }

    public Part getPart() {
        return part;
    }

    public void setPart(Part part) {
        this.part = part;
    }

    public Peripheral getPeripheral() {
        return peripheral;
    }

    public void setPeripheral(Peripheral peripheral) {
        this.peripheral = peripheral;
    }
}
