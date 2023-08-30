package com.zyw.system.service;

import com.zyw.model.system.SysLoginLog;
import com.zyw.model.vo.SysLoginLogQueryVo;
import com.baomidou.mybatisplus.core.metadata.IPage;

public interface LoginLogService {

    //登录日志
    public void recordLoginLog(String username,Integer status,
                               String ipaddr,String message);

    //条件分页查询登录日志
    IPage<SysLoginLog> selectPage(long page, long limit, SysLoginLogQueryVo sysLoginLogQueryVo);
}
