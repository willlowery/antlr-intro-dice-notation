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
}
