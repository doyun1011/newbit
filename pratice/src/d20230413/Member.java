package d20230413;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Member {
	private int mno;
	private String name;
	private String phone;
	private String id;
	private String pw;
	public Member(String name, String phone, String id, String pw) {
		this.name = name;
		this.phone = phone;
		this.id = id;
		this.pw = pw;
	}
	@Override
	public String toString() {
		return mno + " | " + name + " | " + phone + " | " + id;
	}
}
