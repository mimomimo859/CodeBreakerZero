package net.sougetu.first;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * CodeBreakerZero<br>
 * シンプルにmainメソッドだけでコードブレイカーを作成します。
 * @author ono
 */
public class CodeBreakerFirst {

    /**
     * @param args
     */
    public static void main(String[] args) {
        /*
         * タイトル、ルール文、答えの格納される配列、
         * 入力された数字の格納される配列。
         * ヒット数、ブロー数、チャレンジの回数
         */
        String title = "*** CodeBreaker ***";//タイトル
        String rule = "隠された３つの数字を当てます。\n"// \n = 改行文字
                      + "１つの数字は１から６の間です。\n"
                      + "３つの答えの中に同じ数字はありません。\n"
                      + "入力した数字の、"
                      + "位置と数字が当たったらヒット、\n"
                      + "数字だけあっていたらブローとカウントします。\n"
                      + "全部当てたら（３つともヒットになったら）"
                      + "終了です。\n\n";
        //配列の宣言 配列変数名 = new データ型[要素数]              
        int[] answer = new int[3];//答えが入る
        int[] input = new int[3];//入力した答えが入る
        /*
         *変数の初期化
         *必要な変数
         * hitはhitのカウント用、blowもblowのカウント用
         * countは何回目のチャレンジかを数えている
         */
        int hit = 0, blow = 0, count = 0;
        
        
        //タイトルとルールの表示
        BufferedReader br
            = new BufferedReader(new
            InputStreamReader(System.in));
            System.out.println(title);
            System.out.println(rule);
            
        
        //ランダムな答えを作成。
        //ただし、仕様通り、同じ数字がないようにする。
        for (int i = 0; i < answer.length; i++) {
            //自分より前の要素にかぶるやつがないか確かめる。
            //あったらもう１回random
            boolean flag = false;
            answer[i] = (int) (Math.random() * 6 + 1);
            do {
                flag = false;
                for (int j = i - 1; j>= 0; j--) {
                    flag = true;
                    answer[i] = (int) (Math.random() * 6 + 1);
                }
            }
        } while (flag == true);
    }//入力させる。数値のチェックを行う。
    
    
    //ゲーム部
    while (true) {
        count++;
        System.out.println("***" + count + "回目 ***");
        //インプット
        for (int i = 0; i < answer.length; i++) {
            System.out.print((i + 1) + "個目 : ");
            try {
                input[i] = Integer.parseInt(br.readLine());
            } catch (NumberFormatException e) {
                System.err.println("数値を入力してください");
                i--;
            }
        }
        //答え判断
        hit = 0;
        blow = 0;
        for (int i = 0; i < answer.length; i++) {
            if (i == j && input[i] == answer[j]) {
                hit++;
            }
        } else if (input[i] == answer[j]) {
            blow++;
        }
    }
}

//終了判断　ヒットが3つになったら終了
System.out.println("" + hit + "" + blow);
if (hit == 3) {
    System.out.println("おめでとう");
    break;
} else {
    System.out.println();
}