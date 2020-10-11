public String removeDuplicateLetters(String s) {
		 StringBuilder sb = new StringBuilder();
		 int[] count = new int[26];
		 boolean[] used = new boolean[26];
		 
		 char[] chs = s.toCharArray();
		 for (char c : chs) {
			 count[c - 'a']++; //get how many times of each elements exist
		 }
		
		 for (char c : chs) {
			 count[c - 'a']--; //because we used them, so we need to minus them 
			 if (used [c - 'a']) continue; //if used we continue
			 
			 while(sb.length() > 0 &&
					sb.charAt(sb.length()-1) > c && //if last element of sb, bigger than c
					count[sb.charAt(sb.length()-1) - 'a'] > 0) { //check if count still have the last element of sb
				 used[sb.charAt(sb.length()-1) - 'a'] = false; 
				 sb.deleteCharAt(sb.length() -1);
			 }
			 
			 sb.append(c);
			 used[c - 'a'] = true; 
		 }
		 return sb.toString(); 
	}
