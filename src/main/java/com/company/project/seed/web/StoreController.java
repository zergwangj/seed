package com.company.project.seed.web;

import com.company.project.seed.core.Result;
import com.company.project.seed.core.ResultGenerator;
import com.company.project.seed.model.Store;
import com.company.project.seed.service.StoreService;
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
@Api(tags = "Store API")
@RestController
@RequestMapping("/store")
public class StoreController {
    @Resource
    private StoreService storeService;

    @ApiOperation(value = "Create new Store", notes = "Create new Store by store object")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "Store", name = "store", value = "store object", required = true)
    })
    @PostMapping
    public Result add(@RequestBody Store store) {
        storeService.save(store);
        return ResultGenerator.genSuccessResult();
    }

    @ApiOperation(value = "Delete Store by id", notes = "Delete Store by id")
    @ApiImplicitParam(name = "id", value = "Store's id", dataType = "Integer", paramType = "path")
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        storeService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @ApiOperation(value = "Modify Store", notes = "Modify Store")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "Store", name = "store", value = "store object", required = true)
    })
    @PutMapping
    public Result update(@RequestBody Store store) {
        storeService.update(store);
        return ResultGenerator.genSuccessResult();
    }

    @ApiOperation(value = "Get Store detail by id", notes = "Get Store detail by id")
    @ApiImplicitParam(name = "id", value = "Store's id", dataType = "Integer", paramType="path")
    @GetMapping("/{id}")
    public Result detail(@PathVariable Integer id) {
        Store store = storeService.findById(id);
        return ResultGenerator.genSuccessResult(store);
    }

    @ApiOperation(value = "Get Store list", notes = "Get Store list")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "java.lang.Integer", name = "page", value = "page no", required = true, paramType = "path"),
            @ApiImplicitParam(dataType = "java.lang.Integer", name = "size", value = "page size", required = true, paramType = "path")
    })
    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<Store> list = storeService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
