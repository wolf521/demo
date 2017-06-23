package com.example.demo.collection;

import java.util.*;

/**
 * Created by cuizhixiang on 2017/6/23.
 **/
public class ShowHand {
    //该游戏支持的最多玩家数量
    private final int PALY_NUM = 5;
    //该游戏实际参与的玩家数量
    private int factNum = 0;
    //定义所有扑克的花色和数值
    private String[] types = {"♠","♥","♣","♦"};
    private String[] values = {"8","9","10","J","Q","K","A"};
    //在一局中所有牌的数量
    private List<String> cards = new ArrayList<String>();
    //定义所有的玩家
    private String[] players = new String[PALY_NUM];
    //定义所有玩家手上的扑克牌
    private Map<String,Set<String>> playerCards = new HashMap<String,Set<String>>();

    /**
     *	初始化扑克牌，并将其随机排序，相当于洗牌
     **/
    public void initCards(){
        //首先将牌放到集合中去
        for(String type : types){
            for(String value : values){
                this.cards.add(type+value);
            }
        }
        Collections.shuffle(cards);
    }

    /**
     * 初始化玩家
     * */
    public boolean initPlays(String... names){
        if(names.length>this.PALY_NUM || names.length<2){
            System.out.println("玩家数量不正确");
            return false;
        }else{
            //初始化玩家
            for(int i=0;i<names.length;i++){
                this.players[i] = names[i];
                playerCards.put(names[i], this.getSortSet());
            }
            this.factNum = names.length;
            return true;
        }
    }
    /**
     * 创建一个自定义的Set集合，用于存放扑克牌，按照我们定制的顺序排放
     * */
    private Set<String> getSortSet(){
        //自定义排序器，让扑克牌按照我们的方式进行排放
        Comparator<String> comp = new Comparator<String>(){
            /**
             * 扑克牌的大小及排放规则，花色按照黑、红、花、片，排序，大小8、9、10、J、Q、K、A
             * */
            public int compare(String s1, String s2) {
                int num1 = this.getSize(s1.charAt(1));
                int num2 = this.getSize(s2.charAt(1));
                if(num1>num2){
                    return 1;
                }else if(num1<num2){
                    return -1;
                }else{
                    int type1 = this.getType(s1.charAt(0));
                    int type2 = this.getType(s2.charAt(0));
                    if(type1>type2){
                        return -1;
                    }else{
                        return 1;
                    }
                }
            }
            /**
             * 判断牌的点数大小
             * */
            private int getSize(char c){
                switch (c) {
                    case '8':
                        return 8;
                    case '9':
                        return 9;
                    case 'J':
                        return 11;
                    case 'Q':
                        return 12;
                    case 'K':
                        return 13;
                    case 'A':
                        return 14;
                    default:
                        return 10;
                }
            }
            /**
             * 判断牌的花色
             * */
            private int getType(char c){
                switch (c) {
                    case '♦':
                        return 1;
                    case '♣':
                        return 2;
                    case '♥':
                        return 3;
                    default:
                        return 4;
                }
            }
        };
        Set<String> set = new TreeSet<String>(comp);
        return set;
    }
    /**
     * 为每个玩家初始化扑克牌
     * */
    public void deliverCard(){
        for(int i=0;i<5;i++){
            for(int j=0;j<factNum;j++){
                playerCards.get(this.players[j]).add(cards.get(0));
                cards.remove(0);
            }
        }
    }
    /**
     * 测试每个人手中的牌
     * */
    public void print(){
        for(int i=0;i<this.factNum;i++){
            System.out.println(this.playerCards.get(this.players[i]));
        }
    }
    public static void main(String[] args) {
        ShowHand test = new ShowHand();
        test.initCards();
        test.initPlays("张三","李四","王五");
        test.deliverCard();
        test.print();
    }
}
