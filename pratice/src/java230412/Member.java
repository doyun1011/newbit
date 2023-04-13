package java230412;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Member {

	private int mno;
	private String name;
	private String phone;
	private String id;
	private String pw;
	
	@Override
	public String toString() {
		return mno + " | " + name + " | " + phone + " | " + id; 	
	}
}
