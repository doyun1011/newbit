package d20230413;

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
		return bno + " | " + title + " | " + writer + " | " + regDate + " | " + modifyDate;
	}
}
