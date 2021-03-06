package com.baseball.game.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Pitcher {
    private static final int BOX_SIZE = 3;
    private List<NumberBox> numberBox;

    public static Pitcher create(){
        return new Pitcher();
    }

    public Pitcher(){
        numberBox = new ArrayList<>();
        createPitcherBox();
    }

    private void createPitcherBox() {
        for (int i = 0; i < BOX_SIZE ; i++) {
            numberBox.add(NumberBox.of(i, getDistinctValue()));
        }
    }

    protected int getDistinctValue(){
        int input = new Random().nextInt(NumberBox.getMaxValue()) + NumberBox.getMinValue();
        if(isPresent(input)){
            return getDistinctValue();
        }

        return input;
    }

    public boolean isPresent(int input) {
        return this.getNumberBox().stream().filter(box -> box.getNumber() == input).findFirst().isPresent();
    }


    public List<NumberBox> getNumberBox() {
        return numberBox;
    }

    public void setNumberBox(List<NumberBox> numberBox) {
        this.numberBox = numberBox;
    }

    @Override
    public String toString() {
        return "생성된 투수 숫자 힌트 -> " + numberBox.toString();
    }
}