package java0503;

import java.io.Serializable;

import lombok.Data;

@Data
public class StudentDTO implements Serializable {

	private String name;
	private String phone;
	private int score;
}
