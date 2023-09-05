package com.zyw.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zyw.model.system.SysUser;
import com.zyw.model.system.SysWrite;
import com.zyw.model.vo.RouterVo;
import com.zyw.model.vo.SysUserQueryVo;
import com.zyw.model.vo.SysWriteQueryVo;
import com.zyw.system.mapper.SysUserMapper;
import com.zyw.system.mapper.SysWriteMapper;
import com.zyw.system.service.SysMenuService;
import com.zyw.system.service.SysUserService;
import com.zyw.system.service.SysWriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author zyw
 * @since 2022-09-28
 */
@Service
public class SysWriteServiceImpl extends ServiceImpl<SysWriteMapper, SysWrite> implements SysWriteService {

    @Autowired
    private SysMenuService sysMenuService;

    //文章列表
    @Override
    public IPage<SysWrite> selectPage(Page<SysWrite> pageParam, SysWriteQueryVo sysWriteQueryVo) {
        return baseMapper.selectPage(pageParam,sysWriteQueryVo);
    }

    //更改文章状态
    @Override
    public void updateStatus(String id, Integer status) {
        //根据用户id查询
        SysWrite sysWrite = baseMapper.selectById(id);
        //设置修改状态
        sysWrite.setStatus(status);
        //调用方法修改
        baseMapper.updateById(sysWrite);
    }

}
