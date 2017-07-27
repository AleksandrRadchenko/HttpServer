package javase04.t04;

import lombok.Getter;
import lombok.NonNull;

import java.io.*;
import java.util.*;

public class MoviesCollection implements Serializable {
    private boolean started;
    @Getter
    private Map<String, Set<String>> collection = new HashMap<>();

    public void start() {
        //Deserialize
        started = true;
        try (ObjectInputStream is = new ObjectInputStream(
                new FileInputStream(Strings.FILE_PATH + Strings.FILE_NAME))) {
            collection = (Map<String, Set<String>>) is.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Adds actor to the Set of actors, starred in movie.
     * @param movie String with movie name.
     * @param actor String with actor's name.
     */
    public void put(@NonNull String movie, @NonNull String actor) {
        if (collection.containsKey(movie))
                collection.get(movie).add(actor);
        else {
            collection.put(movie, new HashSet<>(Collections.singleton(actor)));
        }

    }

    public Set<String> deleteMovie(String movie) {

        Set<String> s = collection.remove(movie);
        return s;
    }

    public void shutDown() {
        //Serialize
        started = false;
        try (ObjectOutputStream os = new ObjectOutputStream(
                new FileOutputStream(Strings.FILE_PATH + Strings.FILE_NAME))) {
            os.writeObject(collection);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
