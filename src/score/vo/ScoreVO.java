package score.vo;

//VO: Value Object

public class ScoreVO {
//	성적정보
	private int stuId;
	private String name;
	private int grade;
	private int classNum;
	private int kor;
	private int eng;
	private int math;
	private int science;
	private int total;
	private double avg;
	public int getStuId() {
		return stuId;
	}
	public void setStuId(int stuId) {
		this.stuId = stuId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public int getClassNum() {
		return classNum;
	}
	public void setClassNum(int classNum) {
		this.classNum = classNum;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	public int getScience() {
		return science;
	}
	public void setScience(int science) {
		this.science = science;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal() {
		this.total = kor + eng + math + science;
	}
	public double getAvg() {
		return avg;
	}
	public void setAvg() {
		this.avg = total / 4.0;
	}
	
}
