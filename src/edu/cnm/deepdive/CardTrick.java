package edu.cnm.deepdive;

import edu.cnm.deepdive.Suit.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class CardTrick {

  public static void main(String[] args) {
    List<Card> deck = new ArrayList<>();
    for (Suit suit : Suit.values()) {
      for (Rank rank : Rank.values()) {
        deck.add(new Card(rank, suit));
      }
    }
    System.out.println(deck);
    Collections.shuffle(deck);
    System.out.println(deck);

    List<Card> redPile = new ArrayList<>();
    List<Card> blackPile = new ArrayList<>();

    splitDeck(deck, redPile, blackPile);

    Random rng = new Random();

    int maxLength = getMinLength(redPile, blackPile);

    int X = rng.nextInt(maxLength - 1);
    List<Card> tempRed = new ArrayList<>();
    List<Card> tempBlack = new ArrayList<>();

    for (int i = 0; i < X; i++) {
      tempRed.add(redPile.remove(0));
      tempBlack.add(blackPile.remove(0));
    }

    redPile.addAll(tempBlack);
    blackPile.addAll(tempRed);

    int redInRedPile = 0;
    int blackInBlackPile = 0;

    for (Card card : redPile) {
      if (card.getSuit().getColor() == Color.RED) {
        redInRedPile++;
      }
    }
    for (Card card : blackPile) {
      if (card.getSuit().getColor() == Color.BLACK) {
        blackInBlackPile++;
      }
    }

    System.out
        .println("Red in red pile: " + redInRedPile + "\nBlack in black pile: " + blackInBlackPile);
  }

  static <T> int getMinLength(List<T> first, List<T> second) {
    if (first.size() > second.size()) {
      return second.size();
    } else {
      return first.size();
    }
  }

  static void splitDeck(List<Card> deck, List<Card> redPile, List<Card> blackPile) {

    List<Card> discardPile = new ArrayList<>();
    for (int i = 0; i < deck.size() / 2; i++) {
      discardPile.add(deck.get(i * 2));
      if (deck.get(i * 2).getSuit().getColor() == Color.RED) {
        redPile.add(deck.get(2 * i + 1));
      } else {
        blackPile.add(deck.get(2 * i + 1));
      }
    }
    assert redPile.size() + blackPile.size() == deck.size();
  }


}
