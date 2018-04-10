package com.modal;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@MappedSuperclass
public class ModalUtil {

    private Long id;
    private Date createdDate;
    private Date updatedDate;
    private String uuid;
    private boolean is_enabled =true;

    @Type(type = "yes_no")
    @Column(name = "is_enabled", nullable = false, columnDefinition = "char(1) default 'Y'")
    public boolean isIs_enabled() {
        return is_enabled;
    }

    public void setIs_enabled(boolean is_enabled) {
        this.is_enabled = is_enabled;
    }

    @Id

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false,nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }


    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    @Column(name = "uuid", unique = true, updatable = false)
    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @PrePersist
    protected void onPrePersist() {
        setUuid(UUID.randomUUID().toString());
    }


}
