package com.mpt.journal.service;

import com.mpt.journal.model.SubModel;
import com.mpt.journal.repository.InMemorySubRepository;
import org.springframework.stereotype.Service;
import com.mpt.journal.entity.SubEntity;
import java.util.List;

@Service
public class InMemorySubServiceImpl implements SubService {
    private final InMemorySubRepository subRepository;

    public InMemorySubServiceImpl(InMemorySubRepository subRepository) {
        this.subRepository = subRepository;
    }

    @Override
    public List<SubModel> findAllSub() {
        return subRepository.findAllSubs();
    }

    @Override
    public SubModel findSubById(int id) {
        return subRepository.findSubById(id);
    }

    @Override
    public SubModel addSub(SubModel sub) {
        return subRepository.addSub(sub);
    }

    @Override
    public SubModel updateSub(SubModel sub) {
        return subRepository.updateSub(sub);
    }

    @Override
    public void deleteSub(int id) {
        subRepository.deleteSub(id);
    }
}
