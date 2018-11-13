package com.erp.demo.repository;

import com.erp.demo.domain.HiringInfo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface HiringInfoRepository extends CrudRepository<HiringInfo, Integer> {

    List<HiringInfo> getAllByTrainingDateAndDocumentsSubmittedAndJoiningDate(Date trainingDate, char documentsSubmitted, Date joiningDate);
    HiringInfo getByHiringId(int hiringId);

}