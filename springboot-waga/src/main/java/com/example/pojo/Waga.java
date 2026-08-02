package com.example.pojo;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Waga {
    private String wagaCode;
    private BigDecimal uswl;
    private BigDecimal dswl;
    private BigDecimal ttfl;
    private String note;
    private LocalDateTime updateDate;

    public String getWagaCode() {
        return wagaCode;
    }

    public void setWagaCode(String wagaCode) {
        this.wagaCode = wagaCode;
    }

    public BigDecimal getUswl() {
        return uswl;
    }

    public void setUswl(BigDecimal uswl) {
        this.uswl = uswl;
    }

    public BigDecimal getDswl() {
        return dswl;
    }

    public void setDswl(BigDecimal dswl) {
        this.dswl = dswl;
    }

    public BigDecimal getTtfl() {
        return ttfl;
    }

    public void setTtfl(BigDecimal ttfl) {
        this.ttfl = ttfl;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }

}
