package mapper;

public class MemberEntity {
	private String id;
	private String pasword;
	private String mail;
	private String name;
	public MemberEntity() {
		// TODO Auto-generated constructor stub
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPasword() {
		return pasword;
	}
	public void setPasword(String pasword) {
		this.pasword = pasword;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public MemberEntity(String id, String pasword, String mail, String name) {
		super();
		this.id = id;
		this.pasword = pasword;
		this.mail = mail;
		this.name = name;
	}
	@Override
	public String toString() {
		return "MemberEntity [id=" + id + ", pasword=" + pasword + ", mail=" + mail + ", name=" + name + "]";
	}
	
}
