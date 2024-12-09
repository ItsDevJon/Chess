package com.chess.utils;

import com.chess.model.Position;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Getter
public class Grid<T> {

    private int rows;
    private int cols;
    private final List<List<T>> elements;

    public Grid(int rows, int cols, T defaultValue) {
        this.rows = rows;
        this.cols = cols;

        elements = new ArrayList<>();
        initGrid(defaultValue);

    }

    private void initGrid(T defaultValue) {
        IntStream.range(0, rows).forEach(i -> {
            List<T> row = new ArrayList<>(IntStream.range(0, cols).mapToObj(j -> defaultValue).toList());
            elements.add(row);
        });
    }

    public T get(Position position) {
        return elements.get(position.row()).get(position.col());
    }

    public T get(int row, int col) {
        return this.get(Position.of(row, col));
    }

    public void set(Position position, T value) {
        elements.get(position.row()).set(position.col(), value);
    }

    public void set(int row, int col, T value) {
        this.set(Position.of(row, col), value);
    }

    public void forEach(GridConsumer<T> action) {
        for (int row = 0; row < elements.size(); row++) {
            for (int col = 0; col < elements.get(row).size(); col++) {
                action.accept(Position.of(row, col), elements.get(row).get(col));
            }
        }
    }

    @FunctionalInterface
    public interface GridConsumer<T> {
        void accept(Position position, T value);
    }

}