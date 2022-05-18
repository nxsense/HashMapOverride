public class Test {
    public static void main(String[] args) {
        HashMapOverride hashMapOverrride = new HashMapOverride();
        hashMapOverrride.putOverrided(12, "a");
        hashMapOverrride.putOverrided(120, "b");
        hashMapOverrride.putOverrided(17, "c");
        hashMapOverrride.putOverrided(19, "d");
        System.out.println(hashMapOverrride.getOverrided(12));
        System.out.println(hashMapOverrride.getOverrided(17));
        System.out.println(hashMapOverrride.getOverrided(128));
        System.out.println(hashMapOverrride.containsKey(78));
        System.out.println(hashMapOverrride.containsKey(17));
        System.out.println(hashMapOverrride.containsValue("c"));
        System.out.println(hashMapOverrride.getSize());
    }
}
