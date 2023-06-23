

public class SaleVO {
    private int custno;
    private String custname;
    private String grade;
    private int total;
    
    public SaleVO() {
		// TODO Auto-generated constructor stub
	}

	public SaleVO(int custno, String custname, String grade, int total) {
		super();
		this.custno = custno;
		this.custname = custname;
		this.grade = grade;
		this.total = total;
	}

	public int getCustno() {
		return custno;
	}

	public void setCustno(int custno) {
		this.custno = custno;
	}

	public String getCustname() {
		return custname;
	}

	public void setCustname(String custname) {
		this.custname = custname;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "SaleVO [custno=" + custno + ", custname=" + custname + ", grade=" + grade + ", total=" + total + "]";
	}
    
}
