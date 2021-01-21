public class Dough {
    private String flourType;
    private String bakingTechnique;
    private double weight;

    public Dough(String flourType, String bakingTechnique, double weight){
        this.setFlourType(flourType);
        this.setBakingTechnique(bakingTechnique);
        this.setWeight(weight);
    }

    private void setFlourType(String flourType) {
        if(!flourType.equals("White") && !flourType.equals("Wholegrain")){
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.flourType = flourType;
    }

    private void setBakingTechnique(String bakingTechnique) {
        if(!bakingTechnique.equals("Crispy") && !bakingTechnique.equals("Chewy") && !bakingTechnique.equals("Homemade")){
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.bakingTechnique = bakingTechnique;
    }

    private void setWeight(double weight) {
        if(weight < 1 || weight > 200){
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
        this.weight = weight;
    }

    public double calculateCalories() {
        double flourTypeCalories = 0;
        if(this.flourType.equals("White")){
            flourTypeCalories = 1.5;
        }else if(this.flourType.equals("Wholegrain")){
            flourTypeCalories = 1.0;
        }

        double bakingTechniqueCalories = 0;
        if(this.bakingTechnique.equals("Crispy")){
            bakingTechniqueCalories = 0.9;
        }else if(this.bakingTechnique.equals("Chewy")){
            bakingTechniqueCalories = 1.1;
        }else if(this.bakingTechnique.equals("Homemade")){
            bakingTechniqueCalories = 1.0;
        }

        return 2 * this.weight * flourTypeCalories * bakingTechniqueCalories;
    }
}
