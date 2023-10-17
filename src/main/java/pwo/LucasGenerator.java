package pwo;

import java.math.BigDecimal;

public class LucasGenerator {

    private int lastIndex;
    private BigDecimal[] lucasNumbers;

    public LucasGenerator() {
        this.lastIndex = 1;
        this.lucasNumbers = new BigDecimal[]{new BigDecimal(2), new BigDecimal(1)};
    }

    public void reset() {
        this.lastIndex = 1;
        this.lucasNumbers = new BigDecimal[]{new BigDecimal(2), new BigDecimal(1)};
    }

    public BigDecimal nextTerm() {
        BigDecimal next = lucasNumbers[0].add(lucasNumbers[1]);
        lucasNumbers[0] = lucasNumbers[1];
        lucasNumbers[1] = next;
        lastIndex++;
        return next;
    }

    public BigDecimal getTerm(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Indeks mniejszy niż 0.");
        }
        if (i < lastIndex) {
            return lucasNumbers[i];
        }
        while (lastIndex < i) {
            nextTerm();
        }
        return lucasNumbers[1];
    }
}