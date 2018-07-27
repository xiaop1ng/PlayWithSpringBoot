package com.xiaoping.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "contract_template")
public class ContractTemplate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String templateName;

    private String version;

    private String templateType;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;

    private boolean enable;

    private String docSrc;

    private String pdfSrc;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getTemplateType() {
        return templateType;
    }

    public void setTemplateType(String templateType) {
        this.templateType = templateType;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public String getDocSrc() {
        return docSrc;
    }

    public void setDocSrc(String docSrc) {
        this.docSrc = docSrc;
    }

    public String getPdfSrc() {
        return pdfSrc;
    }

    public void setPdfSrc(String pdfSrc) {
        this.pdfSrc = pdfSrc;
    }
}
