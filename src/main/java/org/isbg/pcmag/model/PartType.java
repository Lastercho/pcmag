package org.isbg.pcmag.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class PartType implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false,
            updatable = false)
    private long id;
    @Column(nullable = false,
            columnDefinition = "TEXT")
    private String type;
    @Column(nullable = false,
            columnDefinition = "TEXT")
    private String fullTypeName;
    public PartType() {
        super();

    }
    public PartType(long id,
                    String type,
                    String fullTypeName) {
        super();
        this.id = id;
        this.type = type;
        this.fullTypeName = fullTypeName;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getFullTypeName() {
        return fullTypeName;
    }
    public void setFullTypeName(String fullTypeName) {
        this.fullTypeName = fullTypeName;
    }
    @Override
    public String toString() {
        return "PartType [id="
                + id
                + ", type="
                + type
                + ", fullTypeName="
                + fullTypeName
                + "]";
    }


}
