package POJOClass;

import java.util.List;

public class PostCOMPLX {
	
	
	
	//genetrate getter and setter for simple data 
	String id;
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
	String name;
	
	Subject SUBJ;
	
	
	//Generate getter and setter of SUB object to add it to json file 
		public Subject getMain() {
			return SUBJ;
		}
		public void setMain(Subject SUBJ) {
			this.SUBJ = SUBJ;
		}
	

//Creating object of SUB
	public static class Subject
	{
		String test;
		public String getTest() {
			return test;
		}
		public void setTest(String test) {
			this.test = test;
		}
		public String getTest2() {
			return test2;
		}
		public void setTest2(String test2) {
			this.test2 = test2;
		}
		String test2;
	}
   
	
	
	 public Object[] getCRS() {
		return CRS;
	}
	public void setCRS(Object[] cRS) {
		CRS = cRS;
	}
	 Object CRS[];
	
	
	


	public static class alter
	{
		String SUB1;
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
		String SUB2;
	}
	
	
	
	
	
	
   
   
}
