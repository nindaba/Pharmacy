package pl.edu.vistula.populators;

public interface Populator<SOURCE,TARGET> {
    TARGET populate(SOURCE source);
}
