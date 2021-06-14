package org.isbg.pcmag.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Part implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(nullable = false,
            updatable = false)
    private Long id;
    @Column(nullable = false,
            columnDefinition = "TEXT")
    private String name;
    @OneToOne
    private PartType partType;
    @OneToMany(cascade = CascadeType.ALL, mappedBy="partId")
    private List<PartCount> partCounts;
    @CreationTimestamp
    @Column(nullable = false,
            updatable = false)
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;
    public Part() {
    }

    public Part(String name, PartType partType, List<PartCount> partCounts) {
        this.name = name;
        this.partType = partType;
        this.partCounts = partCounts;
    }

    public Part(Long id, String name, PartType partType, List<PartCount> partCounts) {
        this.id = id;
        this.name = name;
        this.partType = partType;
        this.partCounts = partCounts;
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

    public List<PartCount> getPartCounts() {
        return partCounts;

    }

    public void setPartCounts(List<PartCount> partCounts) {
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

    @Override
    public String toString() {
        return "Part{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", partType=" + partType +
                ", partCounts=" + partCounts +
                '}';   }
}
