package org.zifuString.simple;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * @Author pudding
 * @email gyh020815@outlook.com
 * @Date 2024/12/29 下午9:15
 * 通过投票对团队排名  关键在于哈希映射表
 */
public class RankTeams {
    public static void main(String[] args) {
        System.out.println(rankTeams(new String[]{"WAYZ", "AYZW"}));
    }

    public static String rankTeams(String[] votes) {
        int n = votes.length;
        // 初始化哈希映射
        Map<Character, int[]> ranking = new HashMap<>();
        for (char vid : votes[0].toCharArray()) {
            ranking.put(vid, new int[votes[0].length()]);
        }
        // 遍历统计
        for (String vote : votes) {
            for (int i = 0; i < vote.length(); ++i) {
                ++ranking.get(vote.charAt(i))[i];
            }
        }

        // 取出所有的键值对
        List<Map.Entry<Character, int[]>> result = new ArrayList<>(ranking.entrySet());
        // 排序
        result.sort(new Comparator<Map.Entry<Character, int[]>>() {
            @Override
            public int compare(Map.Entry<Character, int[]> a, Map.Entry<Character, int[]> b) {
//                如果两个值不相等 则降序排列 大的放前面
                for (int i = 0; i < a.getValue().length; i++) {
                    if (a.getValue()[i] != b.getValue()[i]) {
                        return b.getValue()[i] - a.getValue()[i];
                    }
                }
                return a.getKey() - b.getKey();
            }
        });
        System.out.println(result);

        StringBuilder ans = new StringBuilder();
        for (Map.Entry<Character, int[]> entry : result) {
            ans.append(entry.getKey());
        }
        return ans.toString();

    }
}
