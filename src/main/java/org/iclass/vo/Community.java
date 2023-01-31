package org.iclass.vo;

import java.security.Timestamp;

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
	//필드, 객체의 프로퍼티
	private long idx;
	private String writer;
	private String title;
	private String content;
	private int readcount;
	private Timestamp createdAt;
	private String ip;
	private int commentcount;
}
