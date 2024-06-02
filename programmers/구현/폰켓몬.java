import java.util.*;

class Solution {
    public int solution(int[] pokemons) {
        HashMap<Integer, Integer> pokemonMap = new HashMap<>();

        for (int pokemon : pokemons) {
            pokemonMap.put(pokemon, pokemonMap.getOrDefault(pokemon, 0) + 1);
        }

        Set<Integer> keys = pokemonMap.keySet();

        if (pokemons.length / 2 < keys.size()) {
            return pokemons.length / 2;
        }

        return keys.size();
    }
}
