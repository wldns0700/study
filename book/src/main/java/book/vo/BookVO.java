package book.vo;

import javax.persistence.Column;
import javax.persistence.Id;

import org.hibernate.annotations.Entity;
import org.springframework.stereotype.Component;

import anotationspringhainete.MemberEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor

@Data
@Entity
@javax.persistence.Table(name="member")
public class BookVO {
	@Id
	@Column(name="idx")
	private int idx;
	@Column(name="title")
	private String title;
	@Column(name="content")
	private String content;
	@Column(name="price")
	private int price;
    
	public BookVO(String title, String content, int price) {
        this.title = title;
        this.content = content;
        this.price = price;
    }
}
/*public BookVO() {
	// TODO Auto-generated constructor stub
}

public BookVO(int idx, String title, String content, int price) {
	this.idx = idx;
	this.title = title;
	this.content = content;
	this.price = price;
}

public BookVO(String title, String content, int price) {
	this.title = title;
	this.content = content;
	this.price = price;
}

public int getIdx() {
	return idx;
}

public void setIdx(int idx) {
	this.idx = idx;
}

public String getTitle() {
	return title;
}

public void setTitle(String title) {
	this.title = title;
}

public String getContent() {
	return content;
}

public void setContent(String content) {
	this.content = content;
}

public int getPrice() {
	return price;
}

public void setPrice(int price) {
	this.price = price;
}

@Override
public String toString() {
	return "BookVO [idx=" + idx + ", title=" + title + ", content=" + content + ", price=" + price + "]";
}



}
*/