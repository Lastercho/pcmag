package org.isbg.pcmag.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Peripheral implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false,
            updatable = false)
        private Long id;
    @Column(nullable = false,
            columnDefinition = "TEXT")
    private String name;
    @OneToOne
    private PeripheralType peripheralType;
    @OneToMany(cascade = CascadeType.ALL, mappedBy="peripheralId")
    private List<PeripheralCount> peripheralCount;
    @CreationTimestamp
    @Column(nullable = false,
            updatable = false)
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    public Peripheral() {
    }

    public Peripheral(Long id, String name, PeripheralType peripheralType, List<PeripheralCount> peripheralCount, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.name = name;
        this.peripheralType = peripheralType;
        this.peripheralCount = peripheralCount;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
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

    public PeripheralType getPeripheralType() {
        return peripheralType;
    }

    public void setPeripheralType(PeripheralType peripheralType) {
        this.peripheralType = peripheralType;
    }

    public List<PeripheralCount> getPeripheralCount() {
        return peripheralCount;
    }

    public void setPeripheralCount(List<PeripheralCount> peripheralCount) {
        this.peripheralCount = peripheralCount;
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

    @Override
    public String toString() {
        return "Peripheral{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", peripheralType=" + peripheralType +
                ", peripheralCount=" + peripheralCount +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }


}
