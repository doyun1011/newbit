package board;

import lombok.Data;

@Data
public class BoardVO {
	private int bno;
	private String title;
	private String content;
	private String regDate;
	private String modifyDate;
	private String writer;
}
 