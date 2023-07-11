package book.vo;

public class BookVO {
private int idx;
private String title;
private String content;
private int price;

public BookVO() {
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
