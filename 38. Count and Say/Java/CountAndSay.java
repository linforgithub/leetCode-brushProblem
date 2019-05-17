class Solution {
    public String countAndSay(int n) {
        String result = "1";
        int count = 0;
        char num;
        StringBuilder sb;
        for(int i = 2;i <= n;i++){
            num = result.charAt(0);
            count = 1;
            sb = new StringBuilder();
            for(int j = 1;j < result.length();j++){
                if(result.charAt(j) == num){
                    count++;
                }else{
                    sb.append(count).append(num);
                    count = 1;
                    num = result.charAt(j);
                }
            }
            sb.append(count).append(num);
            result = sb.toString();
        }
        return result;
    }
}
