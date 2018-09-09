package com.company.project.seed.service.impl;

import com.company.project.seed.dao.StoreMapper;
import com.company.project.seed.model.Store;
import com.company.project.seed.service.StoreService;
import com.company.project.seed.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2018/09/08.
 */
@Service
@Transactional
public class StoreServiceImpl extends AbstractService<Store> implements StoreService {
    @Resource
    private StoreMapper storeMapper;

}
