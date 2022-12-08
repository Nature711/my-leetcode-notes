class Solution {
    public String getHint(String secret, String guess) {
        HashMap<Character, Integer> map = new HashMap<>();
        char[] secrets = secret.toCharArray();
        char[] guesses = guess.toCharArray();
        for (int i = 0; i < secrets.length; i++) {
            map.put(secrets[i], map.getOrDefault(secrets[i], 0) + 1);
        }
     
        int bull = 0, cow = 0;
        for (int i = 0; i < guesses.length; i++) {
            if (guesses[i] == secrets[i]) {
                if (map.get(guesses[i]) <= 0) cow--;
                map.put(guesses[i], map.get(guesses[i]) - 1);
                bull++;
            } else if (map.containsKey(guesses[i]) && map.get(guesses[i]) > 0) {
                cow++;
                map.put(guesses[i], map.get(guesses[i]) - 1);
            }
        }
        
        String hint = Integer.toString(bull) + "A" + Integer.toString(cow) + "B";
        return hint;
        
    }
}