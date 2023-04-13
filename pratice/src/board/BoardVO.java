package board;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
public class BoardVO {

	int bno;
	private String title;
	private String content;
	private String regDate;
	private String modifyDate;
	private String writer;
	
	BoardVO(){
		bno++;
	}
	
	//조회는 내용 제외 
}
