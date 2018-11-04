package com.erp.demo.service;

import com.erp.demo.domain.HiringInfo;
import com.erp.demo.repository.HiringInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class HiringService {

    @Autowired
    private HiringInfoRepository hiringInfoRepository;

    public List<HiringInfo> getJoineeDetails(Date trainingDate, char documentsSubmitted, Date joiningDate){
        return hiringInfoRepository.getAllByTrainingDateAndDocumentsSubmittedAndJoiningDate(trainingDate, documentsSubmitted, joiningDate);
    }

    public boolean updateHireeDetails(int hiringId, Date trainingDate, char documentsSubmitted){
        HiringInfo hiringInfo = hiringInfoRepository.getByHiringId(hiringId);
        if(hiringInfo == null){
            return false;
        } else {
            hiringInfo.setTrainingDate(trainingDate);
            hiringInfo.setDocumentsSubmitted(documentsSubmitted);
            hiringInfoRepository.save(hiringInfo);
            return true;
        }
    }
}
