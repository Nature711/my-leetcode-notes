class Solution {
   public String simplifyPath(String path) {
       String[] paths = path.split("/");
       Stack<String> actualPaths = new Stack<>();
       for (String p: paths) {
           if (p.length() > 0) {
               if (p.equals("..")) {
                   if (!actualPaths.isEmpty()) {
                       actualPaths.pop();
                   }
               }
               else if (p.equals(".")) continue; 
               else actualPaths.push(p);
           }
       }
       Stack<String> temp = new Stack<>();
       while (!actualPaths.isEmpty()) {
           temp.push(actualPaths.pop());
       }
       StringBuilder sb = new StringBuilder();
       sb.append("/");
      
       while (!temp.isEmpty()) {
           sb.append(temp.pop());
           sb.append("/");
       }
       
       if (sb.length() > 1) sb.deleteCharAt(sb.length() - 1);
       
       return sb.toString();
   }
}