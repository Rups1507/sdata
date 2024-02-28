package com.smartdatasolutions.test.impl;

import com.smartdatasolutions.test.Member;
import com.smartdatasolutions.test.MemberExporter;
import com.smartdatasolutions.test.MemberFileConverter;
import com.smartdatasolutions.test.MemberImporter;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main extends MemberFileConverter {

	@Override
	protected MemberExporter getMemberExporter( ) {
		// TODO
		//return null;
		
		return new MemberExporterImpl();
	}

	@Override
	protected MemberImporter getMemberImporter( ) {
		// TODO
		//return null;
		return new MemberImporterImpl();
	}

	@Override
	protected List< Member > getNonDuplicateMembers( List< Member > membersFromFile ) {

		// TODO
		//return null;
		Set<String> st = new HashSet<>();
		List<Member> list = new ArrayList<>();
		for(Member m : membersFromFile) {
			if(!st.contains(m.getId())) {
				list.add(m);
				st.add(m.getId());
			}
		}
		
		
		return list;
	
	}

	@Override
	protected Map< String, List< Member >> splitMembersByState( List< Member > validMembers ) {
		// TODO
		//return null;
		Map<String, List<Member>> mp = new HashMap<>();
		
		for(Member m : validMembers) {
			String state = m.getState();
			if(!mp.containsKey(state)) {
				mp.put(state, new ArrayList<>());
			}
			mp.get(state).add(m);
		}
		
		return mp;
	}

	public static void main( String[] args ) {
		//TODO
		
		Main main = new Main();
		File inputFile = new File("C:\\Users\\devis\\Downloads\\java test file\\SDS_Entry_Maven\\Members.txt");
	    String outputFilePath = "C:\\Users\\devis\\Downloads\\java test file\\SDS_Entry_Maven\\output"; 
	    String outputFileName = "outputFile.csv"; 
	    
	    try {
            main.convert(inputFile, outputFilePath, outputFileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
	}

}
