package org.isbg.pcmag.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Entity
public class Pc implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false,
            updatable = false)
    private Long id;
    @Column(nullable = false,
            columnDefinition = "TEXT")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy="pcId")
    private List<PcComponents> pcComponents;
    @CreationTimestamp
    @Column(nullable = false,
            updatable = false)
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;
    @Transient
    private BigDecimal price;
    @Transient
    private Long componentCount;

    public Pc() {
    }

    public Pc(Long id, String name, List<PcComponents> pcComponents) {
        this.id = id;
        this.name = name;
        this.pcComponents = pcComponents;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<PcComponents> getPcComponents() {
        return pcComponents;
    }

    public void setPcComponents(List<PcComponents> pcComponents) {
        this.pcComponents = pcComponents;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {

        this.price = price;
    }

    public Long getComponentCount() {
        return componentCount;
    }

    public void setComponentCount(Long componentCount) {
        this.componentCount = componentCount;
    }
}
