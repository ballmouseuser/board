package com.javalec.ex.dto;

import java.io.Serializable;
import java.sql.Timestamp;

// vo(value object) dto (data transfer object)
// MyBatis에서 사용하려면 Serializable을 구현해야함
public class BDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	int bId; // 게시글번호
	String bName; // 작성자 이름
	String bTitle; // 게시글 제목
	String bContent; // 게시글 내용
	Timestamp bDate; // 게시글 날짜
	int bHit; // 조회수
	int bGroup; // 댓글 그룹
	int bStep; // 출력될순서
	int bIndent; // 들여쓰기 기준
	// 기본생성자
	public BDto() {
		// TODO Auto-generated constructor stub
	}
	// 일반생성자
	public BDto(int bId, String bName, String bTitle, String bContent, Timestamp bDate, int bHit, int bGroup, int bStep, int bIndent) {
		// TODO Auto-generated constructor stub
		this.bId = bId;
		this.bName = bName;
		this.bTitle = bTitle;
		this.bContent = bContent;
		this.bDate = bDate;
		this.bHit = bHit;
		this.bGroup = bGroup;
		this.bStep = bStep;
		this.bIndent = bIndent;
	}
	// MyBatis 사용시 getter, setter 네이밍이 문제가 될 수 있다.
	public int getBId() {
		return bId;
	}

	public void setBId(int bId) {
		this.bId = bId;
	}

	public String getBName() {
		return bName;
	}

	public void setBName(String bName) {
		this.bName = bName;
	}

	public String getBTitle() {
		return bTitle;
	}

	public void setBTitle(String bTitle) {
		this.bTitle = bTitle;
	}

	public String getBContent() {
		return bContent;
	}

	public void setBContent(String bContent) {
		this.bContent = bContent;
	}

	public Timestamp getBDate() {
		return bDate;
	}

	public void setBDate(Timestamp bDate) {
		this.bDate = bDate;
	}

	public int getBHit() {
		return bHit;
	}

	public void setBHit(int bHit) {
		this.bHit = bHit;
	}

	public int getBGroup() {
		return bGroup;
	}

	public void setBGroup(int bGroup) {
		this.bGroup = bGroup;
	}

	public int getBStep() {
		return bStep;
	}

	public void setBStep(int bStep) {
		this.bStep = bStep;
	}

	public int getBIndent() {
		return bIndent;
	}

	public void setBIndent(int bIndent) {
		this.bIndent = bIndent;
	}
	
}
