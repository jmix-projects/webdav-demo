package com.company.webdavdemo.entity;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import io.jmix.webdav.entity.WebdavDocument;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@JmixEntity
@Table(name = "W_WD_WITH_ENABLED_VERSIONING", indexes = {
        @Index(name = "IDX_WDWITHENABLEDVERSIONING", columnList = "WEBDAV_DOCUMENT_ID")
})
@Entity(name = "w_WDWithEnabledVersioning")
public class WDWithEnabledVersioning {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @InstanceName
    @Column(name = "NUMBER_", nullable = false)
    @NotNull
    private String number;

    @JoinColumn(name = "WEBDAV_DOCUMENT_ID", nullable = false)
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private WebdavDocument webdavDocument;

    public WebdavDocument getWebdavDocument() {
        return webdavDocument;
    }

    public void setWebdavDocument(WebdavDocument webdavDocument) {
        this.webdavDocument = webdavDocument;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}