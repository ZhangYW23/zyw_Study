package com.zyw.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zyw.model.system.SysWrite;
import com.zyw.model.vo.SysWriteQueryVo;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 文章表 Mapper 接口
 * </p>
 *
 * @author zyw
 * @since 2023-09-28
 */
public interface SysWriteMapper extends BaseMapper<SysWrite> {

    IPage<SysWrite> selectPage(Page<SysWrite> pageParam, @Param("vo") SysWriteQueryVo sysUserQueryVo);
}
