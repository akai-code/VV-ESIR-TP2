package fr.istic.vv;

import java.util.ArrayList;

public class NoGetter {


    public void compare(ArrayList<ArrayList<String>> tab) {
    	ArrayList<String> name_att = new ArrayList<String>();
    	for(String attribut : tab.get(1)) {
    		if(attribut.split(" ")[0].equals("private")) {
    			String att = attribut.split(" ")[2];
    			if (att.endsWith(";")){
    				att = retirerlastcarac(att);
    			}
    			name_att.add(att);
    		}
    	}

    	print("-----------");
    	print(name_att.toString());

    	ArrayList<String> name_get = new ArrayList<String>();
    	for(String fonction : tab.get(0)) {
    		if(fonction.contains("get")) {
    			name_get.add(retirerfirstcarac(fonction));
    		}		

    	}
    	print(name_get.toString());

    	for(String funcname : name_att) {
    		if (! name_get.contains(funcname)) {
    			Main.addErrorStr("No public getter for private attribut : " + funcname);

    		}
    	}
    }
    public String retirerfirstcarac(String att) {
    	String output = "";
    	for (int i = 3; i<att.length(); i++) {
    		output+=att.charAt(i);
    	}
    	return output;
    }

    public String retirerlastcarac(String att) {
    	String output = "";
    	for (int i = 0; i<att.length()-1; i++) {
    		output+=att.charAt(i);
    	}
    	return output;
    }

    public static void print(String s) {
    	System.out.println(s);

    }
}
