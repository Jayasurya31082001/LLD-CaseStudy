package TicTakToe.Models;

import java.awt.*;

public class Symbol {
    private String symbol;
    private Image image;

    public Symbol(String symbol){
        this.symbol=symbol;
    }
    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
