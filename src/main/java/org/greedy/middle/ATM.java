package org.greedy.middle;

import java.util.HashMap;
import java.util.Map;


/**
 * 注意点 cnt有可能超过整数 所以用long存储*/
class ATM {

    private  long[] cnt; //每张钞票剩余数量
    private  long[] value; //没张钞票面额
    public ATM() {
        cnt=new long[]{0,0,0,0,0};
        value=new long[]{20,50,100,200,500};
    }
    
    public void deposit(int[] banknotesCount) {
        /*重置 每张钞票剩余数量*/
        for (int i = 0; i < 5; i++) {
            cnt[i]+=banknotesCount[i];
        }
    }
    
    public int[] withdraw(int amount) {
        //返回结果
        int[] res=new int[5];
        /*amount/value[i] 获取钱数是否大于当前钞票面额*/
        for (int i = 4; i >=0; i--) {
            /*这一步是关键  比较当前钞票面额数量和amount除以面额的值，*/
//            设当前钞票的面额为 d，数量为 banknote
            res[i]=(int) Math.min(cnt[i],amount/value[i]);
            amount-=res[i]*value[i];
        }
        /*如果还有剩余 返回-1*/
        if (amount > 0) {
            return new int[]{-1};
        }else {
            /*可完全提取存款 把响应存款机的钱减少*/
            for (int i = 0; i < 5; i++) {
                cnt[i]-=res[i];
            }
            return res;
        }


    }

}