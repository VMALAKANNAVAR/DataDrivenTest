package POJOClass;

import java.util.List;

public class Post {
	
	String id;
    String name;
    String CRS[];
    Subject SUBJ;
    public Subject getTs() {
		return SUBJ;
	}


	public void setTs(Subject SUBJ) {
		this.SUBJ = SUBJ;
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


	public String[] getCRS() {
		return CRS;
	}


	public void setCRS(String[] cRS) {
		CRS = cRS;
	}


	
    
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
}
