import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Card {
    //一张扑克牌
    private String shape;
    private String num;

    public Card(String shape, String num) {
        this.shape = shape;
        this.num = num;
    }

    @Override
    public String toString() {
        return "[" + shape + num +  "]";
    }
}

class Poker {
    public static final String[] shape = new String[]{"♠", "♥", "♦", "♣"};
    private static List<Card> pokers () {
        //一副扑克牌
        List<Card> poker = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            String temp = shape[i];
            for (int j = 2; j <= 10; j++) {
               poker.add(new Card(temp, j + "")) ;
            }
            poker.add(new Card(temp, "A"));
            poker.add(new Card(temp, "J"));
            poker.add(new Card(temp, "Q"));
            poker.add(new Card(temp, "K"));
        }
        return poker;
    }

    public static void main(String[] args) {
        List<Card> deck = pokers();
        System.out.println("洗牌");
        Collections.shuffle(deck);
        System.out.println(deck);
        System.out.println("共" + deck.size() + "张");
        System.out.println("三人游戏开始，发牌：");
        List<List<Card>> handPokers = new ArrayList<>();
        handPokers.add(new ArrayList<>());
        handPokers.add(new ArrayList<>());
        handPokers.add(new ArrayList<>());
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                handPokers.get(j).add(deck.remove(0));
            }
        }
        System.out.println("玩家A：");
        System.out.println(handPokers.get(0));
        System.out.println("玩家B：");
        System.out.println(handPokers.get(1));
        System.out.println("玩家C：");
        System.out.println(handPokers.get(2));
    }
}