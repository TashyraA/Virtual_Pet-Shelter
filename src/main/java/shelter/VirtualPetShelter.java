package shelter;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class VirtualPetShelter {
    private Map<String, VirtualPet> virtualPets = new HashMap<>();
    private int penCleanliness;

    public VirtualPetShelter(int penCleanliness) {
        this.penCleanliness = penCleanliness;
    }

    public int getPenCleanliness() {
        return penCleanliness;
    }

    public void addPetToShelter(VirtualPet virtualPet) {
        virtualPets.put(virtualPet.getPetName(), virtualPet);
    }

    public VirtualPet getPet(String petName) {
        return virtualPets.get(petName);
    }

    public Collection<VirtualPet> getAllPets() {
        return virtualPets.values();
    }

    public void removePetFromShelter(String petName) {
        virtualPets.remove(petName);
    }

    public void feedAllPets(int food) {
        Collection<VirtualPet> allPets = getAllPets();
        for (VirtualPet pet : allPets) {
            pet.feed(food);
        }
    }

    public void waterAllPets(int water) {
        Collection<VirtualPet> allPets = getAllPets();
        for (VirtualPet pet : allPets) {
            pet.water(water);
        }
    }

    public void playWithPet(String name, int play) {
        VirtualPet pet = getPet(name);
        pet.play(play);
    }

    public void cleanPens(int cleanPens) {
        penCleanliness -= cleanPens;
    }

    public void tick() {
        Collection<VirtualPet> allPets = getAllPets();
        for (VirtualPet pet : allPets) {
            pet.tick();
        }
        penCleanliness += 5;
    }

    public boolean isPetInShelter(String petName) {
        return virtualPets.containsKey(petName);
    }
}