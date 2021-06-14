package org.isbg.pcmag.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class PeripheralCount implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false,
            updatable = false)
    private Long id;
    private Long peripheralId;
    private Long count;
    private BigDecimal pricePerUnit;
    @Column(nullable = false,
            columnDefinition = "TEXT")
    private String supplier;
    @CreationTimestamp
    @Column(nullable = false,
            updatable = false)
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    public PeripheralCount() {
    }

    public PeripheralCount(Long id, Long peripheralId, Long count, BigDecimal pricePerUnit, String supplier, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.peripheralId = peripheralId;
        this.count = count;
        this.pricePerUnit = pricePerUnit;
        this.supplier = supplier;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPeripheralId() {
        return peripheralId;
    }

    public void setPeripheralId(Long peripheralId) {
        this.peripheralId = peripheralId;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public BigDecimal getPricePerUnit() {
        return pricePerUnit;
    }

    public void setPricePerUnit(BigDecimal pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
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
        return "PeripheralCount{" +
                "id=" + id +
                ", peripheralId=" + peripheralId +
                ", count=" + count +
                ", pricePerUnit=" + pricePerUnit +
                ", supplier='" + supplier + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
