package com.unicauca.smart_consumption.domain.model.valueObject;

public class SustainabilityCriteria {
    private double carbonFootprint;
    private double energyEfficiency;
    private double resourceUsage;
    private double wasteManagement;
    private double sustainabilityScore;

    public SustainabilityCriteria(double carbonFootprint, double energyEfficiency,
                                  double resourceUsage, double wasteManagement) {
        this.carbonFootprint = carbonFootprint;
        this.energyEfficiency = energyEfficiency;
        this.resourceUsage = resourceUsage;
        this.wasteManagement = wasteManagement;
        this.sustainabilityScore = calculateSustainabilityScore();
    }

    private double calculateSustainabilityScore() {
        return (energyEfficiency * 0.4) + (resourceUsage * 0.3) + (wasteManagement * 0.2) - (carbonFootprint * 0.1);
    }


    public double getCarbonFootprint() {
        return carbonFootprint;
    }

    public void setCarbonFootprint(double carbonFootprint) {
        this.carbonFootprint = carbonFootprint;
        this.sustainabilityScore = calculateSustainabilityScore();
    }

    public double getEnergyEfficiency() {
        return energyEfficiency;
    }

    public void setEnergyEfficiency(double energyEfficiency) {
        this.energyEfficiency = energyEfficiency;
        this.sustainabilityScore = calculateSustainabilityScore();
    }

    public double getResourceUsage() {
        return resourceUsage;
    }

    public void setResourceUsage(double resourceUsage) {
        this.resourceUsage = resourceUsage;
        this.sustainabilityScore = calculateSustainabilityScore();
    }

    public double getWasteManagement() {
        return wasteManagement;
    }

    public void setWasteManagement(double wasteManagement) {
        this.wasteManagement = wasteManagement;
        this.sustainabilityScore = calculateSustainabilityScore();
    }

    public double getSustainabilityScore() {
        return sustainabilityScore;
    }

    @Override
    public String toString() {
        return "SustainabilityCriteria{" +
                "carbonFootprint=" + carbonFootprint +
                ", energyEfficiency=" + energyEfficiency +
                ", resourceUsage=" + resourceUsage +
                ", wasteManagement=" + wasteManagement +
                ", sustainabilityScore=" + sustainabilityScore +
                '}';
    }
}
