//
//
package com.zyw.model.vo;


import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 文章查询实体
 * </p>
 */
@Data
public class SysWriteQueryVo implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String keyword;

	private String createTimeBegin;
	private String createTimeEnd;

	private String author;
	private String title;
	private String description;

}

