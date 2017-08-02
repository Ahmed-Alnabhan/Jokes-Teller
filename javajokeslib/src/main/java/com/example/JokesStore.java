package com.example;

import java.util.HashMap;
import java.util.Random;
// Jokes are taken from http://www.rd.com/jokes/animal/
public class JokesStore {
    private HashMap<Integer, String> jokes;

    public JokesStore() {
        this.jokes = new HashMap<>();
        fillOutJokes();
    }

    public String tellMeAJoke() {
        String joke;
        int jokesCount = jokes.size();
        Random rand = new Random();
        int currentJokeIndex = rand.nextInt(jokesCount);
        joke = jokes.get(currentJokeIndex);
        return joke;
    }

    public void fillOutJokes() {
        jokes.put(0, "Why do dogs always race to the door when the doorbell rings? It's hardly ever for them.");
        jokes.put(1, "Nature abhors a vacuum, but not as much as a cat does.");
        jokes.put(2, "I dressed my dog up as a cat for Halloween. Now he won't come when I call him.");
        jokes.put(3, "My cat just walked up to the paper shredder and said, \"Teach me everything you know.\"");
        jokes.put(4, "Cats are smarter than dogs. You can't get eight cats to pull a sled through snow.");
        jokes.put(5, "They make cat food out of cow, fish, turkey, chicken & lamb meat-but not mouse meat, which is probably all cats want.");
        jokes.put(6, "I dressed up my dog as a mailman for Halloween. He bit himself.");
        jokes.put(7, "\"For sale: Eight puppies from a German shepherd and an Alaskan hussy.\"");
        jokes.put(8, "What do you call a pig that does karate? -A pork chop.");
        jokes.put(9, "A horse walks into a bar. The bartender says, \"Hey.\" The horse says, \"You read my mind, buddy.\"");
    }
}
