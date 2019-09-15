package com.spm.projectws.controller;

import com.spm.projectws.model.CodeLine;
import com.spm.projectws.model.CodeListDto;
import com.spm.projectws.model.FileDetails;
import com.spm.projectws.service.CalculateCncAndCtcService;
import com.spm.projectws.service.CalculateTwAndCps;
import com.spm.projectws.service.CodeService;
import com.spm.projectws.service.RecursionService;
import com.spm.projectws.service.SizeService;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author IT17119122   |   Liyange I.M
 */
@RestController
@CrossOrigin
public class MainController {
    
    @Autowired
    CodeService codeService;
    
    @Autowired
    RecursionService recursionService;
    
    @Autowired
    SizeService sizeService;
    
    @Autowired
    CalculateCncAndCtcService calculateCncAndCtcService;
    
    @Autowired
    CalculateTwAndCps calculateTwAndCps;

    
    @RequestMapping(value = "/sendfile", method = RequestMethod.POST)
    public ResponseEntity<String> getFile(@RequestParam("file") MultipartFile file ,@RequestParam("codename") String codeName){
        
        FileDetails fileDetails = new FileDetails();
        try {
            fileDetails.setFile(file.getBytes());
            String sourseCode = new String(fileDetails.getFile());
            //save code line by line in to the table
            String uniqueKey = codeService.SaveSourceCode(sourseCode , codeName);
            
            //Find Cnc value
            LinkedList<CodeLine> cncValueList = calculateCncAndCtcService.calculateCnc(codeName);
            //Find Ctc value        
            LinkedList<CodeLine> ctcValueList = calculateCncAndCtcService.calculateCtc(codeName);
            //Find CI value
            Integer ciValueList = codeService.CalculateCI(codeName);
            //Find size
            LinkedList<CodeLine> csValueList = sizeService.calculateCs(codeName);
            //calculate TW 
            LinkedList<CodeLine> twValueList = calculateTwAndCps.calculateTw(cncValueList,ctcValueList,ciValueList);
            //calculate CPS
            LinkedList<CodeLine> cpsValueList = calculateTwAndCps.calculateCps(csValueList,twValueList);
            //Find Recursion(Cr)
            int value = recursionService.findRecursion(codeName);
            
            if(value == 100){
                //Save recursion
                recursionService.saveCr(cpsValueList);
                System.out.println("==============  THERE HAVE A RECURSION IN THE CODE ============");
            }else if(value == -200){
                System.out.println("==============  THERE HAVE NO RECURSION IN THE CODE  ============");
            }
        
        return new ResponseEntity<>(uniqueKey, HttpStatus.OK);
        } catch (IOException ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        
    }
    
    
    @RequestMapping(value = "/codeline/{codeNumber}", method = RequestMethod.GET)
    public ResponseEntity<CodeListDto> getAllSourceCodeByCodeNumber(@PathVariable(value = "codeNumber") String codeNumber) {
        try{
            List<CodeLine> codeLineList = codeService.getAllSourceCodeByCodeNumber(codeNumber);
            int total = 0;
            LinkedList<CodeLine> ValueList = new LinkedList<CodeLine>();
            for(CodeLine obj :codeLineList){
                
                if(obj.getCr() != 0){
                    total = total + obj.getCr();
                }else{
                    total = total + obj.getCps();
                }
                obj.setCp(total);
                ValueList.add(obj);
            }
            
            CodeListDto codeListDto = new CodeListDto();
            codeListDto.setCodeLineList(codeLineList);
            codeListDto.setCpValue(total);
            
            return new ResponseEntity<>(codeListDto, HttpStatus.OK);
        } catch (Exception ex) {
            Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}
