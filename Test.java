1.
给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。

对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。

你可以返回任何满足上述条件的数组作为答案。

 

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/sort-array-by-parity-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

class Solution {
    public int[] sortArrayByParityII(int[] A) {
        int left=0;
        int right=1;
        while(left<A.length&&right<A.length){
            while(left<A.length&&A[left]%2==0){
                left+=2;
            }while(right<A.length&&A[right]%2!=0){
                right+=2;
            }
             if(left<A.length&&right<A.length){
                int tmp=A[left];
                A[left]=A[right];
                A[right]=tmp;
             }
        }
        return A;
    }
}

2.
给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。

示例 1:

输入: s = "anagram", t = "nagaram"
输出: true

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/valid-anagram
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        if(s.equals("")&&t.equals("")){
            return true;
        }
        int[] arr1=new int[s.length()];
        int[] arr2=new int[t.length()];
        int flag=1;
         for(int i=0;i<s.length();i++){
             arr1[i]=(int)(s.charAt(i));
             arr2[i]=(int)(t.charAt(i));
         }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        for(int i=0;i<s.length();i++){
            if(arr1[i]!=arr2[i]){
                flag=0;
                break;
            }
        }
        return flag==1;
    }
}

3.
