package com.smartdatasolutions.test.impl;

import com.smartdatasolutions.test.Member;
import com.smartdatasolutions.test.MemberImporter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class MemberImporterImpl implements MemberImporter {

	@Override
	public List< Member > importMembers( File inputFile ) throws Exception {

		/*
		 * Implement the missing logic
		 */
		
		List<Member> list = new ArrayList<>();
		
		try (BufferedReader br = new BufferedReader( new FileReader( inputFile ) )) {
			String line = br.readLine( );

			while ( line != null ) {
				//line = br.readLine( );
				//System.out.print(line);
				String[] str = line.split("\\s+");
				Member m = new Member();
				
				
				m.setId(str[0]);
				m.setLastName(str[1]);
				m.setFirstName(str[2]);
				m.setAddress(str[3]);
				m.setCity(str[4]);
				m.setState(str[5]);
				m.setZip(str[6]);
				
                list.add(m);
                line = br.readLine( );
			}
		}

		return list;
	}
	
	

}
