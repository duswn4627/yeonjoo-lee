package project.dto;

public class joinDto {
	private int num;
	private String name;
	private String pw;
	private String email;
	private String accnum; // °èÁÂ¹øÈ£
	private int amount; // ÀÜ¾×

	public joinDto() {
	}

	public joinDto(int num, String name, String pw, String email, String accnum, int amount) {
		this.num = num;
		this.name = name;
		this.pw = pw;
		this.email = email;
		this.accnum = accnum;
		this.amount = amount;
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

	public void setAccnum(String accnum) {
		this.accnum = accnum;
	}

	public void setAmount(int amount) {
		this.amount = amount;
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

	public String getAccnum() {
		return accnum;
	}

	public int getAmount() {
		return amount;
	}
}
