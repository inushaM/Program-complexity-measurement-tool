package com.spm.projectws.service;

import java.util.Iterator;
import java.util.LinkedList;
import com.spm.projectws.model.CodeFind;
import com.spm.projectws.model.CodeLine;
import com.spm.projectws.repository.CodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.spm.projectws.repository.CodeLineRepository;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Service;

@Service
public class CalculateCncAndCtcService
{
    @Autowired
    CodeLineRepository codeLineRepository;
    @Autowired
    CodeRepository codeRepository;
    
    public LinkedList<CodeLine>  calculateCnc(final String CodeKeyName) {
        final CodeFind codeFind = this.codeRepository.findCodeKey(CodeKeyName);
        final LinkedList<CodeLine> allCode = (LinkedList<CodeLine>)this.codeLineRepository.getAllSourceCode(codeFind.getCodeNumber());
        LinkedList<CodeLine> cncValueList = new LinkedList<CodeLine>();
        try{
            for (final CodeLine cl : allCode) {
                final CalculateCncService calculateCncService = new CalculateCncService();
                Integer cncValue = calculateCncService.calculateCondionationalCS(cl.getpStatement());
   
                cl.setCnc(cncValue);
                cncValueList.add(cl);
                this.codeLineRepository.updateCnc(cncValue, cl.getId());
            }
            return cncValueList;
        } catch(Exception ex){
            Logger.getLogger(CalculateCncAndCtcService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cncValueList;
    }
    
    public LinkedList<CodeLine> calculateCtc(final String CodeKeyName) {
        final CodeFind codeFind = this.codeRepository.findCodeKey(CodeKeyName);
        final LinkedList<CodeLine> allCode = (LinkedList<CodeLine>)this.codeLineRepository.getAllSourceCode(codeFind.getCodeNumber());
        LinkedList<CodeLine> ctcValueList = new LinkedList<CodeLine>();
        try{
            for (final CodeLine cl : allCode) {
                final CalculateCtcService calculateCtcService = new CalculateCtcService();
                final int ctcValue = calculateCtcService.calculateCondionationalCS(cl.getpStatement()) + calculateCtcService.calculateIteratice(cl.getpStatement()) + calculateCtcService.calculateProgramStatements(cl.getpStatement());
            
                cl.setCtc(ctcValue);
                ctcValueList.add(cl);
                this.codeLineRepository.updateCtc(Integer.valueOf(ctcValue), cl.getId());
            }
            return ctcValueList;
        } catch(Exception ex){
            Logger.getLogger(CalculateCncAndCtcService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ctcValueList;
    }
}