class Solution {
    public String multiply(String num1, String num2) {
        if(num1.length() == 0 ||
                num2.length() == 0 ||
                num1.equals("0") ||
                num2.equals("0")){
            return "0";
        }
        List<String> results = new ArrayList<>();
        int deposit = 0;
        int firstNum = 0;
        int secondNum = 0;
        int tmp = 0;
        StringBuilder sb;
        StringBuilder fillIn = new StringBuilder();
        for(int i = num2.length() - 1;i >= 0;i--){
            if(i != num2.length() - 1){
                fillIn.append("0");
            }
            secondNum = num2.charAt(i) - '0';
            if(secondNum == 0){
                continue;
            }
            sb = new StringBuilder(fillIn.toString());
            deposit = 0;
            for(int j = num1.length() - 1;j >= 0;j--){
                firstNum = num1.charAt(j) - '0';
                tmp = secondNum * firstNum + deposit;
                sb.append(tmp % 10);
                deposit = tmp / 10;
                if(j == 0 && deposit > 0){
                    sb.append(tmp/10);
                }
            }
            results.add(sb.toString());
        }
        String result = "";
        for(String str : results){
            if(result.equals("")){
                result = str;
                continue;
            }
            deposit = 0;
            sb = new StringBuilder();
            for(int i = 0;i < str.length();i++){
                secondNum = str.charAt(i) - '0';
                firstNum = i < result.length() ? result.charAt(i) - '0' : 0;
                tmp = secondNum + firstNum + deposit;
                sb.append(tmp % 10);
                deposit = tmp / 10;
            }
            if(deposit > 0){
                sb.append(deposit);
            }
            result = sb.toString();
        }
        return new StringBuilder(result).reverse().toString();
    }
}
