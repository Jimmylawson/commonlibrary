package com.jimmyproject.utils.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * An example entity that demonstrates the use of BaseEntity.
 * This is a concrete entity that can be used as a template for other entities.
 */
@Entity
@Table(name = "example_entities")
@Getter
@Setter
public class ExampleEntity extends BaseEntity {
    
    private String name;
    
    private String description;
    
    private boolean active = true;
    
    // You can add more fields, relationships, and custom methods as needed
    
    @Override
    public String toString() {
        return "ExampleEntity{" +
                "id=" + getId() +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", active=" + active +
                ", createdAt=" + getCreatedAt() +
                ", updatedAt=" + getUpdatedAt() +
                '}';
    }
}
