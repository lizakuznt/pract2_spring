package com.mpt.journal.service;

import com.mpt.journal.model.SubModel;
import com.mpt.journal.entity.SubEntity;
import java.util.List;

public interface SubService {
    public List<SubModel> findAllSub();
    public SubModel findSubById(int id);
    public SubModel addSub(SubModel sub);
    public SubModel updateSub(SubModel sub);
    public void deleteSub(int id);
}