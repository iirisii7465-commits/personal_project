package dto;

public class MemberDto {
	private String id, name, password, password_length, email_1, email_2, reg_date, exit_date;

	public MemberDto(String id, String name, String password, String password_length, String email_1, String email_2,
			String reg_date, String exit_date) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.password_length = password_length;
		this.email_1 = email_1;
		this.email_2 = email_2;
		this.reg_date = reg_date;
		this.exit_date = exit_date;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	public String getPassword_length() {
		return password_length;
	}

	public String getEmail_1() {
		return email_1;
	}

	public String getEmail_2() {
		return email_2;
	}

	public String getReg_date() {
		return reg_date;
	}

	public String getExit_date() {
		return exit_date;
	}

}
