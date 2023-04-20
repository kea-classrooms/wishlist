package com.example.wishlist.DTOs;

import java.util.ArrayList;
import java.util.List;

public class UserBuildDTO {
    private int userID, buildID;


    List<Integer> updatedParts;
    private int motherboardPartID, gpuPartID, cpuPartID, powerSupplyPartID, storagePartID, coolerPartID;
    private String buildName;
    private List<BuildPartDTO> parts;

    private BuildPartDTO motherboard = new BuildPartDTO();
    private BuildPartDTO gpu = new BuildPartDTO();
    private BuildPartDTO cpu = new BuildPartDTO();
    private BuildPartDTO powerSupply = new BuildPartDTO();
    private BuildPartDTO storage = new BuildPartDTO();
    private BuildPartDTO cooler = new BuildPartDTO();

    public UserBuildDTO() {
        motherboardPartID = 0;
        gpuPartID = 0;
        cpuPartID = 0;
        powerSupplyPartID = 0;
        storagePartID = 0;
        coolerPartID = 0;
        updatedParts = new ArrayList<>(List.of(motherboardPartID, gpuPartID, cpuPartID, powerSupplyPartID, storagePartID, coolerPartID));
    }



    public UserBuildDTO(int userID, int buildID, String buildName) {
        this.userID = userID;
        this.buildID = buildID;
        this.buildName = buildName;
        motherboardPartID = 0;
        gpuPartID = 0;
        cpuPartID = 0;
        powerSupplyPartID = 0;
        storagePartID = 0;
        coolerPartID = 0;
        updatedParts = new ArrayList<>(List.of(motherboardPartID, gpuPartID, cpuPartID, powerSupplyPartID, storagePartID, coolerPartID));
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getBuildID() {
        return buildID;
    }

    public void setBuildID(int buildID) {
        this.buildID = buildID;
    }

    public String getBuildName() {
        return buildName;
    }

    public void setBuildName(String buildName) {
        this.buildName = buildName;
    }

    public List<BuildPartDTO> getParts() {
        return parts;
    }

    public void addPart(BuildPartDTO part) {
        switch (part.partType.toLowerCase()){
            case "motherboard" -> setMotherboard(part);
            case "gpu" -> setGpu(part);
            case "cpu" -> setCpu(part);
            case "power supply" -> setPowerSupply(part);
            case "storage" -> setStorage(part);
            case "cpu cooler" -> setCooler(part);
        }
    }

    public boolean containsPart(int id){
        for (BuildPartDTO part : parts) {
            if (part.partID == id) return true;
        }
        return false;
    }

    public BuildPartDTO getPart(String type){
        return switch (type.toLowerCase()){
            case "motherboard" -> motherboard;
            case "gpu" -> gpu;
            case "cpu" -> cpu;
            case "power supply" -> powerSupply;
            case "storage" -> storage;
            case "cpu cooler" -> cooler;
            default -> null;
        };
    }

    public BuildPartDTO getMotherboard() {
        return motherboard;
    }

    public void setMotherboard(BuildPartDTO motherboard) {
        this.motherboard = motherboard;
    }

    public BuildPartDTO getGpu() {
        return gpu;
    }

    public void setGpu(BuildPartDTO gpu) {
        this.gpu = gpu;
    }

    public BuildPartDTO getCpu() {
        return cpu;
    }

    public void setCpu(BuildPartDTO cpu) {
        this.cpu = cpu;
    }

    public BuildPartDTO getPowerSupply() {
        return powerSupply;
    }

    public void setPowerSupply(BuildPartDTO powerSupply) {
        this.powerSupply = powerSupply;
    }

    public BuildPartDTO getStorage() {
        return storage;
    }

    public void setStorage(BuildPartDTO storage) {
        this.storage = storage;
    }

    public BuildPartDTO getCooler() {
        return cooler;
    }

    public void setCooler(BuildPartDTO cooler) {
        this.cooler = cooler;
    }

    public void instantiateParts() {
        motherboard.setPartType("Motherboard");
        gpu.setPartType("GPU");
        cpu.setPartType("CPU");
        powerSupply.setPartType("Power Supply");
        storage.setPartType("Storage");
        cooler.setPartType("CPU Cooler");
        parts = new ArrayList<>(List.of(motherboard, gpu, cpu, powerSupply, storage, cooler));
    }

    public List<Integer> getPartIDs() {
        List<Integer> partIDs = new ArrayList<>();
        for (BuildPartDTO part : parts) {
            partIDs.add(part.partID);
        }
        return partIDs;
    }

    public int getUpdatedPartID(String partType) {
        return switch (partType.toLowerCase()) {
            case "motherboard" -> motherboardPartID;
            case "gpu" -> gpuPartID;
            case "cpu" -> cpuPartID;
            case "power supply" -> powerSupplyPartID;
            case "storage" -> storagePartID;
            case "cpu cooler" -> coolerPartID;
            default -> 0;
        };
    }

    public List<Integer> getUpdatedParts() {
        return updatedParts;
    }

    public void setUpdatedParts(List<Integer> updatedParts) {
        this.updatedParts = updatedParts;
    }

    public int getMotherboardPartID() {
        return motherboardPartID;
    }

    public void setMotherboardPartID(int motherboardPartID) {
        this.motherboardPartID = motherboardPartID;
        updatedParts = new ArrayList<>(List.of(motherboardPartID, gpuPartID, cpuPartID, powerSupplyPartID, storagePartID, coolerPartID));
    }

    public int getPartID(String partType) {
        return switch (partType){
            case "motherboard" -> motherboard.getPartID();
            case "gpu" -> gpu.getPartID();
            case "cpu" -> cpu.getPartID();
            case "power supply" -> powerSupply.getPartID();
            case "storage" -> storage.getPartID();
            case "cpu cooler" -> cooler.getPartID();
            default -> 0;
        };
    }

    @Override
    public String toString() {
        return "UserBuildDTO{" +
                "buildName='" + buildName + '\'' +
                ", motherboard=" + motherboard +
                ", gpu=" + gpu +
                ", cpu=" + cpu +
                ", powerSupply=" + powerSupply +
                ", storage=" + storage +
                ", cooler=" + cooler +
                '}';
    }
}
