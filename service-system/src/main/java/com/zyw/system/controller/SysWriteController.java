package com.zyw.system.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zyw.common.result.Result;
import com.zyw.common.utils.MD5;
import com.zyw.model.system.SysUser;
import com.zyw.model.system.SysWrite;
import com.zyw.model.vo.SysUserQueryVo;
import com.zyw.model.vo.SysWriteQueryVo;
import com.zyw.system.service.SysUserService;
import com.zyw.system.service.SysWriteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 文章表 前端控制器
 * </p>
 *
 * @author zyw
 * @since 2022-09-28
 */
@Api(tags = "文章管理接口")
@RestController
@RequestMapping("/admin/system/sysWrite")
public class SysWriteController {

    @Autowired
    private SysWriteService sysWriteService;

    @ApiOperation("更改文章状态")
    @GetMapping("updateStatus/{id}/{status}")
    public Result updateStatus(@PathVariable String id,
                               @PathVariable Integer status) {
        sysWriteService.updateStatus(id,status);
        return Result.ok();
    }

    @ApiOperation("文章列表")
    @GetMapping("/{page}/{limit}")
    public Result list(@PathVariable Long page,
                       @PathVariable Long limit,
                       SysWriteQueryVo sysWriteQueryVo) {
        //创建page对象
        Page<SysWrite> pageParam = new Page<>(page,limit);
        //调用service方法
        IPage<SysWrite> pageModel = sysWriteService.selectPage(pageParam,sysWriteQueryVo);
        return Result.ok(pageModel);
    }

    @ApiOperation("添加文章")
    @PostMapping("save")
    public Result save(@RequestBody SysWrite write) {
        boolean is_Success = sysWriteService.save(write);
        if(is_Success) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }
    @ApiOperation("修改文章")
    @PostMapping("update")
    public Result update(@RequestBody SysWrite write) {
        boolean is_Success = sysWriteService.updateById(write);
        if(is_Success) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }

    @ApiOperation("删除文章")
    @DeleteMapping("remove/{id}")
    public Result remove(@PathVariable String id) {
        boolean is_Success = sysWriteService.removeById(id);
        if(is_Success) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }

    @ApiOperation("根据id查询")
    @GetMapping("getWrite/{id}")
    public Result getWrite(@PathVariable String id) {
        SysWrite sysWrite = sysWriteService.getById(id);
        return Result.ok(sysWrite);
    }
}

