package org.isbg.pcmag.model;

import java.time.LocalDateTime;

public class PeripheralSingleCount {
    private Long id;
    private String name;

    private PeripheralType peripheralType;

    private PeripheralCount peripheralCounts;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public PeripheralSingleCount() {
    }

    public PeripheralSingleCount(Long id, String name, PeripheralType peripheralType, PeripheralCount peripheralCounts, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.name = name;
        this.peripheralType = peripheralType;
        this.peripheralCounts = peripheralCounts;
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

    public PeripheralCount getPeripheralCounts() {
        return peripheralCounts;
    }

    public void setPeripheralCounts(PeripheralCount peripheralCounts) {
        this.peripheralCounts = peripheralCounts;
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
}
