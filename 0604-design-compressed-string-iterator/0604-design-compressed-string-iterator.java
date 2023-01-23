class StringIterator {
    String myString;
    int idx;

    public StringIterator(String compressedString) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < compressedString.length()) {
            char c = compressedString.charAt(i);
            i++;
            //if (i == compressedString.length()) break;
            StringBuilder numSb = new StringBuilder();
            while (i < compressedString.length() && Character.isDigit(compressedString.charAt(i))) numSb.append(compressedString.charAt(i++));
            int t = Integer.valueOf(numSb.toString());
            t = Math.min(t, 100);
            while (t-- > 0) sb.append(c);
        }
        
        myString = sb.toString();
        idx = 0;
    }
    
    public char next() {
        if (!hasNext()) return ' ';
        return myString.charAt(idx++);
    }
    
    public boolean hasNext() {
        return idx != myString.length();
    }
}

/**
 * Your StringIterator object will be instantiated and called as such:
 * StringIterator obj = new StringIterator(compressedString);
 * char param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */