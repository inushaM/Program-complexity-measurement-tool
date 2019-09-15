package com.spm.projectws.service;

import java.util.Iterator;
import java.util.LinkedList;
import com.spm.projectws.model.CodeFind;
import java.util.regex.Pattern;
import com.spm.projectws.model.CodeLine;
import com.spm.projectws.repository.CodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.spm.projectws.repository.CodeLineRepository;
import org.springframework.stereotype.Service;

@Service
public class RecursionService
{
    @Autowired
    CodeLineRepository codeLineRepository;
    @Autowired
    CodeRepository codeRepository;
    
    public int findRecursion(final String CodeKeyName) {
        final CodeFind codeFind = this.codeRepository.findCodeKey(CodeKeyName);
        final LinkedList<CodeLine> allCode = (LinkedList<CodeLine>)this.codeLineRepository.getAllSourceCode(codeFind.getCodeNumber());
        for (final CodeLine cl : allCode) {
            String fulFunction = null;
            String functionName = null;
            final CalculateService CalculateService = new CalculateService();
            final int extendsNo = CalculateService.search(cl.getpStatement(), "){");
            if (extendsNo >= 1) {
                final String values = cl.getpStatement();
                final String[] split;
                final String[] array = split = values.split(" ");
                for (final String value : split) {
                    final int v1 = CalculateService.search(value, "(");
                    final int v2 = CalculateService.search(value, ")");
                    if (v1 == 1 && v2 == 1) {
                        fulFunction = value;
                        final String[] split2;
                        final String[] s = split2 = fulFunction.split(Pattern.quote("("));
                        for (int length2 = split2.length, j = 0; j < length2; ++j) {
                            final String f1 = functionName = split2[j];
                            for (final CodeLine c2 : allCode) {
                                final int availableNo = CalculateService.search(c2.getpStatement(), functionName);
                                if (availableNo == 1) {
                                    final int availableComma = CalculateService.search(c2.getpStatement(), ");");
                                    if (availableComma == 1) {
                                        return 100;
                                    }
                                    continue;
                                }
                            }
                        }
                    }
                }
            }
        }
        return -200;
    }
    
    public void saveCr(LinkedList<CodeLine> cpsValueList) {
//        final CodeFind codeFind = this.codeRepository.findCodeKey(CodeKeyName);
//        final LinkedList<CodeLine> allCode = (LinkedList<CodeLine>)this.codeLineRepository.getAllSourceCode(codeFind.getCodeNumber());
//        
        
        for (final CodeLine cl : cpsValueList) {
            
            this.codeLineRepository.updateCr(Integer.valueOf(cl.getCps() * 2), cl.getId());
        }
    }
}