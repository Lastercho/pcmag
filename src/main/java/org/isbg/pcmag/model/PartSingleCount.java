package org.isbg.pcmag.model;

import java.time.LocalDateTime;

public class PartSingleCount {
    private Long id;
    private String name;

    private PartType partType;

    private PartCount partCounts;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public PartSingleCount() {
    }

    public PartSingleCount(Long id, String name, PartType partType, PartCount partCounts, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.name = name;
        this.partType = partType;
        this.partCounts = partCounts;
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

    public PartType getPartType() {
        return partType;
    }

    public void setPartType(PartType partType) {
        this.partType = partType;
    }

    public PartCount getPartCounts() {
        return partCounts;
    }

    public void setPartCounts(PartCount partCounts) {
        this.partCounts = partCounts;
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
