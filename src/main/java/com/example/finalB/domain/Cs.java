package com.example.finalB.domain;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "Cs")
@SequenceGenerator(
		name = "CS_SEQ_GENERATOR", 
		sequenceName = "CS_SEQ", 
		initialValue = 1, allocationSize = 1)
@AllArgsConstructor
public class Cs {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE ,generator = "CS_SEQ_GENERATOR")
	private Integer no; // 게시글 번호

	@Column(nullable = false, length = 100)
	private String title; // 게시글 제목

	@Lob
	@Column(nullable = false)
	private String content; // 내용

	@CreationTimestamp
	private Timestamp createDate; // 작성일자

	private int cnt; // 조회수

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "memberid")
	private Member member;

	@OneToMany(mappedBy = "cs", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
	@OrderBy("no desc")
	private List<Reply> replyList;
}