package com.company.project.seed.web;

import com.company.project.seed.core.Result;
import com.company.project.seed.core.ResultGenerator;
import com.company.project.seed.model.Staff;
import com.company.project.seed.service.StaffService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by CodeGenerator on 2018/09/08.
*/
@Api(tags = "Staff API")
@RestController
@RequestMapping("/staff")
public class StaffController {
    @Resource
    private StaffService staffService;

    @ApiOperation(value = "Create new Staff", notes = "Create new Staff by staff object")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "Staff", name = "staff", value = "staff object", required = true)
    })
    @PostMapping
    public Result add(@RequestBody Staff staff) {
        staffService.save(staff);
        return ResultGenerator.genSuccessResult();
    }

    @ApiOperation(value = "Delete Staff by id", notes = "Delete Staff by id")
    @ApiImplicitParam(name = "id", value = "Staff's id", dataType = "Integer", paramType = "path")
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        staffService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @ApiOperation(value = "Modify Staff", notes = "Modify Staff")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "Staff", name = "staff", value = "staff object", required = true)
    })
    @PutMapping
    public Result update(@RequestBody Staff staff) {
        staffService.update(staff);
        return ResultGenerator.genSuccessResult();
    }

    @ApiOperation(value = "Get Staff detail by id", notes = "Get Staff detail by id")
    @ApiImplicitParam(name = "id", value = "Staff's id", dataType = "Integer", paramType="path")
    @GetMapping("/{id}")
    public Result detail(@PathVariable Integer id) {
        Staff staff = staffService.findById(id);
        return ResultGenerator.genSuccessResult(staff);
    }

    @ApiOperation(value = "Get Staff list", notes = "Get Staff list")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "java.lang.Integer", name = "page", value = "page no", required = true, paramType = "path"),
            @ApiImplicitParam(dataType = "java.lang.Integer", name = "size", value = "page size", required = true, paramType = "path")
    })
    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<Staff> list = staffService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
