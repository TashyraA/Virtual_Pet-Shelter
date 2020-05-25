package shelter;

import org.junit.jupiter.api.Test;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

public class VirtualPetShelterTest {
    @Test
    public void canAddPet() {
        VirtualPet underTestPet = new VirtualPet("Poncho",
                "A dog with course brown fur.");
        VirtualPetShelter underTestShelter = new VirtualPetShelter(50);
        underTestShelter.addPetToShelter(underTestPet);
        VirtualPet underTestShelterPet = underTestShelter.getPet("Poncho");
        assertEquals("Poncho", underTestShelterPet.getPetName());
    }

    @Test
    public void canReturnAllPets() {
        VirtualPet underTestPet1 = new VirtualPet("Poncho",
                "A dog with course brown fur.");
        VirtualPet underTestPet2 = new VirtualPet("Bella",
                "A baby kitten.");
        VirtualPetShelter underTestShelter = new VirtualPetShelter(50);
        underTestShelter.addPetToShelter(underTestPet1);
        underTestShelter.addPetToShelter(underTestPet2);
        Collection<VirtualPet> petsInShelter = underTestShelter.getAllPets();
        assertFalse(petsInShelter.isEmpty());
    }

    @Test
    public void canRemovePet() {
        VirtualPet underTestPet = new VirtualPet("Poncho",
                "A dog with brown course fur.");
        VirtualPetShelter underTestShelter = new VirtualPetShelter(50);
        underTestShelter.addPetToShelter(underTestPet);
        underTestShelter.removePetFromShelter(underTestPet.getPetName());
        Collection<VirtualPet> petsInShelter = underTestShelter.getAllPets();
        assertTrue(petsInShelter.isEmpty());
    }

    @Test
    public void canFeedAllPets() {
        VirtualPet underTestPet1 = new VirtualPet("Poncho",
                "A dog with course brown fur.");
        VirtualPet underTestPet2 = new VirtualPet("Bella",
                "A baby kitten.");
        VirtualPetShelter underTestShelter = new VirtualPetShelter(50);
        underTestShelter.addPetToShelter(underTestPet1);
        underTestShelter.addPetToShelter(underTestPet2);
        underTestShelter.feedAllPets(5);
        assertEquals(40, underTestPet1.getPetHunger());
        assertEquals(40, underTestPet2.getPetHunger());

    }

    @Test
    public void canWaterAllPets() {
        VirtualPet underTestPet1 = new VirtualPet("Poncho",
                "A dog with course brown fur.");
        VirtualPet underTestPet2 = new VirtualPet("Bella",
                "A baby kitten.");
        VirtualPetShelter underTestShelter = new VirtualPetShelter(50);
        underTestShelter.addPetToShelter(underTestPet1);
        underTestShelter.addPetToShelter(underTestPet2);
        underTestShelter.waterAllPets(5);
        assertEquals(50, underTestPet1.getPetThirst());
        assertEquals(50, underTestPet2.getPetThirst());
    }

    @Test
    public void canPlayWithPetByName() {
        VirtualPet underTestPet1 = new VirtualPet("Poncho",
                "A dog with course brown fur.");
        VirtualPet underTestPet2 = new VirtualPet("Bella",
                "A baby kitten.");
        VirtualPetShelter underTestShelter = new VirtualPetShelter(50);
        underTestShelter.addPetToShelter(underTestPet1);
        underTestShelter.addPetToShelter(underTestPet2);
        underTestShelter.playWithPet("Poncho", 5);
        assertEquals(60, underTestPet1.getPetBoredom());
    }

    @Test
    public void petsCanTick() {
        VirtualPet underTestPet1 = new VirtualPet("Poncho",
                "A dog with course brown fur.");
        VirtualPet underTestPet2 = new VirtualPet("Bella",
                "A baby kitten.");
        VirtualPetShelter underTestShelter = new VirtualPetShelter(50);
        underTestShelter.addPetToShelter(underTestPet1);
        underTestShelter.addPetToShelter(underTestPet2);
        underTestShelter.tick();
        assertEquals(54, underTestPet1.getPetHunger());
        assertEquals(54, underTestPet2.getPetHunger());
    }

    @Test
    public void petInShelter() {
        VirtualPet underTestPet1 = new VirtualPet("Poncho",
                "A dog with course brown fur.");
        VirtualPet underTestPet2 = new VirtualPet("Bella",
                "A baby kitten.");
        VirtualPetShelter underTestShelter = new VirtualPetShelter(50);
        underTestShelter.addPetToShelter(underTestPet1);
        underTestShelter.addPetToShelter(underTestPet2);
        assertTrue(underTestShelter.isPetInShelter("Bella"));
        assertFalse(underTestShelter.isPetInShelter("Precious"));
    }
    @Test
    public void checkPenCleanliness(){
        VirtualPetShelter underTestShelter = new VirtualPetShelter(50);
        assertEquals(50, underTestShelter.getPenCleanliness());
    }
    @Test
    public void tickPenCleanliness(){
        VirtualPetShelter underTestShelter = new VirtualPetShelter(50);
        underTestShelter.tick();
        assertEquals(55, underTestShelter.getPenCleanliness());
    }
}