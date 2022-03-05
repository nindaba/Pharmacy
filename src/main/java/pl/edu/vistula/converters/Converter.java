package pl.edu.vistula.converters;

public interface Converter<SOURCE,TARGET> {
    TARGET convert(SOURCE source);
}
