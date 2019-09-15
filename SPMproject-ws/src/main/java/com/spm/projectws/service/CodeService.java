package com.spm.projectws.service;

import com.spm.projectws.model.CodeFind;
import com.spm.projectws.model.CodeLine;
import com.spm.projectws.repository.CodeLineRepository;
import com.spm.projectws.repository.CodeRepository;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.regex.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author IT17119122   |   Liyange I.M
 */
@Service
public class CodeService {
    
    @Autowired
    CodeLineRepository codeLineRepository;
    
    @Autowired
    CodeRepository codeRepository;
    
    @PersistenceContext 
    EntityManager em; 
    
    public String SaveSourceCode(String sourceCode, String codeName){
        
        //Split the code line by line
        Pattern ptn = Pattern.compile("\\r?\\n");
        String[] arrOfStr = ptn.split(sourceCode);
//         System.out.println(Pattern.matches("[public|protected|private|static|]", sourceCode));
        //get uniq id
        String uniqueKey = UUID.randomUUID().toString();    
  
        Integer lineNumber = 1;
        for (String statement : arrOfStr) {
            if(!statement.equals("") && !statement.equals(" ")){
                CodeLine codeLine = new CodeLine();
                        
                codeLine.setpStatement(statement);
                codeLine.setCodeNumber(uniqueKey);
                codeLine.setLineNumber(lineNumber);
                codeLine.setCi(0);
                codeLine.setCnc(0);
                codeLine.setCps(0);
                codeLine.setCr(0);
                codeLine.setCs(0);
                codeLine.setCtc(0);
                codeLine.setTw(0);

                System.out.println(statement); 
                codeLineRepository.save(codeLine);
                lineNumber++;
            }

        }
        CodeFind codeFind = new CodeFind();
        codeFind.setCodeKeyName(codeName);
        codeFind.setCodeNumber(uniqueKey);
        codeRepository.save(codeFind);
        
        return uniqueKey;
    }
    
    public Integer CalculateCI(String CodeKeyName){
        
        //find code KeyNumber
        CodeFind codeFind = codeRepository.findCodeKey(CodeKeyName);
        
        //using CodeKeyNumber get data from CodeLine
        LinkedList<CodeLine> allCode = codeLineRepository.getAllSourceCode(codeFind.getCodeNumber());
        
        StringBuilder sb1 = new StringBuilder();

        //get objects of CodeLine
        for (CodeLine cl : allCode) {
            //CodeLine append to gether
            sb1.append(cl.getpStatement());
        }
        //assing sourceCodes in to string variable
        String sourceCode = sb1.toString();
        
        //get number of matching keywords usding algorithm
        CalculateService CalculateService = new CalculateService();
        int extendsNo = CalculateService.search(sourceCode," extends ");
        
        int implementsNo = 0;
        
        //get objects of CodeLine
        for (CodeLine cl : allCode) {
            //CodeLine append to gether
            sb1.append(cl.getpStatement());
            
            int implementsNoLine = CalculateService.search(cl.getpStatement()," implements ");
            implementsNo = implementsNo + implementsNoLine;
            
            if(implementsNoLine >= 1){
                int commaNo = CalculateService.search(cl.getpStatement(),",");
                implementsNo = implementsNo + commaNo;
            }
        }
        
        int ciValue = 0;
        
        if(extendsNo == 0 && implementsNo == 0){
             //save CCI in all the code lines
            for (CodeLine codeLine : allCode) {
                ciValue = 1;
                codeLine.setCi(ciValue);
                codeLineRepository.save(codeLine);
            }
        }else{
            //save CCI in all the code lines
            for (CodeLine codeLine : allCode) {
                ciValue = extendsNo + implementsNo;
                codeLine.setCi(ciValue);
                codeLineRepository.save(codeLine);
            }
        }
        return ciValue;
    }
    
    public List<CodeLine> getAllSourceCodeByCodeNumber(String codeNumber) {
        
        CriteriaBuilder cb = em.getCriteriaBuilder(); 
        CriteriaQuery<CodeLine> cq = cb.createQuery(CodeLine.class); 
 
        Root<CodeLine> codeLine = cq.from(CodeLine.class); 
        Predicate idPredicate = cb.equal(codeLine.get("codeNumber"), codeNumber); 
        cq.where(idPredicate); 
        
        TypedQuery<CodeLine> query = em.createQuery(cq); 
         
        //get Object list exeuting query 
        List<CodeLine> codeLineList = query.getResultList(); 

        return codeLineList;
    }
}
