class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        char[] note = ransomNote.toCharArray();
        char[] mag = magazine.toCharArray();
        Arrays.sort(note);
        Arrays.sort(mag);
        
        int i = 0, j = 0;
        while (i < note.length) {
            if (j == mag.length) return false;
            if (note[i] == mag[j]) {
                i++;
                j++; 
            } else j++;
        }
        return true;
    }
}