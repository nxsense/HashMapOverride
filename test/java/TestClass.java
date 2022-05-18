import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
public class TestClass {
    HashMapOverride hashMapOverride;
    @BeforeEach
    public void create(){
        hashMapOverride = new HashMapOverride();
    }

    @Test
    public void checkSize(){
        hashMapOverride.putOverrided(12, "a");
        hashMapOverride.putOverrided(120, "b");
        hashMapOverride.putOverrided(17, "c");
        hashMapOverride.putOverrided(19, "d");
        Assertions.assertEquals(hashMapOverride.getSize(), 4);
    }

    @Test
    public void checkContainsKey(){
        hashMapOverride.putOverrided(12, "a");
        hashMapOverride.putOverrided(120, "b");
        hashMapOverride.putOverrided(17, "c");
        hashMapOverride.putOverrided(19, "d");
        Assertions.assertEquals(hashMapOverride.containsKey(120), true);
        Assertions.assertEquals(hashMapOverride.containsKey(56), false);
    }

    @Test
    public void checkContainsValue(){
        hashMapOverride.putOverrided(12, "a");
        hashMapOverride.putOverrided(120, "b");
        hashMapOverride.putOverrided(17, "c");
        hashMapOverride.putOverrided(19, "d");
        Assertions.assertEquals(hashMapOverride.containsValue("b"), true);
        Assertions.assertEquals(hashMapOverride.containsValue("s"), false);
    }

    @Test
    public void checkPutGet(){
        hashMapOverride.putOverrided(12, "a");
        hashMapOverride.putOverrided(17, "c");
        hashMapOverride.putOverrided(null, null);
        Assertions.assertEquals(hashMapOverride.getOverrided(12), "a");
        Assertions.assertEquals(hashMapOverride.getOverrided(17), "c");
        Assertions.assertEquals(hashMapOverride.getOverrided(19), null);

    }

}
