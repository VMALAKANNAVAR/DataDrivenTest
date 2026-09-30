package POJOClass;

public  class RP {

	String id;
	String name;
	Object CRS[];
	Subject SUB;
	public Subject getSUB() {
		return SUB;
	}
	public void setSUB(Subject sUB) {
		SUB = sUB;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Object[] getCRS() {
		return CRS;
	}
	public void setCRS(Object[] cRS) {
		CRS = cRS;
	}
	
	public static class Subject
	{
		String test1;
		String test2;
		public String getTest1() {
			return test1;
		}
		public void setTest1(String test1) {
			this.test1 = test1;
		}
		public String getTest2() {
			return test2;
		}
		public void setTest2(String test2) {
			this.test2 = test2;
		}
		
	}
	
	public static class Subsubj
	{
		String SUB1;
		String SUB2;
		public String getSUB1() {
			return SUB1;
		}
		public void setSUB1(String sUB1) {
			SUB1 = sUB1;
		}
		public String getSUB2() {
			return SUB2;
		}
		public void setSUB2(String sUB2) {
			SUB2 = sUB2;
		}
		
	}
	
	
}
