/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spm.projectws.model;

import java.util.List;

/**
 *
 * @author inushaV
 */
public class CodeListDto {
    List<CodeLine> codeLineList;
    
    Integer cpValue;

    public List<CodeLine> getCodeLineList() {
        return codeLineList;
    }

    public void setCodeLineList(List<CodeLine> codeLineList) {
        this.codeLineList = codeLineList;
    }

    public Integer getCpValue() {
        return cpValue;
    }

    public void setCpValue(Integer cpValue) {
        this.cpValue = cpValue;
    }
    
    
}
