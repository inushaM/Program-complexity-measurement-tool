package com.spm.projectws.service;

import com.spm.projectws.model.CodeFind;
import com.spm.projectws.model.CodeLine;
import com.spm.projectws.repository.CodeLineRepository;
import com.spm.projectws.repository.CodeRepository;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author IT17119122   |   Liyange I.M
 */
@Service
public class CalculateTwAndCps {
    
    @Autowired
    CodeLineRepository codeLineRepository;
    
    @Autowired
    CodeRepository codeRepository;
    
    @PersistenceContext 
    EntityManager em; 
    
    public LinkedList<CodeLine>  calculateTw(LinkedList<CodeLine> cncValueList,LinkedList<CodeLine> ctcValueList,Integer ciValueList){
        
        LinkedList<CodeLine> twValueList = new LinkedList<CodeLine>();
        try{
            int i = 0;

            for(CodeLine  codeLine  : cncValueList){
                int TW = 0;
                int ctc = ctcValueList.get(i).getCtc();
                int cnc = cncValueList.get(i).getCnc();
                int ci = ciValueList;
                    
                TW = ctc + cnc + ci;
                codeLine.setTw(TW);
                twValueList.add(codeLine);
                codeLineRepository.updateTw(TW, codeLine.getId());
                i++;
            }
        
            return twValueList;
         } catch(Exception ex){
            Logger.getLogger(CalculateTwAndCps.class.getName()).log(Level.SEVERE, null, ex);
        }     
        
        return twValueList;
        
        
        
  /*      
        
        //find code KeyNumber
        CodeFind codeFind = codeRepository.findCodeKey(CodeKeyName);
        
        //using CodeKeyNumber get data from CodeLine
//        LinkedList<CodeLine> codeList = codeLineRepository.getAllSourceCode(codeFind.getCodeNumber());
        List<CodeLine> codeList = codeLineRepository.getAllSourceCodebyList(codeFind.getCodeNumber());

        try{
            int TW = 0,ctc = 0,cnc = 0,ci = 0;
            //get objects of CodeLine
            for (CodeLine cl : codeList) {
//                Optional<CodeLine> codeLineObj = codeLineRepository.findById(135);
//                CodeLine obj = codeLineObj.get();
//                 List<CodeLine> obj2 = codeLineRepository.getARecord(cl.getId() , cl.getCodeNumber());
                 
            CriteriaBuilder cb = em.getCriteriaBuilder(); 
        CriteriaQuery<CodeLine> cq = cb.createQuery(CodeLine.class); 
 
        Root<CodeLine> regulation = cq.from(CodeLine.class); 
        Integer num = cl.getId();
        Predicate idPredicate = cb.equal(regulation.get("id"), 1637); 
//        Predicate codeNumberDatePredicate = cb.equal(regulation.get("codeNumber"), cl.getCodeNumber()); 
    
//        Predicate titlePredicate = cb.like(regulation.get("contentEnglish"), "%" + title + "%"); 
 
        cq.where(idPredicate); 
        TypedQuery<CodeLine> query = em.createQuery(cq); 
         
        //get Object list exeuting query 
        List<CodeLine> obj2 = query.getResultList(); 
                
                 CodeLine obj3 = obj2.get(0);
                 
                ctc = obj3.getCtc();
                cnc = obj3.getCnc();
                ci = obj3.getCi();
                
                TW = ctc + cnc + ci;
                codeLineRepository.updateTw(TW, obj3.getId());
                TW = 0;
                ctc=0;
                cnc=0;
                ci=0;
            }
        } catch(Exception ex){
            Logger.getLogger(SizeService.class.getName()).log(Level.SEVERE, null, ex);
        }

    */

    }
    
//        public List<Object> getRegulations(String date) throws ParseException { 
//        //String convert to Date 
//        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); 
//        Date selectedDate = formatter.parse(date); 
//         
//        CriteriaBuilder cb = em.getCriteriaBuilder(); 
//        CriteriaQuery<Regulation> cq = cb.createQuery(Regulation.class); 
// 
//        Root<Regulation> regulation = cq.from(Regulation.class); 
//        Predicate selectedDatePredicate = cb.equal(regulation.get("selectedDate"), selectedDate); 
//        Predicate statusEnglishDatePredicate = cb.equal(regulation.get("statusEnglish"), "APPROVE"); 
//        Predicate statusSinhalaDatePredicate = cb.equal(regulation.get("statusSinhala"), "APPROVE"); 
//        Predicate statusTamilDatePredicate = cb.equal(regulation.get("statusTamil"), "APPROVE"); 
////        Predicate titlePredicate = cb.like(regulation.get("contentEnglish"), "%" + title + "%"); 
// 
//        cq.where(selectedDatePredicate,statusEnglishDatePredicate,statusSinhalaDatePredicate,statusTamilDatePredicate); 
//        TypedQuery<Regulation> query = em.createQuery(cq); 
//         
//        //get Object list exeuting query 
//        List<Regulation> stringList = query.getResultList(); 
//        //Convert in to Object List 
//        List<Object> objectList = Arrays.asList(stringList.toArray()); 
//         
//        return objectList; 
//    } 
    
    public LinkedList<CodeLine>  calculateCps(LinkedList<CodeLine> csValueList,LinkedList<CodeLine> twValueList){
        
        LinkedList<CodeLine> cpsValueList = new LinkedList<CodeLine>();
         try{
            int i = 0;
            for(CodeLine codeLine : csValueList){
                int cps = 0;
                int cs = csValueList.get(i).getCs();
                int tw = twValueList.get(i).getTw();
                cps = cs  * tw;
                
                codeLine.setCps(cps);
                cpsValueList.add(codeLine);
                
                codeLineRepository.updateCps(cps, codeLine.getId());
                i++;
            }
            
            return cpsValueList;
        
        } catch(Exception ex){
            Logger.getLogger(CalculateTwAndCps.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return cpsValueList;
    }
        
   /*     
        
        
        //find code KeyNumber
        CodeFind codeFind = codeRepository.findCodeKey(CodeKeyName);
        
        //using CodeKeyNumber get data from CodeLine
        LinkedList<CodeLine> allCode = codeLineRepository.getAllSourceCode(codeFind.getCodeNumber());
        
        try{
            int Cps = 0 ,cs = 0 ,tw = 0;
            //get objects of CodeLine
            for (CodeLine cl : allCode) {
                cs = cl.getCs();
                tw = cl.getTw();
                Cps = cs * tw;
                codeLineRepository.updateCps(Cps, cl.getId());
                Cps = 0;
                cs = 0;
                tw = 0;
            }
        } catch(Exception ex){
            Logger.getLogger(SizeService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    */
}
