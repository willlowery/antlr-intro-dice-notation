package dice;

public class DieRollRequest {
    private final Integer numberOfRolls;
    private final Integer numberOfFaces;

    public DieRollRequest(Integer numberOfRolls, Integer numberOfFaces) {
        this.numberOfRolls = numberOfRolls;
        this.numberOfFaces = numberOfFaces;
    }

    public Integer getNumberOfRolls() {
        return numberOfRolls;
    }

    public Integer getNumberOfFaces() {
        return numberOfFaces;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DieRollRequest that = (DieRollRequest) o;

        if (!numberOfRolls.equals(that.numberOfRolls)) return false;
        return numberOfFaces.equals(that.numberOfFaces);

    }

    public int hashCode() {
        int result = numberOfRolls.hashCode();
        result = 31 * result + numberOfFaces.hashCode();
        return result;
    }

    public String toString() {
        return numberOfRolls + "D" + numberOfFaces;
    }
}
