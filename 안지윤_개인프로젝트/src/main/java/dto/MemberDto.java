package dto;

public class MemberDto {

	private String id;
	private String name;
	private String password;
	private String password_length;
	private String email_1;
	private String email_2;
	private String reg_date;
	private String update_date;
	private String exit_date;


	public MemberDto(
			String id,
			String name,
			String password,
			String password_length,
			String email_1,
			String email_2,
			String reg_date,
			String update_date,
			String exit_date) {

		this.id = id;
		this.name = name;
		this.password = password;
		this.password_length = password_length;
		this.email_1 = email_1;
		this.email_2 = email_2;
		this.reg_date = reg_date;
		this.update_date = update_date;
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

	public String getUpdate_date() {
		return update_date;
	}

	public String getExit_date() {
		return exit_date;
	}

}