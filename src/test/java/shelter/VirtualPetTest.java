package shelter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VirtualPetTest {
    @Test
    public void canCreateVirtualPet() {
        VirtualPet underTest = new VirtualPet("Poncho", "A dog with course brown fur.");
        assertEquals("Poncho", underTest.getPetName());
        assertEquals("A dog with course brown fur.", underTest.getPetDescription());
        assertEquals(45, underTest.getPetHunger());
        assertEquals(55, underTest.getPetThirst());
        assertEquals(65, underTest.getPetBoredom());
    }


    @Test
    public void canCreateVirtualPetWithAttributes() {
        VirtualPet underTest = new VirtualPet("Poncho",
                "A dog with course brown fur.",
                43, 46, 52);
        assertEquals(43, underTest.getPetHunger());
        assertEquals(46, underTest.getPetThirst());
        assertEquals(52, underTest.getPetBoredom());
    }

    @Test
    public void canFeedPet() {
        VirtualPet underTest = new VirtualPet("Poncho",
                "A dog with course brown fur.",
                43, 46, 52);
        underTest.feed(5);
        assertEquals(38, underTest.getPetHunger());
    }

    @Test
    public void canWaterPet() {
        VirtualPet underTest = new VirtualPet("Poncho",
                "A dog with course brown fur.",
                43, 46, 52);
        underTest.water(5);
        assertEquals(41, underTest.getPetThirst());
    }

    @Test
    public void canPlayWithPet() {
        VirtualPet underTest = new VirtualPet("Poncho",
                "A dog with course brown fur.",
                43, 46, 52);
        underTest.play(5);
        assertEquals(47, underTest.getPetBoredom());
    }

    @Test
    public void petCanTick() {
        VirtualPet underTest = new VirtualPet("Poncho",
                "A dog with course brown fur.",
                43, 46, 52);
        underTest.tick();
        assertEquals(52, underTest.getPetHunger());
    }
}