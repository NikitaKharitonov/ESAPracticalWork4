package com.example.esapracticalwork4.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.Map;

@Entity
public class DbChange {

    public enum Type {INSERT, UPDATE, DELETE}

    @Id
    private Long id;
    private Type type;
    private Long entityId;
    private String entitySimpleName;
    private String oldEntityString;
    private String newEntityString;
    @Transient
    private Map<String, String> oldEntityMap;
    @Transient
    private Map<String, String> newEntityMap;

    public DbChange() {
    }

    public DbChange(Type type, BaseEntity oldEntity, BaseEntity newEntity) {
        this.type = type;
        this.entityId = oldEntity != null ? oldEntity.getId() : newEntity.getId();
        this.entitySimpleName = oldEntity != null ? oldEntity.getClass().getSimpleName() : newEntity.getClass().getSimpleName();
        this.oldEntityString = oldEntity != null ? oldEntity.toString() : null;
        this.newEntityString = newEntity != null ? newEntity.toString() : null;
        this.oldEntityMap = oldEntity != null ? oldEntity.toMap() : null;
        this.newEntityMap = newEntity != null ? newEntity.toMap() : null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Long getEntityId() {
        return entityId;
    }

    public void setEntityId(Long entityId) {
        this.entityId = entityId;
    }

    public String getEntitySimpleName() {
        return entitySimpleName;
    }

    public void setEntitySimpleName(String entitySimpleName) {
        this.entitySimpleName = entitySimpleName;
    }

    public String getOldEntityString() {
        return oldEntityString;
    }

    public void setOldEntityString(String oldEntityString) {
        this.oldEntityString = oldEntityString;
    }

    public String getNewEntityString() {
        return newEntityString;
    }

    public void setNewEntityString(String newEntityString) {
        this.newEntityString = newEntityString;
    }

    public Map<String, String> getOldEntityMap() {
        return oldEntityMap;
    }

    public void setOldEntityMap(Map<String, String> oldEntityMap) {
        this.oldEntityMap = oldEntityMap;
    }

    public Map<String, String> getNewEntityMap() {
        return newEntityMap;
    }

    public void setNewEntityMap(Map<String, String> newEntityMap) {
        this.newEntityMap = newEntityMap;
    }
}
