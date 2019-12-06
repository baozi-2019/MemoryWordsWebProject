package modle.entity;

public class Words {
	private String english;
	private String chinese;
	private int times;
	
	public String getEnglish() {
		return english;
	}
	public void setEnglish(String english) {
		english = english.trim();
		this.english = english;
	}
	public String getChinese() {
		return chinese;
	}
	public void setChinese(String chinese) {
		chinese = chinese.trim();
		this.chinese = chinese;
	}
	public int getTimes() {
		return times;
	}
	public void setTimes(int times) {
		this.times = times;
	}
	
	
	
}
