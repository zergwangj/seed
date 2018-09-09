package com.company.project.seed.service.impl;

import com.company.project.seed.dao.StaffMapper;
import com.company.project.seed.model.Staff;
import com.company.project.seed.service.StaffService;
import com.company.project.seed.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * Created by CodeGenerator on 2018/09/08.
 */
@Service
@Transactional
public class StaffServiceImpl extends AbstractService<Staff> implements StaffService {
    @Resource
    private StaffMapper staffMapper;

}
