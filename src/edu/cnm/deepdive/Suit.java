package edu.cnm.deepdive;

public enum Suit {
  CLUBS(Color.BLACK, '\u2663'),
  SPADES(Color.BLACK, '\u2660'),
  DIAMONDS(Color.RED, '\u2666'),
  HEARTS(Color.RED, '\u2665');

  private Color color;
  private char symbol;


  Suit(Color color, char symbol) {
    this.color = color;
    this.symbol = symbol;
  }

  public Color getColor() {
    return color;
  }

  public char getSymbol() {
    return symbol;
  }

  @Override
  public String toString() {
    return "" + symbol;
  }

  public enum Color {
    RED,
    BLACK;
  }
}
