package project.dto;

public class MemDto {
	private int num;
	private String name;
	private String pw;
	private String email;

	public MemDto() {
	}

	public MemDto(int num, String name, String pw, String email) {
		this.num = num;
		this.name = name;
		this.pw = pw;
		this.email = email;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getNum() {
		return num;
	}

	public String getName() {
		return name;
	}

	public String getPw() {
		return pw;
	}

	public String getEmail() {
		return email;
	}
}
