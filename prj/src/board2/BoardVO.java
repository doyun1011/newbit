package board2;

import lombok.Data;

@Data
public class BoardVO {
	private int bno;
	private String title;
	private String content;
	private String writer;
	private String regDate;
	private String modifyDate;
	@Override
	public String toString() {
		return "[번호: " + bno + "\t|제목: " + title + "\t|작성자: " + writer + "\t|등록날짜: " + regDate
				+ "\t|수정날짜: " + modifyDate + "]";
	}
	
}
