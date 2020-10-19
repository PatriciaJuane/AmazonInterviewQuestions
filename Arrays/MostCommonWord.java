class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        // paso 1 -> eliminar puntuaciones y convertir a minuscula
        
        String formateado = paragraph.replaceAll("[^a-zA-z0-9 ]"," ").toLowerCase();
        
        // paso 2 -> dividir nuestro string en palabras
        String[] palabras = formateado.split("\\s+");
        
        // paso 3 -> contar la frecuencia de cada palabra
        Set<String> palabrasProhibidas = new HashSet<>();
        
        for(String palabra: banned) {
            palabrasProhibidas.add(palabra);
        }
        
        Map<String, Integer> count = new HashMap<>(); // permite almacenar palabra + num de repeticiones
        
        for(String nuevaPalabra: palabras) {
            if(!palabrasProhibidas.contains(nuevaPalabra)) {
                count.put(nuevaPalabra, count.getOrDefault(nuevaPalabra, 0) + 1);
            }
        }
        // paso 4-> devolver la palabra mas repetida
        
        return Collections.max(count.entrySet(), Map.Entry.comparingByValue()).getKey();
        
    }
}