1.
给定一个整数数组 A，我们只能用以下方法修改该数组：我们选择某个个索引 i 并将 A[i] 替换为 -A[i]，然后总共重复这个过程 K 次。（我们可以多次选择同一个索引 i。）

以这种方式修改数组后，返回数组可能的最大和。

 

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/maximize-sum-of-array-after-k-negations
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class Solution {
    public int largestSumAfterKNegations(int[] A, int K) {
        Arrays.sort(A);
        int sum=0;
        int count=0;
        int flag=0;
        for(int i=0;i<A.length;i++){
            if(A[i]==0){
                flag=1;
            }
            if(A[i]>=0){
                break;
            }
            count++;
        }
        if(count<=K){
            if(flag==1){
                for(int i=0;i<count;i++){
                    sum-=A[i];
                }
                for(int i=count;i<A.length;i++){
                    sum+=A[i];
                }
                return sum;
            }else{
               int tmp=0;
                for(int i=0;i<count;i++){
                    A[i]=-A[i];
                }
                Arrays.sort(A);
                if((K-count)%2==0){
                    for(int i=0;i<A.length;i++){
                        sum+=A[i];
                    }
                }else{
                    for(int i=1;i<A.length;i++){
                        sum+=A[i];
                    }
                    sum-=A[0];
                }
                return sum;
            }
            
        }else{
            
            for(int i=0;i<K;i++){
                A[i]=-A[i];
            }
            for(int i=0;i<A.length;i++){
                sum+=A[i];
            }
            return sum;
        }
    }
}

2.
给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。

设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。

注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。

示例 1:

输入: [7,1,5,3,6,4]
输出: 7
解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
     随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class Solution {
    public int maxProfit(int[] prices) {
        int sum=0;
        for(int i=0;i<prices.length-1;i++){
            if(prices[i]<prices[i+1]){
                sum+=prices[i+1]-prices[i];
            }
        }
        return sum;
    }
}

3.
给定字符串 s 和 t ，判断 s 是否为 t 的子序列。

你可以认为 s 和 t 中仅包含英文小写字母。字符串 t 可能会很长（长度 ~= 500,000），而 s 是个短字符串（长度 <=100）。

字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。

示例 1:
s = "abc", t = "ahbgdc"

返回 true.

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/is-subsequence
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s.equals("")){
            return true;
        }
        int j=0;
        int count=0;
        for(int i=0;i<s.length();i++){
            char c1=s.charAt(i);
           while(j<t.length()){
                char c2=t.charAt(j);
                if(c1==c2){
                    count++;
                }
                if(count==s.length()){
                    return true;
                }
               j++;
                if(c1==c2){
                   break;
                }
            }
        }
        return false;
    }
}