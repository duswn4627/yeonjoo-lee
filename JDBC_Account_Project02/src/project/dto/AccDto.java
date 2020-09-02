package project.dto;

public class AccDto {
	private int num;
	private String bank; // ÀºÇà¸í
	private String accnum; // °èÁÂ¹øÈ£
	private int amount; // ÀÜ¾×

	public AccDto() {
	}

	public AccDto(int num, String bank, String accnum, int amount) {
		this.num = num;
		this.bank = bank;
		this.accnum = accnum;
		this.amount = amount;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public String getAccnum() {
		return accnum;
	}

	public void setAccnum(String accnum) {
		this.accnum = accnum;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

}
