package com.zyw.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zyw.model.system.SysWrite;
import com.zyw.model.vo.SysWriteQueryVo;


/**
 * <p>
 * 文章表 服务类
 * </p>
 *
 * @author zyw
 * @since 2022-09-28
 */
public interface SysWriteService extends IService<SysWrite> {

    //文章列表
    IPage<SysWrite> selectPage(Page<SysWrite> pageParam, SysWriteQueryVo sysWriteQueryVo);

    //更改文章状态
    void updateStatus(String id, Integer status);


}
