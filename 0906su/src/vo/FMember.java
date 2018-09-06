package vo;

public class FMember {
	protected String email;
	protected String pw;
	protected String name;
	protected String phone;
	protected String address;
	protected int age;
	protected String selfintro;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSelfintro() {
		return selfintro;
	}
	public void setSelfintro(String selfintro) {
		this.selfintro = selfintro;
	}
	@Override
	public String toString() {
		return "FMember [email=" + email + ", pw=" + pw + ", name=" + name + ", phone=" + phone + ", address=" + address
				+ ", age=" + age + ", selfintro=" + selfintro + "]";
	}
	
}
