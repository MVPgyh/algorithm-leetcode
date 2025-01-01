package org.zifuString.simple;

/**
 * @Author pudding
 * @email gyh020815@outlook.com
 * @Date 2025/1/1 下午6:46
 */
public class ConvertDateToBinary {
    public static void main(String[] args) {

    }

    public String convertDateToBinary(String date) {
        String[] split = date.split("-");
        StringBuffer res = new StringBuffer();
        for (int i = 0; i < split.length; i++) {
            String current = split[i];
            String binaryString = Integer.toBinaryString(Integer.parseInt(current));
            if (i == split.length - 1) {
                res.append(binaryString);
            }else {
                res.append(binaryString).append("-");
            }


        }
        return  res.toString();
    }
}
