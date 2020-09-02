package project.dto;

import java.sql.Date;

public class DepDto {
	private int num;
	private Date cadate;
	private String category;
	private int money;

	public DepDto() {
	}

	public DepDto(int num, Date cadate, String category, int money) {
		this.num = num;
		this.cadate = cadate;
		this.category = category;
		this.money = money;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public Date getCadate() {
		return cadate;
	}

	public void setCadate(Date cadate) {
		this.cadate = cadate;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}
}
