package org.iclass.vo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString

public class Community {
	
	private int idx;
	private String writer;
	private String title;
	private String content;
	private int readcount;
	private Date creaatedAt;
	private String ip;
	private int commentcount;
}
