package ${basePackage}.web;

import ${basePackage}.core.Result;
import ${basePackage}.core.ResultGenerator;
import ${basePackage}.model.${modelNameUpperCamel};
import ${basePackage}.service.${modelNameUpperCamel}Service;
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
* Created by ${author} on ${date}.
*/
@Api(tags = "${modelNameUpperCamel} API")
@RestController
@RequestMapping("${baseRequestMapping}")
public class ${modelNameUpperCamel}Controller {
    @Resource
    private ${modelNameUpperCamel}Service ${modelNameLowerCamel}Service;

    @ApiOperation(value = "Create new ${modelNameUpperCamel}", notes = "Create new ${modelNameUpperCamel} by ${modelNameLowerCamel} object")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "${modelNameUpperCamel}", name = "${modelNameLowerCamel}", value = "${modelNameLowerCamel} object", required = true)
    })
    @PostMapping
    public Result add(@RequestBody ${modelNameUpperCamel} ${modelNameLowerCamel}) {
        ${modelNameLowerCamel}Service.save(${modelNameLowerCamel});
        return ResultGenerator.genSuccessResult();
    }

    @ApiOperation(value = "Delete ${modelNameUpperCamel} by id", notes = "Delete ${modelNameUpperCamel} by id")
    @ApiImplicitParam(name = "id", value = "${modelNameUpperCamel}'s id", dataType = "Integer", paramType = "path")
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        ${modelNameLowerCamel}Service.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @ApiOperation(value = "Modify ${modelNameUpperCamel}", notes = "Modify ${modelNameUpperCamel}")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "${modelNameUpperCamel}", name = "${modelNameLowerCamel}", value = "${modelNameLowerCamel} object", required = true)
    })
    @PutMapping
    public Result update(@RequestBody ${modelNameUpperCamel} ${modelNameLowerCamel}) {
        ${modelNameLowerCamel}Service.update(${modelNameLowerCamel});
        return ResultGenerator.genSuccessResult();
    }

    @ApiOperation(value = "Get ${modelNameUpperCamel} detail by id", notes = "Get ${modelNameUpperCamel} detail by id")
    @ApiImplicitParam(name = "id", value = "${modelNameUpperCamel}'s id", dataType = "Integer", paramType="path")
    @GetMapping("/{id}")
    public Result detail(@PathVariable Integer id) {
        ${modelNameUpperCamel} ${modelNameLowerCamel} = ${modelNameLowerCamel}Service.findById(id);
        return ResultGenerator.genSuccessResult(${modelNameLowerCamel});
    }

    @ApiOperation(value = "Get ${modelNameUpperCamel} list", notes = "Get ${modelNameUpperCamel} list")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "java.lang.Integer", name = "page", value = "page no", required = true, paramType = "path"),
            @ApiImplicitParam(dataType = "java.lang.Integer", name = "size", value = "page size", required = true, paramType = "path")
    })
    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<${modelNameUpperCamel}> list = ${modelNameLowerCamel}Service.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
